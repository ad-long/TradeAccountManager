package com.sunginfo.trade_account_manager.model;

import java.util.Date;
import lombok.Data;

@Data
public class Order {
    long id;
    String product_name;
    String cash_name;
    String user_name;
    String algo_name;
    String symbol;
    Float price;
    Float slide;
    Float vol;
    String offset;
    String direction;
    String traded_id;
    Float traded_price;
    Float traded_vol;
    Float traded_amount;
    Boolean is_complete;
    Date create_time;
    Date update_time;
}
