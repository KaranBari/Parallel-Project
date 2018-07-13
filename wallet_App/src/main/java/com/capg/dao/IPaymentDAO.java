package com.capg.dao;

import java.util.Map;

import com.capg.bean.AccountDetails;
import com.capg.bean.CustomerDetails;

public interface IPaymentDAO {
	public boolean addCustomer(AccountDetails accDetails);

	public float showBalance();

	public boolean depositBalance(float amt);

	public boolean withdrawBalance(float amt1);

	public boolean useLogin(String uname, String pass);

	public boolean fundTransfer(int custAccNum, float amt);
	
	public Map printTransaction();
}
