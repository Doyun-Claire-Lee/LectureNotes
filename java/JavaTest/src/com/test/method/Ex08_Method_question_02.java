package com.test.method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex08_Method_question_02 {
	
	public static void main(String[] args) throws Exception {
		
		//숫자 1개를 입력받아 4자리로 출력하는 메소드를 선언하고 호출하기
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자 입력 : ");
		String num = reader.readLine();
		int inum = Integer.parseInt(num);
		
		digit(inum);
		
	}

	public static void digit(int num) {
		
		
		System.out.printf("%d -> %s"
							, num
							, num >= 0 && num <= 9 ? "000" + num
							: num >= 10 && num <= 99 ? "00" + num
							: num >= 100 && num <= 999 ? "0" + num
							: num >= 1000 ? num : "양의 정수를 입력하세요.");

	}
}
