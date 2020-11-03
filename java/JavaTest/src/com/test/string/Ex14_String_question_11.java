package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_11 {
	
	public static void main(String[] args) throws Exception {
		
		//입력받은 금액을 한글로 출력
		//금액(원) : 53216
		//일금 오만삼천이백십육원
		//금액 최대 자릿수 : 5자리
		
		korMoney();
		
	}

	private static void korMoney() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("금액(원) : ");
		String input = reader.readLine();
		int count = 0;
		String money ="";
		
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			switch (c) {
				case '1' :
					c = '일';
					break;
				case '2' :
					c = '이';
					break;
				case '3' :
					c = '삼';
					break;
				case '4' :
					c = '사';
					break;
				case '5' :
					c = '오';
					break;
				case '6' :
					c = '육';
					break;
				case '7' :
					c = '칠';
					break;
				case '8' :
					c = '팔';
					break;
				case '9' :
					c = '구';
					break;
			}// switch
			
			money += c;
					
		}// for
					
		for (int j=money.length()-1; j>0; j--) {
			
			count++;
			
			String tmp1 = money.substring(0,j);
			String tmp2 = money.substring(j);
			String unit = "";
			
			switch (count) {
				case 1 : 
					unit = "십";
					break;
				case 2 : 
					unit = "백";
					break;
				case 3 : 
					unit = "천";
					break;
				case 4 : 
					unit = "만";
					break;
			}// switch						
		
			money = tmp1 + unit + tmp2;
		}
					
		System.out.printf("일금 %s원", money);
		
	}

}
