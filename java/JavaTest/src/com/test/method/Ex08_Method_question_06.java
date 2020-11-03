package com.test.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_06 {
	
	public static void main(String[] args) throws Exception {
		
		//숫자를 전달하면 "짝수" 혹은 "홀수" 반환
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 : ");
		String num = reader.readLine();
		int inum = Integer.parseInt(num);
				
		String gnum = getNumber(inum);
		System.out.printf("입력하신 숫자 %d는(은) '%s'입니다.", inum, gnum);
		
	}
	
	public static String getNumber(int num) {
		
		return num % 2 == 1 ? "홀수" : "짝수";
		
	}

}
