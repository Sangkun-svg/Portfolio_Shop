package com.sh.Service;

import com.sh.Dto.OrderInfo;

public interface OrderService {

	public void order(OrderInfo orderInfo) throws Exception;

	public OrderInfo orderinto(OrderInfo orderInfo) throws Exception;

}
