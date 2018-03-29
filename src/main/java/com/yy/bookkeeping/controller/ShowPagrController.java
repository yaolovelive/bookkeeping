package com.yy.bookkeeping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowPagrController {

    @GetMapping(value = {"/index.html","/"})
    public String toIndex(){

        return "index";
    }

    @GetMapping("/bookkeeping.html")
    public String toBookkeeping(){

        return "bookkeeping";
    }

}
