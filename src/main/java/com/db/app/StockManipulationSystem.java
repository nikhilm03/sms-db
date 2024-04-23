package com.db.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.db")
public class StockManipulationSystem {
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(StockManipulationSystem.class, args);
    }
}
