package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_question_04 {

	public static void main(String[] args) throws Exception {
		
		//파일명을 10개 입력받아 각 확장자별 갯수 구하기
		
		extension();
		
	}

	private static void extension() throws Exception {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int gif = 0, jpg = 0, png = 0, hwp = 0, doc = 0;
		
		for (int i=0; i<10; i++) {
			
			System.out.print("파일명 : ");
			String filename = reader.readLine();
			String ext = filename.toLowerCase().substring(filename.length()-3);
			
			switch (ext) {
				case "gif":
					gif++;
					break;
				case "jpg":
					jpg++;
					break;
				case "png":
					png++;
					break;
				case "hwp":
					hwp++;
					break;
				case "doc":
					doc++;
					break;
					
			} //switch
			
		} //for
		
		System.out.printf("gif : %d개\njpg : %d개\npng : %d개\nhwp : %d개\ndoc : %d개\n", gif, jpg, png, hwp, doc);
		
	}
	
	
}
