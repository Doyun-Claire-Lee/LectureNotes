package com.test.control;

public class Ex12_For_question_16 {
	
	public static void main(String[] args) {
		
		//1 + 2 + 4 + 7 + 11 + 16 + ... + N = 469
		//N이 100이 넘기 전까지 출력하시오.
		
		sum();
		
	}

	private static void sum() {
		
		int num = 1;
		int sum = 0;
		boolean loop = true;
		
		for (int i=0; loop; i++) {
			
			num += i;
			
			if (num < 100) {
				
				sum += num;
				System.out.printf("%d + ", num);
								
			} else {
				
				loop = false;
				
			}//if
						
		} //for
		
		System.out.printf("\b\b= %d", sum);
	}

}
