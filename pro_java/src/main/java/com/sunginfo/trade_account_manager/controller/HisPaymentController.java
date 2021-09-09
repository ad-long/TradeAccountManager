package com.sunginfo.trade_account_manager.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sunginfo.trade_account_manager.model.HisPayment;
import com.sunginfo.trade_account_manager.service.HisPaymentService;
import com.sunginfo.trade_account_manager.utils.JsonData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HisPaymentController {
    @Autowired
    HisPaymentService hisPayment;

    @RequestMapping("/his_payment/all")
    @GetMapping
    String HisPaymentAll() {
        String result = JsonData.getInit();
        try {
            List<HisPayment> data = hisPayment.getAllHisPayment();
            if (data == null) {
                result = JsonData.getResult(true, "[]");
            } else {
                result = JsonData.getResult(true, data);
            }
        } catch (Exception e) {
            result = JsonData.getResult(false, e);
        }
        return result;
    }

    @RequestMapping("/his_payment/byid")
    @GetMapping
    String getHisPaymentByName(Long id) {
        String result = JsonData.getInit();
        try {
            HisPayment data = hisPayment.getHisPaymentById(id);
            if (data == null) {
                result = JsonData.getResult(true, "{}");
            } else {
                result = JsonData.getResult(true, data);
            }
        } catch (Exception e) {
            result = JsonData.getResult(false, e);
        }
        return result;
    }

    @RequestMapping("/his_payment/bytime")
    @GetMapping
    String getHisPaymentByTime(String create_time) {
        String result = JsonData.getInit();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date ct = sdf.parse(create_time);
            List<HisPayment> data = hisPayment.getHisPaymentByGeTime(ct);
            if (data == null) {
                result = JsonData.getResult(true, "[]");
            } else {
                result = JsonData.getResult(true, data);
            }
        } catch (Exception e) {
            result = JsonData.getResult(false, e);
        }
        return result;
    }

    @RequestMapping("/his_payment/add")
    @PostMapping
    void addHisPayment(@RequestBody Map<String, String> payload) {
        String product_name = payload.get("product_name");
        String cash_name = payload.get("cash_name");
        String user_name = payload.get("user_name");
        String algo_name = payload.get("algo_name");
        Float pay_amount = Float.parseFloat(payload.get("pay_amount"));
        String hold_symbol = payload.get("hold_symbol");
        Float hold_vol = Float.parseFloat(payload.get("hold_vol"));
        String hold_flag = payload.get("hold_flag");
        hisPayment.addHisPayment(product_name, cash_name, user_name, algo_name, pay_amount, hold_symbol, hold_vol,
                hold_flag);
    }

    @RequestMapping("/his_payment/del")
    @PostMapping
    void delHisPayment(@RequestBody Map<String, String> payload) {
        hisPayment.delHisPayment(payload.get("name"));
    }
}