package com.yym.springboot.nodeexporter.controller;

import com.yym.springboot.nodeexporter.componet.PromComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {

    @Autowired
    private PromComponent promComponent;

    @GetMapping("/test")
    public String test(){
        promComponent.setTotal();
        return "操作完成";
    }
}
