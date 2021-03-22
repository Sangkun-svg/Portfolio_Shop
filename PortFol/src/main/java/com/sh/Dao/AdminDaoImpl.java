package com.sh.Dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sh.Dto.UserDto;

@Repository
public class AdminDaoImpl implements AdminDao{

	@Inject SqlSession sql;
	
	@Override
	public List<UserDto> userList() throws Exception {
		return sql.selectList("adminMapper.userList");
	}

}
