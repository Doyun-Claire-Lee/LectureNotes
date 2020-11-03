package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_07 {
	
	public static void main(String[] args) throws Exception {
		
		//숫자 2개를 입력받아 둘 중 큰 숫자 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자 : ");
		String num1 = reader.readLine();
		System.out.print("두번째 숫자 : ");
		String num2 = reader.readLine();
		System.out.print("세번째 숫자 : ");
		String num3 = reader.readLine();
		
		int inum1 = Integer.parseInt(num1);
		int inum2 = Integer.parseInt(num2);
		int inum3 = Integer.parseInt(num3);
		
		
		System.out.printf("%d와(과) %d와(과) %d 중에 더 큰 숫자는 %d입니다."
															, inum1
															, inum2
															, inum3
															, inum1 > (inum2 > inum3 ? inum2 : inum3) ? inum1 : (inum2 > inum3 ? inum2 : inum3));
		
				
	}

}
