package com.sunginfo.trade_account_manager.model;

import java.util.Date;
import lombok.Data;

@Data
public class Cancel {
    String order_id;
    Date create_time;
}
