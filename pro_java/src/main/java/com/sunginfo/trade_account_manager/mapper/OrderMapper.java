package com.sunginfo.trade_account_manager.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.*;

import com.sunginfo.trade_account_manager.model.Order;

public interface OrderMapper {
    @Select("select * from order")
    List<Order> getAllOrder();

    @Select("select * from order where id=#{id}")
    Order getOrderById(Long id);

    @Select("select * from order where product_name=#{product}")
    List<Order> getOrderByProduct(String product);

    @Select("select * from order where cash_name=#{cash}")
    List<Order> getOrderByCash(String cash);

    @Select("select * from order where user_name=#{user}")
    List<Order> getOrderByUser(String user);

    @Select("select * from order where create_time>=#{create_time}")
    List<Order> getOrdersByGeTime(Date create_time);

    @Insert({ "insert into order(product_name,cash_name,user_name,algo_name,symbol,price,slide,vol,offset,direction)"
            + "values(#{product_name},#{cash_name},#{user_name},#{algo_name},#{symbol},#{price},#{slide},#{vol},#{offset},#{direction})" })
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Long.class)
    Long addOrder(String product_name, String cash_name, String user_name, String algo_name, String symbol, Float price,
            Float slide, Float vol, String offset, String direction);

    @Delete("delete from order where id=#{id}")
    void delOrderById(String id);
}
