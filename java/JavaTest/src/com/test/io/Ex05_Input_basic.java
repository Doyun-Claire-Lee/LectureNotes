package com.test.io;

//특정 도구(클래스)를 이 페이지에서 사용하겠습니다. 선언
import java.io.BufferedReader; //클래스임포트
import java.io.InputStreamReader;
//import java.io.*; -> 해당 패키지의 모든 기능을 가져옴.

public class Ex05_Input_basic {
	
	public static void main(String[] args) throws Exception { //throws Exception (예외처리)를 해주어야 입력 가능?
		
		//콘솔 입력 방법
		//1. System.in.read() 메소드
		//2. BufferedReader 클래스
		//3. Scanner 클래스 -> 나중에 함.
		
		
		//System.in.read()
		//System.out.print()
		
		//사용자로부터 키보드로 데이터를 입력받는다.
		
		System.out.println("입력 전");
		
		//문자 유니코드값
		//'A' -> 65 ~ 'Z' -> 90
		//'a' -> 97 ~ 'z' -> 122
		//'0' -> 48 ~ '9' -> 57
		//'가' -> 44032 ~ '힣'-> 55203
		
		int input = System.in.read(); 	//사용자로부터 값을 입력받기 전까진 멈춰있는 상태
										//System.in.read()메소드 사용 시 input값은 항상 int로 받아야 함.
		System.out.println(input);
		
		input = System.in.read();
		System.out.println(input);
		
		input = System.in.read();
		System.out.println(input);
		
		input = System.in.read();
		System.out.println(input);
		
		input = System.in.read();
		System.out.println(input);
		
		//5회 반복되어 5글자를 입력받을 수 있는 상태. 
		//abc 세 글자만 입력해도 총 5줄이 나옴. 입력시 엔터(\r\n) 두글자도 같이 입력되었기 때문
		//입력하는 순간 '버퍼(Buffer)'에 임시로 해당 단어가 저장이되며 여러 글자라도 1글자씩 읽어옴.
		
		System.out.println("입력 후");
		
		
		System.out.println();
		System.out.println();
		
//====================================================================================================================================		
		
		//BefferedReader
		// - class import 필요
		// - throws Exception 필요
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("입력 전");
		int input1= reader.read(); 			//System.in.read()역할 -> int로 값을 받을 수 있음.
		System.out.println((char)input1);	//형변환을 시켜 다시 문자로 출력해줌.
		System.out.println("입력 후");
		
		//reader.readLine() 메소드: String으로 값을 받으며 한 단어씩이 아닌 한꺼번에 출력해줌.		
		
		
	}

}
