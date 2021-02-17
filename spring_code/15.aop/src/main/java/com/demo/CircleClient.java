package com.demo;
import org.springframework.stereotype.Component;
@Component
public class CircleClient {

	public void doCircleLogic(Circle circle) {
		System.out.println("doCircleLogic....");
	}
	
	public void doCircleLogic2(Circle circle) {
		System.out.println("doCircleLogic.2...");
	}
}
