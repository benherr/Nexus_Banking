package com.bank.exception;

public class CustomerInvalidDataException extends RuntimeException{
	
	private String msg;
	
	
	public CustomerInvalidDataException() {};
	
	public CustomerInvalidDataException(String msg) {
		this.msg = msg;
	};
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	
	

}
