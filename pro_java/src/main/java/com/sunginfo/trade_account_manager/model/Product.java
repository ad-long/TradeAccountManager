package com.sunginfo.trade_account_manager.model;

import java.util.Date;
import lombok.Data;

@Data
public class Product {
    String name;
    String user_superior_trader;
    Boolean enable;
    Date create_time;
    Date update_time;
}
