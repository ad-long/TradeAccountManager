
-- drop table if exists trade_account_manager.respond_broker;

create table trade_account_manager.respond_broker(
	id int primary key auto_increment,
	order_id char(63),
	traded_id char(63) not null,
	traded_price float not null,
	traded_vol float not null,
	traded_amount float not null,
	is_complete boolean not null default false,
    respond_time datetime not null,
    create_time datetime not null default current_timestamp,
    index i_respond_broker_order_id(order_id),
    index i_respond_broker_traded_id(traded_id),
    index i_respond_broker_is_complete(is_complete),
    index i_respond_broker_respond_time(respond_time)
);