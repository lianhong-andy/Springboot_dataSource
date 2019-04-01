package com.andy.controller;

import com.andy.model.TourAdmin;
import com.andy.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/user")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/hello.do")
    public String hello(String name){
        log.debug("hello");
        return "hello "+name;
    }

    @GetMapping("get/{id}")
    public TourAdmin getUserById(@PathVariable(name = "id",required = false) Long id){
        return adminService.getUserById(id);
    }
}
