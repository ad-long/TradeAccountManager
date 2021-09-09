package com.sunginfo.trade_account_manager.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sunginfo.trade_account_manager.model.Cancel;
import com.sunginfo.trade_account_manager.service.CancelService;
import com.sunginfo.trade_account_manager.utils.JsonData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CancelController {
    @Autowired
    CancelService cancelService;

    @RequestMapping("/cancel/all")
    @GetMapping
    String CancelAll() {
        String result = JsonData.getInit();
        try {
            List<Cancel> data = cancelService.getAllCancel();
            if (data != null) {
                result = JsonData.getResult(true, "[]");
            } else {
                result = JsonData.getResult(true, data);
            }
        } catch (Exception e) {
            result = JsonData.getResult(false, e);
        }
        return result;
    }

    @RequestMapping("/cancel/byid")
    @GetMapping
    String getCancelByName(Long id) {
        String result = JsonData.getInit();
        try {
            Cancel data = cancelService.getCancel(id);
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

    @RequestMapping("/cancel/bytime")
    @GetMapping
    String getCancelByTime(String create_time) {
        String result = JsonData.getInit();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date ct = sdf.parse(create_time);
            List<Cancel> data = cancelService.getCancelsByGeTime(ct);
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

    @RequestMapping("/cancel/add")
    @PostMapping
    void addCancel(@RequestBody Map<String, String> payload) {
        cancelService.addCancel(payload.get("order_id"));
    }

    @RequestMapping("/cancel/del")
    @PostMapping
    void delCancel(@RequestBody Map<String, String> payload) {
        cancelService.delCancel(payload.get("name"));
    }
}