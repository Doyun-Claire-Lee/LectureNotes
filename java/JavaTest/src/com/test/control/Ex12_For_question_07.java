package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_07 {
	
	public static void main(String[] args) throws Exception {
		
		//문장을 입력받아 출력하시오. 이 행동을 반복하시오.
		out();
		
	}

	private static void out() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("아래에 입력하세요.");

		boolean loop = true;
		String output = "";
		
		for (;loop;) {
			
			String input = reader.readLine();
			
			if (input.equals("")) {
				
				System.out.print(output);
				System.out.println("프로그램을 종료합니다.");
				break;
				
			} else {
				
				output += input + "\r\n";
			} //if
			
		} // for
		
	} // out()
	
}
