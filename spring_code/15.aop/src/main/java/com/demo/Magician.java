package com.demo;

import org.springframework.stereotype.Component;

@Component
 public class Magician {
	
	public String doMagic() {
		System.out.println("abra ka dabra...");
		return "rabbit form the hat";
	}
	
	public void doEat(String food) {
		System.out.println("eating food before magic...");
		//return "food is done";
	}
}
