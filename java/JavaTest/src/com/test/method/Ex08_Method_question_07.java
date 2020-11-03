package com.test.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_07 {
	
	public static void main(String[] args) throws Exception {
		
		//국어, 영어, 수학 점수 전달하여 합격 불합격 반환
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("국어 : ");
		String kor = reader.readLine();
		System.out.print("영어 : ");
		String eng = reader.readLine();
		System.out.print("수학 : ");
		String math = reader.readLine();
		
		int ikor = Integer.parseInt(kor);
		int ieng = Integer.parseInt(eng);		
		int imath = Integer.parseInt(math);
		
		String test = test(ikor, ieng, imath);
		
		System.out.printf("%s입니다.", test);
		
	}
	
	public static String test(int kor, int eng, int math) {
		
		int result = (kor + eng + math) / 3;
		
		return kor < 40 || eng < 40 || math < 40 ? "불합격" 
				:result >= 60 ? "합격" : "불합격";
		
	}

}
