package com.sh.Dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sh.Dto.UserDto;

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
	

}
