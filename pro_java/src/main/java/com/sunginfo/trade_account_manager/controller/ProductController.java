package com.sunginfo.trade_account_manager.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sunginfo.trade_account_manager.model.Product;
import com.sunginfo.trade_account_manager.service.ProductService;
import com.sunginfo.trade_account_manager.utils.JsonData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/product/all")
    @GetMapping
    String ProductAll() {
        String result = JsonData.getInit();
        try {
            List<Product> data = productService.getAllProduct();
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

    @RequestMapping("/product/byname")
    @GetMapping
    String getProductByName(String name) {
        String result = JsonData.getInit();
        try {
            Product data = productService.getProduct(name);
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

    @RequestMapping("/product/bytime")
    @GetMapping
    String getProductByTime(String create_time) {
        String result = JsonData.getInit();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date ct = sdf.parse(create_time);
            List<Product> data = productService.getProductsByGeTime(ct);
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

    @RequestMapping("/product/add")
    @PostMapping
    void addProduct(@RequestBody Map<String, String> payload) {
        Boolean enable = true;
        if (payload.containsKey("enable")) {
            enable = Boolean.parseBoolean(payload.get("enable"));
        }
        productService.addProduct(payload.get("name"), payload.get("user_superior_trader"), enable);
    }

    @RequestMapping("/product/del")
    @PostMapping
    void delProduct(@RequestBody Map<String, String> payload) {
        productService.delProduct(payload.get("name"));
    }
}