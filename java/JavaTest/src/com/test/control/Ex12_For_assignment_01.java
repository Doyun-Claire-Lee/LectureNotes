package com.test.control;

public class Ex12_For_assignment_01 {
	
	public static void main(String[] args) {
		
		out();
		
	}

	private static void out() {
		
		for (int i=1; i<=5; i++) {
			
			for (int j=i; j<=5; j++) {
				
				System.out.printf("i : %d, j : %d\n", i, j);
				
			}
			
		}
		
	}

}
