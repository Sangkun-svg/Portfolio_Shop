package com.sh.Service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.sh.Dao.UserDao;
import com.sh.Dto.OrderInfo;
import com.sh.Dto.UserDto;
import com.sh.Enum.DeliveryAdmin;
import com.sh.Enum.DeliverySituation;

@Service
public class UserServiceImpl implements UserService{

	@Inject private UserDao dao;
	
	@Override
	public void register(UserDto dto) throws Exception {
		dao.register(dto);
	}

	@Override
	public UserDto signin(UserDto dto) throws Exception {
		return dao.signin(dto);
	}

	@Override
	public void signout(HttpSession session) throws Exception {
		session.invalidate();
	}

	@Override
	public void userUpdate(UserDto dto) throws Exception {
		dao.userUpdate(dto);
	}

	@Override
	public void userDelete(UserDto dto) throws Exception {
		dao.userDelete(dto);
	}

	@Override
	public int passValidation(UserDto dto) throws Exception {
		int result = dao.passValidation(dto);
		return result;
	}

	@Override
	public int idValidation(UserDto dto) throws Exception {
		int result = dao.idValidation(dto);
		return result;
	}

	@Override
	public UserDto myInfo(UserDto dto) throws Exception {
		return dao.myInfo(dto);
	}

	@Override
	public List<OrderInfo> orderList(String userId) throws Exception {
		return dao.orderList(userId);
	}

	@Override
	public OrderInfo myOrdered(OrderInfo orderInfo) throws Exception {
		return dao.myOrdered(orderInfo);
	}

	@Override
	public void DsUpdate(OrderInfo orderInfo) throws Exception {
		dao.DsUpdate(orderInfo);
	}


}
