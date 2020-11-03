package com.test.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex15_Array_question_07 {
	
	public static void main(String[] args) throws Exception {
		
		//중복되지 않는 임의의 숫자 5개를 만드시오.
		//******자주 사용하는 로직
	
//		nums();
		logic();
		
	}

	private static void logic() {
		
		int[] nums = new int[5];
		
		//난수 생성 -> 중복 체크 -> 배열에 대입
		
		for (int i=0; i<nums.length; i++) {
			
			int n = (int)(Math.random()*10) + 1; //1~10
			
			if (!duplicate(i, n, nums)) {
				nums[i] = n;
			} else {
				i--; //중복이 되면 회전을 다시 되돌리기(else구문에 아무것도 쓰지 않으면 다음 루프로 넘어가게되며 배열에 아무 값도 저장되지 않음.)
			}
		} // for
		
		System.out.println(Arrays.toString(nums));
		
	}

	public static boolean duplicate(int i, int n, int[] nums) {
		
		boolean duplicate = false;
		
		for (int j=0; j<i; j++) {
			if (nums[j] == n) {
				duplicate = true; // 중복 여부를 바깥에 알려주는 변수 필요
				
				break;
			}
			
		}// for
		
		return duplicate;
		
	}

	private static void nums() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 범위 : ");
		int from = Integer.parseInt(reader.readLine());
		System.out.print("종료 범위 : ");
		int to = Integer.parseInt(reader.readLine());
		System.out.print("숫자의 수 : ");
		int length = Integer.parseInt(reader.readLine());
		
		
		int[] list = new int[length];
		
		for (int i=0; i<length; i++) {
			
			list[i] = (int)(Math.random()*(to - from + 1)) + from;
			
			for(int j=0; j<i; j++){

				if(list[i] == list[j]){

				i--;
			
				break;

				}
			} // for
			
		} // for
		System.out.println(Arrays.toString(list));
	}

}
