package com.test.error2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_use_03 {
	
	public static void main(String[] args) throws Exception {
		
		m1();
		m2();
		
	}

	private static void m2() throws Exception {

		//별찍기(행 입력)
		//*
		//**
		//***
		//****
		//*****
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("행: ");
		
		int row = Integer.parseInt(reader.readLine()); //String -> int는 (int)로 형변환 불가
		
		for (int i=0; i<row; i++) { //i가 0부터 시작하였으므로 입력받은 행 수대로 출력하도록 조건문 변경
			for (int j=0; j<=i; j++) {
				System.out.print("*"); //'*'이 같은 라인에 출력되도록 print문 변경
			}
			System.out.println();
		}
		
	}

	private static void m1() {
		
		//구구단
		//2단 ~ 9단
				
		for (int j=2; j<10; j++) {
		
			for (int i=1; i<10; i++) { //i값이 1씩 증가해야 하므로 증감식 변경 
				System.out.printf("%d x %d = %2d\n", j, i, j * i);
			}
			
			System.out.println();
			
		}
		
	}

}









