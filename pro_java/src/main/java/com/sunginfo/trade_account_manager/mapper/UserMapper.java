package com.sunginfo.trade_account_manager.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.*;

import com.sunginfo.trade_account_manager.model.User;

public interface UserMapper {
    @Select("select * from user")
    List<User> getAllUser();

    @Select("select * from user where name=#{name}")
    User getUserByName(String name);

    @Select("select * from user where create_time>=#{create_time}")
    List<User> getUsersByGeTime(Date create_time);

    @Insert({ "insert into user(name,pwd,enable,is_biller,is_trader,superior_trader)"
            + "values(#{name},#{pwd},#{enable},#{is_biller},#{is_trader},#{superior_trader})" })
    void addUser(String name, String pwd, Boolean enable, Boolean is_biller, Boolean is_trader, String superior_trader);

    @Delete("delete from user where name=#{name}")
    void delUserByName(String name);
}
