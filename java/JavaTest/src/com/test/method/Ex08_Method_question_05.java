package com.test.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_05 {
	
	public static void main(String[] args) throws Exception {
		
		//숫자를 2개 입력받아 산술 결과를 반환하는 메소드 5개 선언 후 호출
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자 : ");
		String n1 = reader.readLine();
		System.out.print("두번째 숫자 : ");
		String n2 = reader.readLine();
		
		int in1 = Integer.parseInt(n1);
		int in2 = Integer.parseInt(n2);		
		
		int result1 = add(in1, in2);
		System.out.println(result1);
		
		int result2 = subtract(in1, in2);
		System.out.println(result2);
		
		int result3 = multiply(in1, in2);
		System.out.println(result3);
		
		double result4 = divide(in1, in2);
		System.out.println(result4);
		
		int result5 = mod(in1, in2);
		System.out.println(result5);
		
	}

	public static int add(int n1, int n2) {
		
		return n1 + n2;
		
	}
	
	public static int subtract(int n1, int n2) {
		
		return n1 - n2;
		
	}
	
	public static int multiply(int n1, int n2) {
		
		return n1 * n2;
		
	}
	
	public static double divide(int n1, int n2) {
		
		return (double)n1 / (double)n2;
		
	}
	
	public static int mod(int n1, int n2) {
		
		return n1 % n2;
		
	}

}
