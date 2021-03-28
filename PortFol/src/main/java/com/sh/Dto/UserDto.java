package com.sh.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserDto {
	private String userId;
	private String userPass;
	private String userName;
	private String userPhone;
	
	String formatDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	private String regDate = formatDate;
	
	private int verify;

	public UserDto() {}
	public UserDto(String userId, String userPass, String userName, String userPhone, int verify) {
		this.userId = userId;
		this.userPass = userPass;
		this.userName = userName;
		this.userPhone = userPhone;
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
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public int getVerify() {
		return verify;
	}
	public void setVerify(int verify) {
		this.verify = verify;
	}	
	public String getRegDate() {
		return regDate;
	}
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userPass=" + userPass + ", userName=" + userName + ", userPhone="
				+ userPhone + ", regDate=" + regDate + ", verify=" + verify + "]";
	}

	
	
}
