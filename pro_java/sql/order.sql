
-- drop table if exists trade_account_manager.order;

create table trade_account_manager.order(
	id int primary key auto_increment,
	user_name char(63) not null,
	product_name char(63) not null,
	cash_name char(63) not null,
	algo_name char(63) default null,
	symbol char(255) not null,
	price float not null,
	slide float not null,
	vol float not null,
	offset char(255) not null,
	direction char(255) not null,
	traded_id char(255) not null,
	traded_price float not null,
	traded_vol float not null,
	traded_amount float not null,
	is_complete boolean not null default false,
    create_time datetime not null default current_timestamp,
    update_time timestamp not null default current_timestamp on
update
	current_timestamp,
    index i_order_user_name(user_name),
    index i_order_product_name(product_name),
    index i_order_cash_name(cash_name),
    index i_order_algo_name(algo_name),
    index i_order_symbol(symbol),
    index i_order_is_complete(is_complete),
    index i_order_update_time(update_time)
);