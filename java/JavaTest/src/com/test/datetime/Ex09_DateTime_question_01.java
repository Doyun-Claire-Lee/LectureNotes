package com.test.datetime;

import java.util.Calendar;

public class Ex09_DateTime_question_01 {

	public static void main(String[] args) {
		
		//현재 시각 출력
		
		nowTime();
		nowTime_AMPM();
		
		
	}
	
	public static void nowTime() {
		
		Calendar now = Calendar.getInstance();
		
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int min = now.get(Calendar.MINUTE);
		int sec = now.get(Calendar.SECOND);
		
		System.out.printf("현재 시간 : %d시 %d분 %d초\n", hour, min, sec);
					
	}
	
	public static void nowTime_AMPM() {
		
		Calendar now = Calendar.getInstance();
		
		int amPm = now.get(Calendar.AM_PM);
		int hour = now.get(Calendar.HOUR);
		int min = now.get(Calendar.MINUTE);
		int sec = now.get(Calendar.SECOND);
		
		System.out.printf("현재 시간 : %s %d시 %d분 %d초\n"
										, amPm == 0 ? "오전" : "오후"
										, hour
										, min
										, sec);
		
	}
}
