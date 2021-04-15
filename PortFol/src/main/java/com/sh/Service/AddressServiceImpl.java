package com.sh.Service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sh.Dao.AddressDao;

@Service
public class AddressServiceImpl implements AddressService{

	@Inject
	AddressDao dao;
	
	@Override
	public void insertAddress() throws Exception {
		dao.insertAddress();
	}
	
}
