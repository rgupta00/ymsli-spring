package com.demo;

import org.springframework.stereotype.Component;

@Component
 public class Magician {
	
	public void doMagic() {
		System.out.println("abra ka dabra...");
		if(1==31)
			throw new RuntimeException("feeling sick ex..");
	}
}
