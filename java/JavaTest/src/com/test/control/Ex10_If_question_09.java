package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex10_If_question_09 {
	
	public static void main(String[] args) throws Exception {
		
		//날짜를 입력받아 조건에 맞게 결과 출력
		
		date();
		
	}
	
	public static void date() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("년 : ");
		int year = Integer.parseInt(reader.readLine());
		System.out.print("월 : ");
		int month = Integer.parseInt(reader.readLine()) - 1;
		System.out.print("일 : ");
		int day = Integer.parseInt(reader.readLine());
		
		Calendar date = Calendar.getInstance();
		date.set(year, month, day);
				
		int weekday = date.get(Calendar.DAY_OF_WEEK);
		
		if (weekday == 1 || weekday == 7) {
			
			System.out.println("입력하신 날짜는 '휴일'입니다.");
			System.out.println("결과가 없습니다.");
			
		} else {
			
			if (weekday == 2) {
				day += 5;
			} else if (weekday == 3) {
				day += 4;
			} else if (weekday == 4) {
				day += 3;
			} else if (weekday == 5) {
				day += 2;
			} else {
				day += 1;
			}
			
			date.set(year, month, day);
			
			
			System.out.println("입력하신 날짜는 '평일'입니다.\n해당 주의 토요일로 이동합니다.");
			System.out.printf("이동한 날짜는 '%tF'입니다.", date);

		}
		
		
		
		
	}

}
