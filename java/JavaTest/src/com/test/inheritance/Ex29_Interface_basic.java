package com.test.inheritance;

public class Ex29_Interface_basic {
	
	public static void main(String[] args) {
		
		//인터페이스, Interface
		// - 클래스(자료형)
		// - 추상 클래스와 유사
		
	}
}

/*

class 일반클래스 {
	구현 멤버;
}

abstract class 추상클래스 {
	구현 멤버;
	추상 멤버;
}

interface 인터페이스 {
	추상 멤버;
}

*/


//인터페이스 선언(설계)
interface ISpeaker {
	
	//구현 멤버를 가질 수 없다.
//	public int a;
//	public void aaa() { //Abstract methods do not specify a body 오류
//		
//	}
	
	//추상 멤버만 가질 수 있다.
	//1. 외부와 내부를 연결해 주는 역할 -> 무조건 public으로 선언 / 생략해도 public으로 생성됨.
	//2. abstract 생략 가능
	public abstract void on();
	void off();
	
}

class Bose100 implements ISpeaker {

	@Override
	public void on() {
		// 
	}

	@Override
	public void off() {
		// 
	}
	
}


abstract class AbstractTest {
	
	//구현 멤버(일반 클래스와 동일)
	public int a;
	public void aaa() {
		System.out.println(a);
	}
	
	//추상 멤버(구현부 X)
	public abstract void bbb();	
}


class Test extends AbstractTest {
	
	public void bbb() {
		//Test클래스 맘대로 구현(but bbb()목적을 벗어나면 안됨)
	}
}