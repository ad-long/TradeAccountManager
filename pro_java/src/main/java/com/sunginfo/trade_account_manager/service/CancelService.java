package com.sunginfo.trade_account_manager.service;

import java.util.Date;
import java.util.List;

import com.sunginfo.trade_account_manager.mapper.CancelMapper;
import com.sunginfo.trade_account_manager.model.Cancel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelService {
    @Autowired
    private CancelMapper cancelMapper;

    public List<Cancel> getAllCancel() {
        return cancelMapper.getAllCancel();
    }

    public Cancel getCancel(Long id) {
        return cancelMapper.getCancelById(id);
    }

    public void addCancel(String order_id) {
        cancelMapper.addCancel(order_id);
    }

    public List<Cancel> getCancelsByGeTime(Date create_time) {
        return cancelMapper.getCancelsByGeTime(create_time);
    }

    public void delCancel(String id) {
        cancelMapper.delCancelById(id);
    }
}
