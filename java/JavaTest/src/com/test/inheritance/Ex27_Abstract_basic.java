package com.test.inheritance;

public class Ex27_Abstract_basic {
	
	public static void main(String[] args) {
		
		//Abstract
		//추상 클래스, Abstract class
		//추상 메소드, Abstract Method
		
		
		//추상 클래스, Abstract class
		// - 클래스
		// - 상속 관계의 구성원이 된다. -> 상속 관계 없이 독립적으로 사용하지 않음.
		// - 객체의 원형(베이스)을 만드는 역할
		// - 파생되는 객체들의 행동(사용법)을 표준화하는 역할
		
		SM101 m1 = new SM101();
//		m1.click();
		m1.push();
		
		M705 m2 = new M705();
//		m2.click();
		//m1과 m2의 메소드이름이 동일한것은 우연의 일치임. 따라서 사용자 입장에서는 클래스가 바뀔 때마다 사용법을 익혀야 하는 문제점이 있음.
		m2.push();
		
	}

}//Ex27

//추상 클래스 : 추상 메소드를 소유할 자격이 있음.
abstract class AbstractParent {
	
	//추상 메소드 : 구현부를 가질 수 없다.
	//자식 클래스에게 구현부를 구현하도록 강제하도록 함.
 	public abstract void test();
 	
 	//평범한 메소드, 변수도 가질 수 있음. : 구현된 멤버를 가질 수 있다.
 	private int a = 10;
 	public int b = 20;
 	
 	public void aaa() {
 		
 	}
}

//The type AbstractChild must implement the inherited abstract method AbstractParent.test() 오류
class AbstractChild extends AbstractParent {

	//부모가 물려준 추상메소드의 구현부를 구현하여 일반 메소드로 생성 -> 오버라이딩 / 구현
	@Override
	public void test() {
		
	}	
}

//마우스 추상 클래스

abstract class Mouse2 {

	public String moel;
	public int price;
	public int button;
	
	public void click() {
		System.out.println("로지텍 기술 + 저소음 클릭");
		
	}
	
	public abstract void push();
	
}

//마우스 일반 클래스
class M705 extends Mouse2 {
	
//	public String Model;
//	public int price;
//	public int button;
	
//	public void click() {
//		System.out.println("로지텍 기술 + 저소음 클릭");
//	}

	@Override
	public void push() {
		System.out.println("로지텍 기술 + 저소음 클릭");
	} //자체적인 메소드가 있어도 추상클래스를 상속받으면 추상 메소드로 구현해야 함.
	
}
class SM101 extends Mouse2 { 
	
//	public String moel;
//	public int price;
//	public int button;
	
//	public void click() {
//		System.out.println("소리가 나는 클릭");
//	}

	@Override
	public void push() {
		System.out.println("소리가 나는 클릭");
	}
}