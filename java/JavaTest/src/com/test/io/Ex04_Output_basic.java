package com.test.io;

public class Ex04_Output_basic {
	
	
	public static void main(String[] args) {
		
		//메소드 = 기능
		
		//콘솔 입출력,  Console Input/Output, Console IO
		// - 기본 입력 장치 : 키보드
		// - 기본 출력 장치 : 모니터
		// - 기본 에러 장치 : 모니터
		
		//콘솔 출력
		//1. Syetem.out.println() 메소드
		//2. Syetem.out.print() 메소드
		//3. Syetem.out.printf() 메소드
	
		//형식 문자
		//1. %s : String
		//2. %d : Decimal(정수 - byte, short, int, long)
		//3. %f : float(실수 - float, double)
		//4. %b : boolean
		//5. %c : char
		
		//형식 문자 추가 기능
		
		//1. %숫자d
		// - 숫자의 역할 : 출력 너비(문자수) 지정
		// - '+'(우측정렬), '-'(좌측정렬) , 가운데정렬은 없음.
		// - 모든 형식문자에 사용 가능
		
		//2. %,d
		// - 자릿수(천단위) 표기
		// - "%,d", "%,f"
		
		//3. %.숫자f
		// - %f에서만 사용 가능
		// - 소수 이하 n자리까지 출력
		// - 반올림
		
		//4. %,너비.소수f
		
		
		//println() : ln = line -> 내용을 출력 후에 개행을 한다.(출력후 엔터)
		System.out.println(100);
		System.out.println(3.14);
		System.out.println("문자열");
		System.out.println('A');
		System.out.println(true);
		
		//print() : 내용을 출력한다.
		System.out.print(100);
		System.out.print(3.14);
		System.out.print("문자열");
		System.out.print('A');
		System.out.print(true);
		
		//printf() : 형식 문자를 사용하여 출력
		System.out.printf("%d", 100);
		System.out.printf("%f", 3.14);
		System.out.printf("%s", "홍길동");
		System.out.printf("%b", true);
		System.out.printf("%c", 'A');
		
		
		
	}
	
	

}
