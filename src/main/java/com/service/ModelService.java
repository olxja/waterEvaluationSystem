package com.service;

import com.bean.Model;
import com.bean.Response;
/**
 * Created by 郑超一 on 2017/2/28.
 */
public interface ModelService {
    void ModelList(Response response,String user_id);

    void sysModelList(Response response);

    void myModelList(Response response,String user_id);

    void addModel(Response response,Model model);

    void getJson(Response response,Model model);

    void getTemp(Response response,Model model);

    void updateTemp(Response response,Model model);

    void updateJson(Response response,Model model);

//    void updateIndex(Response response,Model model);

    void deleteModel(Response response,Model model);

}
