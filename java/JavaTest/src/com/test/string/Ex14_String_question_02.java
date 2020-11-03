package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_02 {
	
	public static void main(String[] args) throws Exception {
		
		//입력받은 이메일에서 아이디와 도메인 추출
		extract();
		
	}

	private static void extract() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이메일 : ");
		String email = reader.readLine();
		
		int at = email.indexOf("@");
		
		System.out.printf("아이디 : %s\n", email.substring(0, at));
		System.out.printf("도메인 : %s\n", email.substring(at + 1));
				
	}

}
