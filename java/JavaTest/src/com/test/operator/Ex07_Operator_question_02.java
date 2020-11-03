package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_02 {
	
	public static void main(String[] args) throws Exception {
		
		
		//Q. 숫자 2개를 입력받아 연산 과정 출력
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자 : ");
		String num1 = reader.readLine();
				
		System.out.print("두번째 숫자 : ");
		String num2 = reader.readLine();
		
		int inum1 = Integer.parseInt(num1);
		int inum2 = Integer.parseInt(num2);
		
		System.out.printf("%,d + %,d = %,d\n", inum1, inum2, inum1 + inum2);
		System.out.printf("%,d - %,d = %,d\n", inum1, inum2, inum1 - inum2);
		System.out.printf("%,d * %,d = %,d\n", inum1, inum2, inum1 * inum2);
		System.out.printf("%,d / %,d = %,.1f\n", inum1, inum2, inum1 / (float)inum2);
		System.out.printf("%,d %% %,d = %,d\n", inum1, inum2, inum1 % inum2);
		

		
	}

}
