package com.test.two;	//없으면 에러남. 이클립스는 자동으로 만들어주지만 다른 툴을 사용할 때 확인할것

import com.test.one.Student;

public class Item {
	
	public void test() {
		
		Student s1 = new Student();
		System.out.println("다른 패키지의 다른 클래스에서 접근");
//		System.out.println("private a: " + s1.a);
		System.out.println("public b: " + s1.b);	//패키지가 다르면 public 빼고는 접근이 안됨.
//		System.out.println("protected c: " + s1.c);	
//		System.out.println("default d: " + s1.d);	
		System.out.println();
		
	}

}
