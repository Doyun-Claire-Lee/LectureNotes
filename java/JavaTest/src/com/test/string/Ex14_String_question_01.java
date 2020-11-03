package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_01 {
	
	public static void main(String[] args) throws Exception {
		
		//입력받은 문장을 거꾸로 출력
		
		backwards();
		
	}

	private static void backwards() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문장 입력 : ");
		String input = reader.readLine();
		String output = "";
		
		for (int i=input.length()-1; i>=0; i--) {
			
			output += input.charAt(i);
			
		}
		
		System.out.print("역순 결과 : " + output);
		
	}

}
