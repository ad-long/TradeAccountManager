package com.sunginfo.trade_account_manager.service;

import java.sql.Date;
import java.util.List;

import com.sunginfo.trade_account_manager.mapper.CashMapper;
import com.sunginfo.trade_account_manager.model.Cash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashService {
    @Autowired
    private CashMapper CashMapper;

    public List<Cash> getAllCashs() {
        return CashMapper.getAllCashs();
    }

    public Cash getCash(String name) {
        return CashMapper.getCashByName(name);
    }

    public void addCash(String name, String product_name, Float total, Float frozen, Float available, Boolean enable) {
        CashMapper.addCash(name, product_name, total, frozen, available, enable);
    }

    public List<Cash> getCashsByGeTime(Date create_time) {
        return CashMapper.getCashsByGeTime(create_time);
    }

    public void delCash(String name) {
        CashMapper.delCashByName(name);
    }
}
