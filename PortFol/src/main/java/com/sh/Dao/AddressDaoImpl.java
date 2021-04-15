package com.sh.Dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl implements AddressDao{

	@Inject
	SqlSession sql;
	
	@Override
	public void insertAddress() throws Exception {
		sql.insert("addressMapper.insertAddress");
	}

}
