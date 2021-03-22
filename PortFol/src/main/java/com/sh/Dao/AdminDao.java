package com.sh.Dao;

import java.util.List;

import com.sh.Dto.UserDto;

public interface AdminDao {
	public List<UserDto> userList() throws Exception;

}
