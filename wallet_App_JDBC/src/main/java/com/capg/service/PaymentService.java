package com.capg.service;

import java.util.Map;

import com.capg.bean.AccountDetails;
import com.capg.bean.CustomerDetails;
import com.capg.dao.PaymentDAO;

public class PaymentService implements IPaymentService {

	PaymentDAO dao = new PaymentDAO();

	public boolean addCustomer(AccountDetails accDetails) {

		return dao.addCustomer(accDetails);
	}

	public float  showBalance() {

		return dao.showBalance();
	}

	public boolean depositBalance(float amt) {

		return dao.depositBalance(amt);
	}

	public boolean withdrawBalance(float amt1) {

		return dao.withdrawBalance(amt1);
	}

	public boolean useLogin(String uname, String pass) {

		return dao.useLogin(uname, pass);
	}

	public boolean fundTransfer(int custAccNum, float amt) {

		return dao.fundTransfer(custAccNum, amt);
	}

	public void printTransaction() {
		
	       dao.printTransaction();	
	}

}
