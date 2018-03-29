package com.yy.bookkeeping.entity;

import com.yy.bookkeeping.util.JsonUtils;

import java.io.Serializable;

public class JsonResult implements Serializable {
    private Integer state;
    private String msg;
    private Object data;

    private JsonResult(){}

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public static JsonResult ok(Object obj){
        JsonResult jsonResult = new JsonResult();
        jsonResult.state = 200;
        jsonResult.data = obj;
        return jsonResult;
    }

    public static JsonResult err(String msg){
        JsonResult jsonResult = new JsonResult();
        jsonResult.state = 500;
        jsonResult.msg = msg;
        return jsonResult;
    }

}
