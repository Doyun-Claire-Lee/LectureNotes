package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_08 {
	
	public static void main(String[] args) throws Exception {
		
		//Q. 2020년 4월 1일은 수요일 -> 4월의 날짜 하나를 입력받아 요일을 구하시오.
		
		// 날짜 % 7 = 1 -> 수요일
		// 날짜 % 7 = 2 -> 목요일
		// 날짜 % 7 = 3 -> 금요일
		// 날짜 % 7 = 4 -> 토요일
		// 날짜 % 7 = 5 -> 일요일
		// 날짜 % 7 = 6 -> 월요일
		// 날짜 % 7 = 0 -> 화요일
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("날짜 입력 : ");
		String day = reader.readLine();
		
		int iday = Integer.parseInt(day);
		
		String wday = iday % 7 == 1 ? "수요일" 
						: (iday % 7 == 2 ? "목요일" 
						: (iday % 7 == 3 ? "금요일" 
						: (iday % 7 == 4 ? "토요일" 
						: (iday % 7 == 5 ? "일요일"
						: (iday % 7 == 6 ? "월요일"
						: (iday % 7 == 0 ? "화요일" : "아무 요일도 아님" ))))));
		
		System.out.printf("입력하신 2020년 4월 %s일은 '%s'입니다.", day, wday);
		
		
		
	}

}
