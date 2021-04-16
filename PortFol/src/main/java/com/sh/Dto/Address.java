package com.sh.Dto;

public class Address {

	private int addressId;	
	private String addressCode; // 우편번호
	private String streetAddress;
	private String address;
	private String userId;
	private String details;
	private String referenceInfo;

	public Address() {}
	public Address(int addressId, String addressCode, String streetAddress, String address, String userId,
			String details, String referenceInfo) {		this.addressId = addressId;
		this.addressCode = addressCode;
		this.streetAddress = streetAddress;
		this.address = address;
		this.userId = userId;
		this.details = details;
		this.referenceInfo = referenceInfo;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressCode() {
		return addressCode;
	}
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getReferenceInfo() {
		return referenceInfo;
	}
	public void setReferenceInfo(String referenceInfo) {
		this.referenceInfo = referenceInfo;
	}


	
}
