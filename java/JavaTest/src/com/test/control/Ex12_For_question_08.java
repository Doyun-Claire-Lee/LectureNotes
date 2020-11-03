package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_08 {
	
	public static void main(String[] args) throws Exception {
		
		//1 + 2 + 3 + 4 + 5 + ... + XX = 10XX
		//누적값이 1000을 넘어가는 순간 루프를 종료하시오.
		//루프를 종료할 누적값을 사용자가 입력할 수 있도록 하시오.
		
		sum();

	}

	private static void sum() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		System.out.print("종료값 : ");
		int exit = Integer.parseInt(reader.readLine());
		
		boolean loop = true;
		
		for (int i=1; loop; i++) {
			
			if (sum < exit) {
				sum += i;
				System.out.printf("%d + ", i);
			} else {
				loop = false;
			} //if
			
		} // for
		
		System.out.printf("\b\b= %d", sum);		
	
	}

}
