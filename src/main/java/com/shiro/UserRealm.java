package com.shiro;

import com.bean.Permission;
import com.bean.Role;
import com.bean.User;
import com.service.RoleService;
import com.service.UserService;
import com.utils.Constants;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.*;


/**
 * Created by lenovo on 2016/8/18.
 */
public class UserRealm extends JdbcRealm {

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;

    /**
     * 授权操作
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        User user = userService.loginUserByEmailOrPhone(username);
        List<Role> roleList = user.getRoleList();
        //角色名的集合
        List<String> roles = new ArrayList<>();
        //权限名集合
        Set<String> permissions = new HashSet<>();
        for (Role role : roleList) {
            roles.add(role.getRole_name());
            //根据角色选择用户
            Set<Permission> permissionSet = roleService.getPermissionByRoleId(role.getRole_id());
            for (Permission permission : permissionSet) {
                String permission_name = permission.getPermission_name();
                permissions.add(permission_name);
            }
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //添加角色名集合
        authorizationInfo.addRoles(roles);
        //添加权限名集合
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;
    }

    /**
     * 身份验证操作
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws UnknownAccountException {
        try {
            UsernamePasswordToken usernamePasswordtoken = (UsernamePasswordToken) token;
            String username = usernamePasswordtoken.getUsername();
            if (!StringUtils.isBlank(username)) {
                User user = userService.loginUserByEmailOrPhone(username);
                if (user != null) {
                    return new SimpleAuthenticationInfo(username, user.getPassword(), getName());
                } else {
                    //木有找到用户
                    throw new UnknownAccountException("没有找到该账号");
                }
            }
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public String getName() {
        return getClass().getName();
    }
}
