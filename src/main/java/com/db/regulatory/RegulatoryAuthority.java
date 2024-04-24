package com.db.regulatory;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.domain.BreachDetail;

@RestController
public class RegulatoryAuthority {
	
	Logger logger = LoggerFactory.getLogger(RegulatoryAuthority.class);
	
	
	@PostMapping(value = "/notify-breach", consumes = MediaType.ALL_VALUE)
	public void handleBreach(@RequestBody List<BreachDetail> breachDetails) {
		
		logger.info("Recieved {} breach notiifications.", breachDetails.size());
		
		
	}
	
	

}
