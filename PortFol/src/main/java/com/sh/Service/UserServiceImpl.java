package com.sh.Service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sh.Dao.UserDao;
import com.sh.Dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Inject private UserDao dao;
	
	@Override
	public void register(UserDto dto) throws Exception {
		dao.register(dto);
	}

}
