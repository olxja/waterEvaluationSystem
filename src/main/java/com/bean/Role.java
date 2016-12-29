package com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by lenovo on 2016/8/18.
 */
public class Role implements Serializable  {
    private Integer role_id;
    private String role_name;
    private String role_description;
    private List<Permission> permissionSet = new ArrayList<>();

    //==========================GS===============================


    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_description() {
        return role_description;
    }

    public void setRole_description(String role_description) {
        this.role_description = role_description;
    }

    public List<Permission> getPermissionSet() {
        return permissionSet;
    }

    public void setPermissionSet(List<Permission> permissionSet) {
        this.permissionSet = permissionSet;
    }
}
