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
    private OrderMapper orderMapper;

    public List<Order> getAllOrder() {
        return orderMapper.getAllOrder();
    }

    public Order getOrderById(Long id) {
        return orderMapper.getOrderById(id);
    }

    public List<Order> getOrderByProduct(String product) {
        return orderMapper.getOrderByProduct(product);
    }

    public List<Order> getOrderByCash(String cash) {
        return orderMapper.getOrderByCash(cash);
    }

    public List<Order> getOrderByUser(String user) {
        return orderMapper.getOrderByUser(user);
    }

    public Long addOrder(String product_name, String cash_name, String user_name, String algo_name, String symbol,
            Float price, Float slide, Float vol, String offset, String direction) {
        return orderMapper.addOrder(product_name, cash_name, user_name, algo_name, symbol, price, slide, vol, offset,
                direction);
    }

    public List<Order> getOrdersByGeTime(Date create_time) {
        return orderMapper.getOrdersByGeTime(create_time);
    }

    public void delOrder(String id) {
        orderMapper.delOrderById(id);
    }
}
