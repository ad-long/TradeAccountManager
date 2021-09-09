
-- drop table if exists trade_account_manager.new_payment;

create table trade_account_manager.new_payment(
	id int primary key auto_increment,
	product_name char(63) not null,
	cash_name char(63) not null,
	user_name char(63) not null,
	algo_name char(63) default null,
	pay_amount float not null,
	hold_symbol char(255) not null,
	hold_vol float not null,
	hold_flag char(255) not null,
    time datetime not null default current_timestamp,
    index i_new_payment_user_name(user_name),
    index i_new_payment_product_name(product_name),
    index i_new_payment_cash_name(cash_name),
    index i_new_payment_algo_name(algo_name),
    index i_new_payment_hold_symbol(hold_symbol),
    index i_new_payment_hold_flag(hold_flag),
    index i_new_payment_time(time)
);