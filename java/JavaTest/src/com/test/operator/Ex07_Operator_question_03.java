package com.test.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex07_Operator_question_03 {
	
	public static void main(String[] args) throws Exception {
		
		//Q. 사각형의 너비와 높이를 입력받아 넓이와 둘레를 출력
		
		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		 
		 System.out.print("너비(cm) : ");
		 String width = reader.readLine();
		 System.out.print("높이(cm) : ");
		 String height = reader.readLine();
		 
		 int iwidth = Integer.parseInt(width);
		 int iheight = Integer.parseInt(height);
		 
		 System.out.printf("사각형의 넓이는 %d㎠입니다.\n", iwidth * iheight);
		 System.out.printf("사각형의 둘레는 %dcm입니다.\n", (iwidth + iheight) * 2);
		 
		 
		
		
		
		
	}

}
