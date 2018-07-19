package com.capg.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.capg.bean.AccountDetails;
import com.capg.bean.CustomerDetails;
import com.capg.service.PaymentDataValidate;
import com.capg.service.PaymentService;

public class ClientMain {

	public static void main(String[] args) {
		int choice1 = 0;
		int choice;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println(
					"\t*********************************** PAYMENT WALLET APPLICATION *****************************\t\t \t\t\t\n");
			System.out.println("\t\t 1.) \t SIGN UP/CREATE ACCOUNT \t\t\t 2.)\t SIGN IN/LOGIN \n");
			System.out.println("\t\t\t\t\t ENTER YOUR CHOICE \t\t\t\n");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				createAccount();
				break;
			case 2:
				boolean log = useLogin();
				if (log)

				{
					do

					{

						System.out.println("=====================================");
						System.out.println("***************MENU***************\n");
						System.out.println("1. *********Show Balance**********");
						System.out.println("2. ******** Deposit***************");
						System.out.println("3. ********* Withdraw*************");
						System.out.println("4.********* Fund Transfer********");
						System.out.println("5. ********* Print Transaction******");
						System.out.println("6. *********Exit***********");

						System.out.println(" ENTER YOUR CHOICE");

						choice1 = sc.nextInt();

						switch (choice1) {
						case 1:
							showBalance();
							break;
						case 2:
							depositBalance();
							break;

						case 3:
							withdrawBalance();
							break;
						case 4:
							fundTransfer();
							break;

						case 5:
							printTransaction();
							break;

						default:
							break;
						}

					} while (choice1 != 6);
				} else {
					System.out.println("ENTER VALID LOGIN DETAILS ");
				}
			}
			

		} while (choice != 3);
	}

	        private  static boolean useLogin() {
		// TODO Auto-generated method stub
		Scanner sc1 = new Scanner(System.in);
		PaymentDataValidate validate = new PaymentDataValidate();
		CustomerDetails c = new CustomerDetails();
		System.out.println("Enter Username");
		String uname = sc1.nextLine();
		System.out.println("Enter Password");
		String pass = sc1.nextLine();
		PaymentService service1 = new PaymentService();
		boolean b = service1.useLogin(uname, pass);
		if (b) {
			return true;

		}
		return false;
	}

	private static void printTransaction() {
		PaymentService service = new PaymentService();
		System.out.println(service.printTransaction());

	}

	private static void fundTransfer() {

		Scanner sc = new Scanner(System.in);

		CustomerDetails c = new CustomerDetails();

		System.out.println("Enter Account number to transfer your fund");
		int custAccNum = sc.nextInt();
		System.out.println("Enter the amount to transfer from your account to other account");
		float amt = sc.nextFloat();

		PaymentService service = new PaymentService();
		boolean trans = service.fundTransfer(custAccNum, amt);

		if (trans) {
			System.out.println(" Fund Transfer done successfully");

		} else {
			System.out.println("Invalid account number");
		}

	}

	private static void depositBalance() {
		CustomerDetails c = new CustomerDetails();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the amount to deposit");
		float amt = sc.nextFloat();

		PaymentService service = new PaymentService();
		boolean details = service.depositBalance(amt);

		if (details) {
			System.out.println("account deposited!");

		} else {
			System.out.println("Invalid account number");
		}

	}

	private static void withdrawBalance() {

		Scanner sc = new Scanner(System.in);
		PaymentService service = new PaymentService();
		System.out.println("Enter the amount to withdraw");
		
		float amt1 = sc.nextFloat();

		boolean withdraw = service.withdrawBalance(amt1);

		if (withdraw) {
			System.out.println("amount withdrawn !");
		} else {
			System.out.println("Invalid account number");
		}
	}

	public static void createAccount() {

		CustomerDetails custDetails = new CustomerDetails();
		AccountDetails accDetails = new AccountDetails();
		PaymentDataValidate validate = new PaymentDataValidate();
		PaymentService service = new PaymentService();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter username");
		String username = sc.nextLine();

		System.out.println("Enter password");
		String password = sc.nextLine();

		System.out.println("Enter 12 digit Aadhar number");
		String aadharNo = sc.nextLine();

		System.out.println("Enter your name");
		String customerName = sc.nextLine();

		System.out.println("Enter your age");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter your gender");
		String gender = sc.nextLine();

		System.out.println("Enter your address");
		String address = sc.nextLine();

		System.out.println("Enter your nationality");
		String nationality = sc.nextLine();

		System.out.println("Enter your mobile number");
		String mobileNo = sc.nextLine();

		System.out.println("Enter your initial balance");
		float initialBal = sc.nextFloat();
		sc.nextLine();
		System.out.println("Enter your Email Id");
		String custEmail = sc.nextLine();

		int custAccNo = (int) (Math.random() * 123456 + 789654);
		LocalDate custAccDate = LocalDate.now();

		boolean isCustomerAadharNo = validate.validateAadharNo(aadharNo);
		boolean isCustomerMobileNo = validate.validateMobileNo(mobileNo);
		boolean isCustomerInitialBal = validate.validateInitialBal(initialBal);

		if (isCustomerAadharNo && isCustomerMobileNo && isCustomerInitialBal) {

			custDetails.setUsername(username);
			custDetails.setPassword(password);
			custDetails.setAadharNo(aadharNo);
			custDetails.setCustomerName(customerName);
			custDetails.setAge(age);
			custDetails.setGender(gender);
			custDetails.setAddress(address);
			custDetails.setNationality(nationality);
			custDetails.setMobileNo(mobileNo);
			accDetails.setInitialBal(initialBal);
			custDetails.setCustEmail(custEmail);
			accDetails.setCustAccDate(custAccDate);
			accDetails.setCustAccNo(custAccNo);

			// passing object of customerDetails into AccountDetails
			// AccountDetails accDetails= new AccountDetails();
			accDetails.setCustDetails(custDetails);

			boolean b = service.addCustomer(accDetails);
			if (b) {
				System.out.println("Account Created. Account number is...." + custAccNo);
			} else {
				System.out.println("Account not created");
			}

		} else {
			System.out.println("Please enter correct details");
		}

	}

	public static void showBalance() {

		Scanner sc = new Scanner(System.in);

		PaymentService service = new PaymentService();
		float details = service.showBalance();
		System.out.println(details);

	}

}
