package com.yy.bookkeeping.controller;

import com.yy.bookkeeping.entity.Bills;
import com.yy.bookkeeping.entity.JsonResult;
import com.yy.bookkeeping.service.BillsService;
import com.yy.bookkeeping.util.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BillsController {
    @Autowired
    private BillsService billsService;

    @GetMapping("/bills")
    public JsonResult getBills(Integer billsType,String startDate,String endDate,Integer pageNo,Integer pageSize){
        if(pageNo == null){
            pageNo = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        Integer dataCount = billsService.getBillsCount(billsType,startDate,endDate);
        List<Bills> bills = billsService.getBills(billsType, startDate, endDate, pageNo, pageSize);
        PageSupport pageSupport = new PageSupport(pageNo,pageSize,dataCount,bills);
        return JsonResult.ok(pageSupport);
    }

    @PostMapping("/addBill")
    @Transactional
    public JsonResult addBill(@Valid Bills bills, BindingResult bindingResult){
        List<FieldError> errors = bindingResult.getFieldErrors();
        if(errors.size() <= 0){
            billsService.addBill(bills);
            return JsonResult.ok(null);
        }else{
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < errors.size(); i++) {
                sb.append(errors.get(i).getDefaultMessage()+"\n");
            }
            return JsonResult.err("验证不通过!\n"+sb.toString());
        }
    }


}
