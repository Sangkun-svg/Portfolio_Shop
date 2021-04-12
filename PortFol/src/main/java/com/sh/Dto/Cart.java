package com.sh.Dto;

public class Cart {
	
	private int proCode;
	private	String userId;
	private int orderStock;
	private int orderName;
	private int orderPirce;
	
	public Cart() {}
	public Cart(int proCode, String userId, int orderStock, int orderName, int orderPirce) {
		this.proCode = proCode;
		this.userId = userId;
		this.orderStock = orderStock;
		this.orderName = orderName;
		this.orderPirce = orderPirce;
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
	public int getOrderStock() {
		return orderStock;
	}
	public void setOrderStock(int orderStock) {
		this.orderStock = orderStock;
	}
	public int getOrderName() {
		return orderName;
	}
	public void setOrderName(int orderName) {
		this.orderName = orderName;
	}
	public int getOrderPirce() {
		return orderPirce;
	}
	public void setOrderPirce(int orderPirce) {
		this.orderPirce = orderPirce;
	}
	
	
	
	
}
