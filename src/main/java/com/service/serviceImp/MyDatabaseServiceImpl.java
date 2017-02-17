package com.service.serviceImp;

import com.bean.MyDatabase;
import com.dao.MyDatabaseMapper;
import com.service.MyDatabaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by olxja_000 on 2017/1/18.
 */
@Service(value = "myDatabaseService")
@Transactional
public class MyDatabaseServiceImpl implements MyDatabaseService{
    @Resource
    private MyDatabaseMapper database;

    @Override
    public List<MyDatabase> getUserCompanyId(Integer user_id) {
        return database.getUserCompanyId(user_id);
    }

    @Override
    public List<MyDatabase> getMyDataByCompanyId(String company_id){
        return database.getMyDataByCompanyId(company_id);
    }


    @Override
    public Integer updateCZLData(MyDatabase data){
        return database.updateCZLData(data);
    }

//    根据公司id删除公司数据
    @Override
    public Integer deleteCompanyInfo(String company_id){
        return database.deleteCompanyInfo(company_id);
    }

    @Override
    public Integer insertCompanyData(MyDatabase data){
        return database.insertCompanyData(data);
    }

}
