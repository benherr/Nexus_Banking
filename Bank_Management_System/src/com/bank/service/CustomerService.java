package com.bank.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import com.bank.dao.CustomerDAO;
import com.bank.dao.TransactionDAO;
import com.bank.dto.CustomerDetails;
import com.bank.dto.Transaction_DetailsDTO;
import com.bank.exception.CustomerInvalidDataException;

public class CustomerService {
	Scanner scanner = new Scanner(System.in);
	CustomerDAO customerDAO = new CustomerDAO();
	TransactionDAO transactionDAO= new  TransactionDAO();
	 
	private CustomerDetails loggedCustomer;
	public void customerLogin() {

	    System.out.println("Enter the Customer Email :");
	    String emailid = scanner.next();

	    System.out.println("Enter the Customer PIN :");
	    int pin = scanner.nextInt();

	    CustomerDetails customerDetails =
	            customerDAO.selectCustomerDetailsByUsingEmailAndPin(emailid, pin);

	    if (customerDetails != null) {

	         loggedCustomer = customerDetails;
	         

	        if (customerDetails.getGender().equalsIgnoreCase("male")) {
	            System.out.println("Welcome Mr : "+customerDetails.getCustomername() );
	            customerOperation();	        
	        } 
	        
	        else if (customerDetails.getGender().equalsIgnoreCase("female")) {
	            System.out.println("Welcome Miss : "+customerDetails.getCustomername() );
	            customerOperation();
	        } 
	        else {
	            System.out.println("Welcome LGTV: "+customerDetails.getCustomername() );
	        }

	        
	       

	    } else {
	        System.out.println("Invalid email or PIN");
	    }
	}
	
	//----------------------------------
	public void customerOperation() {
		System.out.println(
	            "1. Credit\n2. Debit\n3. Balance\n4. Logout");
		
		switch(scanner.nextInt()) {
		 case 1:  System.out.println("Credit "); break;
		 case 2:  System.out.println("Debit "); CustomerDebit(); break;
		 case 3:  System.out.println("Check Statement "); break;
		 case 4:  System.out.println("Change PIN"); break;
		 default :System.out.println("Invalid Option"); break;
		}
	}
	//-----------------------------------------------
	
	public void CustomerDebit() {
	
		System.out.println("Enter the Account Number :");
		int accountnumber1 = scanner.nextInt();
		int dbAccountnumber = loggedCustomer.getAccountnumber();
		
		if(accountnumber1 == loggedCustomer.getAccountnumber()) {
         System.out.println(loggedCustomer.getAmount());
			System.out.println("Enter the Amount");
			Double amount = scanner.nextDouble();
			double dbAmount = loggedCustomer.getAmount();
			   if (amount <= dbAmount) {
				   System.out.println("Debited amount is :"+amount);
				   double balanceamount = dbAmount - amount;
				   System.out.println(balanceamount);
				   if(customerDAO.updateAmountByUsingAccountNumber(dbAccountnumber, balanceamount)) {
					   System.out.println("Amount Debited");
					   Transaction_DetailsDTO transaction_DetailsDTO = new Transaction_DetailsDTO();
					   transaction_DetailsDTO.setAccountnumber(accountnumber1);
					   transaction_DetailsDTO.setRaccountnumber(accountnumber1);
					   transaction_DetailsDTO.setTransactionamount(amount);
					   transaction_DetailsDTO.setBalanceamount(balanceamount);
					   transaction_DetailsDTO.setTransactiondate(LocalDate.now());
					   transaction_DetailsDTO.setTransactiontime(LocalTime.now());
					   transaction_DetailsDTO.setTransactiontype("debit");
					   System.out.println(transaction_DetailsDTO);
					   
					   transactionDAO.insertTransactionDetails(transaction_DetailsDTO);
					   
				   }
				   else {
					   System.out.println("500 error");
				   }
				   
			   }
			   else {
				   System.out.println("insufficient amount");
			   }
			  
			
		}
		else {
			
			System.out.println("Invalid acoount number");
			
		}
		
	}
	
	
	//----------------------------------
	public void customerRegistration() {
		
		
		System.out.println("Enter the Customer Name :");
		String name = scanner.next();
		
		System.out.println("Enter the Customer EmailID :");
		String emailid = scanner.next();
		    if(emailid.contains("@gmail.com")){
		    	
		    }
		    else {
		    	throw new CustomerInvalidDataException("Invalid Email ID ");
		    }
		    
		System.out.println("Enter the Customer Aadhar number:");
		long anumber = scanner.nextLong();
			    if(anumber>=100000000000l  && anumber<=999999999999l){
			    	
			    }
			    else {
			    	throw new CustomerInvalidDataException("Invalid Aadhar number ");
			    }   
			    
	    System.out.println("Enter the Customer mobile number:");
	    long mbnumber = scanner.nextLong();
					    if(mbnumber>=600000000l  && mbnumber<=9999999999l){
					    	
					    }
					    else {
					    	throw new CustomerInvalidDataException("Invalid mobile number ");
					    }  	
					    
		System.out.println("Enter the Customer Pan number:");
		String pannumber = scanner.next();
//						if(pannumber.length() ==10){
//									    	
//									    }
//					    else {
//									    	throw new CustomerInvalidDataException("Invalid pan number ");
//									    }  	
						
		System.out.println("Enter the Customer address:");
		String address = scanner.next();	
		
		System.out.println("Enter the Customer Gender:");
		String gender = scanner.next();
		     if(gender.equals("male") || gender.equals("femmale") || gender.equals("other")){
		    	 
		     }
		     else {
			    	throw new CustomerInvalidDataException("Invalid geneder identity ");
			    }  
		     
		     
		System.out.println("Enter the Customer's DOB:");
		String DOB = scanner.next();	
		
		System.out.println("Enter the Customer age:");
		int Age = scanner.nextInt();	
		
		System.out.println("Enter the amount:");
		Double amount = scanner.nextDouble();	
		
		
		CustomerDetails customerDetails = new CustomerDetails();
		
		customerDetails.setCustomername(name);
		customerDetails.setCustomeremailid(emailid);
		customerDetails.setAadharnumber(anumber);
		customerDetails.setAmount(amount);
		customerDetails.setCustomeraddress(address);
		customerDetails.setCustomerage(Age);
		customerDetails.setDateofbirth(Date.valueOf(DOB));
		customerDetails.setGender(gender);
		customerDetails.setMobilenumber(mbnumber);
		customerDetails.setPannumber(pannumber);
		
		
		customerDAO.insertCustomerDetails(customerDetails);
	}

}
