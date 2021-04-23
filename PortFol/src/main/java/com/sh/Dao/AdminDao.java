package com.sh.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sh.Dto.OrderInfo;
import com.sh.Dto.Product;
import com.sh.Dto.UserDto;

@Component
public interface AdminDao {
	public List<UserDto> userList() throws Exception;

	public void proRegister(Product pd) throws Exception;

	public List<Product> proList() throws Exception;

	public Product proView (int bno) throws Exception;

	public void proUpdate(Product pro) throws Exception;

	public void proDelete(int bno) throws Exception;
	
	public UserDto userInfo(String userId) throws Exception; 

	public void minusProStock(int proCode) throws Exception;

	public void plusProStock(int proCode) throws Exception;

	public List<OrderInfo> reqProList() throws Exception;

}