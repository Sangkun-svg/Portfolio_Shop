package com.sh.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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

	@Override
	public UserDto signin(UserDto dto) throws Exception {
		return dao.signin(dto);
	}

	@Override
	public void signout(HttpSession session) throws Exception {
		session.invalidate();
	}

	@Override
	public void userUpdate(UserDto dto) throws Exception {
		dao.userUpdate(dto);
	}

	@Override
	public void userDelete(UserDto dto) throws Exception {
		dao.userDelete(dto);
	}

	@Override
	public int passValidation(UserDto dto) throws Exception {
		int result = dao.passValidation(dto);
		return result;
	}

	@Override
	public int idValidation(UserDto dto) throws Exception {
		int result = dao.idValidation(dto);
		return result;
	}

}
