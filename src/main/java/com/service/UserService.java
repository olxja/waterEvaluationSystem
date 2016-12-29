package com.service;

import com.bean.User;
import com.page.Pagination;

import java.util.Date;
import java.util.List;

/**
 * Created by lkhwjr on 2016/8/1.
 */
public interface UserService {

    User loginUserByEmailOrPhone(String username);

    Integer deleteUser(Integer userId);

    Integer updatePassword(User user);

    User findUserById(Integer userId);

    void logInfo(Integer level, String departmentName, String detail, Integer type, Date date);



    List<User> selectAllUser();


}
