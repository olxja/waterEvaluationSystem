package com.dao;

import com.bean.MyDatabase;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by olxja_000 on 2017/1/18.
 */
@Repository("myDatabaseMapper")
public interface MyDatabaseMapper {
    List<MyDatabase>getUserCompanyId(@Param("user_id") Integer user_id);

    List<MyDatabase> getMyDataByCompanyId(@Param("company_id") String company_id);

    Integer updateCZLData(MyDatabase data);

//根据公司id来删除公司数据
    Integer deleteCompanyInfo(@Param("company_id") String company_id);

    Integer insertCompanyData(MyDatabase data);
}
