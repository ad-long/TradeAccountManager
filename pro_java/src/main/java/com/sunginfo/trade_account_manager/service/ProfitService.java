package com.sunginfo.trade_account_manager.service;

import java.util.Date;
import java.util.List;

import com.sunginfo.trade_account_manager.mapper.ProfitMapper;
import com.sunginfo.trade_account_manager.model.Profit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfitService {
    @Autowired
    private ProfitMapper profitMapper;

    public List<Profit> getAllProfit() {
        return profitMapper.getAllProfit();
    }

    public Profit getProfitById(Long id) {
        return profitMapper.getProfitById(id);
    }

    public List<Profit> getProfitByProduct(String product) {
        return profitMapper.getProfitByProduct(product);
    }

    public List<Profit> getProfitByCash(String cash) {
        return profitMapper.getProfitByCash(cash);
    }

    public List<Profit> getProfitByUser(String user) {
        return profitMapper.getProfitByUser(user);
    }

    public Long addProfit(String product_name, String cash_name, String user_name, String algo_name, String hold_symbol,
            String hold_flag, Float total_pay_amount, Float total_hold_vol) {
        return profitMapper.addProfit(product_name, cash_name, user_name, algo_name, hold_symbol, hold_flag, total_pay_amount,
                total_hold_vol);
    }

    public List<Profit> getProfitByGeTime(Date create_time) {
        return profitMapper.getProfitByGeTime(create_time);
    }

    public void delProfit(String id) {
        profitMapper.delProfitById(id);
    }
}
