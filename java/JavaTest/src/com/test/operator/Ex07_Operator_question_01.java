package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_01 {
	
	public static void main(String[] args) throws Exception {
		
		//Q. 태어난 년도를 입력받아 나이를 출력
		
		//1. 입력을 위해 BufferedReader, InputStreamReader 삽입
		//2. throws Exception 처리
		//3. 태어난 년도 문구 출력
		//4. 입력받은 값을 int로 변경 후 나이 계산
		//5. 결과 출력
		
				
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("태어난 년도 : ");
		String year = reader.readLine();
		int age = 2020 - Integer.parseInt(year) + 1;
		System.out.printf("나이 : %d세", age);
			
		
		
		
	}

}
