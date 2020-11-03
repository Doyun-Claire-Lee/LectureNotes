package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_If_question_07 {

	public static void main(String[] args) throws Exception {
		
		//시각을 입력받아 주차요금 출력
		parkingFee();
		
	}
	
	public static void parkingFee() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("[들어온 시간]");
		System.out.print("시 : ");
		int inHour = Integer.parseInt(reader.readLine());
		System.out.print("분 : ");
		int inMinute = Integer.parseInt(reader.readLine());
		
		System.out.println("[나간 시간]");
		System.out.print("시 : ");
		int outHour = Integer.parseInt(reader.readLine());
		System.out.print("분 : ");
		int outMinute = Integer.parseInt(reader.readLine());
		
		int time = (outHour * 60 + outMinute) - (inHour * 60 + inMinute);
		int result = 0;
		
		if (time > 30) {
			result = ((time - 30) / 10) * 2000;		
		} else {
			result = 0;
		}
		
		System.out.printf("주차 요금은 %,d원 입니다.", result);
	}
}
