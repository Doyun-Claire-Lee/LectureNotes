package com.test.datetime;

import java.util.Calendar;

public class Ex09_DateTime_question_02 {
	
	public static void main(String[] args) {
		
		//오늘 태어난 아이의 백일과 첫돌이 언제인지 출력
		
		anniversary100();
		anniversary365();
		
	}
	public static void anniversary100() {
		
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, 100);
		System.out.printf("백일 : %tF\n", now);
	}
	
	public static void anniversary365() {
		
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, 365);
		System.out.printf("첫돌 : %tF\n", now);
	}
}
