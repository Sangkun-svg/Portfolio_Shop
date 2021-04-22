package com.sh.Dao;

import com.sh.Dto.OrderInfo;


public interface OrderDao {
	public void order(OrderInfo orderInfo) throws Exception;
	
	public OrderInfo orderinto(OrderInfo orderInfo) throws Exception;

	
}
