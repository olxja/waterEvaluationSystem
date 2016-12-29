package com.service.serviceImp;

import com.bean.Permission;
import com.bean.Role;
import com.dao.RoleMapper;
import com.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * Created by lenovo on 2016/11/18.
 */
@Service(value = "roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> roleList() {
        return roleMapper.roleList();
    }

    @Override
    public Integer updateRolePermission(String role_id, String[] permission_ids) {
        //删除权限
        Integer d = roleMapper.deleteRolePermission(role_id);
        //新增权限
        if (permission_ids != null && permission_ids.length > 0) {
            Integer i = roleMapper.insertRolePermission(role_id, permission_ids);
        }
        return null;
    }

    @Override
    public List<Permission> getAllPermission() {
        Integer fid = 0;
        List<Permission> permissions = roleMapper.getPermissionByFid(fid);
        List<Permission> allPermission = getAllPermission(permissions);
        return allPermission;
    }

    @Override
    public List<Integer> getPermissionIdByRoleId(String role_id) {
        return roleMapper.getPermissionIdByRoleId(role_id);
    }

    @Override
    public Integer addRole(Role role) {
        return roleMapper.addRole(role);
    }

    @Override
    public Integer updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    @Override
    public Integer delRole(String role_id) {
        Integer r = roleMapper.delRole(role_id);
        Integer rp = roleMapper.deleteRolePermission(role_id);
        return r * rp;
    }

    @Override
    public Set<Permission> getPermissionByRoleId(Integer role_id) {
        return roleMapper.getPermissionByRoleId(role_id);
    }

    /*递归*/
    private List<Permission> getAllPermission(List<Permission> permissions) {
        for (Permission permission : permissions) {
            Integer permission_id = permission.getPermission_id();

            List<Permission> permissionByFid = roleMapper.getPermissionByFid(permission_id);
            permission.setChildren(permissionByFid);
            getAllPermission(permissionByFid);
        }
        return permissions;
    }
}
