package com.sh.Dto;

public class Address {

	private String addressId;	
	private int addressCode; // 우편번호
	private int address;
	private String userId;

	public Address() {}
	public Address(String addressId, int addressCode, int address, String userId) {
		this.addressId = addressId;
		this.addressCode = addressCode;
		this.address = address;
		this.userId = userId;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public int getAddressCode() {
		return addressCode;
	}
	public void setAddressCode(int addressCode) {
		this.addressCode = addressCode;
	}
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
}
