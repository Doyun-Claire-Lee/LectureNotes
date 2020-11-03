package com.test.error;


public class Ex02_Variable_use_01 {

	public static void main(String[] args) {
		
		int a;		
		a = 10; //문장 종결자 생략으로 인한 에러
		System.out.println(a);
		
		int b = 20;
		System.out.println(b);
		
		int c, d, e; //변수 d에 ',' 대신 ';' 삽입으로 인한 에러 
		
		c = 30;
		d = 40;
		e = 50;
		
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		
		int f = 60, g = 70, h = 80;
		int i = 90, j = 90; long k, l = 100; // 변수 j 가 제대로 선언 및 초기화되지 않음.
		
		int n = 100; //이미 앞에서 선언된 변수 a -> 변수 이름을 변경하여 해결 
		System.out.println(n);
		
		int m = 20;
		System.out.println(m); //변수 m 값이 초기화되지 않아 출력 불가
		
		int total = f + g + h;
		System.out.println(total); //total이라는 변수는 선언되지 않음 -> 새롭게 선언 및 초기화
	

		
		
		
		
	}
	
}










