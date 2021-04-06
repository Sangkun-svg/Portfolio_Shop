package com.sh.Dao;

import java.util.List;

import com.sh.Dto.Product;
import com.sh.Dto.UserDto;

public interface UserDao {
	public void register(UserDto dto) throws Exception;
	
	public UserDto signin(UserDto dto) throws Exception;
	
	public void userUpdate(UserDto dto) throws Exception;

	public void userDelete(UserDto dto) throws Exception;
	
	public int passValidation(UserDto dto) throws Exception;
	
	public int idValidation(UserDto dto) throws Exception;
	
	public int myInfo(int bno) throws Exception;


	
}				
