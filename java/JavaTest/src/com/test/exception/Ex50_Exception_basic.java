package com.test.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.test.object.User;

public class Ex50_Exception_basic {
	
	public static void main(String[] args) {
		
		/*
		
		예외처리, Exception Handling
		- 예외(Exception): 예측하지 못한 에러
		- 예외를 미리 예측해서 사전에 방지(대응)하는 코드를 작성하는 행동
		
		1. 전통적인 방식(if 조건문)
		2. 전용 도구(try-catch) : 자원을 잡아먹기 때문에 최소한으로 쓰는 것이 좋음.
		
		*/
		
//		m1();
//		m2();
//		m3();
//		m4();
		
//		try {
//			m5();	
//			m6();
//		} catch (Exception e) {
//			System.out.println("main에서 처리함.");
//		}

		m7();
		
				
		
		
	}

	private static void m7() {
		
		//외부와의 입출력작업 -> 예외 미루기 작업 발생
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	
		try {
			reader.readLine();		//예외처리를 readLine()을 쓰는 곳에서 처리하도록 함.
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scanner scan = new Scanner(System.in);
		scan.nextLine();			//예외처리를 nextLine()자체에서 처리하고 값을 반환해줌
	}

	private static void m6() throws Exception {
		
		int num = 0;
		System.out.println(100 / num);
		
	}
	
	private static void m5() throws Exception { //"throws Exception" 호출한 곳에서 에러를 책임지라는 뜻
		
		//예외 미루기 (throws Exception)
		int num = 0;
		System.out.println(100 / num);

	}

	private static void m4() {

		//숫자를 입력 -> 짝수만 사용, 홀수는 에러로 처리하기
		
		int num = 3;
		
		
		if(num % 2 == 0) {
			System.out.println("업무 진행");
		} else {
			System.out.println("오류 발생 - 최대리 연락");
		}
		
		
		try {
			
			if (num % 2 == 1) {//홀수인 경우 강제로 에러(예외) 발생시키기
				throw new Exception();	//예외던지기
			}
			System.out.println("업무 진행");
			
		} catch (Exception e) {
			System.out.println("오류 발생 - 최대리 연락");
		}
		
		
	}

	private static void m3() {	//m2()보다 가독성이 좋아짐, 보통 흔하게 쓰는 스타일
		
		try {
			
			//업무 A.
			int num = 10;
			System.out.println(100 / num);		//new ArithmeticException()
			
			//업무 B.
			int[] nums = new int[3];	
			System.out.println(nums[0]);		//new ArrayIndexOutOfBoundsException()
				
			//업무 C.
			User user = new User();
			System.out.println(user.getName());	//new NullPointerException()
			
			//업무 D.
			String str = "홍길동";
			System.out.println(str.charAt(5));	//new StringIndexOutOfBoundsException()
			
			
		} catch (ArithmeticException e) {
			System.out.println("산술 연산 오류 - 박과장 연락");
		
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 첨자 오류 - 김부장 연락");
		
		} catch (NullPointerException e) {
			System.out.println("Null 참조 오류 - 최대리 연락");
	
		} catch (Exception e) { //항상 마지막에 두어야 함.
			System.out.println("나머지 오류 - 정사원 연락");
		}
		
	}
	
	private static void m2() {
	
		//업무 A.
		try {
			int num = 0;
			System.out.println(100 / num);			
		} catch(Exception e) {
			System.out.println("박과장 연락");
		}
		
		//업무 B.
		try {
			int[] nums = new int[3];
			System.out.println(nums[5]);		
		} catch(Exception e) {
			System.out.println("김부장 연락");
		}

		//업무 C.
		try {
			User user = null;
			System.out.println(user.getName());
		} catch(Exception e) {
			System.out.println("최대리 연락");
		}
		
	}

	private static void m1() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자: ");
		int num = scan.nextInt();	//int 범위 내 숫자는 모두 연산 가능하지만 0일때는 에러가 남.. -> 예외처리 필요
		
		//전통적인 예외처리 방법
		
		//좋은 코드
		if (num != 0) { 
			//원래 의도했던 코드 : 업무코드, 비즈니스 코드
			System.out.printf("100 / %d = %d\n", num, 100 / num);
			
		} else {
			//예외 처리 코드
			System.out.println("0은 입력할 수 없습니다.");
		}
		
		//안좋은 코드		
//		if (num == 0) { 
//			System.out.println("0은 입력할 수 없습니다.");			
//		} else {
//			System.out.printf("100 / %d = %d\n", num, 100 / num);
//		}
		
			
		//전용 도구
		try {					//무조건 비즈니스 코드 블럭
			System.out.printf("100 / %d = %d\n", num, 100 / num);
			System.out.println("업무 완료");
			
		} catch (Exception e) { //무조건 예외 처리 코드 블럭
			System.out.println("0은 입력할 수 없습니다.");
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			System.out.println(e.toString());
		}
	}

}
