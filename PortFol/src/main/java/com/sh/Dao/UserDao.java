package com.sh.Dao;

import com.sh.Dto.UserDto;

public interface UserDao {
	public void register(UserDto dto) throws Exception;
}
