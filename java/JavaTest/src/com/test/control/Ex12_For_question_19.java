package com.test.control;

public class Ex12_For_question_19 {
	
	public static void main(String[] args) {
		
		//1부터 100사이의 완전수
		//6 = [1, 2, 3]
		//28 = [1, 2, 4, 7, 14]
		
		perfectNumber();
		
	}

	private static void perfectNumber() {
		
		for (int i=1; i<=100; i++) {
			
			int sum = 0;
			String factors = "";
			
			for (int j=1; j<i; j++) {
				
				if (i % j == 0) {
					
					sum += j;
					factors += j + ", ";
					
				}//if			
			}//for
			
			if (sum == i) {
				
				System.out.printf("%d = [%s\b\b]\n", i, factors);
				
			}//if
			
		}//for
		
	}

}
