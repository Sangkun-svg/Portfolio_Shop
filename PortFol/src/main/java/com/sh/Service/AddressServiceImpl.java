package com.sh.Service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sh.Dao.AddressDao;
import com.sh.Dto.Address;

@Service
public class AddressServiceImpl implements AddressService{

	@Inject
	AddressDao dao;
	
	@Override
	public void insertAddress(Address address) throws Exception {
		dao.insertAddress(address);
	}
	
}
