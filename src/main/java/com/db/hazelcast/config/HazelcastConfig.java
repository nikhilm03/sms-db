package com.db.hazelcast.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.db.domain.Trade;
import com.db.hazelcast.serializer.TradeSerializer;
import com.hazelcast.config.Config;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@Component
public class HazelcastConfig {
	
	
	@Bean
	public HazelcastInstance getHazelcastInstance() {
		return Hazelcast.newHazelcastInstance(createConfig());
	}
	
	public Config createConfig() {
	  Config config = new Config();
//	  config.getSerializationConfig().addSerializerConfig(serializerConfig());
	  return config;
     }
		 
	private SerializerConfig serializerConfig() {
	  return new SerializerConfig().setImplementation(new TradeSerializer()).setTypeClass(Trade.class);
	}

}
