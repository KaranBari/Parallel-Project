package com.capg.service;

public class PaymentDataValidate {
	public boolean validateAadharNo(String aadharNo) {
		if (aadharNo.length() == 12) {
			return true;
		} else {
			return false;
		}

	}

	public boolean validateMobileNo(String mobileNo) {
		if (mobileNo.length() == 10) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateInitialBal(float initialBal) {
		if (initialBal >= 500) {
			return true;
		} else {
			return false;
		}
	}
}
