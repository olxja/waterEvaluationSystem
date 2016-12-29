package com.page;

import java.io.Serializable;

/**
 * Created by lenovo on 2016/11/18.
 */
public class QueryVo implements Serializable{
    private Integer currPage = 1;
    private Integer pageSize = 10;
    private Integer startRow;

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.startRow = (currPage - 1) * pageSize;
        this.currPage = currPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.startRow = (currPage - 1) * pageSize;
        this.pageSize = pageSize;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }
}
