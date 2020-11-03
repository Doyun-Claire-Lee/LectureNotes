package com.test.control;

public class Ex12_For_assignment_09 {

	public static void main(String[] args) {
		
		sum();
		
	}

	private static void sum() {
		
		for (int i=10; i<=100; i+=10) {
			
			int sum = 0;
			
			for (int j=1; j<=i; j++) {
				
				sum += j;			
				
			}
			
			System.out.printf("1 ~ %3d : %4d\n", i, sum);
			
		}
		
		
	}
	
}
