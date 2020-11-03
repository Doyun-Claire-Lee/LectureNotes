package com.test.inheritance;

public class Ex26_Overriding_basic {
	
	public static void main(String[] args) {
		
		//메소드 오버로딩, Method Overloading(Overload)
		//메소드 오버라이딩, Method Overriding(Override)
		
		//메소드 오버라이드
		// - 메소드 재정의(다시 선언)
		// - 메소드의 헤더는 그대로 두고, 구현부를 다시 만드는 작업
		// - 상속 관계에서 나타나는 현상
		// - 상속 관계에 있는 클래스보다 그 클래스를 사용하는 쪽에서 더욱 편하다. 여러 메소드명을 기억하지 않아도 되기 때문에..
		
		OverrideParent p = new OverrideParent();
		p.hello();
		
		OverrideChild c = new OverrideChild();
		c.hello();
//		c.hi();
		
		
	}

}

class OverrideParent {
	
	public void hello() {
		System.out.println("안녕하세요.");
	}
	
}

class OverrideChild extends OverrideParent {
	
	//오버라이드 발생
	// - 부모가 상속해준 메소드를 동일한 시그니처로 다시 만드는 작업
	// - 부모가 상속해준 메소드가 감춰짐.(*******)

//	public void hello() {
//		System.out.println("hi");
//	}
//
//	public void hi() {
//		System.out.println("hi");
//	}

	//Ctrl + space 눌러서 Override 
	@Override //주석
	public void hello() {

	}
}
