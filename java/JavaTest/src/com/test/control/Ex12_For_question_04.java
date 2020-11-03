package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_04 {
	
	public static void main(String[] args) throws Exception {
		
		//숫자 10개를 입력받아 짝수의 합과 홀수의 합 출력
		
		sum();
		
	}

	public static void sum() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력 개수 : ");
		int times = Integer.parseInt(reader.readLine());
		int evenSum = 0;
		int oddSum = 0;
		
		for (int i=1; i<=times; i++) {
			System.out.print("숫자 : ");
			int num = Integer.parseInt(reader.readLine());
			
			if (num % 2 == 1) {
				oddSum += num;
			} else {
				evenSum += num;
			}
		} 
		
		System.out.printf("짝수의 합 : %d\n", evenSum);
		System.out.printf("홀수의 합 : %d\n", oddSum);
		
	}
	
	
}
