package com.capgemini.test;

import com.capg.bean.AccountDetails;

import junit.framework.TestCase;

public class AccountDetailsTest extends TestCase {
	
	AccountDetails ad = new AccountDetails();
	
	public void testGetInitialBal() 
	{
		
	}

	public void testGetCustAccNo() 
	{
		assertNotSame(1234567890, " ");
		ad.setCustAccNo(123456789);
		assertEquals(123456789,ad.getCustAccNo());
	}

	public void testGetCustAccDate() 
	{
	    	assertEquals("12/12/1995","12/12/1995");
	}

}
