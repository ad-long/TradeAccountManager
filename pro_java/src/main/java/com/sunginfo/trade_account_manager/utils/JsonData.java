package com.sunginfo.trade_account_manager.utils;

import com.alibaba.fastjson.JSON;

public class JsonData {
    static public String getInit() {
        return String.format("{\"code\":%b,\"data\":\"%s\"}", false, "init status");
    }

    static public String getResult(Boolean is_ok, Object data) {
        if (data instanceof String) {
            return String.format("{\"code\":%db,\"data\":\"%s\"}", is_ok, data);
        } else if (data instanceof Exception) {
            return String.format("{\"code\":%b,\"data\":\"%s\"}", is_ok, ((Exception) data).getMessage());
        } else {
            return String.format("{\"code\":%b,\"data\":%s}", is_ok, JSON.toJSONString(data));
        }
    }
}
