package com.sunginfo.trade_account_manager.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.*;

import com.sunginfo.trade_account_manager.model.NewPayment;

public interface NewPaymentMapper {
    @Select("select * from new_payment")
    List<NewPayment> getAllNewPayment();

    @Select("select * from new_payment where id=#{id}")
    NewPayment getNewPaymentById(Long id);

    @Select("select * from new_payment where product_name=#{product}")
    List<NewPayment> getNewPaymentByProduct(String product);

    @Select("select * from new_payment where cash_name=#{cash}")
    List<NewPayment> getNewPaymentByCash(String cash);

    @Select("select * from new_payment where user_name=#{user}")
    List<NewPayment> getNewPaymentByUser(String user);

    @Select("select * from new_payment where create_time>=#{create_time}")
    List<NewPayment> getNewPaymentByGeTime(Date create_time);

    @Insert({ "insert into new_payment(product_name,cash_name,user_name,algo_name,pay_amount,hold_symbol,hold_vol,hold_flag)"
              +"values(#{product_name},#{cash_name},#{user_name},#{algo_name},#{pay_amount},#{hold_symbol},#{hold_vol},#{hold_flag})" })
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Long.class)
    Long addNewPayment(String product_name, String cash_name, String user_name, String algo_name, Float pay_amount,
            String hold_symbol, Float hold_vol, String hold_flag);

    @Delete("delete from new_payment where id=#{id}")
    void delNewPaymentById(String id);
}
