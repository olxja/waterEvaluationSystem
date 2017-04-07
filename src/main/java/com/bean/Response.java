package com.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class Response implements Serializable {

    /**
     */
    private static final long serialVersionUID = 8771040485405650649L;

    // 成功响应的return code为0
    private static final boolean RET_CODE_SUCCESS = true;

    private static final boolean RET_CODE_FAIL = false;

    private boolean success;

    @JsonInclude
    private Object data;

    public Response success() {
        this.success = RET_CODE_SUCCESS;
        return this;
    }

    public Response success(Object data) {
        this.success = RET_CODE_SUCCESS;
        this.data = data;
        return this;
    }

    public Response failure(Object data) {
        this.success = RET_CODE_FAIL;
        this.data = data;
        return this;
    }

    public Response failure(ErrorInfo errorInfo) {
        this.success = RET_CODE_FAIL;
        this.data = errorInfo;
        return this;
    }

    public Response failure(String retCode, String message) {
        this.success = RET_CODE_FAIL;
        ErrorInfo errorInfo = new ErrorInfo(retCode, message);
        this.data = errorInfo;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
