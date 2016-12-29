package com.dao;

import com.bean.User;
import com.bean.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by lkhwjr on 2016/8/1.
 */
@Repository("userMapper")
public interface UserMapper {
    User loginUserByEmailOrPhone(User user);

    Integer addUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(Integer id);

    int getCountUser(User user);

    List<User> getUserListByCondition(@Param("user") User user, @Param("startRow") Integer startRow,
                                      @Param("pageSize") Integer pageSize);

    Integer updatePassword(User user);

    Integer addRole(@Param("user_id") Integer user_id, @Param("role_id") Integer role_id);

    List<Role> findRoleByUser(User user);

    User getUserByCondition(User user);

    void logInfo(@Param("level") Integer level, @Param("departmentName") String departmentName,
                 @Param("detail") String detail, @Param("type") Integer type, @Param("date") Date date);

    int getCountLog();


    Integer contactUserRole(@Param("userId") Integer userId,@Param("roleIds") String[] roleIds);

    Integer delRoleByUserId(@Param("userId") Integer userId);

    List<String> selectUserIdByDepartmentId(@Param("departmentId") Integer departmentId);

    Integer addUserList(@Param("users") List<User> users);

    List<User> selectUserByDepartmentId(@Param("departmentId") Integer departmentId);

    int getTotalUser(User user);

    List<User> getUserListByPage(@Param("user") User user, @Param("startRow") Integer startRow,
                                 @Param("pageSize") Integer pageSize);
}
