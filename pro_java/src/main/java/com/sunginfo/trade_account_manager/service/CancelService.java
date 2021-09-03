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
    private CancelMapper CancelMapper;

    public List<Cancel> getAllCancels() {
        return CancelMapper.getAllCancels();
    }

    public Cancel getCancel(String id) {
        return CancelMapper.getCancelById(id);
    }

    public void addCancel(String order_id) {
        CancelMapper.addCancel(order_id);
    }

    public List<Cancel> getCancelsByGeTime(Date create_time) {
        return CancelMapper.getCancelsByGeTime(create_time);
    }

    public void delCancel(String id) {
        CancelMapper.delCancelById(id);
    }
}
