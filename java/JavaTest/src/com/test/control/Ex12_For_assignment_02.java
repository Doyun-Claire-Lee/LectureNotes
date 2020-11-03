package com.test.control;

public class Ex12_For_assignment_02 {
	
	public static void main(String[] args) {
		
		out();
		
	}

	private static void out() {
	
		for (int i=1; i<=5; i++) {
			
			for (int j=5; j>=i; j--) {
				
				System.out.printf("i : %d, j : %d\n", i, j);
			}
		}
		
		
		
	}

}
