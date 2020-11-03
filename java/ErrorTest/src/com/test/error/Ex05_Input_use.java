package com.test.error;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex05_Input_use {

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader 										//BufferedReader 클래스 삽입 필요 
		= new BufferedReader(new InputStreamReader(System.in));		//InputStreamReader 클래스 삽입 필요
		
		System.out.print("첫번째 숫자: ");
		String num1 = reader.readLine();
		
		System.out.print("두번째 숫자: ");
		String num2 = reader.readLine();
		
		int realNum1 = Integer.parseInt(num1); // String 자료형을 int 자료형으로 형변환 할 수 없음 -> paeseInt 이용
		int realNum2 = Integer.parseInt(num2); // String 자료형을 int 자료형으로 형변환 할 수 없음 -> paeseInt 이용
		
		System.out.printf("%,d + %,d = %,d\n"
								, realNum1
								, realNum2
								, realNum1 + realNum2);
				
		
		
	}
	
}













