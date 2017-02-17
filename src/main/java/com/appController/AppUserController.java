package com.appController;

import com.bean.User;
import com.service.UserService;
import com.utils.Constants;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by lenovo on 2016/11/29.
 */
@Controller
public class AppUserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/app/test",method = RequestMethod.POST)
    @ResponseBody
    public String test(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();

        return jsonObject.toString();
    }

    @RequestMapping(value = "/app/userList")
    @ResponseBody
    public String appUserList() {
        JSONObject jsonObject = new JSONObject();
        //人员部分
        List<User> userList = userService.selectAllUser();
        jsonObject.put("userList", userList);
        jsonObject.put("status", Constants.SUCCESS);
        jsonObject.put("message", "人员列表");
        return jsonObject.toString();
    }
}
