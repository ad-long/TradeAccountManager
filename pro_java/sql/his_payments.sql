
-- drop table if exists trade_account_manager.his_payments;

create table trade_account_manager.his_payments(
	id int primary key auto_increment,
	user_name char(63) not null,
	product_name char(63) not null,
	cash_name char(63) not null,
	algo_name char(63) default null,
	pay_amount float not null,
	hold_symbol char(255) not null,
	hold_vol float not null,
	hold_flag char(255) not null,
    time datetime not null default current_timestamp,
    index i_his_payments_user_name(user_name),
    index i_his_payments_product_name(product_name),
    index i_his_payments_cash_name(cash_name),
    index i_his_payments_algo_name(algo_name),
    index i_his_payments_hold_symbol(hold_symbol),
    index i_his_payments_hold_flag(hold_flag),
    index i_his_payments_time(time)
);