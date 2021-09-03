package com.sunginfo.trade_account_manager.model;

import java.util.Date;
import lombok.Data;

@Data
public class Position {
    String product_name;
    String cash_name;
    String user_name;
    String algo_name;
    String symbol;
    Float vol;
    String flag;
    Date create_time;
    Date update_time;
}
