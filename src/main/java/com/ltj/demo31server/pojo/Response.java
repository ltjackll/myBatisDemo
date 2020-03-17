package com.ltj.demo31server.pojo;


import com.ltj.demo31server.enums.ResponseEnums;

public class Response<T>{
    private boolean success;
    private T data;
    private String errCode;
    private String errMsg;

    public Response(){}

    public Response(boolean success, T data) {
        super();
        this.success = success;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", data=" + data +
                ", errCode='" + errCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }

    public Response(boolean success, T data, String errCode, String errMsg) {
        super();
        this.success = success;
        this.data = data;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public Response(boolean success, String errCode, String errMsg) {
        this.success = success;
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
    public Response(boolean success, ResponseEnums enums){
        this.success=success;
        this.errCode=enums.getCode();
        this.errMsg=enums.getMsg();
    }
    public Response(boolean success, T data, ResponseEnums enums){
        this.success=success;
        this.data=data;
        this.errCode=enums.getCode();
        this.errMsg=enums.getMsg();
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public String getErrCode() {
        return errCode;
    }
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
    public String getErrMsg() {
        return errMsg;
    }
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}