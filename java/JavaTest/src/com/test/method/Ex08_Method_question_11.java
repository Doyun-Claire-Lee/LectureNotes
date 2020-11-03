package com.test.method;

public class Ex08_Method_question_11 {
	
	public static void main(String[] args) {
		
		//이름을 인자로 받아 직급 순으로 출력하는 메소드 구현, 오버로딩 이용
		
		position("홍길동");
		position("홍길동", "유재석");
		position("홍길동", "유재석", "박명수");
		position("홍길동", "유재석", "박명수", "정형돈");
		
		
	}
	
	public static void position(String a) {
		System.out.printf("사원 : %s\n", a);
		System.out.println();
	}
	public static void position(String a, String b) {
		System.out.printf("사원 : %s\n", a);
		System.out.printf("대리 : %s\n", b);
		System.out.println();
		
	}
	public static void position(String a, String b, String c) {
		System.out.printf("사원 : %s\n", a);
		System.out.printf("대리 : %s\n", b);
		System.out.printf("과장 : %s\n", c);
		System.out.println();
	}
	public static void position(String a, String b, String c, String d) {
		System.out.printf("사원 : %s\n", a);
		System.out.printf("대리 : %s\n", b);
		System.out.printf("과장 : %s\n", c);
		System.out.printf("부장 : %s\n", d);
		System.out.println();
	}
	

}
