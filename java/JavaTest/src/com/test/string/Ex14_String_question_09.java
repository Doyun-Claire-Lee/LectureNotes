package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_09 {
	
	public static void main(String[] args) throws Exception {
		
		//주민등록번호 유효성 검사
		
		validityCheck();
		
	}

	private static void validityCheck() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("주민등록번호 : ");
		String idNumber = reader.readLine();
		int mtp = 2;
		int sum = 0;
		
		idNumber = idNumber.replace("-", "");
		
		for (int i=0; i<12; i++) {
			
			int num = Integer.parseInt(idNumber.charAt(i)+"");
			
			if (mtp < 10) {
			num = num * mtp;
			sum += num;
			} else {
			num = num * (mtp-8);
			sum += num;
			}
			mtp++;

		} //for
		
		int vCheck = 11 - (sum % 11);
		if (idNumber.endsWith(vCheck+"")) {
			System.out.println("올바른 주민등록번호입니다.");
			
		} else {
			System.out.println("올바르지 않은 주민등록번호입니다.");
		}
	}

}
