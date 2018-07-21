package com.capg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import com.capg.bean.AccountDetails;
import com.capg.bean.CustomerDetails;
import com.capg.util.DBUtil;

public class PaymentDAO implements IPaymentDAO {

	static AccountDetails acc;
	static ResultSet rs;
	static String aadharNumber;
	Connection con;

	public boolean addCustomer(AccountDetails accDetails) {

		int n1 = 0;
		int n = 0;

		try {

			try {
				con = DBUtil.getConnection();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			String updateQuery = "insert into customer values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, accDetails.getCustDetails().getAadharNo());
			pstmt.setString(2, accDetails.getCustDetails().getCustomerName());
			pstmt.setInt(3, accDetails.getCustDetails().getAge());
			pstmt.setString(4, accDetails.getCustDetails().getGender());
			pstmt.setString(5, accDetails.getCustDetails().getAddress());
			pstmt.setString(6, accDetails.getCustDetails().getNationality());
			pstmt.setString(7, accDetails.getCustDetails().getMobileNo());
			pstmt.setString(8, accDetails.getCustDetails().getCustEmail());
			pstmt.setString(9, accDetails.getCustDetails().getUsername());
			pstmt.setString(10, accDetails.getCustDetails().getPassword());
			n = pstmt.executeUpdate();

			String updateQuery1 = "insert into account values(?,?,?,curdate())";
			PreparedStatement pstmt1 = con.prepareStatement(updateQuery1);
			pstmt1.setString(1, accDetails.getCustDetails().getAadharNo());
			pstmt1.setFloat(2, accDetails.getInitialBal());
			pstmt1.setInt(3, accDetails.getCustAccNo());
			n1 = pstmt1.executeUpdate();

			{
				if (n == 1 && n1 == 1) {
					acc = accDetails;
					return true;
				} else {
					return false;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	public float showBalance() {

		float initialBal1 = 0;

		try {
			con = DBUtil.getConnection();
			String displayQuery = "select * from account WHERE aadharNo=?";
			PreparedStatement pstmt = con.prepareStatement(displayQuery);
			pstmt.setString(1, aadharNumber);
			ResultSet rs6 = pstmt.executeQuery();

			while (rs6.next()) {
				System.out.println(rs6.getFloat("initialBalance"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return initialBal1;
	}

	public boolean withdrawBalance(float amt1) {

		try {
			con = DBUtil.getConnection();
			String withdrawQuery = "update account SET initialBalance = initialBalance-? WHERE aadharNo=?";
			PreparedStatement pstmt = con.prepareStatement(withdrawQuery);
			pstmt.setFloat(1, amt1);
			pstmt.setString(2, aadharNumber);
			int flag = pstmt.executeUpdate();
			if (flag == 1) {
				long tid = (int) (Math.random() * 123456 + 789654);
				LocalDateTime dt = LocalDateTime.now();
				String s = "Amount Withdrawn from Id no. =  " + Long.toString(tid) + "   on date  =  " + dt.toString();
				String transQuery = "insert into transaction values('" + aadharNumber + "','" + s + "') ";
				PreparedStatement pstmt1 = con.prepareStatement(transQuery);
				pstmt1.executeUpdate();

				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean depositBalance(float amt) {

		try {
			con = DBUtil.getConnection();
			String depositQuery = "Update account SET initialBalance = initialBalance + ? WHERE  aadharNo= ? ";
			PreparedStatement pstmt = con.prepareStatement(depositQuery);
			pstmt.setFloat(1, amt);
			pstmt.setString(2, aadharNumber);
			int flag1 = pstmt.executeUpdate();
			if (flag1 == 1) {
				long tid = (int) (Math.random() * 123456 + 789654);
				LocalDateTime dt = LocalDateTime.now();
				String s = "Amount Deposited from Id no. =  " + Long.toString(tid) + "   on date  =  " + dt.toString();
				String transQuery = "insert into transaction values('" + aadharNumber + "','" + s + "') ";
				PreparedStatement pstmt1 = con.prepareStatement(transQuery);
				pstmt1.executeUpdate();
				return true;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return true;
	}

	public boolean useLogin(String uname, String pass) {

		try {
			try {
				con = DBUtil.getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			String loginQuery = "select * from customer WHERE username='" + uname + "' and password='" + pass + "'";
			PreparedStatement pstmt = con.prepareStatement(loginQuery);
			System.out.println(loginQuery);
			ResultSet rs = pstmt.executeQuery(loginQuery);
			while (rs.first()) {
				aadharNumber = rs.getString("aadharNo");
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean fundTransfer(int custAccNum, float amt) {

		int n4 = 0;
		try {
			con = DBUtil.getConnection();

			String query = "update account SET initialBalance = initialBalance-? where aadharNo=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setFloat(1, amt);
			pstmt.setString(2, aadharNumber);
			pstmt.executeUpdate();

			String query1 = "update account SET initialBalance = initialBalance+? where custAccNo=?";
			PreparedStatement pstmt1 = con.prepareStatement(query1);
			pstmt1.setFloat(1, amt);
			pstmt1.setInt(2, custAccNum);
			pstmt1.executeUpdate();

			long tid = (int) (Math.random() * 123456 + 789654);
			LocalDateTime dt = LocalDateTime.now();
			String s = "Amount Fund Transferred from Id no. =  " + Long.toString(tid) + "   on date  =  "
					+ dt.toString();
			String transQuery = "insert into transaction values('" + aadharNumber + "','" + s + "') ";
			PreparedStatement pstmt2 = con.prepareStatement(transQuery);
			pstmt2.executeUpdate();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return true;

	}

	public void printTransaction() {
		try {
			con = DBUtil.getConnection();
			String trans = "select * from transaction WHERE aadharNo=?";
			PreparedStatement pstmt = con.prepareStatement(trans);
			pstmt.setString(1, aadharNumber);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
