package com.bank.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction_DetailsDTO {
  

	private LocalDate transactiondate;
	private LocalTime transactiontime;
	private double transactionamount;
	private double balanceamount;
	private int accountnumber;
	private int raccountnumber;
	private String transactiontype;
	
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	public Transaction_DetailsDTO() {
		
	}
	public Transaction_DetailsDTO( LocalDate transactiondate, LocalTime transactiontime,
			double transactionamount, double balanceamount, int accountnumber, int raccountnumber,String transactiontype) {
		super();
		
		this.transactiondate = transactiondate;
		this.transactiontime = transactiontime;
		this.transactionamount = transactionamount;
		this.balanceamount = balanceamount;
		this.accountnumber = accountnumber;
		this.raccountnumber = raccountnumber;
		this.transactiontype = transactiontype;
	}
	
	
	public LocalDate getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(LocalDate transactiondate) {
		this.transactiondate = transactiondate;
	}
	public LocalTime getTransactiontime() {
		return transactiontime;
	}
	public void setTransactiontime(LocalTime transactiontime) {
		this.transactiontime = transactiontime;
	}
	public double getTransactionamount() {
		return transactionamount;
	}
	public void setTransactionamount(double transactionamount) {
		this.transactionamount = transactionamount;
	}
	public double getBalanceamount() {
		return balanceamount;
	}
	public void setBalanceamount(double balanceamount) {
		this.balanceamount = balanceamount;
	}
	public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}
	public int getRaccountnumber() {
		return raccountnumber;
	}
	public void setRaccountnumber(int raccountnumber) {
		this.raccountnumber = raccountnumber;
	}
	@Override
	public String toString() {
		return "Transaction_DetailsDTO [ transactiondate=" + transactiondate
				+ ", transactiontime=" + transactiontime + ", transactionamount=" + transactionamount
				+ ", balanceamount=" + balanceamount + ", accountnumber=" + accountnumber + ", raccountnumber="
				+ raccountnumber + ", transactiontype=" + transactiontype + "]";
	}
	
}
