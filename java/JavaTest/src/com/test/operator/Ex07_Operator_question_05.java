package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_05 {
	
	public static void main(String[] args) throws Exception {
		
		
		//Q. 한달 급여를 입력받아 세후 금액 출력(세율 : 3.3%)
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("한달 수입 금액(원) : ");
		String money = reader.readLine();
		
		int imoney = Integer.parseInt(money);
		int tax = (int)(imoney * 0.033);			
		
		
		System.out.printf("세후금액(원) : %,d원\n", imoney - tax);
		System.out.printf("세금(원) : %,d원", tax);
		
	
	}

}
