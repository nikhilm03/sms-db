package com.db.utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.db.domain.Trade;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@Component
public class TradeInsertUtility {
	
	private final String TRADE_MAP = "trade_map";
	
	
	@Autowired
	HazelcastInstance instance;
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void loadTestData() {
		
		IMap<String, List<Trade>> traderMap = instance.getMap(TRADE_MAP);
		
		// Bad Trader (punches 6 trades every 1 mins for same stock)
		String badTrader = "nikhil.mayaskar@db.com";
		int delayInMins = -1;
		
		Date date1 = new Date();
		 
//		Instant instant = Instant.now();
//		Timestamp timestamp = Timestamp.from(instant);
//		timestamp.toInstant();
//		instant = timestamp.toInstant();
		
		Trade trade1 = new Trade();
		trade1.setTraderId(8330334);
		trade1.setStockId(1);
		trade1.setAmount(88881);
		trade1.setCountry("IN");
		trade1.setCurrency("INR");
		trade1.setDob("03/04/1981");
		trade1.setFirstName("Nikhil");
		trade1.setLastName("Mayaskar");
		trade1.setNationality("India");
		trade1.setTransaction("Buy");
		trade1.setTimestamp(date1.toInstant());		
		
		Date date2 = DateUtils.addMinutes(date1, delayInMins);
		
		Trade trade2 = new Trade();
		trade2.setTraderId(8330334);
		trade2.setStockId(1);
		trade2.setAmount(88882);
		trade2.setCountry("IN");
		trade2.setCurrency("INR");
		trade2.setDob("03/04/1981");
		trade2.setFirstName("Nikhil");
		trade2.setLastName("Mayaskar");
		trade2.setNationality("India");
		trade2.setTransaction("Buy");
		trade2.setTimestamp(date2.toInstant());
		
		Date date3 = DateUtils.addMinutes(date2, delayInMins);
		
		Trade trade3 = new Trade();
		trade3.setTraderId(8330334);
		trade3.setStockId(1);
		trade3.setAmount(88883);
		trade3.setCountry("IN");
		trade3.setCurrency("INR");
		trade3.setDob("03/04/1981");
		trade3.setFirstName("Nikhil");
		trade3.setLastName("Mayaskar");
		trade3.setNationality("India");
		trade3.setTransaction("Buy");
		trade3.setTimestamp(date3.toInstant());
		
		Date date4 = DateUtils.addMinutes(date3, delayInMins);
		
		Trade trade4 = new Trade();
		trade4.setTraderId(8330334);
		trade4.setStockId(1);
		trade4.setAmount(88884);
		trade4.setCountry("IN");
		trade4.setCurrency("INR");
		trade4.setDob("03/04/1981");
		trade4.setFirstName("Nikhil");
		trade4.setLastName("Mayaskar");
		trade4.setNationality("India");
		trade4.setTransaction("Buy");
		trade4.setTimestamp(date4.toInstant());
		
		Date date5 = DateUtils.addMinutes(date4, delayInMins);
		
		Trade trade5 = new Trade();
		trade5.setTraderId(8330334);
		trade5.setStockId(1);
		trade5.setAmount(88885);
		trade5.setCountry("IN");
		trade5.setCurrency("INR");
		trade5.setDob("03/04/1981");
		trade5.setFirstName("Nikhil");
		trade5.setLastName("Mayaskar");
		trade5.setNationality("India");
		trade5.setTransaction("Buy");
		trade5.setTimestamp(date5.toInstant());
		
		Date date6 = DateUtils.addMinutes(date5, delayInMins);
		
		Trade trade6 = new Trade();
		trade6.setTraderId(8330334);
		trade6.setStockId(1);
		trade6.setAmount(88886);
		trade6.setCountry("IN");
		trade6.setCurrency("INR");
		trade6.setDob("03/04/1981");
		trade6.setFirstName("Nikhil");
		trade6.setLastName("Mayaskar");
		trade6.setNationality("India");
		trade6.setTransaction("Buy");
		trade6.setTimestamp(date6.toInstant());
		
		
		Date date7 = DateUtils.addMinutes(date6, delayInMins);
		
		Trade trade7 = new Trade();
		trade7.setTraderId(8330334);
		trade7.setStockId(2);
		trade7.setAmount(88887);
		trade7.setCountry("IN");
		trade7.setCurrency("INR");
		trade7.setDob("03/04/1981");
		trade7.setFirstName("Nikhil");
		trade7.setLastName("Mayaskar");
		trade7.setNationality("India");
		trade7.setTransaction("Buy");
		trade7.setTimestamp(date7.toInstant());
		
		List<Trade> badTrades = new  ArrayList<Trade>();
		badTrades.add(trade1);
		badTrades.add(trade2);
		badTrades.add(trade3);
		badTrades.add(trade4);
		badTrades.add(trade5);
		badTrades.add(trade6);
		badTrades.add(trade7);
		
		// Good Trader (punches 6 trades every 3 mins for same stock)
		String goodTrader = "good.trader@db.com";
		delayInMins = 3;
		
		Date date8 = DateUtils.addMinutes(date7, delayInMins);
		
		Trade trade8 = new Trade();
		trade8.setTraderId(8330335);
		trade8.setStockId(1);
		trade8.setAmount(88881);
		trade8.setCountry("IN");
		trade8.setCurrency("INR");
		trade8.setDob("03/04/1981");
		trade8.setFirstName("Good");
		trade8.setLastName("Trader");
		trade8.setNationality("India");
		trade8.setTransaction("Buy");
		trade8.setTimestamp(date8.toInstant());		
		
		Date date9 = DateUtils.addMinutes(date8, delayInMins);
		
		Trade trade9 = new Trade();
		trade9.setTraderId(8330335);
		trade9.setStockId(1);
		trade9.setAmount(88882);
		trade9.setCountry("IN");
		trade9.setCurrency("INR");
		trade9.setDob("03/04/1981");
		trade9.setFirstName("Good");
		trade9.setLastName("Trader");
		trade9.setNationality("India");
		trade9.setTransaction("Buy");
		trade9.setTimestamp(date9.toInstant());
		
		Date date10 = DateUtils.addMinutes(date9, delayInMins);
		
		Trade trade10 = new Trade();
		trade10.setTraderId(8330335);
		trade10.setStockId(1);
		trade10.setAmount(88883);
		trade10.setCountry("IN");
		trade10.setCurrency("INR");
		trade10.setDob("03/04/1981");
		trade10.setFirstName("Good");
		trade10.setLastName("Trader");
		trade10.setNationality("India");
		trade10.setTransaction("Buy");
		trade10.setTimestamp(date10.toInstant());
		
		Date date11 = DateUtils.addMinutes(date10, delayInMins);
		
		Trade trade11 = new Trade();
		trade11.setTraderId(8330335);
		trade11.setStockId(1);
		trade11.setAmount(88884);
		trade11.setCountry("IN");
		trade11.setCurrency("INR");
		trade11.setDob("03/04/1981");
		trade11.setFirstName("Good");
		trade11.setLastName("Trader");
		trade11.setNationality("India");
		trade11.setTransaction("Buy");
		trade11.setTimestamp(date11.toInstant());
		
		Date date12 = DateUtils.addMinutes(date11, delayInMins);
		
		Trade trade12 = new Trade();
		trade12.setTraderId(8330335);
		trade12.setStockId(1);
		trade12.setAmount(88885);
		trade12.setCountry("IN");
		trade12.setCurrency("INR");
		trade12.setDob("03/04/1981");
		trade12.setFirstName("Good");
		trade12.setLastName("Trader");
		trade12.setNationality("India");
		trade12.setTransaction("Buy");
		trade12.setTimestamp(date12.toInstant());
		
		Date date13 = DateUtils.addMinutes(date12, delayInMins);
		
		Trade trade13 = new Trade();
		trade13.setTraderId(8330335);
		trade13.setStockId(1);
		trade13.setAmount(88886);
		trade13.setCountry("IN");
		trade13.setCurrency("INR");
		trade13.setDob("03/04/1981");
		trade13.setFirstName("Good");
		trade13.setLastName("Trader");
		trade13.setNationality("India");
		trade13.setTransaction("Buy");
		trade13.setTimestamp(date13.toInstant());
		
		
		Date date14 = DateUtils.addMinutes(date13, delayInMins);
		
		Trade trade14 = new Trade();
		trade14.setTraderId(8330335);
		trade14.setStockId(2);
		trade14.setAmount(88887);
		trade14.setCountry("IN");
		trade14.setCurrency("INR");
		trade14.setDob("03/04/1981");
		trade14.setFirstName("Good");
		trade14.setLastName("Trader");
		trade14.setNationality("India");
		trade14.setTransaction("Buy");
		trade14.setTimestamp(date14.toInstant());	
		
		List<Trade> goodTrades = new  ArrayList<Trade>();
		goodTrades.add(trade8);
		goodTrades.add(trade8);
		goodTrades.add(trade10);
		goodTrades.add(trade11);
		goodTrades.add(trade12);
		goodTrades.add(trade13);
		goodTrades.add(trade14);
		
		traderMap.put(badTrader, badTrades);
		traderMap.put(goodTrader, goodTrades);
		
	}

}
