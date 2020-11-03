package com.test.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Array_question_02 {
	
	public static void main(String[] args) throws Exception {
		
		//숫자를 5개 입력받아 배열에 담은 뒤 역순으로 출력하시오.
		
		backwards();


	}

	private static void backwards() throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int[] list = new int[5];
		
		for (int i=0; i<list.length; i++) {
			
			System.out.print("숫자 : ");
			list[i] = Integer.parseInt(reader.readLine());
			
		}
		
		for (int j=list.length-1; j>=0; j--) {
			System.out.printf("list[%d] = %d\n", j, list[j] );
		}
		
		
		
	}
	
	

}
