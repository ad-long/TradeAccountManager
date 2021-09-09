package com.sunginfo.trade_account_manager.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.*;

import com.sunginfo.trade_account_manager.model.Profit;

public interface ProfitMapper {
    @Select("select * from profit")
    List<Profit> getAllProfit();

    @Select("select * from profit where id=#{id}")
    Profit getProfitById(Long id);

    @Select("select * from profit where product_name=#{product}")
    List<Profit> getProfitByProduct(String product);

    @Select("select * from profit where cash_name=#{cash}")
    List<Profit> getProfitByCash(String cash);

    @Select("select * from profit where user_name=#{user}")
    List<Profit> getProfitByUser(String user);

    @Select("select * from profit where create_time>=#{create_time}")
    List<Profit> getProfitByGeTime(Date create_time);

    @Insert({ "insert into profit(product_name,cash_name,user_name,algo_name,pay_amount,hold_symbol,hold_vol,hold_flag, total_pay_amount, total_hold_vol)"
            + "values(#{product_name},#{cash_name},#{user_name},#{algo_name},#{pay_amount},#{hold_symbol},#{hold_vol},#{hold_flag},#{total_pay_amount},#{total_hold_vol})" })
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Long.class)
    Long addProfit(String product_name, String cash_name, String user_name, String algo_name, String hold_symbol,
            String hold_flag, Float total_pay_amount, Float total_hold_vol);

    @Delete("delete from profit where id=#{id}")
    void delProfitById(String id);
}
