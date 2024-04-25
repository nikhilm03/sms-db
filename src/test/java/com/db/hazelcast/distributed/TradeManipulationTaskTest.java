package com.db.hazelcast.distributed;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.db.domain.BreachDetail;
import com.db.domain.Trade;
import com.hazelcast.core.HazelcastInstance;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class TradeManipulationTaskTest {
	
	private final String TRADE_MAP = "trade_map";	
	
	@InjectMocks
	private TradeManipulationTask classUnderTest = new TradeManipulationTask("nikhil.mayaskar@db.com");
	
	@Mock
	private HazelcastInstance instance;	
	
	@Test
	public void testBreachDetection() throws Exception {
		
		when(instance.getMap(TRADE_MAP).get("nikhil.mayaskar@db.com")).thenReturn(getTestTrades());
		
		List<BreachDetail> breachDetails = classUnderTest.call();
		
		assertTrue(breachDetails.size() == 1);
		assertTrue(breachDetails.get(0).getFirstName() == "Nikhil");
		
	}

	private List<Trade> getTestTrades() {
		
        
		int delayInMins = -1;
		Date date1 = new Date();
		
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
		badTrades.add(trade7);;
		
		return badTrades;
	}

}
