package com.sh.Dto;

import com.sh.Enum.DeliverySituation;

public class ReqProList {

	private String userId;
	private String userName; 
	private String address; 
	private int orderId; 
	private int proCode; 
	private String orderProName;
	private int orderStock; 
	private int orderPrice; 
	private DeliverySituation deliveryInfo;
	public ReqProList(String userId, String userName, String address, int orderId, int proCode, String orderProName,
			int orderStock, int orderPrice, DeliverySituation deliveryInfo) {
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.orderId = orderId;
		this.proCode = proCode;
		this.orderProName = orderProName;
		this.orderStock = orderStock;
		this.orderPrice = orderPrice;
		this.deliveryInfo = deliveryInfo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProCode() {
		return proCode;
	}
	public void setProCode(int proCode) {
		this.proCode = proCode;
	}
	public String getOrderProName() {
		return orderProName;
	}
	public void setProName(String orderProName) {
		this.orderProName = orderProName;
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
	public DeliverySituation getDeliveryInfo() {
		return deliveryInfo;
	}
	public void setDeliveryInfo(DeliverySituation deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}
	
	
	
	
}
