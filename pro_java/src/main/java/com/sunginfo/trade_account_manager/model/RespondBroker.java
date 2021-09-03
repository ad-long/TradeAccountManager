package com.sunginfo.trade_account_manager.model;

import java.util.Date;
import lombok.Data;

@Data
public class RespondBroker {
    long id;
    String order_id;
    String traded_id;
    Float traded_price;
    Float traded_vol;
    Float traded_amount;
    Boolean is_complete;
    Date respond_time;
    Date create_time;
}
