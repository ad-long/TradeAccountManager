package com.sunginfo.trade_account_manager.service;

import java.sql.Date;
import java.util.List;

import com.sunginfo.trade_account_manager.mapper.ProductMapper;
import com.sunginfo.trade_account_manager.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductMapper ProductMapper;

    public List<Product> getAllProducts() {
        return ProductMapper.getAllProducts();
    }

    public Product getProduct(String name) {
        return ProductMapper.getProductByName(name);
    }

    public void addProduct(String name, String user_superior_trader, Boolean enable) {
        ProductMapper.addProduct(name, user_superior_trader, enable);
    }

    public List<Product> getProductsByGeTime(Date create_time) {
        return ProductMapper.getProductsByGeTime(create_time);
    }

    public void delProduct(String name) {
        ProductMapper.delProductByName(name);
    }
}
