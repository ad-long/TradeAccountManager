
-- drop table if exists trade_account_manager.profit_user;

create table trade_account_manager.profit_user(
	id int primary key auto_increment,
	user_name char(63) not null,
	product_name char(63) not null,
	algo_name char(63) not null,
	time datetime not null default current_timestamp,
	cash_amount float not null default 0,
	position_amount float not null default 0,
	total_amount float not null default 0,
    index i_profit_user_user_name(user_name),
    index i_profit_user_product_name(product_name),
    index i_profit_user_algo_name(algo_name),
    index i_profit_user_time(time)
);