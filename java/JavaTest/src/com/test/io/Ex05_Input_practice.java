package com.test.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex05_Input_practice {

	public static void main(String[] args) throws Exception {
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자을 입력하세요 : ");
		String num1 = reader.readLine();
		
		System.out.print("숫자를 입력하세요. : ");
		String num2 = reader.readLine();
		
		int inum1 = Integer.parseInt(num1);
		int inum2 = Integer.parseInt(num2);
		
		System.out.printf("%d * %d = %d\n", inum1, inum2, inum1 * inum2);
				
	
	}
	
	
	
}
