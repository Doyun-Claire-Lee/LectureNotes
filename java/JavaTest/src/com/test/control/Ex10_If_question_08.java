package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_If_question_08 {
	
	public static void main(String[] args) throws Exception {
		
		//년도를 입력받아 평년인지 윤년인지 출력
		
		year();
				
	}
	
	public static void year() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("년도 입력 : ");
		int year = Integer.parseInt(reader.readLine());
		
		String result = "";
		
		if (year % 4 == 0) {
			
			if (year % 100 == 0) {
				
				if (year % 400 ==0) {
					result = "윤년";
				} else {
					result = "평년";
				}
				
			} else {
				result = "윤년";
			}		
			
		} else { 
			result = "평년";
		}
		
		System.out.printf("%d년은 '%s'입니다.", year, result);
	}

}
