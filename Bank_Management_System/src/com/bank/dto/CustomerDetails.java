package com.bank.dto;

import java.sql.Date;

public class CustomerDetails {

	private int customerid;
	private String customername;
	private String customeremailid;
	private long aadharnumber;
	private String pannumber;
	private long mobilenumber;
	private String customeraddress;
	private String gender;
	private Date dateofbirth;
	private int customerage;
	private double amount;
	private int accountnumber;
	private int pin;
	
	public CustomerDetails() {}
	
	public CustomerDetails(int customerid, String customername, String customeremailid, long aadharnumber,
			String pannumber, long mobilenumber, String customeraddress, String gender, Date dateofbirth,
			int customerage, double amount, int accountnumber, int pin) {
		super();
		this.customerid = customerid;
		this.customername = customername;
		this.customeremailid = customeremailid;
		this.aadharnumber = aadharnumber;
		this.pannumber = pannumber;
		this.mobilenumber = mobilenumber;
		this.customeraddress = customeraddress;
		this.gender = gender;
		this.dateofbirth = dateofbirth;
		this.customerage = customerage;
		this.amount = amount;
		this.accountnumber = accountnumber;
		this.pin = pin;
	}
		
	

		public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomeremailid() {
		return customeremailid;
	}

	public void setCustomeremailid(String customeremailid) {
		this.customeremailid = customeremailid;
	}

	public long getAadharnumber() {
		return aadharnumber;
	}

	public void setAadharnumber(long aadharnumber) {
		this.aadharnumber = aadharnumber;
	}

	public String getPannumber() {
		return pannumber;
	}

	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getCustomeraddress() {
		return customeraddress;
	}

	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public int getCustomerage() {
		return customerage;
	}

	public void setCustomerage(int customerage) {
		this.customerage = customerage;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "CustomerDetails [customerid=" + customerid + ", customername=" + customername + ", customeremailid="
				+ customeremailid + ", aadharnumber=" + aadharnumber + ", pannumber=" + pannumber + ", mobilenumber="
				+ mobilenumber + ", customeraddress=" + customeraddress + ", gender=" + gender + ", dateofbirth="
				+ dateofbirth + ", customerage=" + customerage + ", amount=" + amount + ", accountnumber="
				+ accountnumber + ", pin=" + pin + "]";
	}
	}

