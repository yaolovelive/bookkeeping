package com.yy.bookkeeping.service.impl;

import com.yy.bookkeeping.dao.BillTypeDao;
import com.yy.bookkeeping.entity.BillType;
import com.yy.bookkeeping.service.BillTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("billTypeService")
public class BillTypeServiceImpl implements BillTypeService {

    @Autowired
    private BillTypeDao billTypeDao;

    @Override
    public List<BillType> getAllBillTypes() {

        return billTypeDao.getAllBillTypes();
    }
}
