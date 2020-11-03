package com.test.error;

public class Ex06_Casting_use {
	
	public static void main(String[] args) {
		
		byte a = 10;
		byte b = 20;
		byte c = 0;
		
		c = (byte)(a + b);  // byte + byte = int , int이하 자료형의 연산의 결과는 무조건 int로 반환하게 되어있다.
		
		System.out.printf("%d + %d = %d\n", a, b, c);
		
		
		int n1 = 1234567;
		int n2 = 654321;
		
		
		System.out.printf("%,d * %,d = %,d\n", n1, n2, (long)n1 * n2); // n1 * n2의 값이 int 자료형의 값 범위를 넘어가기 때문에 형변환
		
		
	}

}












