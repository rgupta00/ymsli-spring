package com.bankapp.service.exceptions;

public class AccountNotFoundException extends RuntimeException{
	public AccountNotFoundException(String message) {
		super(message);
	}
}
