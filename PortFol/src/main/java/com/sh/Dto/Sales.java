package com.sh.Dto;

public class Sales {
	private String salesDate;
	private int daySales;
	private int average;

	public Sales(String salesDate, int daySales, int average) {
		this.salesDate = salesDate;
		this.daySales = daySales;
		this.average = average;
	}

	public String getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(String salesDate) {
		this.salesDate = salesDate;
	}

	public int getDaySales() {
		return daySales;
	}

	public void setDaySales(int daySales) {
		this.daySales = daySales;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}
	
	
	
}