package com.sh.Dto;

public class CategoryDto {

	private String cateName;
	private String cateCode;
	private String cateCodeRef;
	private int level;
	
	public CategoryDto() {}
	public CategoryDto(String cateName, String cateCode, String cateCodeRef , int level) {
		this.cateName = cateName;
		this.cateCode = cateCode;
		this.cateCodeRef = cateCodeRef;
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public String getCateCodeRef() {
		return cateCodeRef;
	}
	public void setCateCodeRef(String cateCodeRef) {
		this.cateCodeRef = cateCodeRef;
	}
	
	
	
}
