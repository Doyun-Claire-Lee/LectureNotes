package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_09 {
	
	public static void main(String[] args) throws Exception {
		
		//Q. 영문자 1개의 대소문자 구분
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("영문자 입력 : ");
		int iletter = reader.read();
		
		char letter = (char)iletter;

		System.out.printf("입력한 문자 '%c'는 %s입니다.\n"
														, letter
														, letter >= 'a' && letter <= 'z' ? "소문자" : (letter >= 'A' && letter <= 'Z' ? "대문자" : "영문자X"));
		
				
		
	}

}
