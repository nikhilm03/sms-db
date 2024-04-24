package com.db.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class BreachDetail implements Serializable {	
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String firstName;
	@JsonProperty
	private String lastName;
	@JsonProperty
	private String nationality;
	@JsonProperty
	private String country;
	@JsonProperty
	private String dob;	
	@JsonProperty
	private long traderId;
	@JsonProperty
	private long stockId;
	@JsonProperty
	private String breachDate;
	
	public BreachDetail() {
		super();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getTraderId() {
		return traderId;
	}
	public void setTraderId(long traderId) {
		this.traderId = traderId;
	}
	public long getStockId() {
		return stockId;
	}
	public void setStockId(long stockId) {
		this.stockId = stockId;
	}
	public String getBreachDate() {
		return breachDate;
	}
	public void setBreachDate(String breachDate) {
		this.breachDate = breachDate;
	}
	

}
