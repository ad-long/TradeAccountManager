
-- drop table if exists trade_account_manager.profit_product;

create table trade_account_manager.profit_product(
	id int primary key auto_increment,
	product_name char(63) not null,
	time datetime not null default current_timestamp,
	cash_amount float not null default 0,
	position_amount float not null default 0,
	total_amount float not null default 0,
    index i_profit_product_product_name(product_name),
    index i_profit_product_time(time)
);