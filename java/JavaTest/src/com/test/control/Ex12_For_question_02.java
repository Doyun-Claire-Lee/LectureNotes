package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_02 {
	
	public static void main(String[] args) throws Exception {
		
		// 숫자를 입력받아 값을 증가시켜 출력
		number();
		
	}
	
	public static void number() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자 : ");
		int startNum = Integer.parseInt(reader.readLine());
		System.out.print("종료 숫자 : ");
		int finishNum = Integer.parseInt(reader.readLine());
		System.out.print("증가 숫자 : ");
		int addNum = Integer.parseInt(reader.readLine());
		
		for (int i=startNum; i<=finishNum; i+=addNum) {
			System.out.println(i);
		}
		
	}

}
