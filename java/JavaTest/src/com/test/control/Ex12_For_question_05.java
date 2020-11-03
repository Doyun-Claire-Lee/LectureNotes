package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_05 {

	public static void main(String[] args) throws Exception {
		
		//1 + 2 + 3 + 4 + 5 + ...+ 10 = 55 출력
		
		sum();
		
	}
	
	public static void sum() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자 : ");
		int startNum = Integer.parseInt(reader.readLine());
		System.out.print("종료 숫자 : ");
		int finishNum = Integer.parseInt(reader.readLine());
		
		
		int sum = 0;
		
		for (int i=startNum; i<=finishNum; i++) {
			sum += i;
			System.out.printf("%d + ", i);
		}
		
		System.out.printf("\b\b= %d", sum);
	}
}
