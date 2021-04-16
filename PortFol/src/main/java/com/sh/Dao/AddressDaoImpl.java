package com.sh.Dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sh.Dto.Address;

@Repository
public class AddressDaoImpl implements AddressDao{

	@Inject
	SqlSession sql;
	
	@Override
	public void insertAddress(Address address) throws Exception {
		sql.insert("addressMapper.insertAddress" , address);
	}

}
