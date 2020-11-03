package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_05 {
	
	public static void main(String[] args) throws Exception {
		
		//숫자를 입력받아 3자리마다 ','삽입하기
		comma();
	}

	private static void comma() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 : ");
		String num = reader.readLine();

        for (int i=num.length()-3; i>0; i-=3) {

            String tmp1 = num.substring(0, i);
            String tmp2 = num.substring(i);
            num = tmp1 + "," + tmp2;

        }
		
		System.out.printf("결과 : %s", num);
		
		
	}

}
