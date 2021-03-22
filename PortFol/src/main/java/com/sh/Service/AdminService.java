package com.sh.Service;

import java.util.List;

import com.sh.Dto.UserDto;

public interface AdminService {

	public List<UserDto> userList() throws Exception;

}
