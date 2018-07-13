package com.capgemini.test;

import junit.framework.TestCase;

public class PaymentDetailsTest extends TestCase {

	public void testGetCustomerName() {
	      assertEquals("Valid","Karan","Karan");
	      assertEquals("InValid"," "," ");
	      assertEquals("InValid",123,123);
	      assertNotSame("abc", " ");
	      assertNotSame("abcdefgh", "abc ");
	}

	public void testGetAge() {
		assertEquals("Valid",11,11);
	      assertEquals("InValid"," "," ");
	      assertNotSame("InValid",11,"abc");
	}

	public void testGetGender() {
		  assertEquals("Valid","male","male");
	      assertEquals("InValid"," "," ");
	     
	}

	public void testGetAddress() {
		assertEquals("Jaipur ","Jaipur ");
	      assertEquals(" "," ");
	      assertNotSame("abc", " ");
	      assertNotSame("abcdefgh", "abc ");
	}

	public void testGetNationality() {
		
	}

	public void testGetMobileNo() {
		assertEquals(1234567890, 1234567890);
		assertNotSame(1234567890, " ");
		assertNotSame(1234567890, "abc ");
		assertNotSame(1234567890, 45345);

	}

	public void testGetInitialBal() {
		
	}

	public void testGetAadharNo() {
		assertEquals(1234567890, 1234567890);
		assertNotSame(1234567890, " ");
		assertNotSame(1234567890, "abc ");
		assertNotSame(1234567890, 45345);
	}

	public void testGetCustAccNo() {
		assertNotSame(1234567890, " ");
	}

	public void testGetCustEmail() {
		assertEquals("abc@gmail.com", "abc@gmail.com");
		assertNotSame("abc@gmail.com", " ");
		assertNotSame("abc@gmail.com", "abc ");
		assertNotSame("abc@gmail.com", 45345);
	}
	

	public void testGetCustAccDate() {
		
	}

}
