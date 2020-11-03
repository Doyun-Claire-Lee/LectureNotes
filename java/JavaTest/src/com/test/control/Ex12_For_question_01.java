package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_01 {
	
	public static void main(String[] args) throws Exception {
		
		//이름과 횟수를 입력받아 출력
		
		hello();
		
	}//main
	
	public static void hello() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이름 : ");
		String name = reader.readLine();
		System.out.print("횟수 : ");
		int times = Integer.parseInt(reader.readLine());
		
		for (int i=1; i<=times; i++) {
			System.out.printf("%s님 안녕하세요~\n", name);
		}
		
	}

}
