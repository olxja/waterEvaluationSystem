package com.controller;

import com.bean.User;
import com.service.UserService;
import com.utils.Constants;
import com.utils.MD5Util;
import com.utils.StringUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

//总之返回一个login或报错

@Controller
public class AccessController {
    static Logger log = Logger.getLogger(AccessController.class);

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public String index(){
        return "redirect:/login";
    }
//    //test start
//    @RequestMapping(value = "+++")
//    public String index(){
//        return "login";
//    }
//    //test end
    @RequestMapping("/login")
    public String login() {
        /*自动登陆*/
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated() && subject.isRemembered()) {   //如果没有认证且已记入
            Object principal = subject.getPrincipal();
            if (null != principal) {
                User user = userService.loginUserByEmailOrPhone(String.valueOf(principal));
                if (user == null){
                    return "login";
                }
                UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), user.getPassword());
                token.setRememberMe(true);
                subject.login(token);//登录
                Session session = subject.getSession();
                session.setAttribute("user",user);
                session.setAttribute("username",user.getUsername());
                return "redirect:/notepad/findNotepad";
            }
        }
        return "login";
    }

    @RequestMapping(value = "/loadUser")
    public String loadUser(String username, String password, Boolean rememberMe, Model model) {
        String msg = "";
        if (StringUtil.isNullAll(username) || StringUtil.isNullAll(password)) {
            msg = "帐号/密码不能为空!";
            model.addAttribute("message", msg);
            return "login";
        }
        password = MD5Util.string2MD5(password).toUpperCase();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        if (null != rememberMe) {
            token.setRememberMe(rememberMe);
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            if (subject.isAuthenticated()) {
                User user = userService.loginUserByEmailOrPhone(username);
                Session session = subject.getSession();
                session.setAttribute("user",user);
                session.setAttribute("username",user.getUsername());
                //记录登陆日志
                String detail = user.getUsername() + " Login - PC";
                userService.logInfo(Constants.OK,user.getDepartmentName(),detail,Constants.OK,new Date());
                //登陆成功,跳转首页
                return "redirect:/notepad/findNotepad";
            } else {//失败跳转登录页
                return "redirect:/login";
            }
        } catch (IncorrectCredentialsException e) {
            msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
            model.addAttribute("message", msg);
            log.error(e.getMessage());
        } catch (ExcessiveAttemptsException e) {
            msg = "登录失败次数过多";
            model.addAttribute("message", msg);
            log.error(e.getMessage());
        } catch (LockedAccountException e) {
            msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
            model.addAttribute("message", msg);
            log.error(e.getMessage());
        } catch (DisabledAccountException e) {
            msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
            model.addAttribute("message", msg);
            log.error(e.getMessage());
        } catch (ExpiredCredentialsException e) {
            msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
            model.addAttribute("message", msg);
            log.error(e.getMessage());
        } catch (UnknownAccountException e) {
            msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
            model.addAttribute("message", msg);
            log.error(e.getMessage());
        } catch (UnauthorizedException e) {
            msg = "您没有得到相应的授权！";
            model.addAttribute("message", msg);
            log.error(e.getMessage());
        } catch (AuthenticationException  e){
            msg = "帐号密码不匹配！";
            model.addAttribute("message", msg);
            log.error(e.getMessage());
        } catch (Exception e){
            msg = "帐号或密码不存在！";
            model.addAttribute("message", msg);
            log.error(e.getMessage());
        }
        return "redirect:/login";
    }
}