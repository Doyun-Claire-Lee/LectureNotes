package com.test.inheritance;

public class Ex29_Interface_use_02 {
	
	public static void main(String[] args) {
		
		//1. 추상메소드 -> 추상클래스 vs 인터페이스
		//2. 추상클래스(인터페이스)를 반드시 사용해야 하는지?
		
		
//		M706 m1 = new M706();
//		m1.click();
//		m1.drag();
//		
//		S300 m2 = new S300();
//		m2.click();
//		m2.wheel();
		
		//참조 변수 주의해서 보기?
//		M706 m1 = new M706();
//		m1.click(); 	//마우스 공통기능
//		m1.drag();		//로지텍 특화기능  => 코드 상으로 구분이 안감..
//		m1.wheel();		//마우스 공통기능
//		
//		S300 m2 = new S300();
//		m2.click();
//		m2.wheel();
//		m2.drag();	//없는 기능
		
		//인터페이스 변수
		//인터페이스로 구현한 메소드는 인터페이스 변수로 
		IMouse m1 = new M706();
		m1.click();
		m1.click();
		
		M706 temp = (M706)m1; //다운캐스팅
		temp.drag(); // 이제 공통기능이 아닌 drag를 다운캐스팅을 통해 씀
		
		IMouse m2 = new S300();
		m2.click();
		m2.wheel();
		
	}

}//main

//공통 기능 : click(), wheel()
//부모 역할 : 인터페이스(추상클래스보다 부담이 적음)

interface IMouse {
	
	void click();
	void wheel();
	
}

abstract class AMouse {
	
	//구현 멤버 - 모든 마우스가 가져야할 멤버
	public String model;
	public String color;
	public int button;
	public int weight;
	public int size;
	public int level;
	
	public abstract void click();
	public abstract void wheel();
	
}

class M500 extends AMouse {

	@Override
	public void click() {
		// 
	}

	@Override
	public void wheel() {
		// 
	}
	
	//6개 구현 멤버 변수 상속
	//2개 추상 메소드 상속
	// => 8개를 이해하고 만드느냐? 2개를 이해하고 만드느냐? => 2개가 더 쉽다 : 인터페이스 사용!!
	
}


//일반 마우스
class M706 implements IMouse {
	//멤버 변수
	
	//멤버 메소드
	public void click() {
		System.out.println("로지텍 기술 + 클릭");
	}
	public void drag() {
		System.out.println("로지텍 기술 + 드래그");
	}
	@Override
	public void wheel() {
		// TODO Auto-generated method stub
		System.out.println("로지텍 기술 + 휠");
	}
}

class S300 implements IMouse {
	//멤버 변수
	
	//멤버 메소드
	public void click() {
		System.out.println("삼성 기술 + 클릭");
	}
	public void wheel() {
		System.out.println("삼성 기술 + 스크롤");
	}
}



