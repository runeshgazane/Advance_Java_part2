package com.app.custom_exception;

public class EmployeeNotFoundException extends Exception {
	public EmployeeNotFoundException(String msg) {
		super(msg);
	}
}
