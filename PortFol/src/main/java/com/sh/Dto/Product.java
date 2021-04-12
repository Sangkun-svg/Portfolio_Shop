package com.sh.Dto;

import java.time.LocalDate;

public class Product {
	private int bno;
	private int proCode;
	private String 	proName;
	private int 	proPrice;
	private int 	proStock;
	private String 	proDescription;
	private LocalDate proRegDate = LocalDate.now();
	private String proImg;
	private String proThumbnail;
	
	public Product() {}
	public Product(int bno ,int proCode, String proName, int proPrice, int proStock, String proDescription, LocalDate proRegDate,
			String proImg , String proThumbnail) {
		this.bno= bno;
		this.proCode = proCode;
		this.proName = proName;
		this.proPrice = proPrice;
		this.proStock = proStock;
		this.proDescription = proDescription;
		this.proRegDate = proRegDate;
		this.proImg = proImg;
		this.proThumbnail= proThumbnail;
	}
	
	
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getProCode() {
		return proCode;
	}
	public void setProCode(int proCode) {
		this.proCode = proCode;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public int getProStock() {
		return proStock;
	}
	public void setProStock(int proStock) {
		this.proStock = proStock;
	}
	public String getProDescription() {
		return proDescription;
	}
	public void setProDescription(String proDescription) {
		this.proDescription = proDescription;
	}
	public LocalDate getProRegDate() {
		return proRegDate;
	}
	public void setProRegDate(LocalDate regDate) {
		this.proRegDate = proRegDate;
	}
	public String getProImg() {
		return proImg;
	}
	public void setProImg(String proImg) {
		this.proImg = proImg;
	}
	public String getProThumbnail() {
		return proThumbnail;
	}
	public void setProThumbnail(String proThumbnail) {
		this.proThumbnail = proThumbnail;
	}
	
	
	

	
}
