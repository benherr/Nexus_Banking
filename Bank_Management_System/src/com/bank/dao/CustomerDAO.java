package com.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.dto.CustomerDetails;

public class CustomerDAO {
	
	private final static String insertion = "insert into customer_details(customer_name, customer_emailid, aadhar_number, pan_number, mobile_number, customer_address, gender, Date_Of_Birth, customer_age, Amount)"+
	"values(?,?,?,?,?,?,?,?,?,?)";
	
	private final static String url = "jdbc:mysql://localhost:3306/a4_bank_management_system_db?user=root&password=root";
	
	private final static String customer_login = "select * from customer_details where customer_emailid =? and pin=?";
	
	private final static String byusingacno = "select * from customer_details where Account_number = ?";
	
	private final static String updateAmount = "update customer_details set Amount = ? where Account_number = ?";
	
	public void insertCustomerDetails(CustomerDetails customerDetails) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(insertion);
			
			preparedStatement.setString(1, customerDetails.getCustomername());
			preparedStatement.setString(2, customerDetails.getCustomeremailid());
			preparedStatement.setLong(3, customerDetails.getAadharnumber());
			preparedStatement.setString(4, customerDetails.getPannumber());
			preparedStatement.setLong(5, customerDetails.getMobilenumber());
			preparedStatement.setString(6, customerDetails.getCustomeraddress());
			preparedStatement.setString(7, customerDetails.getGender());
			preparedStatement.setDate(8, customerDetails.getDateofbirth());
			preparedStatement.setInt(9, customerDetails.getCustomerage());
			preparedStatement.setDouble(10, customerDetails.getAmount());
			
			int result = preparedStatement.executeUpdate();
			
			if(result!=0) {
				System.out.println("Registration Successful...");
			}
			else {
				System.out.println("500 error");
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public CustomerDetails selectCustomerDetailsByUsingEmailAndPin(String emailid,int pin) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement = connection.prepareStatement(customer_login);
				preparedStatement.setString(1,emailid);
				preparedStatement.setInt(2,pin);
				ResultSet resultSet = preparedStatement.executeQuery();
				CustomerDetails cd = new CustomerDetails();
				if(resultSet.next()) {
					
					    cd.setGender(resultSet.getString("gender")); 
					    cd.setCustomername(resultSet.getString("customer_name"));
					    cd.setAccountnumber(resultSet.getInt("Account_number"));
					    cd.setAmount(resultSet.getDouble("Amount"));
					    
					 
					
					return cd;
				}
				else {
					return null;
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
		}
		
		public boolean selectCustomerDetailsByUsingAccount_number(int accountnumber) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement = connection.prepareStatement(byusingacno);
				preparedStatement.setInt(1,accountnumber);
				CustomerDetails cust = new CustomerDetails();
				ResultSet resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					 
					return true;
				}
				else {
					return false;
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
		public boolean updateAmountByUsingAccountNumber(int accountnumber , double balanceamount) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement = connection.prepareStatement(updateAmount);
				
				preparedStatement.setDouble(1, balanceamount);
				preparedStatement.setInt(2, accountnumber);
				
				int result = preparedStatement.executeUpdate();
				
				if(result!=0) {
					return true;
				}
				else {
					return false;
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
			
		}
	}


