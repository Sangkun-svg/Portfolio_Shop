package com.sh.Dto;

public class Cart {
	
	private int proCode;
	private	String userId;
	private String orderName;
	private int proPrice;
	
	public Cart() {}
	public Cart(int proCode, String userId, String orderName, int proPirce) {
		this.proCode = proCode;
		this.userId = userId;
		this.orderName = orderName;
		this.proPrice = proPrice;
	}
	public int getProCode() {
		return proCode;
	}
	public void setProCode(int proCode) {
		this.proCode = proCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	
	
	
	
}
