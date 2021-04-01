package com.sh.Service;

import java.util.List;

import com.sh.Dto.ReplyDto;

public interface ReplyService {

	public List<ReplyDto> readReply(int bno) throws Exception;

	public void writeReply(ReplyDto dto) throws Exception;

}
