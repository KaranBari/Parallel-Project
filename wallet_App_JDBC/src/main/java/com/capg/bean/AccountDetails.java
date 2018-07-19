package com.capg.bean;

import java.sql.Date;
import java.time.LocalDate;

public class AccountDetails {
	private float initialBal;
	private int custAccNo;
	private Date CustAccDate;
	private CustomerDetails custDetails;
	private String aadharNo;
	
	public CustomerDetails getCustDetails() {
		return custDetails;
	}

	public void setCustDetails(CustomerDetails custDetails) {
		this.custDetails = custDetails;
	}

	

	@Override
	public String toString() {
		return "AccountDetails [initialBal=" + initialBal + ", custAccNo=" + custAccNo + ", CustAccDate=" + CustAccDate
				+ ", custDetails=" + custDetails + ", aadharNo=" + aadharNo + "]";
	}

	public Date getCustAccDate() {
		return CustAccDate;
	}

	public void setCustAccDate(Date custAccDate) {
		CustAccDate = custAccDate;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public float getInitialBal() {
		return initialBal;
	}

	public void setInitialBal(float initialBal) {
		this.initialBal = initialBal;
	}

	public int getCustAccNo() {
		return custAccNo;
	}

	public void setCustAccNo(int custAccNo) {
		this.custAccNo = custAccNo;
	}

	
	public String getAadharNo() {
	
		return null;
	}

}
