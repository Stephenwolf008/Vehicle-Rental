package com.model;

import java.sql.Date;

public class BookingVO {
	
	private String customerName;
	private int category;
	private String regNo;
	private Date fromDate;
	private Date toDate;
	private int totalRent;
	private boolean paymentReceived;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public int getTotalRent() {
		return totalRent;
	}
	public void setTotalRent(int totalRent) {
		this.totalRent = totalRent;
	}
	public boolean isPaymentReceived() {
		return paymentReceived;
	}
	public void setPaymentReceived(boolean paymentReceived) {
		this.paymentReceived = paymentReceived;
	}
	public BookingVO(String customerName, int category, String regNo, Date fromDate, Date toDate, int totalRent,
			boolean paymentReceived) {
		super();
		this.customerName = customerName;
		this.category = category;
		this.regNo = regNo;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.totalRent = totalRent;
		this.paymentReceived = paymentReceived;
	}
	
	public BookingVO() {}
	
}