package com.service.serviceImp;

import com.bean.Permission;
import com.bean.UserCare;
import com.bean.Response;
import com.dao.UserCareMapper;
import com.service.UserCareService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * Created
 */
@Service(value = "UserCareService")
@Transactional
public class UserCareServiceImpl implements UserCareService {
    @Resource
    private UserCareMapper userCareMapper;

    @Override
    public void UserCareList(Response response,String user_id,String group_name) {
        System.out.print("关心列表");
        JSONObject jsonObject = new JSONObject();
        try {
            List<UserCare> userCareList = userCareMapper.userCareList(user_id,group_name);
            //可以返回多个数据
            jsonObject.put("userCareList",userCareList);
            //将多个数据返回
            response.setData(jsonObject);
        }catch (Exception e){//捕捉异常，返回异常信息
            response.failure(e.getMessage());
            return;
        }
        response.success();
    }

//    @Override
//    public Integer updateUserCarePermission(String userCare_id, String[] permission_ids) {
//        //删除权限
//        Integer d = userCareMapper.deleteUserCarePermission(userCare_id);
//        //新增权限
//        if (permission_ids != null && permission_ids.length > 0) {
//            Integer i = userCareMapper.insertUserCarePermission(userCare_id, permission_ids);
//        }
//        return null;
//    }
//
//    @Override
//    public List<Permission> getAllPermission() {
//        Integer fid = 0;
//        List<Permission> permissions = userCareMapper.getPermissionByFid(fid);
//        List<Permission> allPermission = getAllPermission(permissions);
//        return allPermission;
//    }
//
//    @Override
//    public List<Integer> getPermissionIdByUserCareId(String UserCare_id) {
//        return userCareMapper.getPermissionIdByUserCareId(UserCare_id);
//    }
//
    @Override
    public Integer addUserCare(UserCare UserCare) {
        return userCareMapper.addUserCare(UserCare);
    }

    @Override
    public Integer updateUserCare(UserCare UserCare) {
        return userCareMapper.updateUserCare(UserCare);
    }

    @Override
    public Integer delUserCare(UserCare UserCare) {
        System.out.print("123456789");
        Integer r = userCareMapper.deleteUserCare(UserCare);
//        Integer rp = UserCareMapper.deleteUserCarePermission(UserCare_id);
        System.out.print("1111111111");
        return r ;
    }

    @Override
    public void choseGroup(Response response,int  user_id) {
        System.out.print("关心列表");
        JSONObject jsonObject = new JSONObject();
        try {
            List<UserCare> userCareGroupList = userCareMapper.choseGroup(user_id);
            //可以返回多个数据
            jsonObject.put("userCareGroupList",userCareGroupList);
            //将多个数据返回
            response.setData(jsonObject);
        }catch (Exception e){//捕捉异常，返回异常信息
            response.failure(e.getMessage());
            return;
        }
        response.success();
    }

    @Override
    public void addGroup(Response response,int user_id,String group_name) {
        JSONObject jsonObject = new JSONObject();
        try {
            int r = userCareMapper.addGroup(user_id,group_name);
            //可以返回多个数据
            jsonObject.put("userCareGroupList",r);
            //将多个数据返回
            response.setData(jsonObject);
        }catch (Exception e){//捕捉异常，返回异常信息
            response.failure(e.getMessage());
            return;
        }
        response.success();
    }

    @Override
    public void updateGroup(Response response,int user_id,String group_name1,String group_name2) {
        JSONObject jsonObject = new JSONObject();
        try {
            int r = userCareMapper.updateGroup(user_id,group_name1,group_name2);
            //可以返回多个数据
            jsonObject.put("userCareGroupList",r);
            //将多个数据返回
            response.setData(jsonObject);
        }catch (Exception e){//捕捉异常，返回异常信息
            response.failure(e.getMessage());
            return;
        }
        response.success();
    }

    @Override
    public void deleteGroup(Response response,int user_id,String group_name) {
        JSONObject jsonObject = new JSONObject();
        try {
            int r = userCareMapper.deleteGroup(user_id,group_name);
            //可以返回多个数据
            jsonObject.put("userCareGroupList",r);
            //将多个数据返回
            response.setData(jsonObject);
        }catch (Exception e){//捕捉异常，返回异常信息
            response.failure(e.getMessage());
            return;
        }
        response.success();
    }
}
