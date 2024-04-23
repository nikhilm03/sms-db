package com.db.hazelcast.distributed;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import com.db.domain.Trade;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.HazelcastInstanceAware;

public class TradeManipulationTask implements HazelcastInstanceAware, Callable<List<Trade>>, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final String TRADE_MAP = "trade_map";
	private final long DURATION_SECONDS = 600;
	
	transient HazelcastInstance instance;
	
	private String key;
	
	
	public TradeManipulationTask(String key) {
		this.key = key;
	}

	@Override
	public List<Trade> call() throws Exception {
		
		List<Trade> trades = (List<Trade>) instance.getMap(TRADE_MAP).get(key);
		
		Instant now = new Date().toInstant();
		Instant then = now.minusSeconds(DURATION_SECONDS);
		
		List<Trade> invalidTrades = new ArrayList<Trade>(); 
		if(trades != null && trades.size() > 0) {
			
			Map<Long, List<Trade>> map = trades.stream().collect(Collectors.groupingBy(Trade::getStockId) );
			//for each stock check the validity of trades			
			for (Long stock : map.keySet()) {
				int invalidTradesCount = 0;
				List<Trade> stockTrades = map.get(stock);
				for (Trade trade : stockTrades) {
					Instant instant = trade.getTimestamp();
					if (!instant.isBefore(then) && instant.isBefore(now)) {
						invalidTradesCount++;
					}
				}
				if (invalidTradesCount > 5) {
					invalidTrades.add(stockTrades.get(0));
				}				
			}
		}
		
		return invalidTrades;
	}
	
	 @Override
     public void setHazelcastInstance(HazelcastInstance hazelcastInstance) {
         this.instance = hazelcastInstance;
     }

}
