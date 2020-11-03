package com.test.array;

public class Ex15_Array_question_05 {
	
	public static void main(String[] args) {
		
		//1~20 사이의 난수를 담고 있는 배열을 생성하고 최대값과 최소값을 출력하시오.
		
		maxMin();
		
	}

	private static void maxMin() {
		// TODO Auto-generated method stub
		
		int length = 20;
		int[] nums = new int[length];
		String s = "";
		
		int max = 0;
		int min = 20;
		
		for (int i=0; i<length; i++) {
			int n = (int)(Math.random()*20) +1;
			nums[i] = n;
			s += nums[i] + ", ";
		}
		
		for (int j=0;j<length;j++) {
			if (max < nums[j]) {
				max = nums[j];
			} 
			
			if (min > nums[j]) {
				min = nums[j];
			}
		}
		
		
		System.out.println("원본 : " + s);
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);

		
	}

}
