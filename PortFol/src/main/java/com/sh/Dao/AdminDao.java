package com.sh.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sh.Dto.OrderInfo;
import com.sh.Dto.Product;
import com.sh.Dto.UserDto;
import com.sh.Dto.UserRequest;

@Component
public interface AdminDao {
	public List<UserDto> userList() throws Exception;

	public void proRegister(Product pd) throws Exception;

	public List<Product> proList() throws Exception;

	public Product proView (int bno) throws Exception;

	public void proUpdate(Product pro) throws Exception;

	public void proDelete(int bno) throws Exception;
	
	public UserDto userInfo(String userId) throws Exception; 

	public void minusProStock(OrderInfo orderInfo) throws Exception;

	public void plusProStock(OrderInfo orderInfo) throws Exception;

	public List<OrderInfo> reqProList() throws Exception;

	public void DeleteOrderInfo(OrderInfo orderInfo) throws Exception;
	
	public int pickM() throws Exception;
	public int pickG() throws Exception;
	
	public void reqRefund_Cancel(UserRequest userReq) throws Exception;

	public void insertSales() throws Exception;
	
	public void daySalesUpdate() throws Exception; // + , - both

	public String selectLasted() throws Exception;
}