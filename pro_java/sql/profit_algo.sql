
-- drop table if exists trade_account_manager.profit_algo;

create table trade_account_manager.profit_algo(
	id int primary key auto_increment,
	user_name char(63) not null,
	algo_name char(63) not null,
	time datetime not null default current_timestamp,
	cash_amount float not null default 0,
	position_amount float not null default 0,
	total_amount float not null default 0,
    index i_profit_algo_user_name(user_name),
    index i_profit_algo_algo_name(algo_name),
    index i_profit_algo_time(time)
);