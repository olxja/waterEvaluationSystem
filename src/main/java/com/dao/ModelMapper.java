package com.dao;

import com.bean.Model;
import com.bean.Response;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by 郑超一 on 2017/2/28.
 */

@Repository("ModelMapper")
public interface ModelMapper {
    List<Model> modelList(@Param("user_id") String user_id);

    List<Model> sysModelList();

    List<Model> myModelList(@Param("user_id") String user_id);

    Integer addModel(Model model);

    List<Model> getJson(Model model);

    List<Model> getTemp(Model model);

    Integer updateTemp(Model model);

    Integer updateJson(Model model);

//    Integer updateIndex(Model model);

    Integer deleteModel(Model model);
}
