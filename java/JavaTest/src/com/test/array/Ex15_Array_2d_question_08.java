package com.test.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Array_2d_question_08 {
	
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
		
		for (int i=0; i<nums.length; i++) {
			for (int j=0, k=i; j<=i; j++, k--) {	
				nums[j][k] = num;
				num++;
			}	
		}
		
		for(int i=1; i<nums.length; i++) {
			for (int j=i, k=nums.length-1; j<nums.length; j++, k--) {
				nums[j][k] = num;
				num++;
			}
		}
		
		for (int i=0; i<nums.length; i++) {
			for (int j=0; j<nums[0].length; j++) {
				System.out.printf("%4d", nums[i][j]);
			}
			System.out.println();
		}
		
		
	}

}
