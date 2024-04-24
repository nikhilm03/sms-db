package com.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Entry point of the application to identify trades manipulator.
 * 
 * 1. Configures and spawns hazelcast nodes to store trades.
 * 2. Insert test trades in hazelcast.
 * 3. Creates a distributed task that runs at specified frequency on hazelcast nodes and identifies breach.
 * 4. Reports the breaches to regulatory authorities.
 * 
 * @author admin
 *
 */
@SpringBootApplication
@EnableScheduling 
public class StockManipulationSystem {
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(StockManipulationSystem.class, args);
    }
}
