package com.test.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex09_DateTime_question_04 {
	
	public static void main(String[] args) throws Exception {
		
		//남녀 커플의 이름과 만난날을 입력받아 기념일 출력
				
		anniversary();
	}
	
	public static void anniversary() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("남자 이름 : ");
		String maleName = reader.readLine();
		System.out.print("여자 이름 : ");
		String femaleName = reader.readLine();
		System.out.print("만난날(년) : ");
		String year = reader.readLine();
		int iyear = Integer.parseInt(year);
		System.out.print("만난날(월) : ");
		String month = reader.readLine();
		int imonth = Integer.parseInt(month) - 1;
		System.out.print("만난날(일) : ");
		String day = reader.readLine();
		int iday = Integer.parseInt(day);
		
		Calendar now = Calendar.getInstance();
		Calendar date = Calendar.getInstance();
		date.set(iyear, imonth, iday);
				
		
		System.out.printf("'%s'과(와) '%s'의 기념일\n", maleName, femaleName);
		
		date.add(Calendar.DATE, 100);
		System.out.printf("100일 : %tF\n", date);
		
		date.add(Calendar.DATE, 100);
		System.out.printf("200일 : %tF\n", date);
		
		date.add(Calendar.DATE, 100);
		System.out.printf("300일 : %tF\n", date);
		
		date.add(Calendar.DATE, 200);
		System.out.printf("500일 : %tF\n", date);
		
		date.add(Calendar.DATE, 500);
		System.out.printf("1000일 : %tF\n", date);

		
		
		
		
	}
	

}
