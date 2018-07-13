package com.capg.bean;

import java.time.LocalDate;

public class AccountDetails {
	private float initialBal;
	private int custAccNo;
	private LocalDate CustAccDate;
	private CustomerDetails custDetails;

	public CustomerDetails getCustDetails() {
		return custDetails;
	}

	public void setCustDetails(CustomerDetails custDetails) {
		this.custDetails = custDetails;
	}

	@Override
	public String toString() {
		return "accountDetails [initialBal=" + initialBal + ", custAccNo=" + custAccNo + ", custAccDate=" + CustAccDate
				+ "]";
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

	public LocalDate getCustAccDate() {
		return CustAccDate;
	}

	public void setCustAccDate(LocalDate custAccDate) {
		CustAccDate = custAccDate;
	}

}
