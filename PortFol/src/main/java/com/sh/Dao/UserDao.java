package com.sh.Dao;

import java.util.List;

import com.sh.Dto.OrderInfo;
import com.sh.Dto.Product;
import com.sh.Dto.UserDto;
import com.sh.Enum.DeliverySituation;

public interface UserDao {
	public void register(UserDto dto) throws Exception;
	
	public UserDto signin(UserDto dto) throws Exception;
	
	public void userUpdate(UserDto dto) throws Exception;

	public void userDelete(UserDto dto) throws Exception;
	
	public int passValidation(UserDto dto) throws Exception;
	
	public int idValidation(UserDto dto) throws Exception;
	
	public UserDto myInfo(UserDto dto) throws Exception;

	public List<OrderInfo> orderList(String userId) throws Exception;

	public OrderInfo myOrdered (OrderInfo orderInfo) throws Exception;

	public void DsUpdate (OrderInfo orderInfo) throws Exception; 
}				
