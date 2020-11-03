package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_assignment_07 {
	
	public static void main(String[] args) throws Exception {
		
		out();
		
		
	}

	private static void out() throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행 : ");
		int row = Integer.parseInt(reader.readLine());
		
		for(int i=1; i<=row; i++) {
			
			for (int j=row; j>i; j--) {
				System.out.print(" ");
			}
			
			for (int k=1; k<=i; k++) {
				System.out.printf("%c", (char)(k+96));
			}
			
			for (int l=1; l<=i; l++) {
				System.out.printf("%c", (char)(97+i-l));
			}
			
			System.out.println();
		}
		
	}

}
