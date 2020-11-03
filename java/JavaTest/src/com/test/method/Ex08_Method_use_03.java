package com.test.method;

public class Ex08_Method_use_03 {
	
	public static void main(String[] args) {
		
		//메소드 오버로딩
		
		//요구사항) 숫자 두개를 전달하면 연산과정과 결과를 출력
		//1. int + int
		//2. double + double
		//3. String + String
		//4. byte + byte =>> 3번으로 퉁쳐짐...
		//5. String + int 등등... 9개 자료형으로 총 81가지 구현 가능함.
		
		add(10, 20);
		add((int)3.14, (int)5.28);	// int a = 3.14와 똑같은 얘기
		add(3.14, 5.28);
		add("안녕", "하세요");
		
		
		//요구사항) 선긋기 메소드 구현
		//메소드 다형성 -> 생김새는 같지만 여러 내용을 가진다.
		drawLine();
		drawLine('-');
		drawLine('+');
		drawLine('#', 50);
		
		
		
	}
	
	public static void add(int a, int b) {
		System.out.printf("%d + %d = %d\n", a, b, a + b);
	}
	public static void add(double a, double b) {
		System.out.printf("%.2f + %.2f = %.2f\n", a, b, a + b);
	}
	public static void add(String a, String b) {
		System.out.printf("%s + %s = %s\n", a, b, a + b);
	}
	
	public static void drawLine() {
		System.out.println("==============================================================");	
	}
	
	public static void drawLine(char c) { //원하는 문자로 30개 출력
		for (int i=0; i<30; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	public static void drawLine(char c, int n) { //원하는 문자로 n개 출력
		for (int i=0; i<n; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	
}
