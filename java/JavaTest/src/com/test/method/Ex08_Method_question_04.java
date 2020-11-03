package com.test.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_04 {
	
	public static void main(String[] args) throws Exception {
		
		//이름을 전달받아 님자를 붙여 리턴
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름 : ");
		String input = reader.readLine();
		
		String name = getName(input);
		System.out.printf("고객 : %s\n", name);
	}
	
	public static String getName(String name) {
		
		return name + "님";
		
	}
	
}
