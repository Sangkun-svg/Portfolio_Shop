package com.sh.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sh.Dto.Product;
import com.sh.Dto.UserDto;

@Component
public interface AdminDao {
	public List<UserDto> userList() throws Exception;

	public void proRegister(Product pd) throws Exception;

	public List<Product> proList() throws Exception;

}
