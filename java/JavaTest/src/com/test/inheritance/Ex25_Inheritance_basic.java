package com.test.inheritance;

public class Ex25_Inheritance_basic {
	
	public static void main(String[] args) {
		
		//상속, Inheritance
		// - 클래스와 클래스간에 발생
		// - 부모클래스 역할 <-> 상속 <-> 자식클래스 역할
		// - 부모 클래스가 구현한 모든 멤버(변수, 메소드)를 자식클래스에게 물려주는 기술
		// - 코드 재사용(*******)
		
		//상속 관계에 있는 클래스
		// - 부모 클래스 <-> 자식 클래스
		// - 슈퍼 클래스 <-> 서브 클래스
		// - 기본 클래스 <-> 확장(파생) 클래스
		
		// 1:n 상속은 가능하나 n:1 상속(다중상속)은 불가능.. -> 부모클래스는 하나만 있어야 함. 
		// 자바에서는 다중상속 허용 X
				
		
		Child c = new Child();
		
		//(상속된)멤버
		c.a = 10;
		c.b = 20;
		c.aaa();
		
		//구현된 멤버
		c.c = 30;
		c.d = 40;
		c.bbb();
		
		
		DDD d = new DDD();
		d.a = 10;
		d.b = 20;
		d.c = 30;
		d.d = 40;
		
			
		
	}//main

}//Ex25

class Parent {
	
	public int a;
	public int b;
	
	public void aaa() {
		
	}
	
}

class Child extends Parent { //항상 나중에 태어난 개체가 먼저 태어난 개체를 참조함.
	//상속 - 복사 개념
	
	//상속된 멤버
	//int a, int b, aaa()
	
	//구현한 멤버
	//int c, int d, bbb()
	public int c;
	public int d;
	
	public void bbb() {
		
	}
	
}

class AAA {
	public int a;
}

class BBB extends AAA {
	public int b;
}

class EEE extends AAA {
	public int e;
}

class CCC extends BBB {
	public int c;
}

class DDD extends CCC { 
	public int d;
}