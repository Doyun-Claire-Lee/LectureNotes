package com.test.inheritance;

public class Ex28_Casting_basic {
	
	public static void main(String[] args) {
		
		//형변환
		
		//1. 값형 형변환
		// - 값형은 값형끼리만 형변환이 가능하다.(boolean 제외 7개 -> 숫자형)
		// - 큰형 -> 작은형 : 명시적(경우에 따라 달라짐)
		// - 작은형 -> 큰형 : 암시적(100%안전)
		
		//2. 참조형 형변환
		// - 참조형은 참조형끼리만 형변환이 가능하다. (클래스간의 형변환)
		// - 상속 관계에 있는 클래스끼리만 가능(부모-자식 클래스간에 발생)
		// - 부모클래스 -> 자식클래스 : 명시적, 다운 캐스팅(Down Casting)
		//		- 불가능 작업(100% 불가능)
		// - 자식클래스 -> 부모클래스 : 암시적, 업 캐스팅(Up Casting)
		//		- 가능 작업(100% 가능)
		
		CastingParent p1;
		CastingChild c1; 
		
		c1 = new CastingChild(); //원본
		
		
		//CastingParent = CastingChild
		//부모클래스 = 자식클래스
		//**업캐스팅** 발생
		p1 = c1;
		p1 = (CastingParent)c1;
		
		//복사 검증 방법
		// - 복사된 참조변수의 사용이 문제가 없으면 복사가 제대로 되었다고 판단***
		// - 사용자 눈앞에 있는 종이의 구멍으로 데이터가 보이면 제대로된 상황이라고 했을 때와 동일한 상황
		
		p1.a = 10;
		p1.b = 20;
//		p1.c  -> 보이지 않아 사용하지 못하지만 오류 혹은 잘못된 것이 아님.
//		p1.d

		CastingParent p2;
		CastingChild c2;
		
		p2 = new CastingParent();
		//명시적 형변환
		//자식클래스 = 부모클래스
		//다운캐스팅 발생
//		c2 = (CastingChild)p2;
//		
//		c2.a = 10;	//문제없음
//		c2.b = 20;	//문제없음..
//		c2.c = 30; 	//문제 발생 ->  구멍 4개뚫린 종이 뒤로 변수 2개밖에 보이지 않기 때문에..
//		c2.d = 40;	//문제 발생
		
		
		//편법? 다운캐스팅
		
		CastingChild c3;
		CastingParent p3;
		
		c3 = new CastingChild();
		p3 = c3; // -> 부모클래스타입 변수에 자식클래스타입 변수의 주소값을 복사
		
		
		CastingChild c4;
	
		c4 =(CastingChild)p3; // -> 다시 자식클래스타입 변수의 주소값을 자식클래스 변수에 복사
		
		System.out.println("종료");
		
		c4.a = 10;
		c4.b = 20;
		c4.c = 30;
		c4.d = 40;
		
		//직계 관계일때만 형변환이 가능하다..
		
		
	}//main

}

class CastingParent {
	public int a = 10;
	public int b = 20;
}

class CastingChild extends CastingParent {
	public int c = 30;
	public int d = 40;
}
