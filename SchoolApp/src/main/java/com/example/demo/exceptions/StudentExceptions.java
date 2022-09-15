package com.example.demo.exceptions;

public class StudentExceptions extends Throwable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public StudentExceptions(String msg) {
		super(msg);
		this.message = msg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
