package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_04 {
	
	public static void main(String[] args) throws Exception {
		
		//Q. 26인치 휠을 가진 자전거가 달린 총 거리를 구하시오.
		
		//원주 = 반지름 * 3.14
		//반지름 = 13인치 = 0.3302m
		//원주 = 0.3302 * 3.14 = 1.036828‬m 
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("사용자가 페달을 밟은 횟수 : ");
		String pedal = reader.readLine();
		
		System.out.print("기어 : ");
		String gear = reader.readLine();
		
		int ipedal = Integer.parseInt(pedal);
		int igear = Integer.parseInt(gear);
		
				
		double distance = igear * ipedal * 1.036828 * 3.14;
			
		
		System.out.printf("사용자가 총 %,d회 페달을 밟아 자전거가 총 %,fm를 달렸습니다.", ipedal, distance);		
		
		
		
	}

}
