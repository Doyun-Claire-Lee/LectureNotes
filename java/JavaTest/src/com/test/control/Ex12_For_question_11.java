package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_question_11 {
	
	public static void main(String[] args) throws Exception {
		
		//사용자가 입력한 범위의 숫자까지 369 게임의 결과를 출력하시오.
		//1   2   짝   4   5   짝 .. 100
		
		game();
		
	}

	private static void game() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("최대 숫자 : ");
		int max = Integer.parseInt(reader.readLine());
		
		for (int i=1; i<=max; i++) {
			
			int one = i % 10;
			int ten = i / 10;
			
			
			if (one == 3 || one == 6 || one == 9) { 
				
				if (ten == 3 || ten == 6 || ten == 9) {
					System.out.print("짝짝  ");
				} else {
					System.out.print("짝  ");
				}
				
			} else if (ten == 3 || ten == 6 || ten == 9){ 
				System.out.print("짝 ");
			} else {
				System.out.print(i + "  ");
			}
			
		}
			
		
	}

	
}
