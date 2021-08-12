
-- drop table if exists trade_account_manager.product;

create table trade_account_manager.product(
    name char(63) primary key not null,
    user_superior_trader char(255) not null,
    enable boolean not null default true,
    create_time datetime not null default current_timestamp,
    update_time timestamp not null default current_timestamp on
update
	current_timestamp,
    index i_product_user_superior_trader(user_superior_trader),
    index i_product_enable(enable)
);