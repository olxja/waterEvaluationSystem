package com.bean;

public class ErrorInfo {

    public String retCode;
    public String retMsg;

    public ErrorInfo() {
        this.retCode = "";
        this.retMsg = "";
    }

    public ErrorInfo(String retCode) {
        this.retCode = retCode;
        this.retMsg = "";
    }

    public ErrorInfo(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public ErrorInfo(Integer retCode, String retMsg) {
        this.retCode = String.valueOf(retCode);
        this.retMsg = retMsg;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public String getRetCode() {
        return retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

}
