package com.bean;

import java.io.Serializable;

/**
 * Created by 郑超一 on 2017/1/18.
 */
public class UserCare implements Serializable{
    private Integer group_id;
    private Integer user_id;
    private Integer count;
    private String company_name;
    private String group_name;
    private String industry_business_name;

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getIndustry_business_name() { return industry_business_name;}

    public void setIndustry_business_name(String industry_business_name) { this.industry_business_name = industry_business_name;}
}
