package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_12 {
	
	public static void main(String[] args) throws Exception {
		//숫자를 10개 입력받아 한글로 변환 후 출력하시오.
//		숫자 : 5 
//		숫자 : 7 
//		숫자 : 4 
//		숫자 : 3 
//		숫자 : 5 
//		숫자 : 7 
//		숫자 : 6 
//		숫자 : 2 
//		숫자 : 1 
//		숫자 : 3
		
		//결과 : 오칠사삼오칠육이일삼
		//2자리 이상 숫자를 입력하면 결과없이 프로그램을 중지시키시오.
		
		numKor();
	}

	private static void numKor() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String out = "";
		
		for (int i=0; i<10; i++) {
			
			System.out.print("숫자 : ");
			int num = Integer.parseInt(reader.readLine());
			
			if (num >=10) {
				
				break;
				
			} else {
				
				switch (num) {
					case 1:
						out += "일";
						break;
					case 2:
						out += "이";
						break;
					case 3:
						out += "삼";
						break;
					case 4:
						out += "사";
						break;
					case 5:
						out += "오";
						break;
					case 6:
						out += "육";
						break;
					case 7:
						out += "칠";
						break;
					case 8:
						out += "팔";
						break;
					case 9:
						out += "구";
						break;
				} //switch
			} //if
			
		} //for
		System.out.printf("결과 : %s", out);
		
	}

}
