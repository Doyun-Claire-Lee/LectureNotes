package com.test.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_09 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("맑은 날 : ");
		String day1 = reader.readLine();
		System.out.print("흐린 날 : ");
		String day2 = reader.readLine();
		
		int iday1 = Integer.parseInt(day1);
		int iday2 = Integer.parseInt(day2);
		
		int apple = getApple(iday1, iday2);
		
		System.out.printf("사과가 총 %d개 열렸습니다.", apple);
		
	}
	
	public static int getApple(int day1, int day2) {
		
		int height = day1 * 5 + day2 * 2;
		return height > 100 ? (height - 100) / 10 : 0;
		
	}

}
