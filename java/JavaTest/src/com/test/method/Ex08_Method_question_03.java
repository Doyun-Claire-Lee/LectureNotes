package com.test.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_03 {
	
	public static void main(String[] args) throws Exception {
		
		//숫자 2개를 입력받아 산술 연산 메소드 5개 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자 : ");
		String n1 = reader.readLine();
		System.out.print("두번째 숫자 : ");
		String n2 = reader.readLine();
		
		int in1 = Integer.parseInt(n1);
		int in2 = Integer.parseInt(n2);
				
		add(in1, in2);
		subtract(in1, in2);
		multifly(in1, in2);
		divide(in1, in2);
		mod(in1, in2);
			
	}
	
	public static void add(int n1, int n2) {
		
		System.out.printf("%d + %d = %d\n", n1, n2, n1 + n2);
		
	}
	
	public static void subtract(int n1, int n2) {
		
		System.out.printf("%d - %d = %d\n", n1, n2, n1 - n2);
		
	}
	
	public static void multifly(int n1, int n2) {
		
		System.out.printf("%d * %d = %d\n", n1, n2, n1 * n2);
		
	}
	
	public static void divide(int n1, int n2) {
		
		System.out.printf("%d / %d = %d\n", n1, n2, n1 / n2);
		
	}
	
	public static void mod(int n1, int n2) {
		
		System.out.printf("%d %% %d = %d\n", n1, n2, n1 % n2);
		
	}
	
	
}
