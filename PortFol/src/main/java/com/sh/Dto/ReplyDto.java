package com.sh.Dto;

public class ReplyDto {

	private int bno;
	private int rno;
	private String content;
	private String writer;
	private String regdate;

	public ReplyDto() {}
	public ReplyDto(int bno, int rno, String content, String writer, String regdate) {
		this.bno = bno;
		this.rno = rno;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
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
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
