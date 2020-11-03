package com.test.datatype;

public class Ex02_Variable_use_03 {
	
	
	public static void main(String[] args) {
		
		// '+' 연산자
		// - 숫자 + 숫자 = 산술 연산
		// - 문자열 + 문자열 = Concat(붙이기)
		// - 숫자 + 문자열 = Concat
		// - 문자열 + 숫자 = Concat
		
		//요구사항 : int 10, 20 -> '10 + 20 = 30'으로 출력
		int a = 10;
		int b = 20;
		
		System.out.println("10 + 20 = 30");
		System.out.println(a + "+" + b + "=" + a+b);
		System.out.println(a + "+" + b + "=" + (a+b));
		
		
		
		//숫자 저장 자료형
		//1. 나이? -> byte
		//2. 몸무게? -> short
		//3. 주민등록번호 앞자리? -> 950409 -> int?
		
		int jumin;
		jumin = 950409;
		System.out.println(jumin);
		
		jumin = 051003;
		System.out.println(jumin); //결과값 = 20995
		
		//숫자 데이터이지만 성격이 숫자가 아닌 것들
		//더하기, 빼기, 곱하기, 나누기 하지 않을 숫자는 전부 문자열로 취급하기
		//ex) 전화번호, 상품번호 등등
		
		String jumin2 = "051003";
		System.out.println(jumin2);
		
		//자바에서의 기수법 표현 방식
		// - 잘 사용 안함. 기수법을 쓸 일이 별로 없음.
		//1. 자바는 10진수 표현을 할 수 있음.
		//2. 자바는 8진수 표현을 할 수 있음.
		//3. 자바는 16진수 표현을 할 수 있음.
		//4. 자바는 2진수 표현은 할 수 없음.
		
		int num = 10; // 숫자 상수 -> 10진수 
		System.out.println(num);
		
		num = 010; //앞에 0을 붙이면 8진법(0~7까지의 숫자만 이용)
		System.out.println(num);
		
		num = 0x10; //0x를 붙이면 16진수(0~F)
		System.out.println(num);
		
		
		
	}
	

}
