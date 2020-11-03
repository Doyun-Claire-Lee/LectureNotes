package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_03 {
	
	public static void main(String[] args) throws Exception {
		
		//1부터 입력받은 숫자 까지의 누적합
		
		sum();
		
	}
	
	public static void sum() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 : ");
		int num = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		
		for (int i=1; i<=num; i++) {
			
			sum += i;
		}
		
		System.out.printf("1 ~ %,d = %,d", num, sum);
	}

}
