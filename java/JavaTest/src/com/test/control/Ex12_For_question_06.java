package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_06 {
	
	public static void main(String[] args) throws Exception {
		
		//1 - 2 + 3 - 4 + ... - 10 = -5 출력
		
		addSub();
		
	}
	
	public static void addSub() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자 : ");
		int startNum = Integer.parseInt(reader.readLine());
		System.out.print("종료 숫자 : ");
		int finishNum = Integer.parseInt(reader.readLine());
		
		int sum = 0;
//		int place = 1;
		
		for (int i=startNum, place=1; i<=finishNum; i++,place++) {
			
			if (place % 2 == 1) {
				System.out.printf("%d - ", i);
				sum += i;
			} else { 
				System.out.printf("%d + ", i);
				sum -= i;
			}
			
//			place++;
		}
		
		System.out.printf("\b\b = %d", sum);
		
		
	}

}
