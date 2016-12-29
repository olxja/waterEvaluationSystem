package com.appController;

import com.bean.User;
import com.service.UserService;
import com.utils.Constants;
import com.utils.StringUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.utils.MailSender.sendMail;


/**
 * Created by lenovo on 2016/10/9.
 */

@Controller
public class AppAccessController {
    private static Logger log = Logger.getLogger(AppAccessController.class);

    @Resource
    private RedisTemplate<Serializable, Serializable> redisTemplate;
    @Resource
    private UserService userService;

    //登录
    @RequestMapping(value = "/app/loadUser")
    @ResponseBody
    public String loadUser(String username, String password) {
        JSONObject jsonObject = new JSONObject();
        if (null == username || null == password) {
            jsonObject.put("status", Constants.FAIL);
            jsonObject.put("message", "用户名或密码为空!");
            return jsonObject.toString();
        }
        //验证用户名,密码
        User user = userService.loginUserByEmailOrPhone(username);
        if (null == user) {
            jsonObject.put("status", Constants.FAIL);
            jsonObject.put("message", "该帐号不存在!");
        } else if (!user.getPassword().equals(password)) {
            jsonObject.put("status", Constants.FAIL);
            jsonObject.put("message", "密码不正确!");
        } else {
            log.info(username + ":用户登陆成功!");
            jsonObject.put("status", Constants.SUCCESS);
            jsonObject.put("user", user);
            //记录登陆日志
            String detail = user.getUsername() + " Login - Tel";
            userService.logInfo(Constants.OK, user.getDepartmentName(), detail, Constants.OK, new Date());
        }
        return jsonObject.toString();
    }

    /**
     * 获取手机验证码(找回密码)(临时改为邮箱)
     *
     * @param phoneNum
     * @return
     */

    @RequestMapping(value = "/app/getBackPassCodeMobile")
    @ResponseBody
    public String getBackPassCodeMobile(String phoneNum) {
        JSONObject jsonObject = new JSONObject();
        if (phoneNum == null) {
            jsonObject.put("status", Constants.FAIL);
            jsonObject.put("message", "请输入邮箱!");
            return jsonObject.toString();
        }
        if (userService.loginUserByEmailOrPhone(phoneNum) == null) {
            jsonObject.put("status", Constants.FAIL);
            jsonObject.put("message", "该邮箱未注册!");
            return jsonObject.toString();
        }
        try {
            String code = StringUtil.getSixRandom();
            sendMail(Constants.EMAIL_FROM, Constants.EMAIL_USERNAME, Constants.EMAIL_PASSWORD,
                    phoneNum, "水滴笔记验证码", "您的验证码为:" + code + ".有效时间30分钟,请尽快输入.");
            redisTemplate.opsForValue().set(phoneNum, code, 30, TimeUnit.MINUTES);
            jsonObject.put("status", Constants.SUCCESS);
            jsonObject.put("message", "验证码发送成功!");
            jsonObject.put("code", code);
        } catch (Exception e) {
            jsonObject = new JSONObject();
            jsonObject.put("status", Constants.FAIL);
            jsonObject.put("message", "验证码发送失败!");
            log.error("验证码发送失败");
            e.printStackTrace();
        }


        /*if (phoneNum == null) {
            jsonObject.put("status", Constants.FAIL);
            jsonObject.put("message", "请输入手机号!");
            return jsonObject.toString();
        }
        if (userService.loginUserByEmailOrPhone(phoneNum) == null) {
            jsonObject.put("status", Constants.FAIL);
            jsonObject.put("message", "该手机号未注册!");
            return jsonObject.toString();
        }
        try {
            String smsTemplateCode = "SMS_27930139";//变动的
            String code = StringUtil.getSixRandom();
            JSONObject param = new JSONObject();
            param.put("code", code);//变动的
            param.put("name", phoneNum);//变动的
            String paramString = param.toString();
            SmsUtil.sendSms(phoneNum, smsTemplateCode, paramString);
            redisTemplate.opsForValue().set(phoneNum + Constants.code, code, 30, TimeUnit.MINUTES);
            jsonObject.put("status", Constants.SUCCESS);
            jsonObject.put("message", "验证码发送成功!");
            jsonObject.put("code", code);
        } catch (Exception e) {
            jsonObject = new JSONObject();
            jsonObject.put("status", Constants.FAIL);
            jsonObject.put("message", "验证码发送失败!");
            log.error("验证码发送失败");
            e.printStackTrace();
        }*/
        return jsonObject.toString();
    }

    /**
     * 判断验证码是否正确(下一步)
     *
     * @param phoneNum
     * @param vetificationCode
     * @return
     */
    @RequestMapping(value = "/app/checkCode")
    @ResponseBody
    public String checkCode(String phoneNum, String vetificationCode) {
        JSONObject jsonObject = new JSONObject();
        if (null == phoneNum || null == vetificationCode) {
            jsonObject.put("status", Constants.FAIL);
            jsonObject.put("message", "数据不完整!");
            return jsonObject.toString();
        }
        Serializable realCode = redisTemplate.opsForValue().get(phoneNum);
        if (realCode == null) {
            jsonObject.put("status", Constants.FAIL);
            jsonObject.put("message", "您还未发送验证码!");
            return jsonObject.toString();
        }
        if (!vetificationCode.equalsIgnoreCase(realCode.toString())) {
            jsonObject.put("status", Constants.FAIL);
            jsonObject.put("message", "验证码不正确!");
            return jsonObject.toString();
        }
        jsonObject.put("status", Constants.SUCCESS);
        jsonObject.put("message", "验证码正确!");
        return jsonObject.toString();
    }


    /**
     * 重置密码
     *
     * @param phoneNum
     * @param newPass
     * @param newPass2
     * @return
     */
    @RequestMapping(value = "/app/getBackPassword")
    @ResponseBody
    public String getBackPassword(String phoneNum, String newPass, String newPass2) {
        JSONObject jsonObject = new JSONObject();
        if (null == phoneNum || null == newPass || null == newPass2) {
            jsonObject.put("status", Constants.FAIL);
            jsonObject.put("message", "数据不完整!");
            return jsonObject.toString();
        }
        if (!newPass.equals(newPass2)) {
            jsonObject.put("status", Constants.FAIL);
            jsonObject.put("message", "前后密码不一致!");
            return jsonObject.toString();
        }
        //验证完成,进行修改操作
        User user = userService.loginUserByEmailOrPhone(phoneNum);
        user.setPassword(newPass);
        Integer integer = userService.updatePassword(user);
        if (integer > 0) {
            jsonObject.put("status", Constants.SUCCESS);
            jsonObject.put("message", "修改密码成功!");
            return jsonObject.toString();
        }
        jsonObject.put("status", Constants.FAIL);
        jsonObject.put("message", "修改密码失败!");
        return jsonObject.toString();
    }

    /**
     * 修改密码
     *
     * @param userId
     * @param oldPass
     * @param newPass
     * @param newPass2
     * @return
     */
    @RequestMapping(value = "/app/updatePassword")
    @ResponseBody
    public String updatePassword(Integer userId, String oldPass, String newPass, String newPass2) {
        JSONObject jsonObject = new JSONObject();
        if (null == userId || null == oldPass || null == newPass || null == newPass2) {
            jsonObject.put("status", Constants.FAIL);
            jsonObject.put("message", "数据不完整!");
            return jsonObject.toString();
        }
        if (!newPass.equals(newPass2)) {
            jsonObject.put("status", Constants.FAIL);
            jsonObject.put("message", "前后密码不一致!");
            return jsonObject.toString();
        }
        //验证旧密码
        User user = userService.findUserById(userId);
        if (!user.getPassword().equals(oldPass)) {
            jsonObject.put("status", Constants.FAIL);
            jsonObject.put("message", "旧密码不正确!");
            return jsonObject.toString();
        }
        user.setPassword(newPass);
        Integer integer = userService.updatePassword(user);
        if (integer > 0) {
            jsonObject.put("status", Constants.SUCCESS);
            jsonObject.put("message", "修改密码成功!");
            return jsonObject.toString();
        }
        jsonObject.put("status", Constants.FAIL);
        jsonObject.put("message", "修改密码失败!");
        return jsonObject.toString();
    }
}
