package com.yy.bookkeeping.service;

import com.yy.bookkeeping.entity.Bills;

import java.util.List;

public interface BillsService {

    Integer getBillsCount(Integer type,String startDate,String endDate);

    List<Bills> getBills(Integer type,String startDate,String endDate,Integer pageNo,Integer pageSize);

    Integer addBill(Bills bills);

}
