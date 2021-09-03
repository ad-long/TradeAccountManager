package com.sunginfo.trade_account_manager.model;

import java.util.Date;
import lombok.Data;

@Data
public class User {
    String name;
    String pwd;
    String enable;
    Boolean is_biller;
    Boolean is_trader;
    String superior_trader;
    Date create_time;
    Date update_time;
}
