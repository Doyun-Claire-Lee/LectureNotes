package com.test.error;

public class Ex02_Variable_use_02 {

	public static void main(String[] args) {
		
		byte b1;
		b1 = 100; //byte에 들어갈 수 없는 값(-128~127) -> 100으로 수정 
		System.out.println(b1);
		
		short s1;
		s1 = 10;
		System.out.println(s1);
		
		int n1;
		n1 = 10;
		System.out.println(n1);
		
		long l1;
		l1 = 10000000000L; //Literal은 int 형식 -> 숫자 뒤에 L을 붙여 수정
		System.out.println(l1);
		
		
		
		float f1;
		f1 = 3.14F; //Literal은 double 형식 -> 숫자 뒤에 F을 붙여 수정
		System.out.println(f1);
		
		double d1;
		d1 = 6.28;
		System.out.println(d1);
		
		
		
		char c1;
		c1 = 'A'; //쌍따옴표를 호따옴표로 변경
		System.out.println(c1);
		
		c1 = '홍'; // char 타입에는 하나의 문자만 저장 가능 -> '홍'으로 수정
		System.out.println(c1);
		
		
		String name;
		name = "홍길동"; // 쌍따옴표로 수정
		System.out.println(name);
				
		
	}
	
}




















