
-- drop table if exists trade_account_manager.cash;

create table trade_account_manager.cash(
    name char(63) primary key not null,
	product_name char(63) not null,
    total float not null default 0,
    frozen float not null default 0,
    available float not null default 0,
    enable boolean not null default true,
    create_time datetime not null default current_timestamp,
    update_time timestamp not null default current_timestamp on
update
	current_timestamp,
    index i_cash_product_name(product_name),
    index i_cash_enable(enable),
    index i_cash_frozen(frozen),
    index i_cash_available(available)
);