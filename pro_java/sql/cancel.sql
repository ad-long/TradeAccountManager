
-- drop table if exists trade_account_manager.cancel;

create table trade_account_manager.cancel(
	order_id int primary key not null,
    create_time datetime not null default current_timestamp,
    index i_cancel_update_time(create_time)
);