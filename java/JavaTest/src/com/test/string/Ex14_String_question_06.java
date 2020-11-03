package com.test.string;

public class Ex14_String_question_06 {
	
	public static void main(String[] args) {
		
		//문자 사이의 공백만 제거하여 출력
		//원본 문자열 : "    하나    둘    셋    "
		//결과 문자열 : "    하나둘셋    "
		
		spaceRemoval();
	}

	private static void spaceRemoval() {
		
		String txt = "    하나    둘    셋    ";
		String front = "";
		String back = "";
		
		boolean loop = true;

		
		for (int i=0; loop; i++) {
			
			if (txt.charAt(i) != ' ') {

				loop = false;
			} else {
			
				front += " ";
			}
			
		} //for
		
		loop = true;
		
		for (int j=txt.length()-1; loop; j--) {
			
			if (txt.charAt(j) != ' ') {

				loop = false;
				
			} else {
			
				back += " ";
			}
			
		} //for
		
		System.out.printf("원본 문자열 : \"%s\"\n", txt);
		System.out.printf("결과 문자열 : \"%s\"\n", front + txt.replace(" ", "") + back);
		
		
	}

}
