package com.service.serviceImp;

import com.bean.Enterprise_score;
import com.bean.MyDatabase;
import com.bean.Response;
import com.dao.EnterScoreMapper;
import com.dao.MyDatabaseMapper;
import com.service.MyDatabaseService;
import com.utils.SolrUtils;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
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
    @Resource
    private EnterScoreMapper score;

    //    通过user_id查找拥有的公司的公司id，公司名字和所属行业3个字段,拼装成json数据发回去
    @Override
    public Response getUserCompanyInfo(Response response,Integer user_id) {
        JSONObject jsonObject1 = new JSONObject();
        try{
            List<MyDatabase> myCompanyName=database.getUserCompanyId(user_id);
            JSONArray array=JSONArray.fromObject(myCompanyName);
//            array.fromObject(myCompanyName);
//            for(int i=0;i<myCompanyName.size();i++){
//                MyDatabase myDatabase=myCompanyName.get(i);
//
//                jsonObject1.put("company_id",myDatabase.getCompany_id());
//                jsonObject1.put("company_name",myDatabase.getCompany_name());
//                jsonObject1.put("industry_business_name",myDatabase.getIndustry_business_name());
//
//                array.add(i,jsonObject1.toString());
//            }

            response.setData(array);
        }catch (Exception e){
            response.failure(e.getMessage());
        }
        response.success();
        return response;
    }

    @Override
    public Response getMyDataByCompanyId(Response response, String company_id){
        JSONObject jsonObject = new JSONObject();
        try {
            List<MyDatabase> myDataList = database.getMyDataByCompanyId(company_id);
            //可以返回多个数据
            jsonObject.put("companyDataList",myDataList);
            //将多个数据返回
            response.setData(jsonObject);
        }catch (Exception e){//捕捉异常，返回异常信息
            response.failure(e.getMessage());
        }
        response.success();
        return response;

    }

//    更新某行公司数据
    @Override
    public Response updateCompanyData(Response response,MyDatabase data){
        Integer num=0;
        try {
            num = database.updateCompanyData(data);
            if(num==0){
                response.setSuccess(false);
                response.setData("update fail");
            }else{
                response.success();
                response.setData("update "+num+" line success" );
            }
        }catch (Exception e){
            response.failure(e.getMessage());
        }
        return response;
    }

//    根据公司id删除公司数据
    @Override
    public Response deleteCompanyInfo(Response response,String company_id){
        Integer num=0;
        try {
//            dao层的函数会返回更改的行数，如果是0就表示没有更改
            num= database.deleteCompanyInfo(company_id);
            if(num==0){
                response.setSuccess(false);
                String info="don't exit this company";
                response.setData(info);
            }
//        成功删除了一行数据
            else{
                response.success();
                String info="delete "+num+" row success";
                response.setData(info);
            }
        }catch (Exception e){
            response.failure(e.getMessage());
        }
//        如果删除0行

        return  response;
    }

//    插入一个新的company信息，如果dao层的函数返回0说明没有插入，返回公司已存在，不然就返回成功
    @Override
    public Response insertCompanyData(Response response,MyDatabase data){
        Integer num=0;
        try {
//            把公司信息插入数据库
            num=database.insertCompanyData(data);
            if(num==0){
                String info="insert companydata error";
                response.failure(info);
            }else{
                JSONObject jsonObject=new JSONObject();

//                拼装传值json格式
                SolrUtils.getJSONform(jsonObject,data);
//                与模型部分json合并
//                与算法传值，接受值再加上模型id一起存进数据库
                Enterprise_score enterscore=new Enterprise_score();
//                测试插入数据库用
                enterscore.setCompany_id("t5r3");
                enterscore.setModel_id(45l);
//                插入公司得分数据库
                Integer num2=score.insertEnterScore(enterscore);
                if(num2==0){
                    response.failure("insert companyscore error");
                }else{
//                    测试用，返回拼装完的传值json
                    response.success(jsonObject);
                }

                return  response;


            }
        }catch (Exception e){
            response.failure(e.getMessage());
        }

        return response;
    }

}
