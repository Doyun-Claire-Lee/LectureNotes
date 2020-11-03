package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_If_basic {
	
	public static void main(String[] args) throws Exception {
		
		/*

		제어문
		 - 프로그램 코드의 실행 순서를 제어하는 역할
		 - 로직(알고리즘)을 구성
		 - 구문이 실행되는 순서가 중요 ******************************
		 
		 1. 조건문
		 	a. if
		 	b. switch
		 2. 반복문
		 	a. for
		 	b. while
		 	c. do while
		 	d. for(향상된 for문, for each문, Enhanced For Statement)
		 3. 분기문
		 	a. break
		 	b. continue
		 	c. goto(JDK 1.5 -> 폐기)
		 	
		 	
		 if 문
		  - 조건을 제시한 후 결과에 따라 실행할 코드를 선택하는 제어문
		  - ex) 기상(7시 이전 조건) -> 지하철 vs 택시
		  - 조건은 반드시 boolean값을 가진다.
		  - A ? B : C
		 
		 a. if문만
		 
		 if (조건식) {
		 
		 	실행문;
		 	
		 }
		 
		 
		 b.if-else문
		 
		 if (조건식) { 
		 
		 	실행문;
		 	
		 } else {
		 
		 	실행문;
		 	
		 }
		
		
		c.다중if문(if - else if - else)
		
		if (조건식) {
		
			실행문;
			
		} [else if (조건식) {
		
			실행문;
		
		}] X n [ else {
		
			실행문;
			
		}] >> 생략가능

		*/
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 : ");
		int num = Integer.parseInt(reader.readLine());
		
//		if (num > 0) {
//			
//			System.out.println("입력한 숫자는 양수입니다.");
//			
//		} 
		
//		if (num > 0) {
//			
//			System.out.println("입력한 숫자는 양수입니다.");
//			
//		} else {
//			
//			System.out.println("입력한 숫자는 양수가 아닙니다.");
//		
//		}
		
		if (num > 0) {
			
			System.out.println("입력한 숫자는 양수입니다.");
			
		} else if ( num < 0 ) {
			
			System.out.println("입력한 숫자는 음수입니다.");
			
		} else {
			
			System.out.println("입력한 숫자는 0입니다.");
			
		}
		
		System.out.println("프로그램 종료");
		}
	
		
		
}
	
	
