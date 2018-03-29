package com.yy.bookkeeping.exception;

import com.yy.bookkeeping.entity.JsonResult;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = {RestController.class, Service.class, Repository.class})
@ResponseBody
public class RestControllerException {

    @ExceptionHandler(value = RuntimeException.class)
    public JsonResult runtimeException(RuntimeException e){

        return JsonResult.err(e.getMessage());
    }

}
