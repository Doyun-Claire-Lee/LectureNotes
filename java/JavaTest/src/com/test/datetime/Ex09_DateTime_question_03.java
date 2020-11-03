package com.test.datetime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex09_DateTime_question_03 {
	
	public static void main(String[] args) throws Exception {
		
		//생년을 입력받아 한국식 현재나이 구하기 
		
		age();
		
	}
	
	public static void age() throws Exception {
		
		Calendar now = Calendar.getInstance();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("태어난 년도 : ");
		String year = reader.readLine();
		
		int year_birth = Integer.parseInt(year);
		int year_now = now.get(Calendar.YEAR);

		int age = year_now - year_birth + 1;
		
		System.out.printf("나이 : %d세", age);
		
	}

}
