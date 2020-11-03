package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_06 {

	public static void main(String[] args) throws Exception {
		
		
		//Q. 영문 소문자 1자를 대문자로 변환
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자 입력 : ");
		int letter = reader.read();
		int capital_letter = letter - 32;
		
		
		System.out.printf("소문자 '%c'의 대문자는 '%c' 입니다.", (char)letter, (char)capital_letter);
		
		
	}

	
}
