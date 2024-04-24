package com.db.regulatory;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.db.domain.BreachDetail;
import com.google.gson.Gson;

/**
 * This utility informs regulatory authority for any breaches.
 * 
 * @author admin
 *
 */
public class RegulatoryAuthorityUtil {
	
	private static Logger logger = LoggerFactory.getLogger(RegulatoryAuthorityUtil.class);
	
	private static final String URL = "http://localhost:8080/notify-breach";
	private static final Gson gson = new Gson();
	
	public static void notifyRegulatoryAuthorities(List<BreachDetail> breachDetails) {
		
		RestTemplate restTemplate = new RestTemplate();		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		
		String requestJson = gson.toJson(breachDetails);
		
		HttpEntity<String> request = new HttpEntity<>(requestJson, headers);
		
		restTemplate.postForObject(URL, request, Void.class);
		
		logger.info("Regulatory authorities notified.");
		
	}

}
