package com.sunginfo.trade_account_manager.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.*;

import com.sunginfo.trade_account_manager.model.Cash;

public interface CashMapper {
    @Select("select * from cash")
    List<Cash> getAllCashs();

    @Select("select * from cash where name=#{name}")
    Cash getCashByName(String name);

    @Select("select * from cash where create_time>=#{create_time}")
    List<Cash> getCashsByGeTime(Date create_time);

    @Insert({ "insert into cash(name,product_name,total,frozen,available,enable)"
            + "values(#{name},#{product_name},#{total},#{frozen},#{available},#{enable})" })
    void addCash(String name, String product_name, Float total, Float frozen, Float available, Boolean enable);

    @Delete("delete from cash where name=#{name}")
    void delCashByName(String name);
}
