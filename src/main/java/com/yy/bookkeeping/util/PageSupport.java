package com.yy.bookkeeping.util;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.List;

public class PageSupport implements Serializable {
    private Integer pageNo = 1;
    private Integer pageSize = 10;
    private Integer pageCount = 0;
    private Integer dataCount = 0;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Object data;
    public Integer getPageNo() {
        return pageNo;
    }
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getPageCount() {
        if(dataCount % pageSize == 0){
            pageCount = dataCount / pageSize;
        }else{
            pageCount = dataCount / pageSize + 1;
        }
        return pageCount;
    }
    public Integer getDataCount() {
        return dataCount;
    }
    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }

    public PageSupport() {
    }

    public PageSupport(Integer pageNo, Integer pageSize, Integer dataCount,List data) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.dataCount = dataCount;
        this.data = JSON.toJSONString(data);
    }
}
