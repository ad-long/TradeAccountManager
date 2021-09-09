package com.sunginfo.trade_account_manager.service;

import java.util.Date;
import java.util.List;

import com.sunginfo.trade_account_manager.mapper.UserMapper;
import com.sunginfo.trade_account_manager.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    public User getUser(String name) {
        return userMapper.getUserByName(name);
    }

    public void addUser(String name, String pwd, Boolean enable, Boolean is_biller, Boolean is_trader,
            String superior_trader) {
        userMapper.addUser(name, pwd, enable, is_biller, is_trader, superior_trader);
    }

    public List<User> getUsersByGeTime(Date create_time) {
        return userMapper.getUsersByGeTime(create_time);
    }

    public void delUser(String name) {
        userMapper.delUserByName(name);
    }
}
