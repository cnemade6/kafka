package com.example.kafka.kafkaCustomObjectDemo.util;

public class User {

	private Integer  uId;
	private String name;
	private String city;
	
	public User() {
		
	}
	
	public User(Integer uId, String name, String city) {
		super();
		this.uId = uId;
		this.name = name;
		this.city = city;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	  @Override
	  public String toString() { return "User [uId=" + uId + ", name=" +
	  name + ", city=" + city + "]"; }
	 
	
}
