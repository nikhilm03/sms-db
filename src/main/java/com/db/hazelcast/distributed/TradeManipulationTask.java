package com.db.hazelcast.distributed;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.db.domain.BreachDetail;
import com.db.domain.Trade;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.HazelcastInstanceAware;

/**
 * This task runs on hazelcast node where key (trader email) is stored.
 * It evaluates the trades for a particular stock and flags if more than 5 trades are executed in last 10 mins.
 * 
 * This api should be : 
 * 1. HazelcastInstanceAware : as it runs in a distributed way on hazelcast nodes
 * 2. Callable : as it is executed asynchronously
 * 3. Serializable : as it runs outside the parent jvm.
 * 
 * @author admin
 *
 */
public class TradeManipulationTask implements HazelcastInstanceAware, Callable<List<BreachDetail>>, Serializable {
	
	private Logger logger = LoggerFactory.getLogger(TradeManipulationTask.class);
	
	private static final long serialVersionUID = 1L;
	
	private String key;
	private final String TRADE_MAP = "trade_map";
	private final long DURATION_SECONDS = 600;
	private final int INVALID_TRADE_COUNT = 5;
	private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
	
	transient HazelcastInstance instance;	
	
	public TradeManipulationTask(String key) {
		this.key = key;
    }
		

	@Override
	public List<BreachDetail> call() throws Exception {
		
		List<Trade> trades = (List<Trade>) instance.getMap(TRADE_MAP).get(key);
		
		Instant now = new Date().toInstant();
		Instant then = now.minusSeconds(DURATION_SECONDS);
		
		List<BreachDetail> breachDetails = new ArrayList<BreachDetail>(); 
		if(trades != null && trades.size() > 0) {
			
			Map<Long, List<Trade>> map = trades.stream().collect(Collectors.groupingBy(Trade::getStockId));
			//for each stock check the validity of trades. TODO: multithreading per stock to speed up		
			for (Long stock : map.keySet()) {
				int invalidTradesCount = 0;
				List<Trade> stockTrades = map.get(stock);
				for (Trade trade : stockTrades) {
					Instant instant = trade.getTimestamp();
					if (!instant.isBefore(then) && instant.isBefore(now)) {
						invalidTradesCount++;
					}
				}
				if (invalidTradesCount > INVALID_TRADE_COUNT) {
					breachDetails.add(getBreachDetails(stockTrades.get(0)));
				}				
			}
		}
		
		return breachDetails;
	}
	
	 
	/*
	 * TODO : Orika mapper can be used here;
	 */
	private BreachDetail getBreachDetails(Trade trade) {
		
		BreachDetail breach = new BreachDetail();
		
		breach.setBreachDate(DATE_FORMAT.format(new Date()));
		breach.setCountry(trade.getCountry());
		breach.setDob(trade.getDob());
		breach.setFirstName(trade.getFirstName());
		breach.setLastName(trade.getLastName());
		breach.setNationality(trade.getNationality());
		breach.setStockId(trade.getStockId());
		breach.setTraderId(trade.getTraderId());
		
		return breach;
	}

	@Override
     public void setHazelcastInstance(HazelcastInstance hazelcastInstance) {
         this.instance = hazelcastInstance;
     }

}
