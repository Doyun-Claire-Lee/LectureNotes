package com.test.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex09_DateTime_question_06 {
	
	public static void main(String[] args) throws Exception {
		
		//여러 배달 음식을 같은 시각에 받으려면 몇시에 전화를 해야 하는지?
		//받기 원하는 시각을 입력받아 전화해야 하는 시각을 출력
		//날짜가 바뀌는 경우는 출력x
		//짜장면 : +10분
		//치킨 : +18분
		//피자 : +25분
		
		delivery();
		delivery_calendar();
		
	}
	
	public static void delivery() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("음식을 받기 원하는 시각");
		
		System.out.print("시 : ");
		int hour = Integer.parseInt(reader.readLine());
		
		System.out.print("분 : ");
		int min = Integer.parseInt(reader.readLine());
		
		//14:00 - 10 = 13:50
		//0:840 - 10 = 0:830
		
		int num = hour * 60 + min;
		
		num -= 10;
		hour = num / 60;
		min = num % 60;
		System.out.printf("짜장면 : %d시 %d분\n", hour, min);
		
		num -= 8;
		hour = num / 60;
		min = num % 60;
		System.out.printf("치킨 : %d시 %d분\n", hour, min);
		
		num -= 7;
		hour = num / 60;
		min = num % 60;
		System.out.printf("피자 : %d시 %d분\n", hour, min);
			
	}
	
	
	//캘린더 이용 메소드	
	public static void delivery_calendar() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("음식을 받기 원하는 시각");
		
		System.out.print("시 : ");
		String hour = reader.readLine();
		int ihour = Integer.parseInt(hour);
		
		System.out.print("분 : ");
		String min = reader.readLine();
		int imin = Integer.parseInt(min);
		
		
		Calendar time = Calendar.getInstance();
		time.set(Calendar.HOUR_OF_DAY, ihour);
		time.set(Calendar.MINUTE, imin);
		
//		System.out.printf("%tT\n", time);
		
		time.add(Calendar.MINUTE, -10);
		int dHour = time.get(Calendar.HOUR_OF_DAY);
		int dMin = time.get(Calendar.MINUTE);
		System.out.printf("짜장면 : %d시 %d분\n", dHour, dMin);
		
		time.add(Calendar.MINUTE, -8);
		dHour = time.get(Calendar.HOUR_OF_DAY);
		dMin = time.get(Calendar.MINUTE);
		System.out.printf("치킨 : %d시 %d분\n", dHour, dMin);
		
		time.add(Calendar.MINUTE, -7);
		dHour = time.get(Calendar.HOUR_OF_DAY);
		dMin = time.get(Calendar.MINUTE);
		System.out.printf("피자 : %d시 %d분\n", dHour, dMin);
		
		
	}

}
