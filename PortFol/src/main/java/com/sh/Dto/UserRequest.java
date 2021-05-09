package com.sh.Dto;

public class UserRequest {

	private String choose;
	private String userId;
	private String orderId;
	private String proCode;
	private String Rs_Refund_option;
	private String Rs_Refund_text;
	private String 	Rs_Change_option;
	private String 	Rs_Change_text;

	public UserRequest() {}
	public UserRequest(String choose,String userId, String orderId, String rs_Refund_option, String rs_Refund_text,
			String rs_Change_option, String rs_Change_text ,String proCode) {
		this.choose = choose;
		this.userId = userId;
		this.orderId = orderId;
		this.Rs_Refund_option = rs_Refund_option;
		this.Rs_Refund_text = rs_Refund_text;
		this.Rs_Change_option = rs_Change_option;
		this.Rs_Change_text = rs_Change_text;
		this.proCode = proCode;
	}
	
	
	public String getChoose() {
		return choose;
	}
	public void setChoose(String choose) {
		this.choose = choose;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getRs_Refund_option() {
		return Rs_Refund_option;
	}
	public void setRs_Refund_option(String rs_Refund_option) {
		Rs_Refund_option = rs_Refund_option;
	}
	public String getRs_Refund_text() {
		return Rs_Refund_text;
	}
	public void setRs_Refund_text(String rs_Refund_text) {
		Rs_Refund_text = rs_Refund_text;
	}
	public String getRs_Change_option() {
		return Rs_Change_option;
	}
	public void setRs_Change_option(String rs_Change_option) {
		Rs_Change_option = rs_Change_option;
	}
	public String getRs_Change_text() {
		return Rs_Change_text;
	}
	public void setRs_Change_text(String rs_Change_text) {
		Rs_Change_text = rs_Change_text;
	}
	public String getProCode() {
		return proCode;
	}
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	
	

}
