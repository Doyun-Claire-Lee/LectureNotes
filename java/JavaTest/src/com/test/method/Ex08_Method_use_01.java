package com.test.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_use_01 {
	
	public static void main(String[] args) throws Exception {
		
		//메소드
		// - 코드의 집합
		// - 자주 사용하는 반복적인 코드를 단위(모듈)로 묶어 놓고 재사용할 수 있는 요소
		
		//메소드 선언하기(x1) > 호출하기(xN + 재사용 효과)의 과정
		
		//메소드 특징
		//1. 코드 재사용 >> 반복적인 행동
		//2. 재사용과 무관하게 독립적인 행동(모듈) >> 가독성 향상
		//3. 
		
		
		
		//m1을 호출하는 순간 실행하다가 잠시 멈추고  m1 메소드로 이동하여 실행
//		m1();
//		m1();
//		m1();
		//여러개를 호출하면 동일한 내용의 각각의 새로운 m1이 생성되어 해당 메소드로 이동하여 실행
		
//		m2();
		
		m3(10);	//여기서의 10 -> 실인자
//		m3(); 			>> The method m3(int) in the type Ex08_Method_use_01 is not applicable for the arguments ()에러 발생
//		m3(10, 20); 	>> 똑같은 에러 발생(매개변수의 갯수가 달라 에러 발생)
//		m3("홍길동");	>> 똑같은 에러 발생(매개변수의 자료형이 달라 에러 발생)
		
		m4(10, 20);
		m4(5, 11);
		m4(534, 22);
		
		m5("도윤", 2);
		
		
	}// main 메소드의 끝 : 프로그램의 종료
	
	
	
	//메소드의 순서는 상관 없으나 보통 main이 중요하기 때문에 먼저 씀.
	//메소드 헤더 = 메소드 서명(Signature)
	public static void m1() {
		
		System.out.println("메소드 m1을 호출했습니다.");
		
	}
	
	public static void m2() throws Exception { 
		
		//사용자의 이름을 입력받아 인사하는 코드 작성
		
		//ctrl + shift + o -> 클래스 한꺼번에 삽입(현재 페이지에 한해) / 안쓰는 클래스를 없애줌
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름을 입력하세요. : ");
		String name = reader.readLine();
		
		//1. reader.read()
		// - 문자 하나 입력
		// - 문자코드 반환
		// - \r\n 입력됨
		//2. reader.readline()
		// - 라인 입력
		// - 문자열 반환
		// - \r\n 제거
		
		System.out.printf("안녕~ %s\n", name);
				
	}
	
	public static void m3(int a) { // 여기서의 a >> 가인자
		System.out.println(a + a);
	}
	
	public static void m4(int a, int b) {
		System.out.printf("%d + %d = %d\n", a, b, a + b);
	}
	
	public static void m5(String name, int jumin) {
		String gender = jumin == 1 ? "남자" : "여자";
		System.out.printf("안녕하세요, %s님. 당신은 %s입니다.\n", name, gender);
	}
	
//	public static void m6() { 
//		return 10; >> Void methods cannot return a value오류 
//	}
	
//	public static int m7() {
//		>> This method must return a result of type int 오류
//	}
	
//	public static int m8() {
//		return true; >> Type mismatch: cannot convert from boolean to int 오류
//	}
	
	
}
