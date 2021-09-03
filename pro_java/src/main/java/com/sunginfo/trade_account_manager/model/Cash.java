package com.sunginfo.trade_account_manager.model;

import java.util.Date;
import lombok.Data;

@Data
public class Cash {
    String name;
    String product_name;
    Float total;
    Float frozen;
    Float available;
    Boolean enable;
    Date create_time;
    Date update_time;
}
