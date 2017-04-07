package com.service;

import com.bean.MyDatabase;
import com.bean.Response;

import java.util.List;

/**
 * Created by olxja_000 on 2017/1/18.
 */
public interface MyDatabaseService {
//    通过user_id查找拥有的公司的公司id，公司名字和所属行业3个字段
    Response getUserCompanyInfo(Response response,Integer user_id);
    Response getMyDataByCompanyId(Response response, String company_id);

    Response updateCompanyData(Response response,MyDatabase data);
//根据公司id删除公司数据
    Response deleteCompanyInfo(Response response,String company_id);

    Response insertCompanyData(Response response,MyDatabase data);
}
