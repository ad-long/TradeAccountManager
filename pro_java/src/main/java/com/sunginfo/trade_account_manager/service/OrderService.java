package com.sunginfo.trade_account_manager.service;

import java.sql.Date;
import java.util.List;

import com.sunginfo.trade_account_manager.mapper.OrderMapper;
import com.sunginfo.trade_account_manager.model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderMapper OrderMapper;

    public List<Order> getAllOrders() {
        return OrderMapper.getAllOrders();
    }

    public Order getOrder(String id) {
        return OrderMapper.getOrderById(id);
    }

    public Long addOrder(String product_name, String cash_name, String user_name, String algo_name, String symbol,
            Float price, Float slide, Float vol, String offset, String direction) {
        return OrderMapper.addOrder(product_name, cash_name, user_name, algo_name, symbol, price, slide, vol, offset,
                direction);
    }

    public List<Order> getOrdersByGeTime(Date create_time) {
        return OrderMapper.getOrdersByGeTime(create_time);
    }

    public void delOrder(String id) {
        OrderMapper.delOrderById(id);
    }
}
