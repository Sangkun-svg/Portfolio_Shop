package com.sh.Dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sh.Dto.Product;
import com.sh.Dto.UserDto;

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
	public void minusProStock(int proCode) throws Exception {
		sql.update("adminMapper.minusProStock" , proCode);
	}

	@Override
	public void plusProStock(int proCode) throws Exception {
		sql.update("adminMapper.plusProStock" , proCode);		
	}

	
}
