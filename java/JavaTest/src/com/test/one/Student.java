package com.test.one;

public class Student {
	
	
	/*
	 * 
	접근 지정자
	 - private, public, protected, default(=friendly)
	 
	 1. private
		- 같은패키지, 다른패키지 모두 비공개
	 2. public 
		- 모두 공개
	 3. protected 
		- 같은패키지일 때 : public
		- 다른패키지일 때 : private
		- 다른패키지 + 자식클래스일 때 : public
	 4. default (나만 쓰는 public 느낌?)
		- 같은패키지일 때 : public
		- 다른패키지일 때 : private
	
	*/
	
	private int a = 100;
	public int b = 200;
	protected int c = 300;
	int d = 400; 			//아무것도 안쓰면 default
	
	
	public void test() {
		System.out.println("같은 클래스 내에서 접근");
		//같은 클래스 내에서 접근할때는 접근지정자가 동작을 안함. => 모두 접근 가능
		System.out.println("private a: " + this.a);
		System.out.println("public b: " + this.b);
		System.out.println("protected c: " + this.c);
		System.out.println("default d: " + this.d);
		System.out.println();
	}
	

}
