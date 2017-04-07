package com.service.serviceImp;

import com.bean.Model;
import com.bean.Response;
import com.dao.ModelMapper;
import com.service.ModelService;
import com.sun.javafx.sg.prism.NGShape;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
/**
 * Created by 郑超一 on 2017/2/28.
 */

@Service(value = "ModelService")
@Transactional
public class ModelServiceImpl implements ModelService {
    @Resource
    private ModelMapper modelMapper;

    @Override
    public void ModelList(Response response, String user_id) {
        System.out.print("关心列表");
        JSONObject jsonObject = new JSONObject();
        try {
            List<Model> modelList = modelMapper.modelList(user_id);
            //可以返回多个数据
            jsonObject.put("modelList", modelList);
            //将多个数据返回
            response.setData(jsonObject);
        } catch (Exception e) {//捕捉异常，返回异常信息
            response.failure(e.getMessage());
            return;
        }
        response.success();
    }

    @Override
    public void sysModelList(Response response) {
        System.out.print("关心列表");
        JSONObject jsonObject = new JSONObject();
        try {
            List<Model> myModelList = modelMapper.sysModelList();
            //可以返回多个数据
            jsonObject.put("myModelList", myModelList);
            //将多个数据返回
            response.setData(jsonObject);
        } catch (Exception e) {//捕捉异常，返回异常信息
            response.failure(e.getMessage());
            return;
        }
        response.success();
    }

    @Override
    public void myModelList(Response response,String user_id) {
        System.out.print("关心列表");
        JSONObject jsonObject = new JSONObject();
        try {
            List<Model> sysModelList = modelMapper.myModelList(user_id);
            //可以返回多个数据
            jsonObject.put("sysModelList", sysModelList);
            //将多个数据返回
            response.setData(jsonObject);
        } catch (Exception e) {//捕捉异常，返回异常信息
            response.failure(e.getMessage());
            return;
        }
        response.success();
    }

    @Override
    public void addModel(Response response, Model model) {
        JSONObject jsonObject = new JSONObject();
        try {
            int r = modelMapper.addModel(model);
            //可以返回多个数据
            jsonObject.put("modelList",r);
            //将多个数据返回
            response.setData(jsonObject);
        }catch (Exception e){//捕捉异常，返回异常信息
            response.failure(e.getMessage());
            return;
        }
        response.success();
    }

    @Override
    public void getModelJson(Response response, Model model) {
        JSONObject jsonObject = new JSONObject();
        try {
            String r = modelMapper.getModelJson(model);
//            r = r.replace("\r","");
//            r = r.replace(" ","");
//            r = r.replace("\n","");
            //可以返回多个数据
            jsonObject.put("getModelJson",r);
            //将多个数据返回
            response.setData(jsonObject);
        }catch (Exception e){//捕捉异常，返回异常信息
            response.failure(e.getMessage());
            return;
        }
        response.success();
    }

    @Override
    public void getTemp(Response response, Model model) {
        JSONObject jsonObject = new JSONObject();
        try {
            List<Model> r = modelMapper.getTemp(model);
            //可以返回多个数据
            jsonObject.put("getTemp",r);
            //将多个数据返回
            response.setData(jsonObject);
        }catch (Exception e){//捕捉异常，返回异常信息
            response.failure(e.getMessage());
            return;
        }
        response.success();
    }

    @Override
    public void updateTemp(Response response, Model model) {
        JSONObject jsonObject = new JSONObject();
        try {
            int t = modelMapper.updateTemp(model);
            //可以返回多个数据
            jsonObject.put("updateTemp",t);
            //将多个数据返回
            response.setData(jsonObject);
        }catch (Exception e){//捕捉异常，返回异常信息
            response.failure(e.getMessage());
            return;
        }
        response.success();
    }

    @Override
    public void updateJson(Response response, Model model) {
        JSONObject jsonObject = new JSONObject();
        try {
            int t = modelMapper.updateJson(model);
            //可以返回多个数据
            jsonObject.put("updateJson",t);
            //将多个数据返回
            response.setData(jsonObject);
        }catch (Exception e){//捕捉异常，返回异常信息
            response.failure(e.getMessage());
            return;
        }
        response.success();
    }



//    //设置一个加一列，不用操作数据库，直接在这里加？
//    @Override
//    public void updateIndex(Response response, Model model) {
//        JSONObject jsonObject = new JSONObject();
//        try {
//            Integer t = modelMapper.updateTemp(model);
//            Integer r = modelMapper.updateIndex(model);
//            //可以返回多个数据
//            jsonObject.put("updateTemp", t);
//            jsonObject.put("updateIndex", r);
//            //将多个数据返回
//            response.setData(jsonObject);
//        }catch (Exception e){//捕捉异常，返回异常信息
//            response.failure(e.getMessage());
//            return;
//        }
//        response.success();
//    }

    @Override
    public void deleteModel(Response response, Model model) {
        JSONObject jsonObject = new JSONObject();
        try {
            int r = modelMapper.deleteModel(model);
            //可以返回多个数据
            jsonObject.put("modelList",r);
            //将多个数据返回
            response.setData(jsonObject);
        }catch (Exception e){//捕捉异常，返回异常信息
            response.failure(e.getMessage());
            return;
        }
        response.success();
    }
}
