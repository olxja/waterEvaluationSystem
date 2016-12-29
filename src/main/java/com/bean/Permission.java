package com.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2016/8/18.
 */
public class Permission  implements Serializable {
    private Integer permission_id;
    private String permission_name;
    private String permission_description;
    private Boolean checked;
    private Integer fid;
    private List<Permission> children;


    //==========================GS===============================


    public Integer getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Integer permission_id) {
        this.permission_id = permission_id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }

    public String getPermission_description() {
        return permission_description;
    }

    public void setPermission_description(String permission_description) {
        this.permission_description = permission_description;
    }

    public List<Permission> getChildren() {
        return children;
    }

    public void setChildren(List<Permission> children) {
        this.children = children;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
