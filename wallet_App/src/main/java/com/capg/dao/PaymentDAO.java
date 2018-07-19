package com.capg.dao;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.capg.bean.AccountDetails;
import com.capg.bean.CustomerDetails;

public class PaymentDAO implements IPaymentDAO {
	static AccountDetails acc;
	static HashMap<String, AccountDetails> map = new HashMap<String, AccountDetails>();
	static CustomerDetails details;
	static HashMap<String, Float> transaction = new HashMap<String, Float>();
	
	public boolean addCustomer(AccountDetails accDetails) {

		map.put(accDetails.getCustDetails().getUsername(), accDetails);

		return true;
	}

	public float showBalance() {

		return acc.getInitialBal();

	}

	public boolean withdrawBalance(float amt1) {

		if (acc.getInitialBal() >= (amt1 + 1000)) {
			acc.setInitialBal(acc.getInitialBal() - amt1);
			System.out.println("Withdrawn amount:" + acc.getInitialBal());
			
			LocalDateTime dt= LocalDateTime.now();
			long tid= (long) (Math.random() * 1234 + 9999);
			String s= "Transactin Id "+ Long.toString(tid) + dt.toString()+"Withdrawn Balance andNet Balance is = ";
	     
			transaction.put(s,amt1 );	
			return true;
		} else {
			System.out.println("You have not the required mandatory balance in your account to withdraw");
		}

		return false;
	}

	public boolean depositBalance(float amt) {
		acc.setInitialBal(acc.getInitialBal() + amt);
		System.out.println("Balance:" + acc.getInitialBal());
		
		
		LocalDateTime dt= LocalDateTime.now();
		long tid= (long) (Math.random() * 1234 + 9999);
		String s= "Transactin Id " + Long.toString(tid) +  dt.toString()+"Balance Deposited and Net Balance is = ";
     
		transaction.put(s,amt);	
		return true;

	}

	public boolean useLogin(String uname, String pass) {
		for (String key : map.keySet()) {
			AccountDetails login = map.get(key);
			if ((login.getCustDetails().getUsername().equals(uname))
					&& (login.getCustDetails().getPassword().equals(pass))) {
				acc = login;
				return true;
			}
		}
		return false;
	}

	public boolean fundTransfer(int custAccNum, float amt) {

		for (String key : map.keySet()) {
			AccountDetails paydetails = map.get(key);
			if (paydetails.getCustAccNo() == custAccNum) {
				paydetails.setInitialBal(paydetails.getInitialBal() + amt);
				acc.setInitialBal(paydetails.getInitialBal() - amt);
				// System.out.println("Your account has balance left"+details.getInitialBal());
				// System.out.println("Balance in new account"+paydetails.getInitialBal());
				
				
				LocalDateTime dt= LocalDateTime.now();
				long tid= (long) (Math.random() * 1234 + 9999);
				String s= "Transactin Id "+ Long.toString(tid) + dt.toString() +"Fund Transfered and Net Balance is = ";
		     
				transaction.put(s,amt );	
				
				
				return true;
			} else {

				acc.setInitialBal(paydetails.getInitialBal() - amt);
				return true;
			}
		}
		return false;
	}
	
	public Map printTransaction() 
	{
	return transaction;
		
	}

}
