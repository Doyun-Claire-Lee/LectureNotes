package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_If_question_11 {
	
	public static void main(String[] args) throws Exception {
		
		//숫자를 입력하여 자료형 판단
		type();
		
		
	}

	public static void type() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 입력 : ");
		long l = Long.parseLong(reader.readLine());
		
		String result = "";
		
		
		if (l >= -9223372036854775808L && l <= 9223372036854775807L) {
			
			if (l >= -2147483648 && l <= 2147483647) {
				result = "int";
			
			} else {
				result = "long";
			}
			
		} else {
			result = "범위를 벗어났습니다.";
		}
		
		System.out.printf("%s", result);
		
	}
}
