package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_assignment_04 {
	
	public static void main(String[] args) throws Exception {
		
		stars();
		
	}

	private static void stars() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행 : ");
		int row = Integer.parseInt(reader.readLine());

		for (int i=1; i<=row; i++) {
			
			for(int j=row-i; j>0; j--) {
				System.out.print(" ");
			}
			
			for (int k=1; k<=i; k++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
	}

}
