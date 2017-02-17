package com.service;

import com.bean.MyDatabase;
import com.bean.Response;

import java.util.List;

/**
 * Created by olxja_000 on 2017/1/18.
 */
public interface MyDatabaseService {
    List<MyDatabase>getUserCompanyId(Integer user_id);
    void getMyDataByCompanyId(Response response, String company_id);

    Integer updateCZLData(MyDatabase data);
//根据公司id删除公司数据
    Integer deleteCompanyInfo(String company_id);

    Integer insertCompanyData(MyDatabase data);
}
