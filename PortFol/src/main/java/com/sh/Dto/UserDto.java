package com.sh.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserDto {

	private String userId;
	private String userPass;
	private String userName;
	private String address;	
	private String userPhone;
	String formatDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-hh-mm"));
	private String userJoinDate = formatDate;	
	private int verify;
	private String platform;
	
	public UserDto() {}

	public UserDto(String userId, String userPass, String userName, String address, String userPhone, String formatDate,
			String userJoinDate, int verify , String platform) {
		super();
		this.userId = userId;
		this.userPass = userPass;
		this.userName = userName;
		this.address = address;
		this.userPhone = userPhone;
		this.formatDate = formatDate;
		this.userJoinDate = userJoinDate;
		this.verify = verify;
		this.platform = platform;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
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

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserJoinDate() {
		return userJoinDate;
	}

	public void setUserJoinDate(String userJoinDate) {
		this.userJoinDate = userJoinDate;
	}

	public int getVerify() {
		return verify;
	}

	public void setVerify(int verify) {
		this.verify = verify;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userPass=" + userPass + ", userName=" + userName + ", address="
				+ address + ", userPhone=" + userPhone + ", formatDate=" + formatDate + ", userJoinDate=" + userJoinDate
				+ ", verify=" + verify + "]";
	}

	public String getFormatDate() {
		return formatDate;
	}

	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	
	 
	
}
