package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_If_question_06 {
	
	public static void main(String[] args) throws Exception {
		
		//1~10 숫자 5개를 입력받아 짝수와 홀수의 개수를 출력
		
		count();

	}
	
	public static void count() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 입력 : ");
		int n1 = Integer.parseInt(reader.readLine());
		System.out.print("숫자 입력 : ");
		int n2 = Integer.parseInt(reader.readLine());
		System.out.print("숫자 입력 : ");
		int n3 = Integer.parseInt(reader.readLine());
		System.out.print("숫자 입력 : ");
		int n4 = Integer.parseInt(reader.readLine());
		System.out.print("숫자 입력 : ");
		int n5 = Integer.parseInt(reader.readLine());
		
		int odd = 0;
		int even = 0;
		
		if (n1 % 2 == 0) {
			even += 1;
		} else {
			odd += 1;
		}
		
		if (n2 % 2 == 0) {
			even += 1;
		} else {
			odd += 1;
		}
		
		if (n3 % 2 == 0) {
			even += 1;
		} else {
			odd += 1;
		}
		
		if (n4 % 2 == 0) {
			even += 1;
		} else {
			odd += 1;
		}
		
		if (n5 % 2 == 0) {
			even += 1;
		} else {
			odd += 1;
		}
		
		System.out.printf("짝수는 %d개, 홀수는 %d개 입력했습니다.\n" , even, odd);
		System.out.printf("홀수가 짝수보다 %d개 더 많습니다.\n", odd - even);
		
		
		
	}

}
