package com.dao;

import com.bean.Permission;
import com.bean.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by lenovo on 2016/11/25.
 */
@Repository("roleMapper")
public interface RoleMapper {
    List<Role> roleList();

    List<Integer> getPermissionIdByRoleId(@Param("role_id") String role_id);

    List<Permission> getPermissionByFid(@Param("fid") Integer fid);

    Integer deleteRolePermission(@Param("role_id") String role_id);

    Integer insertRolePermission(@Param("role_id") String role_id,@Param("permission_ids") String[] permission_ids);

    Integer addRole(Role role);

    Integer updateRole(Role role);

    Integer delRole(String role_id);

    Set<Permission> getPermissionByRoleId(@Param("role_id") Integer role_id);
}
