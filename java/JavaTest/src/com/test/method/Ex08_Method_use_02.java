package com.test.method;

public class Ex08_Method_use_02 {
	
	public static void main(String[] args) {
		
		//요구사항) 2개의 int값을 매개변수로 받아 서로 교환하고 출력하는 메소드 작성
		//전제조건) 두 변수의 자료형이 똑같아야 함.
		
		int a = 10;
		int b = 20;
		
		swap(a, b);
		
		
		
		//재귀 메소드(Recursive method)
		// - 메소드가 구현부에서 자기 자신을 호출하는 형태
		// - 트리 구조의 자료형을 조작할 때 많이 사용(윈도우 탐색기 구조 - 파일 시스템 구조)
				
		//팩토리얼(Factorial)
		// - 4! = 4 * 3 * 2 * 1 = 24
		
		int n = 4;
		int result = factorial(n);
		System.out.printf("%d! = %d\n", n, result);
		
//		test(); >>끝나지 않는 재귀메소드
		
	}

	public static void swap(int a, int b) {
		
		System.out.printf("스왑 전 : a = %d, b = %d\n", a, b);
		
		//빈컵 생성
		int temp;
		
		temp = a;
		a = b;
		b = temp;
		
		System.out.printf("스왑 후 : a = %d, b = %d\n", a, b);
		
	}
	
	public static int factorial(int n) {
		
		int temp = (n == 1) ? 1 : n * factorial(n - 1);
		return temp;
		
	}
	
	public static void test() { // 끝나지 않는 재귀메소드
		System.out.println("테스트입니다.");
		test();
		System.out.println("테스트입니다.2"); // 위 세줄만 계속 돌기 때문에 접근할 수 없는 코드가 됨.
		
	}
}
