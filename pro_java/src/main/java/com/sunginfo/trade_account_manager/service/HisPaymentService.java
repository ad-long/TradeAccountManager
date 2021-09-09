package com.sunginfo.trade_account_manager.service;

import java.util.Date;
import java.util.List;

import com.sunginfo.trade_account_manager.mapper.HisPaymentMapper;
import com.sunginfo.trade_account_manager.model.HisPayment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HisPaymentService {
    @Autowired
    private HisPaymentMapper hisPaymentMapper;

    public List<HisPayment> getAllHisPayment() {
        return hisPaymentMapper.getAllHisPayment();
    }

    public HisPayment getHisPaymentById(Long id) {
        return hisPaymentMapper.getHisPaymentById(id);
    }

    public List<HisPayment> getHisPaymentByProduct(String product) {
        return hisPaymentMapper.getHisPaymentByProduct(product);
    }

    public List<HisPayment> getHisPaymentByCash(String cash) {
        return hisPaymentMapper.getHisPaymentByCash(cash);
    }

    public List<HisPayment> getHisPaymentByUser(String user) {
        return hisPaymentMapper.getHisPaymentByUser(user);
    }

    public Long addHisPayment(String product_name, String cash_name, String user_name, String algo_name,
            Float pay_amount, String hold_symbol, Float hold_vol, String hold_flag) {
        return hisPaymentMapper.addHisPayment(product_name, cash_name, user_name, algo_name, pay_amount, hold_symbol, hold_vol,
                hold_flag);
    }

    public List<HisPayment> getHisPaymentByGeTime(Date create_time) {
        return hisPaymentMapper.getHisPaymentByGeTime(create_time);
    }

    public void delHisPayment(String id) {
        hisPaymentMapper.delHisPaymentById(id);
    }
}
