package com.bank.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import com.bank.dto.Transaction_DetailsDTO;

public class TransactionDAO {
   
	private final static String insert = "insert into transaction_details (transaction_Date, transaction_time, transaction_Amount, balance_Amount, Customer_account_number, Receiver_account_number, transaction_type) "
			+ "values (?,?,?,?,?,?,?)";
	
	private final static String url = "jdbc:mysql://localhost:3306/a4_bank_management_system_db?user=root&password=root";
	
	
	
	
	public void insertTransactionDetails(Transaction_DetailsDTO td) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(td);
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			
			preparedStatement.setDate(1,Date.valueOf(td.getTransactiondate()));
			preparedStatement.setTime(2,Time.valueOf(td.getTransactiontime()));
			preparedStatement.setDouble(3,td.getTransactionamount());
			preparedStatement.setDouble(4,td.getBalanceamount());
			preparedStatement.setInt(5,td.getAccountnumber());
			preparedStatement.setInt(6,td.getRaccountnumber());
			preparedStatement.setString(7,td.getTransactiontype());
			
            int result = preparedStatement.executeUpdate();
			
			   if(result!=0) {
				  System.out.println("inserted Successful...");
			}
			   else {
				  System.out.println("500 error");
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
