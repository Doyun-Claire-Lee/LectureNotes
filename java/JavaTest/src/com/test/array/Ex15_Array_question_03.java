package com.test.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Array_question_03 {
	
	public static void main(String[] args) throws Exception {
		
		//학생의 이름을 N개 입력받아 출력
		
		students();
		
		
		
	}

	private static void students() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("학생 수 : ");
		int num = Integer.parseInt(reader.readLine());
		
		String[] names = new String[num];
		
		for(int i=0; i<num; i++) {
			
			System.out.print("학생명 : ");
			names[i] = reader.readLine();		
			
		}
		
		System.out.printf("입력한 학생은 총 %d명입니다.\n", num);
		int n = 0;
		
		for(int j=num-1; j>=0; j--) {
			n++;
			System.out.printf("%d. %s\n", n, names[j]);
		}
		
	}

}
