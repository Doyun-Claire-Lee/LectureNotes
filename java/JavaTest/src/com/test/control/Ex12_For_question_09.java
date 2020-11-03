package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_09 {
	
	public static void main(String[] args) throws Exception {
		
		//숫자를 N개 입력받아 아래와 같이 출력하시오.
		//4 - 7 + .. - 15 + 12 = 1XX
		//누적값이 100을 넘어가는 순간 루프를 종료하시오.
		//짝수는 더하고 홀수는 빼시오.
		//루프를 종료할 누적값을 사용자가 입력할 수 있도록 하시오.
		
		addSub();
		
	}

	private static void addSub() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		boolean loop = true;
		int sum = 0;
		String out = "";
		
		System.out.print("종료값 : ");
		int quit = Integer.parseInt(reader.readLine());
		
		System.out.print("숫자 : ");
		sum = Integer.parseInt(reader.readLine());
		out += sum;
		
		for (;loop;) {
				
			if (sum >= quit) {
				
				System.out.printf("%s = %d", out, sum);
				loop = false;
				
			} else {
				
				System.out.print("숫자 : ");
				int num = Integer.parseInt(reader.readLine());
				
				if (num % 2 == 0) {
					out += " + " + num;
					sum += num;
				} else {
					out += " - " + num;
					sum -= num;	
				}// if
				
			} //if
			
		} //for
		
	}

}
