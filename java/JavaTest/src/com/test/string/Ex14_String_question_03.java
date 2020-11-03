package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_03 {
	
	public static void main(String[] args) throws Exception {
		
		//숫자를 입력받아 각 자릿수의 합 구하기
		
		sum();
		
	}

	private static void sum() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 : ");
		String input = reader.readLine();
		String output = "";
		int sum = 0;
		
		for (int i=0; i<input.length(); i++) {
			
			int num = Integer.parseInt(input.charAt(i)+"");
			output += num + " + ";
			sum += num;
			
		}
		
		output += " = " + sum;
		System.out.printf("결과 : %s", output.replace("+  =", "="));
		
		
	}

}
