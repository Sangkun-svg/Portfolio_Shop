package com.sh.Dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReplyDto {

	private int bno;
	private int rno;
	private String content;
	private String writer;

	String formatDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-hh-mm"));
	private String writeDate = formatDate;	

	public ReplyDto() {}
	public ReplyDto(int bno, int rno, String content, String writer, String writeDate) {
		this.bno = bno;
		this.rno = rno;
		this.content = content;
		this.writer = writer;
		this.writeDate = writeDate;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegdate() {
		return writeDate;
	}
	public void setRegdate(String writeDate) {
		this.writeDate = writeDate;
	}
	
	
}
