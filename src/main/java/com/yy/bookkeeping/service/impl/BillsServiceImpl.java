package com.yy.bookkeeping.service.impl;

import com.yy.bookkeeping.dao.BillsDao;
import com.yy.bookkeeping.entity.Bills;
import com.yy.bookkeeping.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("billsService")
public class BillsServiceImpl implements BillsService {
    @Autowired
    private BillsDao billsDao;
    @Override
    public Integer getBillsCount(Integer type, String startDate, String endDate) {
        return billsDao.getBillsCount(type, startDate, endDate);
    }

    @Override
    public List<Bills> getBills(Integer type, String startDate, String endDate, Integer pageNo, Integer pageSize) {
        pageNo = (pageNo - 1) * pageSize;
        return billsDao.getBills(type, startDate, endDate, pageNo, pageSize);
    }

    @Override
    public Integer addBill(Bills bills) {
        return billsDao.addBill(bills);
    }
}
