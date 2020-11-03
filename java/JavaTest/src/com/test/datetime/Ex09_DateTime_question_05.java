package com.test.datetime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex09_DateTime_question_05 {
	
	public static void main(String[] args) throws Exception {
		
		//아빠와 딸의 생일을 입력받아 아빠가 딸보다 며칠을 더 살았는지 출력
		
		days();
		
	}
	
	public static void days() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("아빠 생일(년) : ");
		String fYear = reader.readLine();
		int ifYear = Integer.parseInt(fYear);
		System.out.print("아빠 생일(월) : ");
		String fMonth = reader.readLine();
		int ifMonth = Integer.parseInt(fMonth) - 1;
		System.out.print("아빠 생일(일) : ");
		String fDay = reader.readLine();
		int ifDay = Integer.parseInt(fDay);
	
		
		System.out.print("딸 생일(년) : ");
		String dYear = reader.readLine();
		int idYear = Integer.parseInt(dYear);
		System.out.print("딸 생일(월) : ");
		String dMonth = reader.readLine();
		int idMonth = Integer.parseInt(dMonth) - 1;
		System.out.print("딸 생일(일) : ");
		String dDay = reader.readLine();
		int idDay = Integer.parseInt(dDay);
		

				
		Calendar father = Calendar.getInstance();
		father.set(ifYear, ifMonth, ifDay);
		
		Calendar daughter = Calendar.getInstance();
		daughter.set(idYear, idMonth, idDay);
		
//		System.out.printf("%tF %tF", father, daughter);
		
		long fTick = father.getTimeInMillis();
		long dTick = daughter.getTimeInMillis();
		
		
		System.out.printf("아빠는 딸보다 총 %,d일을 더 살았습니다.", (dTick - fTick) / 1000 / 60 / 60 / 24 );
		
		
		
		
		
		
		
		
		
		
	}

}
