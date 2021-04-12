package com.sh.Dto;

public class OrderInfo {

	private String orderId;
	private String userId;
	private int proCode;
	private int orderStock;
	private int orderprice;
	private String address;
	private String deliveryInfo;

	public OrderInfo() {}
	public OrderInfo(String orderId, String userId, int proCode, int orderStock, int orderprice, String address,
			String deliveryInfo) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.proCode = proCode;
		this.orderStock = orderStock;
		this.orderprice = orderprice;
		this.address = address;
		this.deliveryInfo = deliveryInfo;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getProCode() {
		return proCode;
	}
	public void setProCode(int proCode) {
		this.proCode = proCode;
	}
	public int getOrderStock() {
		return orderStock;
	}
	public void setOrderStock(int orderStock) {
		this.orderStock = orderStock;
	}
	public int getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(int orderprice) {
		this.orderprice = orderprice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDeliveryInfo() {
		return deliveryInfo;
	}
	public void setDeliveryInfo(String deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}
	
	
	
	
}
