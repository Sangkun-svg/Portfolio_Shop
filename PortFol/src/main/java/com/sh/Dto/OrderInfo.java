package com.sh.Dto;

import com.sh.Enum.DeliverySituation;

public class OrderInfo {

	private String orderId;
	private String userId;
	private int proCode;
	private int orderStock;
	private int orderPrice;
	private String address;
	private DeliverySituation deliveryInfo;

	public OrderInfo() {}
	public OrderInfo(String orderId, String userId, int proCode, int orderStock, int orderPrice, String address,
			DeliverySituation deliveryInfo) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.proCode = proCode;
		this.orderStock = orderStock;
		this.orderPrice = orderPrice;
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
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	public DeliverySituation getDeliveryInfo() {
		return deliveryInfo;
	}
	public void setDeliveryInfo(DeliverySituation string) {
		this.deliveryInfo = string;
	}
	
	
	
	
}
