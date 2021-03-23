package com.sh.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserDto {
	private String userId;
	private String userPass;
	private String userName;
	private String userPhone;
	private LocalDate regDate = LocalDate.now();
	private int verify;

	public UserDto() {}
	public UserDto(String userId, String userPass, String userName, String userPhone, LocalDate regDate, int verify) {
		this.userId = userId;
		this.userPass = userPass;
		this.userName = userName;
		this.userPhone = userPhone;
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
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	public int getVerify() {
		return verify;
	}
	public void setVerify(int verify) {
		this.verify = verify;
	}

	
}
