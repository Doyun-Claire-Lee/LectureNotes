package com.test.io;

import java.util.Arrays;
import java.util.Scanner;

public class Ex35_Scanner_basic {
	
	public static void main(String[] args) {
		
		//콘솔 입력
		//1. System.in.read()
		//2. ButteredReader
		//3. Scanner
		
		Scanner scan = new Scanner(System.in);
		
		//사용자가 입력한 데이터를 반환
		// - 실체 : 입력 버퍼의 읽어올 수 있는 다음 데이터 반환
		//scan.nextXXX();
		
		//입력받은 \r\n을 자동으로 버림.
		System.out.print("입력 : ");
//		String input = scan.nextLine(); //reader.readLine(); 과 같은 역할
//		System.out.println(input);
		
		
		
		//숫자 입력받아 +10
		//입력받은 \r\n을 자동으로 버려주지 않음.
//		int num = scan.nextInt(); //Integer.parseInt(reader.readLine()); 과 같은 역할
//		System.out.println(num + 10);
//		
//		scan.skip("\r\n"); //엔터가 버퍼에 남아있기 때문에 넘어가도록 해주는 역할 필요 
//		
//		String input = scan.nextLine(); //reader.readLine(); 과 같은 역할
//		System.out.println(input);
		
		//nextLine() : 라인 입력
		//next() : 토큰(Token - 공백으로 구분되는 요소) 입력
//		String input = scan.next(); 
//		System.out.println(input);
		
		//공백이 얼마나 있을지 모르기 때문에 보통 루프를 돌림.
//		String input ="";
//		
//		while ((input = scan.nextLine()) != "") {
//			System.out.println(input);
//		}

		String input = scan.nextLine();
		//문자열 메소드
		// - String[] split(String splitter)
		
		String[] result = input.split(" "); //********
		System.out.println(Arrays.toString(result));
		

		System.out.println("종료");
		
		
	}

}
