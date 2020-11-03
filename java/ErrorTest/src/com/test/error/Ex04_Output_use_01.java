package com.test.error;

public class Ex04_Output_use_01 {
	
	public static void main(String[] args) {
		
		String name = "홍길동";
		int age = 20;
		double pi = 3.14;
		char c = 'A';
		
		System.out.printf("제 이름은 %-1s입니다.\n", name); 			//%.-1c를 %s로 수정
		System.out.printf("나이는 %d살입니다.\n", age); 				//age 값만 필요 -> pi 삭제
		System.out.print("소문자 'c'의 대문자는 'C'입니다.\n");			//printf 기능이 필요 없는 문장 -> print 로 변경
		System.out.printf("원주율은 %,.2f입니다.\n", pi); 				//실수 자료형 -> %f로 변경, 문자 바깥의 ','를 문자 안으로 이동 
		System.out.printf("제가 제일 좋아하는 문자는 %c입니다.\n", c); 	//char 자료형 -> %c로 변경
		System.out.print("오늘 3개의 에러를 발견하고 수정했습니다.\n");	//printf 기능이 필요 없는 문장 -> print 로 변경
		
		
	}

}











