package com.sh.Service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.sh.Dao.ReplyDao;
import com.sh.Dto.ReplyDto;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject
	ReplyDao dao;
	
	@Override
	public List<ReplyDto> readReply(int bno) throws Exception {
		return dao.readReply(bno);
	}


}
