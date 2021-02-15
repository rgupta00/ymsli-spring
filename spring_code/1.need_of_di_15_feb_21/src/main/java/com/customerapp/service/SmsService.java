package com.customerapp.service;

public class SmsService implements MessageService {

	@Override
	public void sendMessage(String reciver, String message) {
		System.out.println("email is send to recipent" );
	}

}
