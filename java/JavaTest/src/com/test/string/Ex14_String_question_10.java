package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_10 {
	
	public static void main(String[] args) throws Exception {
		
		//금지어 마스킹 처리
		//금지어 : 바보, 멍청이
		
		masking();
	}

	private static void masking() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String word1 = "바보";
		String word2 = "멍청이";
		
		System.out.print("입력 : ");
		String content = reader.readLine();
		
		int num = 0;
		
		if (content.contains(word1)) {
			
			num++;
			
			if (content.contains(word2)) {
				
				num++;
				System.out.println(content.replace(word2, "***").replace(word1, "**"));
				
			} else {
			
			System.out.println(content.replace(word1, "**"));
			
			}
						
		} else if (content.contains(word2)) {
			
			num++;
			System.out.println(content.replace(word2, "***"));
			
		} 
		
		System.out.printf("금지어를 %d회 마스킹했습니다.", num);
		
	}

}
