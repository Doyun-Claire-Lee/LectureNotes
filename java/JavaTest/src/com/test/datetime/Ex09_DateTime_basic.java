package com.test.datetime;

import java.util.Calendar;
import java.util.Date;

public class Ex09_DateTime_basic {
	
	public static void main(String[] args) {
		
		//날짜, 시간 데이터를 다루는 방법
		
		//1. Date 클래스				JDK 1.0
		//2. Calendar 클래스			JDK 1.1
		//3. java.time 패키지 + 클래스	JDK 1.8
						
		//시각과 시간
		//시각이란..?
		//시간이란..? 
		//n개월 n일 n시간 n분 n초 -> 1개월은 며칠인가?????? 정의할 수 없기 때문에 개월수를 시간데이터로 사용하지 않음.
		//시각 + 시각 = 연산 불가..?
		//시각 - 시각 = 시간
		//시간 + 시간 = 시간 *** int 변수로 해결함..
		//시간 - 시간 = 시간 *** int 변수로 해결
		//시각 + 시간 = 시각
		//시각 - 시간 = 시각
		
		//현재 시각 얻어오기
		Date d1 = new Date(); //컴퓨터 메인보드에 저장되어있는 시각 정보를 얻어오기 때문에 컴퓨터마다 다를 수도 있음..
		System.out.println(d1); //Tue Apr 14 12:36:13 KST 2020
		
		Calendar c1 = Calendar.getInstance();
		System.out.println(c1); //java.util.GregorianCalendar[time=1586835373955,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2020,MONTH=3,WEEK_OF_YEAR=16,WEEK_OF_MONTH=3,DAY_OF_MONTH=14,DAY_OF_YEAR=105,DAY_OF_WEEK=3,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=0,HOUR_OF_DAY=12,MINUTE=36,SECOND=13,MILLISECOND=955,ZONE_OFFSET=32400000,DST_OFFSET=0]
		
		//Calendar내의 원하는 요소 추출하기
		// - int get(int field) 메소드 이용
		System.out.println(c1.get(1)); //2020 -> 년도
		System.out.println(c1.get(2)); //3 -> 월
		System.out.println(c1.get(3)); //16 -> 년도
		System.out.println(c1.get(4)); //3 
		System.out.println(c1.get(5)); //14

		int year = 1;
		int month = 2;
		
		System.out.println(c1.get(year));
		System.out.println(c1.get(month));
		
		//캘린더 상수
		System.out.println(Calendar.YEAR); //1
		System.out.println(Calendar.MONTH); //2
		System.out.println();
		
		//자바(C언어 계열)는 순서를 셀 때 0부터 센다.
		// -> 서수를 0부터 시작 -> Zero-based Index 
		
		System.out.println(c1.get(Calendar.YEAR)); //2020 - 년도
		System.out.println(c1.get(Calendar.MONTH)); //3 - 월(0~11사이의 값 리턴) : 열거(배열)형이기 때문에 숫자임에도 불구하고 0부터 센다.
		System.out.println(c1.get(Calendar.DATE)); //14 - 일
		System.out.println(c1.get(Calendar.HOUR)); //2 - 시(12H)
		System.out.println(c1.get(Calendar.MINUTE)); //6 - 분
		System.out.println(c1.get(Calendar.SECOND)); //41 - 초
		System.out.println(c1.get(Calendar.MILLISECOND)); //839 - 밀리초
		System.out.println(c1.get(Calendar.HOUR_OF_DAY)); //14 - 시(24H) ->> 보통 많이 씀
		System.out.println(c1.get(Calendar.DAY_OF_WEEK)); //3 - 요일(일 : 1 ~ 토 : 7)
		System.out.println(c1.get(Calendar.AM_PM)); //AM : 0, PM : 1
		System.out.println();
		
		
		//오늘은 2020년 4월 14일입니다. 지금 시간은 오후 2시 21분입니다.
		System.out.printf("오늘은 %d년 %d월 %d일입니다. 지금 시간은 %s %d시 %d분입니다.\n"
											,c1.get(Calendar.YEAR)
											,c1.get(Calendar.MONTH) + 1
											,c1.get(Calendar.DATE)
											,c1.get(Calendar.AM_PM) == 0 ? "오전" : "오후"
											,c1.get(Calendar.HOUR)
											,c1.get(Calendar.MINUTE));
		System.out.println();
		
		//시각 출력하기 + printf() 메소드
		System.out.printf("%tF\n", c1);	//2020-04-14 -> %tF
		System.out.printf("%d-%02d-%02d\n"
								,c1.get(Calendar.YEAR)
								,c1.get(Calendar.MONTH) + 1
								,c1.get(Calendar.DATE));
		System.out.printf("%tT\n", c1); //14:27:16 -> %tT
		System.out.printf("%tA\n", c1); //화요일 -> 운영체제가 한국어로 되어있기 때문에 한국어로 나옴, 지역설정(로케일)에 따름.
		System.out.printf("%tR\n", c1); //14:28
		System.out.printf("%tr\n", c1); //02:28:03 오후
		
		
		
	}

}
