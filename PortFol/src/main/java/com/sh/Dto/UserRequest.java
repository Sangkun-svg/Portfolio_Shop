package com.sh.Dto;

public class UserRequest {

	private String userId;
	private int orderId;
	private String Rs_Refund_option;
	private String Rs_Refund_text;
	private String 	Rs_Change_option;
	private String 	Rs_Change_text;

	public UserRequest() {}
	public UserRequest(String userId, int orderId, String rs_Refund_option, String rs_Refund_text,
			String rs_Change_option, String rs_Change_text) {
		this.userId = userId;
		this.orderId = orderId;
		Rs_Refund_option = rs_Refund_option;
		Rs_Refund_text = rs_Refund_text;
		Rs_Change_option = rs_Change_option;
		Rs_Change_text = rs_Change_text;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
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

	

}
