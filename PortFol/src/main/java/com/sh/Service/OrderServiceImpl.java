package com.sh.Service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sh.Dao.OrderDao;
import com.sh.Dto.OrderInfo;

@Service
public class OrderServiceImpl implements OrderService{

	@Inject
	OrderDao dao;
	
	@Override
	public void order(OrderInfo orderInfo) throws Exception {
		dao.order(orderInfo);
	}

	@Override
	public OrderInfo orderinto(OrderInfo orderInfo) throws Exception {
		return dao.orderinto(orderInfo);
	}


}
