package com.sh.Service;

import java.util.List;

import com.sh.Dto.Product;
import com.sh.Dto.UserDto;

public interface AdminService {

	public List<UserDto> userList() throws Exception;

	public void proRegister(Product pd) throws Exception;

	public List<Product> proList() throws Exception;

	public Product proView (int bno) throws Exception;

	public void proUpdate(Product pro) throws Exception;

	public void proDelete(int bno) throws Exception;

	public UserDto userInfo(int bno) throws Exception; 

}
