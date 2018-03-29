package com.yy.bookkeeping.controller;

import com.yy.bookkeeping.entity.JsonResult;
import com.yy.bookkeeping.service.BillTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillsTypeController {
    @Autowired
    private BillTypeService billTypeService;

    @GetMapping("/billTypes")
    public JsonResult getBillTypes(){

        return JsonResult.ok(billTypeService.getAllBillTypes());
    }

}
