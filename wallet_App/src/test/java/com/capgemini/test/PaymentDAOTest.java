package com.capgemini.test;

import com.capg.bean.CustomerDetails;
import com.capg.dao.PaymentDAO;

import junit.framework.TestCase;

public class PaymentDAOTest extends TestCase {

	
	CustomerDetails detail = new CustomerDetails();
	PaymentDAO dao = new PaymentDAO();
	public void testAddCustomer() {
		
	}

	public void testShowBalance() {
		
	}

	public void testWithdrawBalance() {
		assertEquals(false,dao.withdrawBalance( 40000));
		assertEquals(false,dao.withdrawBalance( 0));
	}

	public void testDepositBalance() {
		assertEquals(false,dao.depositBalance( 40000));
		assertEquals(false,dao.depositBalance( 0));
	}

}
