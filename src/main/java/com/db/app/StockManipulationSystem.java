package com.db.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.db")
@EnableScheduling 
public class StockManipulationSystem {
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(StockManipulationSystem.class, args);
    }
}
