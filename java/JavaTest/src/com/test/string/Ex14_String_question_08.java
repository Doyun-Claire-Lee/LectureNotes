package com.test.string;

public class Ex14_String_question_08 {
	
	public static void main(String[] args) {
		//특정 단어가 문장 내에 몇회 반복되는지 구하기
		
		words();
		
	}

	private static void words() {
	
		String content = "안녕~ 길동아~ 잘가~ 길동아~";
		String word = "길동";
		int num = 0;
		
		int index = -word.length();
		
		while (true) {
		
		index = content.indexOf(word, index + word.length());
		
		if (index > -1) {
			num++;
		} else {
			break;
		}
			
		}//while
		
		System.out.printf("'%s'을 총 %d회 발견했습니다.", word, num);
		
	}

}
