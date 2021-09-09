package com.sunginfo.trade_account_manager.service;

import java.util.Date;
import java.util.List;

import com.sunginfo.trade_account_manager.mapper.ProductMapper;
import com.sunginfo.trade_account_manager.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public List<Product> getAllProduct() {
        return productMapper.getAllProduct();
    }

    public Product getProduct(String name) {
        return productMapper.getProductByName(name);
    }

    public void addProduct(String name, String user_superior_trader, Boolean enable) {
        productMapper.addProduct(name, user_superior_trader, enable);
    }

    public List<Product> getProductsByGeTime(Date create_time) {
        return productMapper.getProductsByGeTime(create_time);
    }

    public void delProduct(String name) {
        productMapper.delProductByName(name);
    }
}
