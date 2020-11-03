package com.test.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex05_Input_use {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//요구사항) 태어난 년도를 입력받아 나이를 출력하시오.
		//입력) 태어난 년도(ex.1995) : 1995
		//출력) 당신은 26세 입니다.
		
		System.out.print("태어난 년도 : ");
		String year = reader.readLine();		//readLine메소드 -> String으로만 값을 받을 수 있음.
		
		int year2= Integer.parseInt(year);		//문자열로 받은 "year" 값의 쌍따옴표를 벗겨주는 역할(문자열을 int로 변경해주는 과정)
		
		System.out.printf("당신은 %d세 입니다.\n", 2020 - year2);
		
		//"문자열" -> int : Integer.parseInt("문자열")
		//"문자열" -> byte : Byte.parseByte("문자열")
		//"문자열" -> short : Short.parseShort("문자열")
		//"문자열" -> long : Long.parseLong("문자열")
		//"문자열" -> float : Float.parseFloat("문자열")
		//"문자열" -> double : Double.parsedouble("문자열")
		//"true" -> boolean : Boolean.parseBoolean("true")
		
		
				
		//요구사항) 숫자 2개를 입력받아 '+' 연산과정과 결과를 출력하시오.
		//입력) 첫번째 숫자 : 5
		//		두번째 숫자 : 3
		//출력) 5 + 3 = 8
		
		System.out.print("첫번째 숫자 : ");
		String num1 = reader.readLine();
		System.out.print("두번째 숫자 : ");
		String num2 = reader.readLine();
		
		int realNum1 = Integer.parseInt(num1);
		int realNum2 = Integer.parseInt(num2);
		
		System.out.printf("%,d + %,d = %,d\n"
								, realNum1
								, realNum2
								, realNum1 + realNum2);
				
		//클래스.메소드("")
		//Integer.parseInt("")
		//Byte.parseByte("")
		//여기서의 Integer, Byte는 클래스명
		//유틸 클래스, 래퍼(Wrapper)클래스 -> 해당 자료형의 여러 가지 기능을 제공함.
		
		//ex) 각 자료형의 최대값, 최소값을 알고 싶을 경우
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		
		//ex) 각 자료형의 비트 수(크기)를 알고 싶을 경우
		System.out.println(Long.SIZE);
		
			
		
	}

}
