package com.sh.Service;

import javax.servlet.http.HttpSession;

import com.sh.Dto.UserDto;

public interface UserService {
	public void register(UserDto dto) throws Exception;

	public UserDto signin(UserDto dto) throws Exception;

	public void signout(HttpSession session) throws Exception;

	public void userUpdate(UserDto dto) throws Exception;

}
