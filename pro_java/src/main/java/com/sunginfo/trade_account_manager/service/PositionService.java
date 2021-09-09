package com.sunginfo.trade_account_manager.service;

import java.sql.Date;
import java.util.List;

import com.sunginfo.trade_account_manager.mapper.PositionMapper;
import com.sunginfo.trade_account_manager.model.Position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {
    @Autowired
    private PositionMapper positionMapper;

    public List<Position> getAllPosition() {
        return positionMapper.getAllPosition();
    }

    public Position getPositionById(Long id) {
        return positionMapper.getPositionById(id);
    }

    public Position getPositionByProduct(String product) {
        return positionMapper.getPositionByProduct(product);
    }

    public Position getPositionByCash(String cash) {
        return positionMapper.getPositionByCash(cash);
    }

    public Position getPositionByUser(String user) {
        return positionMapper.getPositionByUser(user);
    }

    public Long addPosition(String product_name, String cash_name, String user_name, String algo_name, String symbol, Float vol, String flag) {
        return positionMapper.addPosition(product_name, cash_name, user_name, algo_name, symbol, vol, flag);
    }

    public List<Position> getPositionsByGeTime(Date create_time) {
        return positionMapper.getPositionsByGeTime(create_time);
    }

    public void delPosition(Long id) {
        positionMapper.delPositionById(id);
    }
}
