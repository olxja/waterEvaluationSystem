package com.service.serviceImp;

import com.bean.User;
import com.dao.UserMapper;
import com.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.user;


/**
 * Created by lkhwjr on 2016/8/1.
 */
@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User loginUserByEmailOrPhone(String username) {
        User user = new User();
        user.setEmail(username);
        user.setPhone(username);
        user = userMapper.loginUserByEmailOrPhone(user);
        return user;
    }




    @Override
    public Integer deleteUser(Integer userId) {
        //删除该用户的角色
        Integer a = userMapper.delRoleByUserId(userId);
        //删除该用户
        Integer b = userMapper.deleteUser(userId);
        return b;
    }

    @Override
    public Integer updatePassword(User user) {
        return userMapper.updatePassword(user);
    }


    @Override
    public User findUserById(Integer userId) {
        User user = new User();
        user.setUserId(userId);
        User userByCondition = userMapper.getUserByCondition(user);
        return userByCondition;
    }

    @Override
    public void logInfo(Integer level, String departmentName, String detail, Integer type, Date date) {
        userMapper.logInfo(level, departmentName, detail, type, date);
    }



    @Override
    public List<User> selectAllUser() {
        User user = new User();
        int countUser = userMapper.getCountUser(user);
        List<User> userByCondition = userMapper.getUserListByCondition(user, 0, countUser);
        return userByCondition;
    }



}
