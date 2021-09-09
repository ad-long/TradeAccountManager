package com.sunginfo.trade_account_manager.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sunginfo.trade_account_manager.model.Cash;
import com.sunginfo.trade_account_manager.service.CashService;
import com.sunginfo.trade_account_manager.utils.JsonData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashController {
    @Autowired
    CashService cashService;

    @RequestMapping("/cash/all")
    @GetMapping
    String CashAll() {
        String result = JsonData.getInit();
        try {
            List<Cash> data = cashService.getAllCash();
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

    @RequestMapping("/cash/byname")
    @GetMapping
    String getCashByName(String name) {
        String result = JsonData.getInit();
        try {
            Cash data = cashService.getCash(name);
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

    @RequestMapping("/cash/bytime")
    @GetMapping
    String getCashByTime(String create_time) {
        String result = JsonData.getInit();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date ct = sdf.parse(create_time);
            List<Cash> data = cashService.getCashsByGeTime(ct);
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

    @RequestMapping("/cash/add")
    @PostMapping
    void addCash(@RequestBody Map<String, String> payload) {
        Float total = Float.parseFloat(payload.get("total"));

        Float frozen = 0f;
        if (payload.containsKey("frozen")) {
            frozen = Float.parseFloat(payload.get("frozen"));
        }

        Float available = total;
        if (payload.containsKey("available")) {
            available = Float.parseFloat(payload.get("available"));
        }

        Boolean enable = true;
        if (payload.containsKey("enable")) {
            enable = Boolean.parseBoolean(payload.get("enable"));
        }
        cashService.addCash(payload.get("name"), payload.get("product_name"), total, frozen, available, enable);
    }

    @RequestMapping("/cash/del")
    @PostMapping
    void delCash(@RequestBody Map<String, String> payload) {
        cashService.delCash(payload.get("name"));
    }
}