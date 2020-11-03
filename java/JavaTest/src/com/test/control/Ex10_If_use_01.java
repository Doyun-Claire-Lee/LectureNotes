package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_If_use_01 {
	
	public static void main(String[] args) throws Exception {
		
//		m1();
		m2();
		
	}
	
	public static void m1() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//숫자 입력
		System.out.print("숫자 : ");
		int num = Integer.parseInt(reader.readLine());
		
		//짝수 or 홀수
		
		//지역변수
		// - 특정 지역(메소드, 제어문)내에서 선언된 변수
		
		//컴파일 에러 vs 런타임 에러
		//******지역변수는 생성과 동시에 반드시 초기화를 한다.
		
		String result = ""; //빈문자열(Empty String)으로 초기화
		
		if (num % 2 == 0) {
			result = "짝수";
		} else if (num % 2 == 1){
			result = "홀수";
		} 
		
		System.out.printf("%d은(는) %s입니다.\n", num, result);
	}

	public static void m2() throws Exception {
			
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//요구사항) 나이 입력 -> 원하는 나이?
		// 19세 이상 ~ 60세 미만
		
		//중첩된 if문 , Nested If Statement
		System.out.print("나이 : ");
		int age = Integer.parseInt(reader.readLine());
		
		if (age >= 0 && age <= 130) {
			if (age >= 19 && age < 60) {
				System.out.println("통과");
			} else {
				if (age < 19) {
					System.out.println("거절 - 어려서");
				} else {
					System.out.println("거절 - 많아서");
				}	
			}
		} else {
			System.out.println("올바른 나이를 입력하세요.");
		}
		
		
		//안좋은 코드
		if (age >= 19 && age < 60) {
			System.out.println("통과");		
		} else if (age >= 0 && age <= 130) {
			System.out.println("올바른 나이를 입력하세요.");
		} else if (age < 19) {
			System.out.println("거절 - 어려서");
		} else if (age >= 60) {
			System.out.println("거절 - 많아서");
		}
			
			
		}
}
