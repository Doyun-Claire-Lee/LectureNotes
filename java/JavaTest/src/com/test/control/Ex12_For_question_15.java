package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_15 {
	
	public static void main(String[] args) throws Exception {
		
		//최대 9자리 정수를 입력받아 각자리의 홀수 숫자합과 짝수 숫자합을 구하시오.
		//9자리 숫자 입력 : 273645281
		//Math.pow() 메소드 사용(제곱값 구하는 메소드)
		//9자리가 넘어가면 동작 금지
		//9자리 이하는 동작 가능
		
		sum();
	}

	private static void sum() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("9자리 숫자 입력: ");
		int num = Integer.parseInt(reader.readLine());
		
		int oddSum = 0;
		int evenSum = 0;
		
		if (num < Math.pow(10,9)) {
			
			int n;
			
			for (int i=9; i>=0; i--) {
				
				n = num / (int)Math.pow(10,i);
				
				if (n % 2 == 0) {
					evenSum += n;
				} else {
					oddSum += n;
				}
				
				num -= n * (int)Math.pow(10,i);
				
			}
			
			System.out.printf("짝수의 합 : %d\n", evenSum);
			System.out.printf("홀수의 합 : %d\n", oddSum);
			
		} else {
			System.out.println("프로그램을 종료합니다.");
		}
		
	}
	
	

}
