package com.sunginfo.trade_account_manager.model;

import java.util.Date;
import lombok.Data;

@Data
public class Profit {
    Long id;
    String product_name;
    String cash_name;
    String user_name;
    String algo_name;
    String hold_symbol;
    String hold_flag;
    Float total_pay_amount;
    Float total_hold_vol;
    Date statistics_time;
}
