package com.test.array;

public class Ex15_Array_question_01 {
	
	public static void main(String[] args) {
		
		//1차원 int 배열을 매개변수로 해서 내용을 문자열로 반환하는 dump 메소드를 구현하시오.
		
		int[] list = new int[4];
		list[0] = 10;
		list[1] = 20;
		list[2] = 30;
		list[3] = 40;
		String result = dump(list);
		System.out.printf("nums = %s\n", result);
		
	}
	
	public static String dump(int[] list) {
		
		String result = "";
		
		for (int i=0; i<list.length; i++) {
			result += list[i] + ", ";
		}
		
		result = "[ " + result + "]";
		result = result.replace(", ]", " ]");
		
		return result;
		
	}

}
