package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_If_question_01 {
	
	public static void main(String[] args) throws Exception {
		
		//숫자 두개를 입력받아 큰수와 작은수 비교
		
		comparison();
				
	}
	
	public static void comparison() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자 : ");
		int n1 = Integer.parseInt(reader.readLine());
		System.out.print("두번째 숫자 : ");
		int n2 = Integer.parseInt(reader.readLine());
		
		int big = 0;
		int small = 0;
		
		if (n1 > n2) { 
			big = n1;
			small = n2;
		} else {
			big = n2;
			small = n1;
		}
		
		System.out.printf("큰수는 %d이고, 작은 수는 %d입니다.\n", big, small);
		System.out.printf("입력한 두 숫자는 %d가 차이납니다.\n", big - small);
		
	}

}
