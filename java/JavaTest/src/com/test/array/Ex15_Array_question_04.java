package com.test.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Array_question_04 {
	
	public static void main(String[] args) throws Exception {
		
		//난수로 채워진 배열에서 첫번째 방부터 연속으로 2개씩 더한 결과를 출력
		//난수 범위 : 1 ~10이내
		
		lists();
		
	}

	private static void lists() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("배열의 길이(짝수) : ");
		int length = Integer.parseInt(reader.readLine());
		
		int[] nums = new int[length];
		int[] result = new int[length/2];
		
		String s1 = "";
		String s2 = "";
		
		for (int i=0; i<length; i++) {
			
			int n = (int)(Math.random() * 10) + 1;
			nums[i] = n;
			s1 += nums[i] + ", ";
			
		}
		
		for (int j=0; j<result.length; j++) {
			result[j] = nums[j*2] + nums[j*2+1];
			s2 += result[j] + ", ";
		}
		
		s1 = "[ " + s1 + "]";
		s1 = s1.replace(", ]", " ]");
		s2 = "[ " + s2 + "]";
		s2 = s2.replace(", ]", " ]");
		
		
		System.out.printf("nums = %s\n", s1);
		System.out.printf("result = %s\n", s2);
		
	}

}
