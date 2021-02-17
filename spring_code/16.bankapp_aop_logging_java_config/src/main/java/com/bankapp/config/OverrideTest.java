package com.bankapp.config;
class Base {
	public static void foo(Base bObj) {
		System.out.println("In Base.foo()");
		bObj.bar();
	}

	public void bar() {
		System.out.println("In Base.bar()");
	}
}

class Derived extends Base {
	public static void foo(Base bObj) {
		System.out.println("In Derived.foo()");
		bObj.bar();
	}

	public void bar() {
		System.out.println("In Derived.bar()");
	}
}

class OverrideTest {
	public static void main(String[] args) {
		
		/*
		 * In Base.foo()
          In Derived.bar()
		 */
		Base bObj = new Derived();
		bObj.foo(bObj);
	}
}