package com.test.object;

public class Ex34_Generic_basic {
	
	public static void main(String[] args) {
		
		Monitor<Integer> n1 = new Monitor<Integer>();
		n1.a = 10;
		n1.b = 20;
		n1.c = 30; //컴파일 시 자료형을 확정지음. <>안에 Integer를 넣었기 때문에 변수 c에 정수값 저장 가능
		
		Monitor<String> n2 = new Monitor<String>();
		n2.a = 10;
		n2.b = 20;
		n2.c = "문자열"; 
		
		Monitor<Boolean> n3 = new Monitor<Boolean>();
		n3.a = 10;
		n3.b = 20;
		n3.c = true; 
		
		Desk<Double> n4 = new Desk<Double>();
		n4.a = 10;
		n4.b = 3.1;
		n4.c = 5.2;
		n4.d = 4.7;
		
		Pad<String,Integer> n5 = new Pad<String,Integer>();
		n5.a = "문자열";
		n5.b = 10;
		
		Room<String> n6 = new Room<String>();
		n6.a = "문자열";
		n6.test("하하하");
		System.out.println(n6.get());
		
	}

}

//제네릭 클래스 선언하기
// - T : 타입 변수(자료형 자체를 저장하는 변수), 보통 Type의 약자로 "T"를 씀. 반드시 참조형만 인자로 받을 수 있음.(Integer(o), int(x))
class Monitor<T> { //public void test(int "T")같은 표현
	
	//멤버 구현
	public int a;
	public int b;
	
	public T c;
	
	
}

class Desk<T> {
	
	public int a;
	public T b;
	public T c;
	public T d;

}

class Pad<T,U> {
	
	public T a;
	public U b;
}

class Room<T> {
	
	public T a;
	
	public void test(T a) {
		
		//하나의 자료형을 타겟으로 하는 업무를 진행하면 안된다..
		//ex)
//		System.out.println(a + 10); -> T에 참조형이 들어오는 경우 진행이 불가능
		//따라서 모든 자료형들이 다 할 수 있는 업무를 진행해야 한다.
		
	}
	
	public T get() {
		return a;
	}
}