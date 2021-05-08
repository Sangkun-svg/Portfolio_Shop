package com.sh.Service;

import java.util.List;

import com.sh.Dto.OrderInfo;
import com.sh.Dto.Product;
import com.sh.Dto.UserDto;

public interface AdminService {

	public List<UserDto> userList() throws Exception;

	public void proRegister(Product pd) throws Exception;

	public List<Product> proList() throws Exception;

	public Product proView (int bno) throws Exception;

	public void proUpdate(Product pro) throws Exception;

	public void proDelete(int bno) throws Exception;

	public Object userInfo(String userId) throws Exception; 

	public void minusProStock(OrderInfo orderInfo) throws Exception;

	public void plusProStock(OrderInfo orderInfo) throws Exception;

	public List<OrderInfo> reqProList() throws Exception;

	public void DeleteOrderInfo(OrderInfo orderInfo) throws Exception;

	public int pickM() throws Exception;
	public int pickG() throws Exception;

}
