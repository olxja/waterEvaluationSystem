package com.controller;

import com.bean.Permission;
import com.bean.Role;
import com.service.RoleService;
import com.utils.Constants;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lenovo on 2016/11/18.
 */
@Controller
public class RoleController {

    @Resource
    private RoleService roleService;

    //角色列表
    @RequestMapping(value = "/roleList")
    @ResponseBody
//    public String roleList(HttpServletRequest request, Model model) {
//        request.getSession().setAttribute("module", Constants.SYSTEM);
//        List<Role> roles = roleService.roleList();
//        model.addAttribute("roles", roles);
//        return "system/roleList";
//    }
    public String roleList(HttpServletRequest request, Model model) {
        JSONObject jsonObject = new JSONObject();
        request.getSession().setAttribute("module", Constants.SYSTEM);
        List<Role> roles = roleService.roleList();
        model.addAttribute("roles", roles);
        jsonObject.put("roles", roles);
        return jsonObject.toString();
    }


    @RequestMapping(value = "/getPermissionByRoleId")
    @ResponseBody
    public String getPermissionByRoleId(String role_id) {
        List<Permission> permissionList = roleService.getAllPermission();
        List<Integer> permissionIds = roleService.getPermissionIdByRoleId(role_id);
        //选中
        permissionList = checked(permissionList, permissionIds);
        JSONArray jsonArray = JSONArray.fromObject(permissionList);
        String jsonString = jsonArray.toString().replace("permission_description", "text");
        return jsonString;
    }

    /*递归选中*/
    private List<Permission> checked(List<Permission> permissionList, List<Integer> permissionIds) {
        for (Permission permission : permissionList) {
            if (permissionIds.contains(permission.getPermission_id())) {
                permission.setChecked(true);
            }
            List<Permission> children = permission.getChildren();
            checked(children, permissionIds);
        }
        return permissionList;
    }

    @RequestMapping(value = "/updateRolePermission")
    public String updateRolePermission(String role_id, String permission_id) {
        if (role_id == null) {
            return "redirect:/roleList";
        }
        String[] permission_ids = new String[0];
        if (permission_id != null) {
            permission_ids = permission_id.split(",");
        }
        Integer integer = roleService.updateRolePermission(role_id, permission_ids);
        return "redirect:/roleList";
    }

    @RequestMapping(value = "/addRole")
    public String addRole(Role role) {
        Integer integer = roleService.addRole(role);
        return "redirect:/roleList";
    }

    @RequestMapping(value = "/updateRole")
    public String updateRole(Role role) {
        Integer integer = roleService.updateRole(role);
        return "redirect:/roleList";
    }

    @RequestMapping(value = "/delRole")
    public String delRole(String role_id) {
        Integer integer = roleService.delRole(role_id);
        return "redirect:/roleList";
    }


}
