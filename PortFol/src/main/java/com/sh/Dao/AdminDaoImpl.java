package com.sh.Dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sh.Dto.OrderInfo;
import com.sh.Dto.Product;
import com.sh.Dto.UserDto;
import com.sh.Dto.UserRequest;

@Repository
public class AdminDaoImpl implements AdminDao{

	@Inject SqlSession sql;
	
	@Override
	public List<UserDto> userList() throws Exception {
		return sql.selectList("adminMapper.userList");
	}

	@Override
	public void proRegister(Product pd) throws Exception {
		sql.insert("adminMapper.proRegister" , pd);
	}

	@Override
	public List<Product> proList() throws Exception {
		return sql.selectList("adminMapper.proList");
	}

	@Override
	public Product proView(int bno) throws Exception {
		return sql.selectOne("adminMapper.proView" , bno);
	}

	@Override
	public void proUpdate(Product pro) throws Exception {
		sql.update("adminMapper.proUpdate" , pro);
	}

	@Override
	public void proDelete(int bno) throws Exception {
		sql.delete("adminMapper.proDelete" , bno);
	}

	@Override
	public UserDto userInfo(String userId) throws Exception {
		return sql.selectOne("adminMapper.userInfo",  userId);	
	}

	@Override
	public void minusProStock(OrderInfo orderInfo) throws Exception {
		sql.update("adminMapper.minusProStock" , orderInfo);
	}

	@Override
	public void plusProStock(OrderInfo orderInfo) throws Exception {
		sql.update("adminMapper.plusProStock" , orderInfo);		
	}

	@Override
	public List<OrderInfo> reqProList() throws Exception {
		return sql.selectList("adminMapper.reqProList");
	}

	@Override
	public void DeleteOrderInfo(OrderInfo orderInfo) throws Exception {
		sql.delete("adminMapper.DeleteOrderInfo" , orderInfo);
	}

	@Override
	public int pickM() throws Exception {
		int result = sql.selectOne("adminMapper.pickM");
		return result;
	}

	@Override
	public int pickG() throws Exception {
		int result = sql.selectOne("adminMapper.pickG");
		return result;
	}

	@Override
	public void reqRefund_Cancel(UserRequest userReq) throws Exception {
		sql.insert("adminMapper.reqRefund_Cancel" , userReq);
	}


	
}
