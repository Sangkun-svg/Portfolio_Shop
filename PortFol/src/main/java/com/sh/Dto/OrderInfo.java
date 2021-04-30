package com.sh.Dto;

import com.sh.Enum.DeliverySituation;
import com.sh.Enum.PermissionToComment;

public class OrderInfo {

	private String orderId;
	private String userId;
	private String orderProName;
	private int proCode;
	private int proPrice;	
	private int orderStock;
	private int orderPrice = orderStock * proPrice;
	private String address;
	private DeliverySituation deliveryInfo;
	private PermissionToComment replyEnum;
	public OrderInfo() {}
	public OrderInfo(String orderId, String userId,String orderProName, int proCode,int proPrice, int orderStock, int orderPrice, String address,
			DeliverySituation deliveryInfo ,PermissionToComment replyEnum) {
		this.orderId = orderId;
		this.userId = userId;
		this.proCode = proCode;
		this.proPrice = proPrice;
		this.orderStock = orderStock;
		this.orderPrice = orderPrice;
		this.address = address;
		this.deliveryInfo = deliveryInfo;
		this.orderProName = orderProName;
		this.replyEnum = replyEnum;
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
	public String getOrderProName() {
		return orderProName;
	}
	public void setOrderProName(String orderProName) {
		this.orderProName = orderProName;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public PermissionToComment getReplyEnum() {
		return replyEnum;
	}
	public void setReplyEnum(PermissionToComment replyEnum) {
		this.replyEnum = replyEnum;
	}
	
	
	
	
}
