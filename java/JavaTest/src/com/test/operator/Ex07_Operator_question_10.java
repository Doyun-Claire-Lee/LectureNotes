package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_10 {
	
	public static void main(String[] args) throws Exception {
		
		//Q. 섭씨 온도를 화씨 온도로 변환
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("섭씨(℃) : ");
		String c = reader.readLine();
		
		int ic = Integer.parseInt(c);
		
		System.out.printf("섭씨 %s℃는 화씨 %.1f℉입니다.", c, ic * 1.8 + 32);
		
				
		
	}

}
