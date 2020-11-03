package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_07 {
	
	public static void main(String[] args) throws Exception {
		
		//파스칼 표기법으로 입력받은 영단어를 대문자 앞 띄어쓰기
		
		space();
	}

	private static void space() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("단어 : ");
		String input = reader.readLine();
		String output = "";
		
		for (int i=1; i<input.length(); i++) { 
			char c = input.charAt(i);
			
			if (c >= 'A' && c <= 'Z' ) {
				output = input.substring(0, i) + " " + input.substring(i);
			}
			
		}
		System.out.print("결과 : " + output);	
		
	}

}
