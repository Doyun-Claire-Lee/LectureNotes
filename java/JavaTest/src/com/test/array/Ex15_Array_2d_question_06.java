package com.test.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Array_2d_question_06 {
	
	public static void main(String[] args) throws Exception {
		
		
		array();
		
	}

	private static void array() throws Exception {
		
		//입력받아 출력
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("행/열의 개수 : ");
		int row = Integer.parseInt(reader.readLine());
		int column = row;
	
		
		int[][] nums = new int[row][column];
		int num = 1;
		
		for (int i=0; i<nums.length-1; i++) {

			for (int j=0; j<nums[0].length-1; j++) {
				nums[i][j] = num;
				num++;	
			}
		}
				
		for (int i=0; i<nums.length; i++) {
			
			int rsum = 0;
			int csum = 0;
			
			for (int j=0; j<nums[0].length; j++) {
				rsum += nums[i][j];
				csum += nums[j][i];
			}
			
			nums[i][nums.length-1] = rsum;
			nums[nums.length-1][i] = csum;
			
		}
			
		// 출력
		for (int i=0; i<nums.length; i++) {
			for (int j=0; j<nums[0].length; j++) {
				System.out.printf("%4d", nums[i][j]);
			}
			System.out.println();
		}
		
	}

}
