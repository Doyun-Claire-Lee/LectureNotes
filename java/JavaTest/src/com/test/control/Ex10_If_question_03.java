package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_If_question_03 {

	public static void main(String[] args) throws Exception {
		
		//정수 두개와 산술연산자를 입력받아 연산 과정과 결과 출력
		calculate();
		
	}
	
	public static void calculate() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자 : ");
		int n1 = Integer.parseInt(reader.readLine());
		System.out.print("두번째 숫자 : ");
		int n2 = Integer.parseInt(reader.readLine());
		System.out.print("연산자 : ");
		String operator = reader.readLine();
		
		
		
		if (operator.equals("/")) {
			
			System.out.printf("%d %s %d = %.1f", n1, operator, n2, (double)n1 / n2);
			
		} else {
			
			int result = 0;
			
			if (operator.equals("+")) {
				result = n1 + n2;
			} else if (operator.equals("-")) {
				result = n1 - n2;
			} else if (operator.equals("*")) {
				result = n1 * n2;
			} else if (operator.equals("%")) {
				result = n1 % n2;
			}
			System.out.printf("%d %s %d = %d", n1, operator, n2, result);
		}
	}
}
