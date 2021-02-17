package com.bankapp.config;

class ExceptionTest {
	public static void foo() throws Exception{
		try {
			throw new ArrayIndexOutOfBoundsException();
		} catch (ArrayIndexOutOfBoundsException oob) {
			throw new Exception(oob);
		}
	}

	public static void main(String[] args) {
		try {
			foo();
		} catch (Exception re) {
			System.out.println(re.getCause());
		}
	}
}