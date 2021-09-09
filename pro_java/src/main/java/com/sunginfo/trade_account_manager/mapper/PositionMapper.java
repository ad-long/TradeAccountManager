package com.sunginfo.trade_account_manager.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.*;

import com.sunginfo.trade_account_manager.model.Position;

public interface PositionMapper {
    @Select("select * from position")
    List<Position> getAllPosition();

    @Select("select * from position where id=#{id}")
    Position getPositionById(Long id);

    @Select("select * from position where product_name=#{product} group by product_name")
    Position getPositionByProduct(String product);

    @Select("select * from position where cash_name=#{cash} group by cash_name")
    Position getPositionByCash(String cash);

    @Select("select * from position where user_name=#{user} group by user_name")
    Position getPositionByUser(String user);

    @Select("select * from position where create_time>=#{create_time}")
    List<Position> getPositionsByGeTime(Date create_time);

    @Insert({ "insert into position(product_name,cash_name,user_name,algo_name,symbol,vol,flag)"
            + "values(#{product_name},#{cash_name},#{user_name},#{algo_name},#{symbol},#{vol},#{flag})" })
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Long.class)
    Long addPosition(String product_name, String cash_name, String user_name, String algo_name, String symbol, Float vol, String flag);

    @Delete("delete from position where id=#{id}")
    void delPositionById(Long id);
}
