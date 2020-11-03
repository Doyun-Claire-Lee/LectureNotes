package com.test.control;

public class Ex12_For_question_18 {
	
	public static void main(String[] args) {
		
		//2부터 100까지의 소수 구하기
		primeNumber();
		
	}

	private static void primeNumber() {
		
		//각 숫자를 2부터 n-1까지 나눠봄..
		//나머지가 0인게 나오면 소수가 아님.
		
		
		int count = 0;
		
		for (int i=2; i<101; i++) {
			
			count = 0;
			
			for (int j=2; j<i; j++) {
				
				if (i % j == 0) {
					count += 1;	
				} //if
			}//for	
						
			if (count == 0) {
				
				System.out.printf("%d, ", i);
				
			}//if

		}//for
		
		System.out.print("\b\b");

		
	}
	
	

}
