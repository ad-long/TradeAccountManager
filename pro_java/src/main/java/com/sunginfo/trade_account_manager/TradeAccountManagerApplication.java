package com.sunginfo.trade_account_manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.sunginfo.trade_account_manager.mapper")
public class TradeAccountManagerApplication {
	public static void main(String[] args) {
		SpringApplication.run(TradeAccountManagerApplication.class, args);
	}

}
