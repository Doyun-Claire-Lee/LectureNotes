package com.test.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Array_question_06 {
	
	public static void main(String[] args) throws Exception {
		
		//1~20 사이의 난수를 20개 담고 있는 배열을 생성한 뒤 아래의 조건을 적용해 출력하시오.
		//배열을 탐색하여 범위에 만족하는 숫자만 출력한다.(범위 : 입력받기)
		
		maxMin();
		
	}

	private static void maxMin() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("최대 범위 : ");
		int max = Integer.parseInt(reader.readLine());
		System.out.print("최소 범위 : ");
		int min = Integer.parseInt(reader.readLine());
		
		int length = 20;
		int[] nums = new int[length];
		String s1 = "";
		String s2 = "";
		
		for(int i=0; i<length; i++) {
			int random = (int)(Math.random()*20) + 1;
			nums[i] = random;
			s1 += nums[i] + ", ";			
		}
		
		for(int j=0; j<length; j++) {
			
			if (nums[j] >= min && nums[j] <= max) {
				s2 += nums[j] + ", ";
			}
	
		}
		
		System.out.println("원본 : " + s1);
		System.out.println("결과 : " + s2);
		
		
		
		
	}

}
