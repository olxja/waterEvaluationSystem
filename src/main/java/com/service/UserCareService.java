package com.service;

import com.bean.Permission;
import com.bean.UserCare;
import com.bean.Response;
import java.util.List;
import java.util.Set;

/**
 * Created by 郑超一 on 2017/1/18.
 */
public interface UserCareService {
    void UserCareList(Response response,String user_id,String group_name);

    Integer addUserCare(UserCare UserCare);

    Integer updateUserCare(UserCare UserCare);

    Integer delUserCare(UserCare UserCare);

    void choseGroup(Response response,int user_id);

    void addGroup(Response response,int user_id,String group_name);

    void updateGroup(Response response,int user_id,String group_name1,String group_name2);

    void deleteGroup(Response response,int user_id,String group_name);

}
