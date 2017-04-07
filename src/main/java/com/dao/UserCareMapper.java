package com.dao;

import com.bean.Permission;
import com.bean.UserCare;
import com.bean.Response;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by 郑超一 on 2017/1/18.
 */
@Repository("UserCareMapper")
public interface UserCareMapper {
    List<UserCare> userCareList(@Param("user_id") String user_id,@Param("group_name") String group_name);

    Integer addUserCare(UserCare UserCare);

    Integer updateUserCare(UserCare UserCare);

    Integer deleteUserCare(UserCare UserCare);

    List<UserCare> choseGroup(@Param("user_id") int user_id);

    Integer addGroup(@Param("user_id") int user_id,@Param("group_name") String group_name);

    Integer updateGroup(@Param("user_id") int user_id,@Param("group_name1") String group_name1,@Param("group_name2") String group_name2);

    Integer deleteGroup(@Param("user_id") int user_id,@Param("group_name") String group_name);

}
