package com.controller;

import com.alibaba.druid.support.json.JSONParser;
import com.bean.Mail;
import com.bean.MyDatabase;
import com.bean.Student;
import com.service.MyDatabaseService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by olxja_000 on 2017/1/18.
 */
@Controller
public class MyDatabaseController {
    @Resource
    private MyDatabaseService myDatabaseService;
//    根据输入的user_id输出拥有的company_id
    @RequestMapping(value = "/getUserCompanyId")
    @ResponseBody
    public String getUserCompanyId(@RequestParam Integer user_id){
        JSONObject jsonObject=new JSONObject();
        List<MyDatabase> data=myDatabaseService.getUserCompanyId(user_id);
        jsonObject.put("companies",data);
        return jsonObject.toString();
    }

//    根据company_id获取MyDatabase对象
    @RequestMapping(value = "/getMyData")
    @ResponseBody
    public String getMyDataByCompanyId(@RequestParam String company_id) {
        JSONObject jsonObject=new JSONObject();
        List<MyDatabase> data=myDatabaseService.getMyDataByCompanyId(company_id);
        jsonObject.put("datas",data);
        return jsonObject.toString();
    }

    @RequestMapping(value = "/updateCZLData")
    public String updateCZLData(MyDatabase data){
        data.setCompany_id("100000000");
        data.setMain_business_income_2015(2000.45d);
        data.setMain_business_income_2014(3888.345d);
       Integer interger=myDatabaseService.updateCZLData(data);
        return "redirect:/getMyData";
    }
//    根据公司id删除公司数据
    @RequestMapping(value = "/deleteCompanyInfo")
    @ResponseBody
    public String deleteCompanyInfo(@RequestParam String company_id){
        Integer integer=myDatabaseService.deleteCompanyInfo(company_id);
        String str="delete success";
        return str;
    }

    @RequestMapping(value = "/insertCompanyInfo")
    @ResponseBody
    public String insertCompanyData(@RequestBody Student companyData){
//        JSONObject object=JSONObject.fromObject(companyData);
        System.out.println(companyData);
//        Student st1=new Student();
//        st1.setStudentName("lisi");
//        st1.setStudentNo("211");
//        JSONObject jsonObject = JSONObject.fromObject(st1);
//        System.out.println(jsonObject);
        String str2="hello";
        return str2;
    }


}
