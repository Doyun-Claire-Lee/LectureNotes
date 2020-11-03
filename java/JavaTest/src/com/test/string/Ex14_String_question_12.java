package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_12 {
	
	public static void main(String[] args) throws Exception {
		
		//입력받은 문장에서 숫자들을 찾아 그 합을 구하시오.
		//저는 홍길동입니다. 제 나이는 20살입니다. 몸무게는 72kg입니다. 전화번호는 010-2848-9372입니다.
		
		sum();
		
	}

	private static void sum() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력 : ");
		String content = reader.readLine();
		int sum = 0;
		
		for (int i=0; i<content.length(); i++) {
			
			char c = content.charAt(i);
			
			if (c >= '0' && c <= '9') {
				sum += Integer.parseInt(c+"");
			}			
		}
		
		System.out.printf("문장에 존재하는 모든 숫자의 합은 %d입니다.", sum);
	}

}
