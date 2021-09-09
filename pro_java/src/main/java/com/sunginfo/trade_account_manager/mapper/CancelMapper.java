package com.sunginfo.trade_account_manager.mapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.*;

import com.sunginfo.trade_account_manager.model.Cancel;

public interface CancelMapper {
    @Select("select * from cancel")
    List<Cancel> getAllCancel();

    @Select("select * from cancel where id=#{id}")
    Cancel getCancelById(Long id);

    @Select("select * from cancel where create_time>=#{create_time}")
    List<Cancel> getCancelsByGeTime(Date create_time);

    @Insert({ "insert into cancel(order_id) values(#{order_id})" })
    void addCancel(String order_id);

    @Delete("delete from cancel where id=#{id}")
    void delCancelById(String id);
}
