package com.db.hazelcast.serializer;

import java.io.IOException;

import com.db.domain.Trade;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;

public class TradeSerializer implements StreamSerializer<Trade> {
	
	@Override
	 public void write(ObjectDataOutput out, Trade object) throws IOException {
	      out.writeLong(object.getTraderId());
		  out.writeLong(object.getStockId());
		  out.writeLong(object.getAmount());
		  out.writeUTF(object.getCurrency());
		  out.writeUTF(object.getTransaction());
//		  out.writeLong(object.getTimestamp());
		 
		  out.writeUTF(object.getFirstName());
		  out.writeUTF(object.getLastName());
		  out.writeUTF(object.getNationality());
		  out.writeUTF(object.getCountry());
		  out.writeUTF(object.getDob());
	  		
	 }

	 @Override
	 public Trade read(ObjectDataInput in) throws IOException {

		 Trade trade = new Trade();
		 
		 trade.setTraderId(in.readLong());
		 trade.setStockId(in.readLong());
		 trade.setAmount(in.readLong());
		 trade.setCurrency(in.readUTF());
		 trade.setTransaction(in.readUTF());
//		 trade.setTimestamp(in.readLong());
		 
		 trade.setFirstName(in.readUTF());
		 trade.setLastName(in.readUTF());
		 trade.setNationality(in.readUTF());
		 trade.setCountry(in.readUTF());
		 trade.setCountry(in.readUTF());
		 trade.setDob(in.readUTF());
		 
		 
		 return trade;
	 }

	 @Override
	 public int getTypeId() {
	  return 1;
	 }

	@Override
	public void destroy() {
		
		
	}

}
