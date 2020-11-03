package com.test.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex15_Array_question_09 {
	
	public static void main(String[] args) throws Exception {
		
		//배열 내의 요소 삭제
		
		//removal();
		logic();
	}

	private static void logic() {

		String[] color = { "빨강", "노랑", "파랑", "검정", "하양", "초록", "보라" };
		System.out.println(Arrays.toString(color));
		
		int deletIndex = 2;
		
		for(int i=deletIndex; i<color.length-1; i++) {
			color[i] = color[i+1];
			System.out.println(Arrays.toString(color));
			
		}
		
		color[color.length-1] = "";
		System.out.println(Arrays.toString(color));
		
	}

	private static void removal() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("삭제 위치 : ");
		int removeIndex = Integer.parseInt(reader.readLine());
		
		int length = 5;
		int[] list = new int[length];
		
		for (int i=0; i<length; i++) {
			list[i] = (int)(Math.random()*10);
		}
		
		System.out.println("원본 : " + Arrays.toString(list));
		
		for (int i=0; i<length; i++) {
			
			if (i >= removeIndex) {
				if (i == list.length - 1) {
					list[i] = 0;
					
				} else {
				list[i] = list[i+1];
				}
			}
		} //for
		
		System.out.println("결과 : " + Arrays.toString(list));
	}

}
