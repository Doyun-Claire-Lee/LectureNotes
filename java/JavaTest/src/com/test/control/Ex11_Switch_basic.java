package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex11_Switch_basic {

	public static void main(String[] args) throws Exception {
		
		/*
		 
		 조건문
		 1. if
		 2. switch
		 
		 switch (조건값) {
		 
		 	case 값:
		 		실행문;
		 		break;
		 	[case 값:
		 		실행문;
		 		break;] X 0~N
		 	[default 값:
		 		실행문;
		 		break;] X 0~1
		 
		 }
		
		
		*/
		
//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
		m6();
		
	}//main
	

	private static void m6() {

		//쇼핑몰
		//1. 카메라 + 메모리카드 + 삼각대 패키지
		//2. 카메라 + 메모리카드 패키지
		//3. 카메라 
		
		//교집합이 있는 경우 break 생략을 통해 코드를 줄일 수 있음.
		
		int input = 1;
		
		switch (input) {
		
			case 1:
//				System.out.println("카메라");
//				System.out.println("메모리카드");
				System.out.println("삼각대");
//				break;
			case 2:
//				System.out.println("카메라");
				System.out.println("메모리카드");
//				break;
			case 3:
				System.out.println("카메라");
				break;
		}
		
	}


	public static void m1() {
		
		//사용자입력 : 숫자 1개 -> 한글로 출력
		//1 -> '하나'
		
		int n = 3;
		
		//괄호 안에 있는 값을 찾아 똑같은 값의 case로 이동
		switch (n) {
		
			case 1: //Label
				System.out.println("하나");
				break; // 본인이 소속된 제어문을 탈출하는 역할
			case 2:
				System.out.println("둘");
				break;
			case 3:
				System.out.println("셋");
				break;
			
		}
		//break를 만나면 이곳으로 이동
		
	}
	
	public static void m2() { 
		
		//쇼핑몰에서 옷을 색을 입력하여 주문
		
		String color = "검정"; 
		
		//재고가 있는 색상만 판매
		switch (color) {
			case "빨강":
				System.out.println("주문 완료");
				break;
			case "파랑":
				System.out.println("주문 완료");
				break;
			case "노랑":
				System.out.println("주문 완료");
				break;
			default: //기타 등등
				System.out.println("취급하지 않는 색상입니다.");
				break;
		}
		
	}
	
	public static void m3() throws Exception {
		
		//자판기 
		// - 메뉴 출력 후 음료 선택 -> 가격 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println("==========");
		System.out.println("자판기");
		System.out.println("==========");
		System.out.println("1. 콜라");
		System.out.println("2. 사이다");
		System.out.println("3. 비타500");
		System.out.println("==========");
		System.out.print("선택(메뉴번호) : ");
		String input = reader.readLine();
		
//		switch (input) {
//		
//			case "1":
//				System.out.println("700원 입니다.");
//				break;//break가 없으면 밑으로 내려감.
//			case "2": 
//				System.out.println("600원 입니다.");
//				break;
//			case "3":
//				System.out.println("500원 입니다.");
//				break;
//		}
		switch (input) {
		//콜라와 사이다의 가격이 똑같을 때 아래와 같이 생략할 수 있음. 
		case "1":
		case "2": 
			System.out.println("600원 입니다.");
			break;
		case "3":
			System.out.println("500원 입니다.");
			break;
		}
		
	}
	
	public static void m4() {
		
		//사용자 입력 월 : 해당월의 마지막 날짜 출력
		
		int month = 5;
		int lastDay = 0;
		
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
		
			lastDay = 31;
			
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			
			lastDay = 30;
			
		} else {
			//윤년 계산하여 출력하는게 정석..
			lastDay = 28;
		}
		
		System.out.println(lastDay);
		
		switch (month) {
		
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				lastDay = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				lastDay = 30;
				break;
			case 2:
				lastDay = 28;
				break;
		}
		
		System.out.println(lastDay);
				
	}
		
	private static void m5() {
		
		//switch 조건
		// - 숫자(정수), 문자열, 열거형만 가능하다.
		//		Cannot switch on a value of type double. Only convertible int values, strings or enum variables are permitted오류
		// - 범위 비교 or 논리 비교 -> switch로 사용 안함.
		
//		double d= 3.4;
//		switch (d) {
//			case 3.4 : 
//				break;		
//		}
		
		
	}
		
}
	
	

