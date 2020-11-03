package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_If_question_05 {
	
	public static void main(String[] args) throws Exception {
		
		//영문자 1개를 입력받아 대소문자 변환하여 출력
		
		System.out.println((int)'a');
		System.out.println((int)'A');

		change();		
		
	}
	
	public static void change() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자 : ");
		int c = reader.read();
		
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
			
			int result = 0;
			
			if (c >= 'a' && c <= 'z') {
				result = c - 32;
			} else {
				result = c + 32;
			}

			System.out.printf("결과 : %c", (char)result);
			
			} else {
				System.out.println("유효한 문자가 아닙니다.");
			}
			
	}
}
