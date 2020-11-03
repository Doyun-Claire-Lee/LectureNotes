package com.test.two;

import com.test.one.Student;

public class Student2 extends Student {
	
	public void test() {
		
		System.out.println("다른패키지내의 자식클래스에서 접근");
//		System.out.println(this.a);
		System.out.println(this.b);
		System.out.println(this.c);	//상속관계에 있는 클래스에게만 오픈하고 싶을 때 protected를 씀
//		System.out.println(this.d);
		
	}

}
