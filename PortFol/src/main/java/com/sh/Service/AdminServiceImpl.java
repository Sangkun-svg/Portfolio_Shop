package com.sh.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sh.Dao.AdminDao;
import com.sh.Dto.OrderInfo;
import com.sh.Dto.Product;
import com.sh.Dto.UserDto;
import com.sh.Dto.UserRequest;

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


	@Override
	public List<OrderInfo> reqProList() throws Exception {
		return dao.reqProList();
	}

	@Override
	public void DeleteOrderInfo(OrderInfo orderInfo) throws Exception {
		dao.DeleteOrderInfo(orderInfo);
	}

	@Override
	public void minusProStock(OrderInfo orderInfo) throws Exception {
		dao.minusProStock(orderInfo);
	}

	@Override
	public void plusProStock(OrderInfo orderInfo) throws Exception {
		dao.plusProStock(orderInfo);
	}

	@Override
	public int pickM() throws Exception {
		int result = dao.pickM();
		return result;
	}

	@Override
	public int pickG() throws Exception {
		int result = dao.pickG();
		return result;
	}

	@Override
	public void reqRefund_Cancel(UserRequest userReq) throws Exception {
		dao.reqRefund_Cancel(userReq);
	}

	@Override
	public void insertSales() throws Exception {
		dao.insertSales();
	}

	@Override
	public void daySalesUpdate() throws Exception {
		dao.daySalesUpdate();
	}

	@Override
	public String selectLasted() throws Exception {
		return dao.selectLasted();
	}



}
