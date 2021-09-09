package com.sunginfo.trade_account_manager.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.*;

import com.sunginfo.trade_account_manager.model.HisPayment;

public interface HisPaymentMapper {
    @Select("select * from his_payment")
    List<HisPayment> getAllHisPayment();

    @Select("select * from his_payment where id=#{id}")
    HisPayment getHisPaymentById(Long id);

    @Select("select * from his_payment where product_name=#{product}")
    List<HisPayment> getHisPaymentByProduct(String product);

    @Select("select * from his_payment where cash_name=#{cash}")
    List<HisPayment> getHisPaymentByCash(String cash);

    @Select("select * from his_payment where user_name=#{user}")
    List<HisPayment> getHisPaymentByUser(String user);

    @Select("select * from his_payment where create_time>=#{create_time}")
    List<HisPayment> getHisPaymentByGeTime(Date create_time);

    @Insert({ "insert into his_payment(product_name,cash_name,user_name,algo_name,pay_amount,hold_symbol,hold_vol,hold_flag)"
              +"values(#{product_name},#{cash_name},#{user_name},#{algo_name},#{pay_amount},#{hold_symbol},#{hold_vol},#{hold_flag})" })
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Long.class)
    Long addHisPayment(String product_name, String cash_name, String user_name, String algo_name, Float pay_amount,
            String hold_symbol, Float hold_vol, String hold_flag);

    @Delete("delete from his_payment where id=#{id}")
    void delHisPaymentById(String id);
}
