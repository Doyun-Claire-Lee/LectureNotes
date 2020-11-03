package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_13 {

	public static void main(String[] args) throws Exception {
		//컴퓨터가 1~10 사이의 숫자 1개를 생각하면 사용자가 맞추는 프로그램을 구현하시오.
//		숫자 : 5 
//		맞췄습니다.
//
//		컴퓨터가 생각한 숫자는 5입니다.
//		정답을 맞추는데 시도한 횟수는 5회입니다.
//
//		프로그램을 종료합니다.
		
		guess();
		
	}

	private static void guess() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int random = (int)(Math.random() * 10) + 1;
//		System.out.println(random);
		
		boolean loop = true;
		int count = 0;
		
		for (;loop;) {
			
			System.out.print("숫자 : ");
			int num = Integer.parseInt(reader.readLine());
			
			if (num != random) {
				count++;
				System.out.println("틀렸습니다.\n");
				
			} else {
				count++;
				System.out.println("맞췄습니다.\n");
				loop = false;
			} // if
			
		} // for
		
		System.out.println();
		System.out.printf("컴퓨터가 생각한 숫자는 %d입니다.\n", random);
		System.out.printf("정답을 맞추는 데 시도한 횟수는 %d회 입니다.\n", count);
		System.out.println();
		System.out.println("프로그램을 종료합니다.");
	}
}
