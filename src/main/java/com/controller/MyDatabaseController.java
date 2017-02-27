package com.controller;

import com.bean.MyDatabase;
import com.bean.Response;
import com.bean.Student;
import com.service.MyDatabaseService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by olxja_000 on 2017/1/18.
 */
@Controller
public class MyDatabaseController {
    @Resource
    private MyDatabaseService myDatabaseService;
    //    通过user_id查找拥有的公司的公司id，公司名字和所属行业3个字段
    @RequestMapping(value = "/getUserCompanyInfo")
    @ResponseBody
    public Response getUserCompanyId(@RequestParam Integer user_id){
       Response response=new Response();
        myDatabaseService.getUserCompanyInfo(response,user_id);
        return response;
    }

//    根据company_id获取整个company信息，返回json数据
    @RequestMapping(value = "/getCompanyList")
    @ResponseBody
    public Response getMyDataByCompanyId(@RequestParam String company_id) {
        Response response = new Response();
        myDatabaseService.getMyDataByCompanyId(response,company_id);
        return response;
    }
//根据传入的json数据更新公司数据
//    未完
    @RequestMapping(value = "/updateCompanyList")
    @ResponseBody
    public Response updateCompanyData(@RequestBody MyDatabase data){
        Response response=new Response();
       myDatabaseService.updateCompanyData(response,data);
        return response;
    }
//    根据公司id删除公司数据
    @RequestMapping(value = "/deleteCompanyList")
    @ResponseBody
    public Response deleteCompanyInfo(@RequestParam String company_id){
        Response response=new Response();
        myDatabaseService.deleteCompanyInfo(response,company_id);
        return response;
    }
//插入一个新的company信息，如果dao层的函数返回0说明没有插入，返回公司已存在，不然就返回成功
//    未完
    @RequestMapping(value = "/insertCompanyList")
    @ResponseBody
    public Response insertCompanyData(@RequestBody MyDatabase companyData){
       Response response=new Response();
        myDatabaseService.insertCompanyData( response,companyData);
        return response;
    }


}
