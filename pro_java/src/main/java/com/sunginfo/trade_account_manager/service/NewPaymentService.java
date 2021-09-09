package com.sunginfo.trade_account_manager.service;

import java.util.Date;
import java.util.List;

import com.sunginfo.trade_account_manager.mapper.NewPaymentMapper;
import com.sunginfo.trade_account_manager.model.NewPayment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewPaymentService {
    @Autowired
    private NewPaymentMapper newPaymentMapper;

    public List<NewPayment> getAllNewPayment() {
        return newPaymentMapper.getAllNewPayment();
    }

    public NewPayment getNewPaymentById(Long id) {
        return newPaymentMapper.getNewPaymentById(id);
    }

    public List<NewPayment> getNewPaymentByProduct(String product) {
        return newPaymentMapper.getNewPaymentByProduct(product);
    }

    public List<NewPayment> getNewPaymentByCash(String cash) {
        return newPaymentMapper.getNewPaymentByCash(cash);
    }

    public List<NewPayment> getNewPaymentByUser(String user) {
        return newPaymentMapper.getNewPaymentByUser(user);
    }

    public Long addNewPayment(String product_name, String cash_name, String user_name, String algo_name,
            Float pay_amount, String hold_symbol, Float hold_vol, String hold_flag) {
        return newPaymentMapper.addNewPayment(product_name, cash_name, user_name, algo_name, pay_amount, hold_symbol, hold_vol,
                hold_flag);
    }

    public List<NewPayment> getNewPaymentByGeTime(Date create_time) {
        return newPaymentMapper.getNewPaymentByGeTime(create_time);
    }

    public void delNewPayment(String id) {
        newPaymentMapper.delNewPaymentById(id);
    }
}
