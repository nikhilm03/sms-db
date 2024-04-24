package com.db.sms;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.db.domain.BreachDetail;
import com.db.domain.Trade;
import com.db.hazelcast.distributed.TradeManipulationTask;
import com.db.regulatory.RegulatoryAuthorityUtil;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IExecutorService;
import com.hazelcast.core.IMap;

/**
 * The job is scheduled as per cron configuration (every 2 mins). 
 * It creates a distributed task which runs on hazelcast node where that particular key is present (trader email).
 * This prevents network hops and memory overflow in parent node.
 *  
 * 
 * @author admin
 *
 */
@Component
public class SmsJob {	
	
	Logger logger = LoggerFactory.getLogger(SmsJob.class);
	
	private final String TRADE_MAP = "trade_map";
	
	@Autowired
	HazelcastInstance instance;
	
	 @Scheduled(cron = "0 */2 * ? * *")  //TODO:to be externalized to a property file.
	 public void identifyCorruptTrader() {
		 
		 logger.info("Job triggered to identify manipulative trader(s)..");
		 
		 IMap<String, List<Trade>> traderMap = instance.getMap(TRADE_MAP);
		 
		 for (String key : traderMap.keySet()) {
			 Callable<List<BreachDetail>> task = new TradeManipulationTask(key);
			 IExecutorService executorService =  instance.getExecutorService("default");
			 Future<List<BreachDetail>> future = executorService.submitToKeyOwner(task, key);
			 try {
				 List<BreachDetail> breachDetails = future.get();
				 if (breachDetails != null && breachDetails.size() > 0) {
					 breachDetails.stream().forEach(breach -> logBreachDetails(breach));
					 RegulatoryAuthorityUtil.notifyRegulatoryAuthorities(breachDetails);
				 }				 				 
				
			} catch (InterruptedException e) {
				logger.error("Error while executing distributed task {} ", e.getMessage());
			} catch (ExecutionException e) {
				logger.error("Error while executing distributed task {} ", e.getMessage());
			}
		 }	
		 
		 logger.info("Job finished to identify manipulative trader(s).");
		
	}

	private void logBreachDetails(BreachDetail breach) {		
		logger.error("ALERT - Trader {} {} with trader Id {} executed more than 5 trades in last 10 mins on Stock Id {}.", breach.getFirstName(), breach.getLastName(), breach.getTraderId(), breach.getStockId());		
	}

}
