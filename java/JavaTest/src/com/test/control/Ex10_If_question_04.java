package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_If_question_04 {
	
	public static void main(String[] args) throws Exception {
		
		//문자 1개를 입력받아 단어 출력
		
		word();
				
	}
	
	public static void word() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자 : ");
		int c = reader.read();
		
		String result = "";
		
		if (c == 'f' || c == 'F') {
			result = "Father";
		} else if (c == 'm' || c == 'M') {
			result = "Mother";
		} else if (c == 's' || c == 'S') {
			result = "Sister";
		} else if (c == 'b' || c == 'B') {
			result = "Brother";
		}
		
		System.out.println(result);
	}

}
