
-- drop table if exists trade_account_manager.user;

create table trade_account_manager.user(
    name char(63) primary key not null,
    pwd char(255) not null,
    enable boolean not null default true,
    is_biller boolean not null default false,
    is_trader boolean not null default false,
    superior_trader char(63) default null,
    create_time datetime not null default current_timestamp,
    update_time timestamp not null default current_timestamp on
update
	current_timestamp,
	index i_user_enable(enable),
	index i_user_is_biller(is_biller),
	index i_user_is_trader(is_trader),
	index i_user_superior_traderr(superior_trader)
);