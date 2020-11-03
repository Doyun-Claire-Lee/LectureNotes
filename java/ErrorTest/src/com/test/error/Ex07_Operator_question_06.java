package com.test.error;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_06 {

	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자 입력 : ");
		int input = reader.read(); // 한 글자만 입력받을때는 read()이용하여 값은 항상 int로 받아야 함.
//		int c = Integer.parseInt(input);
		
		//계산한 문자코드값을 문자로 출력하기 위해 char형으로 형변환
		System.out.printf("소문자 '%c'의 대문자는 '%c'입니다.\n", (char)input, (char)(input - 32)); 
		
	}
	
}








