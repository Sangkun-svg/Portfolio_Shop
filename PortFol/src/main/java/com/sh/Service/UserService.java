package com.sh.Service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.sh.Dto.OrderInfo;
import com.sh.Dto.UserDto;

public interface UserService {
	public void register(UserDto dto) throws Exception;

	public UserDto signin(UserDto dto) throws Exception;

	public void signout(HttpSession session) throws Exception;

	public void userUpdate(UserDto dto) throws Exception;

	public void userDelete(UserDto dto) throws Exception;

	public int passValidation(UserDto dto) throws Exception;

	public int idValidation(UserDto dto) throws Exception;

	public UserDto myInfo(UserDto dto) throws Exception;

	public List<OrderInfo> orderList(String userId) throws Exception;
	
}
