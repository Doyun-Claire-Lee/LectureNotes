package com.test.control;

import java.util.Calendar;

public class Ex12_For_question_10 {
	
	public static void main(String[] args) {
		
		//서기 1년 1월 1일부터 오늘까지 며칠째인지 합을 구하시오.
		//Calendar, Date 사용 금지
		//추가)오늘이 무슨 요일인가?..
		//2020-04-17 금요일		
		
		// %7 했을때 5가 나와야 함..
		// 답 737532
		
		//4년마다 윤년 => +1일
		//100년마다 윤년 무시 
		//400년마다 윤년 -> +1일
		
		days();
		
	}

	private static void days() {
		
		int year = 2020;
		int month = 4;
		int day = 17;
		
		int date = 0;
		
			
		for (int i=1; i<year; i++) {
			
			if (i % 4 == 0) {
				
				if (i % 100 == 0) {
					
					if (i % 400 == 0) {
						date += 366;
					} else {						
						date += 365;
					}
					
				} else {					
					date += 366;				
				}
				
			} else {				
				date += 365;
			} // if		
				
		} // for
		
		System.out.println(date);
		
		switch (month) { //2월 빼고
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				date += 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				date += 30;
				break;
				
			case 2:
				if (year % 4 == 0) {
					if (year % 100 == 0) {				
						if (year % 400 == 0) {
							date += 29;
						} else {						
							date += 28;
						}
					} else {					
						date += 29;				
					}
				} else {				
					date += 28;
				} // if	
				break;				
		}//switch
		
		date = date + day;
		
		System.out.printf("%d년 %d월 %d일은 %,d일째 되는 날입니다.\n", year, month, day, date);
		System.out.println(date % 7);
		
	}
	

	
}
