package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_20 {
	
	public static void main(String[] args) throws Exception {
		
		fators();
		
	}

	private static void fators() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자 : ");
		int n1 = Integer.parseInt(reader.readLine());
		System.out.print("두번째 숫자 : ");
		int n2 = Integer.parseInt(reader.readLine());
		
		String s1 = "";
		String s2 = "";
		String s3 = "";
		
		
		for (int i=1; i<=n1; i++) {

			if (n1 % i == 0) {
				
				s1 += i + ", ";
			}		
		}
		
		System.out.printf("%d의 약수 : %s\b\b\n", n1, s1);
		
		for (int i=1; i<=n2; i++) {
			
			if (n2 % i == 0) {
				
			s2 += i + ", ";
			}		
			
		}
		System.out.printf("%d의 약수 : %s\b\b\n", n2, s2);	
		

		
	
		
	}

}
