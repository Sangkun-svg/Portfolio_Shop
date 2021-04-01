package com.sh.Dao;


import java.util.List;

import com.sh.Dto.ReplyDto;

public interface ReplyDao {
	
	public List<ReplyDto> readReply(int bno) throws Exception;

	public void writeReply(ReplyDto dto) throws Exception;
}
