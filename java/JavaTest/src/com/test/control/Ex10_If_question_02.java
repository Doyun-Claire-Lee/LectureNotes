package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_If_question_02 {
	
	public static void main(String[] args) throws Exception {
		
		//국어 점수를 입력받아 성적을 출력
		
		kor();
		
	}
	
	public static void kor() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("점수 : ");
		int score = Integer.parseInt(reader.readLine());
		
		if (score >= 0 && score <= 100) {
			
			String result = "";
			
			if (score >= 90) {
				result = "A";
			} else if (score >= 80) {
				result = "B";
			} else if (score >= 70) {
				result = "C";
			} else if (score >= 60) {
				result = "D";
			} else {
				result = "F";
			}
			
			System.out.printf("입력한 %d점은 성적 %s입니다.", score, result);
		
		} else {
			System.out.println("유효한 점수가 아닙니다.");
		}
	}
}
