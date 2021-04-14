package com.sh.Dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sh.Dto.OrderInfo;

@Repository
public class OrderDaoImpl implements OrderDao{

	@Inject
	SqlSession sql;
	

	@Override
	public void order(OrderInfo orderInfo) throws Exception {
		sql.insert("orderMapper.order" , orderInfo);
	}


	@Override
	public OrderInfo orderinto(OrderInfo orderInfo) throws Exception {
		return sql.selectOne("orderMapper.orderInfo" , orderInfo);
	}

}
