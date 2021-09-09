
-- drop table if exists trade_account_manager.position;

create table trade_account_manager.position(
	id int primary key auto_increment,
	product_name char(63) not null,
	cash_name char(63) not null,
	user_name char(63) not null,
	algo_name char(63) default null,
	symbol char(63) not null,
	vol float not null,
	flag char(7) not null,
    create_time datetime not null default current_timestamp,
    update_time timestamp not null default current_timestamp on
update
	current_timestamp,
	CONSTRAINT u_position_upcas UNIQUE (user_name,
	product_name,
	algo_name,
	symbol),
	index i_position_product_name(product_name),
	index i_position_cash_name(cash_name),
	index i_position_user_name(user_name),
	index i_position_algo_name(algo_name),
	index i_position_symbol(symbol),
	index i_position_flag(flag),
	index i_position_update_time(update_time)
);