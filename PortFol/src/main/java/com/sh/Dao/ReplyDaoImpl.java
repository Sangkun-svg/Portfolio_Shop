package com.sh.Dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sh.Dto.ReplyDto;

@Repository
public class ReplyDaoImpl implements ReplyDao{

	@Inject SqlSession sql;
	
	@Override
	public List<ReplyDto> readReply(int bno) throws Exception {
		return sql.selectList("replyMapper.readReply" , bno);
	}

	@Override
	public void writeReply(ReplyDto dto) throws Exception {
		sql.insert("replyMapper.writeReply" , dto);
	}

}
