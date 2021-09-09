package com.sunginfo.trade_account_manager.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.*;

import com.sunginfo.trade_account_manager.model.Product;

public interface ProductMapper {
    @Select("select * from product")
    List<Product> getAllProduct();

    @Select("select * from product where name=#{name}")
    Product getProductByName(String name);

    @Select("select * from product where create_time>=#{create_time}")
    List<Product> getProductsByGeTime(Date create_time);

    @Insert({ "insert into product(name,user_superior_trader,enable)"
            + "values(#{name},#{user_superior_trader},#{enable})" })
    void addProduct(String name, String user_superior_trader, Boolean enable);

    @Delete("delete from product where name=#{name}")
    void delProductByName(String name);
}
