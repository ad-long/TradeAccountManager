
-- drop table if exists trade_account_manager.transfer_cash;

create table trade_account_manager.transfer_cash(
	id int primary key auto_increment,
    from_cash_name char(63) not null,
    to_cash_name char(63) not null,
    amount float not null default 0,
    user_name char(63) not null,
    create_time datetime not null default current_timestamp,
    update_time timestamp not null default current_timestamp on
update
	current_timestamp,
	is_complete boolean not null default false,
	index i_transfer_cash_from_cash_name(from_cash_name),
	index i_transfer_cash_to_cash_name(to_cash_name),
	index i_transfer_cash_user_name(user_name),
	index i_transfer_cash_create_time(create_time),
	index i_transfer_cash_is_complete(is_complete)
);