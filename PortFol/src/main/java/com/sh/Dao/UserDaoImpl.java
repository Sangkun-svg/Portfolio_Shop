package com.sh.Dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sh.Dto.Cart;
import com.sh.Dto.OrderInfo;
import com.sh.Dto.UserDto;
import com.sh.Enum.DeliverySituation;

@Repository
public class UserDaoImpl implements UserDao{

	@Inject SqlSession sql;
	
	@Override
	public void register(UserDto dto) throws Exception {
		sql.insert("userMapper.register" , dto);
	}						   

	@Override
	public UserDto signin(UserDto dto) throws Exception {
		return sql.selectOne("userMapper.signin" , dto);
	}

	@Override
	public void userUpdate(UserDto dto) throws Exception {
		sql.update("userMapper.userUpdate" , dto);
	}

	@Override
	public void userDelete(UserDto dto) throws Exception {
		sql.delete("userMapper.userDelete" , dto);
	}

	@Override
	public int passValidation(UserDto dto) throws Exception {
		int result = sql.selectOne("userMapper.passValidation" , dto);
		return result;
	}

	@Override
	public int idValidation(UserDto dto) throws Exception {
		int result = sql.selectOne("userMapper.idValidation" , dto);
		return result;
	}

	@Override
	public List<OrderInfo> orderList(String userId) throws Exception {
		return sql.selectList("userMapper.orderList" , userId);
	}

	@Override
	public UserDto myInfo(UserDto dto) throws Exception {
		return sql.selectOne("userMapper.myInfo" , dto);
	}

	@Override
	public OrderInfo myOrdered(OrderInfo orderInfo) throws Exception {
		return sql.selectOne("userMapper.myOrdered" , orderInfo);
	}

	@Override
	public void DsUpdate(OrderInfo orderInfo) throws Exception {
		sql.update("userMapper.DsUpdate" , orderInfo);
	}

	@Override   
	public void PtcUpdate(OrderInfo orderInfo) throws Exception {
		sql.update("userMapper.PtcUpdate" , orderInfo);
	}

	@Override
	public void goCart(Cart cart) throws Exception {
		sql.insert("userMapper.goCart" , cart);
	}

	

}
