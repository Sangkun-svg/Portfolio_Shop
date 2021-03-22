package com.sh.Dto;

public class Product {

	private int proCode;
	private String 	proName;
	private int 	proPrice;
	private int 	proStock;
	private String 	proDescription;

	public Product() {}
	public Product(int proCode, String proName, int proPrice, int proStock, String proDescription) {
		this.proCode = proCode;
		this.proName = proName;
		this.proPrice = proPrice;
		this.proStock = proStock;
		this.proDescription = proDescription;
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

	

}
