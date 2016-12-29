package com.service;

import com.bean.Permission;
import com.bean.Role;

import java.util.List;
import java.util.Set;

/**
 * Created by lenovo on 2016/11/18.
 */
public interface RoleService {
    List<Role> roleList();

    Integer updateRolePermission(String role_id,String[] permission_ids);

    List<Permission> getAllPermission();

    List<Integer> getPermissionIdByRoleId(String role_id);

    Integer addRole(Role role);

    Integer updateRole(Role role);

    Integer delRole(String role_id);

    Set<Permission> getPermissionByRoleId(Integer role_id);
}
