package com.sunginfo.trade_account_manager.controller;

import com.sunginfo.trade_account_manager.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/user")
    String users() {
        return userService.getAllUsers().toString();
    }
}