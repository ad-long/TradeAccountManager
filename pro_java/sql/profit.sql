
-- drop table if exists trade_account_manager.profit;

create table trade_account_manager.profit(
	id int primary key auto_increment,
	user_name char(63) not null,
	product_name char(63) not null,
	cash_name char(63) not null,
	algo_name char(63) default null,
	hold_symbol char(255) not null,
	hold_flag char(255) not null,
	total_pay_amount float not null,
	total_hold_vol float not null,
    statistics_time datetime not null default current_timestamp,
    index i_profit_user_name(user_name),
    index i_profit_product_name(product_name),
    index i_profit_cash_name(cash_name),
    index i_profit_algo_name(algo_name),
    index i_profit_hold_symbol(hold_symbol),
    index i_profit_hold_flag(hold_flag),
    index i_profit_statistics_time(statistics_time)
);