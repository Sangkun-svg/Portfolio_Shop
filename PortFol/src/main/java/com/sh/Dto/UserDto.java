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
	String formatDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	private String regDate = formatDate;	
	private int verify;
	
	public UserDto() {}

	public UserDto(String userId, String userPass, String userName, String address, String userPhone, String formatDate,
			String regDate, int verify) {
		super();
		this.userId = userId;
		this.userPass = userPass;
		this.userName = userName;
		this.address = address;
		this.userPhone = userPhone;
		this.formatDate = formatDate;
		this.regDate = regDate;
		this.verify = verify;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getVerify() {
		return verify;
	}

	public void setVerify(int verify) {
		this.verify = verify;
	}

	
	 
	
}
