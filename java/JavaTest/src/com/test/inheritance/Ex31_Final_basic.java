package com.test.inheritance;

import java.util.Calendar;

public class Ex31_Final_basic {
	
	public static void main(String[] args) {
		
		//final 키워드
		// - "한번 정하면 수정이 불가능하다."
		
		//1. 변수에 적용
		//	a. 지역 변수(final)
		//	b. 멤버 변수(private, public, static, final)
		
		//2. 메소드에 적용
		//	a. 상속 구현 시 (Override 금지)
		// - 상속할 메소드를 수정하면 안되는 경우 
		// - 프로그램 안정성을 위해
		
		//3. 클래스에 적용
		//	a. 상속 구현 시
		// - 상속을 못하게 막는 역할
				
		
		
		//final 변수
		// - 상수(constant) : 변하지 않는 수
		// - 값을 한번 할당하면 다시는 변경할 수 없는 변수
		// - 이름이 있는 리터럴
		// - (되도록) 변수명을 모두 대문자로 만듬.
		
		int a = 10;
		final int b = 20;
		final double PI= 3.14;
		
		a=20;
//		b=30; //The final local variable b cannot be assigned. It must be blank and not using a compound assignment
		
		
		//1. final 변수?
		final int YEAR = 1; //지역변수
		System.out.println(Calendar.YEAR); // 숫자 1
		
		MyCalendar my = new MyCalendar();  // year값을 가지고 오고 싶으면 인스턴스로 만들어야 함. 혹은 static 변수로 생성
		System.out.println(my.YEAR);
		
		System.out.println(MyCalendar.SYEAR);
		// static final 변수 => 아무데서나 가져다 쓰고 싶을때..
		
				
	}
}

class MyCalendar {
	public final static int YEAR = 1;
	public final static int SYEAR = 1;
	
	//static final 변수의 예
	public final static String PATH = "D:\\Java\\Data";
	public final static String ID = "admin";
}


final class FinalParent { //누군가 이 클래스를 부모삼지 못하도록 할 때
	public final void test() { //한번 만든 메소드를 재정의(override)하지 못하도록 할 때
		System.out.println("구현");
	}
}

//class FinalChild extends FinalParent {
//	
////	@Override
////	public void test() { //Cannot override the final method from FinalParent
////		System.out.println("재정의");
////	}
//	
//}