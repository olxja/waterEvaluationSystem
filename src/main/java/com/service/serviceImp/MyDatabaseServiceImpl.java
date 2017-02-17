package com.service.serviceImp;

import com.bean.MyDatabase;
import com.bean.Response;
import com.dao.MyDatabaseMapper;
import com.service.MyDatabaseService;
import net.sf.json.JSONObject;
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
    public void getMyDataByCompanyId(Response response, String company_id){
        JSONObject jsonObject = new JSONObject();
        try {
            List<MyDatabase> myDataList = database.getMyDataByCompanyId(company_id);
            //可以返回多个数据
            jsonObject.put("myDataList",myDataList);
            //将多个数据返回
            response.setData(jsonObject);
        }catch (Exception e){//捕捉异常，返回异常信息
            response.failure(e.getMessage());
            return;
        }
        response.success();

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
