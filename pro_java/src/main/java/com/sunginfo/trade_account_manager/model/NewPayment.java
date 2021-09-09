package com.sunginfo.trade_account_manager.model;

import java.util.Date;
import lombok.Data;

@Data
public class NewPayment {
    Long id;
    String product_name;
    String cash_name;
    String user_name;
    String algo_name;
    Float pay_amount;
    String hold_symbol;
    Float hold_vol;
    String hold_flag;
    Date time;
}
