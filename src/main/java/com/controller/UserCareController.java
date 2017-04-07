package com.controller;

import com.bean.Permission;
import com.bean.UserCare;
import com.bean.Response;
import com.service.UserCareService;
import com.utils.Constants;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 郑超一 on 2017/1/18.
 */
@Controller
public class UserCareController {
    @Resource
    private UserCareService UserCareService;

//    //根据user_id和默认分组号显示专辑列表
//    @RequestMapping(value = "/UserCareList")
//    @ResponseBody
//    public String UserCareList(HttpServletRequest request, Model model) {          //
//        JSONObject jsonObject = new JSONObject();
//        List<UserCare> UserCares = UserCareService.UserCareList("22");
//        jsonObject.put("UserCares", UserCares);
//        return jsonObject.toString();
//    }
    //根据user_id和默认分组号显示专辑列表
    @RequestMapping(value = "/UserCareList")
    @ResponseBody
    public Response UserCareList(@RequestParam String user_id,@RequestParam String group_name) {          //
        Response response = new Response();
        UserCareService.UserCareList(response,user_id,group_name);
        return response;
    }
    //添加用户关心的企业
    @RequestMapping(value = "/addUserCare")
    public String addUserCare(UserCare UserCare) {
        UserCare.setGroup_id(4);
        UserCare.setUser_id(44);
        UserCare.setCompany_name("444");
        UserCare.setGroup_name("四");
//        UserCare.setIndustry_business_name("医疗");
        Integer integer = UserCareService.addUserCare(UserCare);
        return "redirect:/login";
    }
    //更新用户关心的企业
    @RequestMapping(value = "/updateUserCare")
    public String updateUserCare(UserCare UserCare) {
        Integer integer = UserCareService.updateUserCare(UserCare);
        return "redirect:/UserCareList";
    }
    //根据user_id和company_name删除一行
    @RequestMapping(value = "/delUserCare")
    public String delUserCare(UserCare UserCare) {
        UserCare.setUser_id(44);
        UserCare.setCompany_name("444");
        UserCareService.delUserCare(UserCare);
        return "redirect:/login";
    }
    //根据user_id选择分组
    @RequestMapping(value = "/choseGroup")
    @ResponseBody
    public Response choseGroup(@RequestParam int user_id) {          //
        Response response = new Response();
        UserCareService.choseGroup(response,user_id);
        return response;
    }
    //根据user_id添加分组，公司名留空
    @RequestMapping(value = "/addGroup")
    @ResponseBody
    public Response addGroup(@RequestParam int user_id,@RequestParam String group_name) {
        Response response = new Response();
        UserCareService.addGroup(response,user_id,group_name);
        return response;
    }
    //根据user_id，group_name1，group_name2修改分组名称
    @RequestMapping(value = "/updateGroup")
    @ResponseBody
    public Response addGroup(@RequestParam int user_id,@RequestParam String group_name1,@RequestParam String group_name2) {
        Response response = new Response();
        UserCareService.updateGroup(response,user_id,group_name1,group_name2);
        return response;
    }
    //根据user_id、group_id删除分组
    @RequestMapping(value = "/deleteGroup")
    @ResponseBody
    public Response deleteGroup(@RequestParam int user_id,@RequestParam String group_name) {
        Response response = new Response();
        UserCareService.deleteGroup(response,user_id,group_name);
        return response;
    }
}
