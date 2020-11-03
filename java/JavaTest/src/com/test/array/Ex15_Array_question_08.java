package com.test.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex15_Array_question_08 {
	
	public static void main(String[] args) throws Exception {
		
		//배열에 요소를 삽입하시오.
		
		//input();
		logic();
		
		
	}

	private static void logic() {

		//배열 삽입(우측 시프트)
		
		String[] color = { "빨강", "노랑", "파랑", "검정", "하양", "초록", "보라" };
		
		System.out.println(Arrays.toString(color));
		
		String newColor = "주황";
		int insertIndex = 2;
		
		//기존의 요소들을 우측으로 옮긴다 -> 빈 방 발생 -> 새 요소 삽입
		
		for (int i=color.length-2; i>=insertIndex; i--) {
			color[i+1] = color[i];			
			System.out.println(Arrays.toString(color));
		}
		
		color[insertIndex] = newColor;
		System.out.println(Arrays.toString(color));
		
	}

	private static void input() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("삽입 위치 : ");
		int inputIndex = Integer.parseInt(reader.readLine());
		System.out.print("값 : ");
		int inputValue = Integer.parseInt(reader.readLine());
		
		int length = 10;	
		int[] list = new int[length];
		
		for (int i=0; i<length; i++) {
			list[i] = (int)(Math.random()*10);
		}
		
		System.out.println("원본 : " + Arrays.toString(list));
		
		for(int i=list.length-1; i>0; i--) {
			if (i == inputIndex) {
				list[i] = inputValue;
				break;
			} else { 
				list[i] = list[i-1];
			}
		}
		System.out.println("결과 : " + Arrays.toString(list));
		
	}
	

}
