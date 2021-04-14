package com.sh.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sh.Dao.AdminDao;
import com.sh.Dto.Product;
import com.sh.Dto.UserDto;

@Service
public class AdminServiceImpl implements AdminService{

	@Inject AdminDao dao;
	
	@Override
	public List<UserDto> userList() throws Exception {
		return dao.userList();
	}

	@Override
	public void proRegister(Product pd) throws Exception {
		dao.proRegister(pd);
	}

	@Override
	public List<Product> proList() throws Exception {
		return dao.proList();
	}

	@Override
	public Product proView(int bno) throws Exception {
		return dao.proView(bno);
	}

	@Override
	public void proUpdate(Product pro) throws Exception {
		dao.proUpdate(pro);
	}

	@Override
	public void proDelete(int bno) throws Exception {
		dao.proDelete(bno);
	}

	@Override
	public Object userInfo(String userId) throws Exception {
		return dao.userInfo(userId);
	}


}
