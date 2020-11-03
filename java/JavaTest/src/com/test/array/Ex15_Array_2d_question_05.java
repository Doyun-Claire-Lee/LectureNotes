package com.test.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Array_2d_question_05 {
	
	public static void main(String[] args) throws Exception {
		
		array();
		
	}

	private static void array() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("행/열의 개수 : ");
		int row = Integer.parseInt(reader.readLine());
		int column = row;
		
		int[][] nums = new int[row][column];
		
		int num = 1;
		int n = 1; //거꾸로된 피라미드 만들 때 j변수의 마지막값을 조절하기 위한 변수
		
		for (int i=0; i<nums.length; i++) {
			
			if (i <= nums.length / 2 ) { 
				
				for (int j=nums.length/2-i; j<= i+nums.length/2 ; j++) {
					
					nums[i][j] = num;
					num++;
				}
				
			} else {
				for (int j=i-nums.length/2; j<nums.length-n; j++) {
					
					nums[i][j] = num;
					num++;
				}
				n++;
			}//if
			
		}//for
		
		for (int i=0; i<nums.length; i++) {
			for (int j=0; j<nums.length; j++) {
				System.out.printf("%4d", nums[i][j]);
			}
			System.out.println();
		}
		
		

		
	}

}
