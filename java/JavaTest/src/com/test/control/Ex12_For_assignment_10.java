package com.test.control;

public class Ex12_For_assignment_10 {
	
	public static void main(String[] args) {
		
		sum();
		
	}

	private static void sum() {
		
		for (int i=0; i<10; i++) {
			
			int sum = 0;
			
			for (int j=(i*10)+1; j<= (i*10)+10; j++) {
				
				sum += j;
								
			}
			
			System.out.printf("%2d ~ %3d : %3d\n", (i*10)+1, (i*10)+10, sum);
			
		}
		
		
		
		
	
		
	}

}
