package com.test.datetime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex09_DateTime_use_01 {
	
	public static void main(String[] args) throws Exception {
		
//		m1(); //메소드명 작성하고 Ctrl + 1 하면 자동으로 생성됨.
//		m2();
//		m3();
//		m4();
		m5();
	}

	private static void m5() {
		
		//시각 - 시각 -> tick
		//시각 + 시간 -> add()
		//시각 - 시간 -> add()
		//시간 + 시간 -> +
		//시간 - 시간 -> -
		
		//시간의 최대 자릿수 : 시간(일)
		
		//2시간 30분을 표현하고 싶을 때 -> 각각 변수를 만들기
		int hour = 2;
		int min = 30;
		//40분을 더하고 싶을 때
		min += 40; // 2시간 70분이라는 답이 나옴.
		//자릿수 재정비
		hour += min / 60; 
		min = min % 60;
		
		System.out.printf("%d시간 %d분\n", hour, min);
		
		
		
	}

	private static void m4() {
		
		//시각 - 시각 = 시간
		
		//현재 시각의 tick을 얻는 방법(tick : 기준일부터 현재까지의 기간)
		// - 자바 기준으로 1970.01.01 00:00:00 ~ 현재까지의 시간을 밀리초 단위로 반환해줌
		
		Calendar now = Calendar.getInstance();
		System.out.println(now.getTimeInMillis()); // 1586847757987 -> long형 값으로 반환됨.
		
		Calendar birth = Calendar.getInstance();
		birth.set(1992, 11, 4); //생일로 변경처리
		
		long nowTick = now.getTimeInMillis();
		long birthTick = birth.getTimeInMillis();
		
		System.out.printf("내가 태어난지 %,d일이 흘렀습니다.\n" 
									,(nowTick - birthTick) / 1000 / 60 / 60 / 24);
		
		
		//올해 크리스마스가 며칠 남았는지??
		
		Calendar xMas = Calendar.getInstance();
		xMas.set(2020, 11, 25);
		
		long xMasTick = xMas.getTimeInMillis();
		
		System.out.printf("올해 크리스마스까지 %d일 남았습니다."
								,(xMasTick - nowTick) / 1000 / 60 / 60 / 24);
		
		
	}

	private static void m3() {
		
		// 시각 + 시간
		// 시각 - 시간 : 두번째 인자에 (-)값을 넣으면 됨.
		// - void add(int, int)
		
		Calendar c1 = Calendar.getInstance();
//		c1.add(Calendar.HOUR, 5); //5시간 더하기
//		c1.add(Calendar.HOUR, 2); //2시간 더 더하기
		
//		c1.add(Calendar.DATE, 100); // -> 오늘 날짜로부터 100일 후 날짜를 구해줌.
//		c1.add(Calendar.DATE, -100); // -> 오늘 날짜로부터 100일 전 날짜를 구해줌.
		
		
		System.out.printf("%tF %tT", c1, c1);
		
	}

	private static void m2() {
		
		//시각
		//1. 현재 시각 -> Calendar c1 = Calendar.getInstance();
		//2. 특정 시각
		// a. void set(int, int)
		// b. void set(int, int, int)
		// c. void set(int, int, int, int, int)
		// d. void set(int, int, int, int, int, int)
		
		//ex) 생일이 1995, 4, 30이라고 할 때
		Calendar birthday = Calendar.getInstance();
		
		//a. 1995-04-30 14:48:22
		birthday.set(Calendar.YEAR, 1995);
		birthday.set(Calendar.MONTH, 3);  //해당월 - 1 의 값을 삽입해야 함****
		birthday.set(Calendar.DATE, 30);
		
		System.out.printf("%tF %tT\n", birthday, birthday);
		
		//b. 1996-03-15 14:48:22
		birthday.set(1996, 2, 15);
		System.out.printf("%tF %tT\n", birthday, birthday);
		
		//c. 1997-06-05 02:30:22
		birthday.set(1997, 5, 5, 2, 30);
		System.out.printf("%tF %tT\n", birthday, birthday);
		
		//d. 1998-07-06 06:50:02
		birthday.set(1998, 6, 6, 6, 50, 2);
		System.out.printf("%tF %tT\n", birthday, birthday);
		
		
		
		
	}

	private static void m1() throws Exception {
	
		Calendar c1 = Calendar.getInstance();
		System.out.printf("%tT\n", c1);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름 : ");
		String name = reader.readLine();
		System.out.println(name);
		
		System.out.printf("%tT\n", c1);
		
		//현재시각을 가져오는 코드는 Calendar c1 = Calendar.getInstance(); 이기 때문에 print문에서 사용한 c1의 값은 단순히 해당 변수의 값을 가져오는 것임.
		
		
		
	}

}
