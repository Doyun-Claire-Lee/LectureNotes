
package com.test.method;

public class Ex08_Method_question_12 {
	
	public static void main(String[] args) {
		
		int count = positive(10);
		System.out.printf("양수 : %d개\n", count);
		
		count = positive(10, 20);
		System.out.printf("양수 : %d개\n", count);
		
		count = positive(10, 20, -30);
		System.out.printf("양수 : %d개\n", count);
		
		count = positive(10, 20, -30, 40);
		System.out.printf("양수 : %d개\n", count);
		
		count = positive(10, 20, -30, 40, 50);
		System.out.printf("양수 : %d개\n", count);
		
	}

	public static int positive(int a) {
		
		int count = a > 0 ? 1 : 0;
		return count;
	}
	
	public static int positive(int a, int b) {
		
		int count = (a > 0 ? 1 : 0) + (b > 0 ? 1 : 0);
		return count;		
	}
	
	public static int positive(int a, int b, int c) {
		
		int count = (a > 0 ? 1 : 0) + (b > 0 ? 1 : 0) + (c > 0 ? 1 : 0);
		return count;		
	}
	
	public static int positive(int a, int b, int c, int d) {
		
		int count = (a > 0 ? 1 : 0) + (b > 0 ? 1 : 0) + (c > 0 ? 1 : 0) + (d > 0 ? 1 : 0);
		return count;		
	}
	
	public static int positive(int a, int b, int c, int d, int e) {
		
		int count = (a > 0 ? 1 : 0) + (b > 0 ? 1 : 0) + (c > 0 ? 1 : 0) + (d > 0 ? 1 : 0) + (e > 0 ? 1 : 0);
		return count;		
	}
	
	
}
