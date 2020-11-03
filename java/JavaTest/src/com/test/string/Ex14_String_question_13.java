package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_13 {
	
	public static void main(String[] args) throws Exception {
		
		// 연산식을 입력받아 실제 연산
//		산술 연산자만 구현(+, -, *, /, %) 
//		연산식의 공백은 무관하게 
//		산술 연산자가 반드시 존재하는지 체크 
//		피연산자의 갯수가 2개인지 체크 
		
		cal();
		
	}

	private static void cal() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력 : ");
		String input = reader.readLine();
		input = input.replace(" ", "");
		int result = 0;
		
		
		for(int i=0; i<input.length(); i++) {
			
			char c = input.charAt(i);
		
			if (c < '0' || c > '9') {
				
				if (input.substring(i+1).length() > 0) {
				int num1 = Integer.parseInt(input.substring(0,i));
				int num2 = Integer.parseInt(input.substring(i+1));
				
					switch (c) {
						case '+' : 
							result = num1 + num2;
							System.out.printf("%d %c %d = %d", num1, c, num2, result);
							break;
						case '-' :
							result = num1 - num2;
							System.out.printf("%d %c %d = %d", num1, c, num2, result);
							break;
						case '*' : 
							result = num1 * num2;
							System.out.printf("%d %c %d = %d", num1, c, num2, result);
							break;
						case '/' : 
							result = num1 / num2;
							System.out.printf("%d %c %d = %d", num1, c, num2, result);
							break;
						case '%' :
							System.out.printf("%d %c %d = %d", num1, c, num2, result);
							result = num1 % num2;
							break;
						default :
							System.out.println("연산자가 잘못되었습니다.");
							break;
					} //swtich
				} else {
					System.out.println("피연산자가 부족합니다.");
				} //if
			} //for
			
			
			
		}
	}

}
