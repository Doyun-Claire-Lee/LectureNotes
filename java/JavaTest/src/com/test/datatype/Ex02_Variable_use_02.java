package com.test.datatype;

public class Ex02_Variable_use_02 {
	
	public static void main(String[] args) {
		
		//자바 자료형 8개로 변수 만들기
		
		//정수
		
		//1. byte : -128 ~ 127
		byte b1 = 10;
		System.out.println(b1);
//		byte b2 = 130;
		//Type mismatch: cannot convert from int to byte 오류 -> byte 범위를 넘어가는 상수로 초기화 하려 할 경우 발생
		
		//2. short : -32768 ~ 32767
		short s1 = 10;
		System.out.println(s1);
		
		//3. int : -21억 ~ 21억
		int n1 = 10;
		System.out.println(n1);
		
		//4. long : -922경 ~ 922경
	
		long l1 = 10000000000L;
		System.out.println(l1);
		
//		long l2 = 10000000000;
		//The literal 10000000000 of type int is out of range 오류 
		//상수를 쓸 경우 자바에서 4바이트(int)를 기본으로 잡기 때문에 21억을 넘는 숫자를 이용할 경우 범위를 초과하게됨. 
		//자바에서 int(4바이트 - 32비트)를 기본으로 잡는 이유? -> 컴퓨터 운영체제와 관련 있음.
		//int의 비트 수는 운영 체제에 따라 변해왔음. (16비트 운영체제 -> int(2byte)) 
		//32비트 운영체제가 널리 쓰이게 되면서 int의 크기도 4바이트(32비트)로 변경되었음.
		//최근들어 64비트 운영체제가 널리 보급되었는데, int의 크기를 이에 따라 변경해야 할 경우,
		//현재까지 시중에 있는 모든 프로그램을 수정해야 하기 때문에 막대한 비용이 발생 -> 4바이트로 유지됨.		
		
		//int 범위를 넘어가는 숫자의 경우 끝에 'L'을 붙여 주어야 함.
	
		int n2; //메모리 값을 할당받고, 해당 공간의 이름을 n2로
		n2 = 10; // 상수값을 지정하는 순간 메모리에 4byte를 잡아 해당 상수값을 넣어버림. 이후 값을 n2에 복사하고 잡았던 4byte 메모리는 사라짐(?)
	
		System.out.println(10); //출력하기 위해 넣은 데이터 '10' : (정수형)상수, 리터럴(Literal) 10
		
		
		//실수
		
		//1. float
		float f1;
		f1 = 3.14F;	
		f1 = 1.123456789123456789123456789F;
		System.out.println(f1); //1.1234568 - 정밀도가 낮음
//		f1 = 3.14;
		//Type mismatch: cannot convert from double to float 오류 -> 실수형 상수는 double이므로 형변환을 하지 않으면 float형 변수에 저장이 불가능함.
		//실수형 상수는 무조건 double형으로 잡힘, 마지막에 F를 붙여야 함.
		
		//2. double
		double d1;
		d1 = 6.28;
		d1 = 1.123456789123456789123456789;
		System.out.println(d1); //1.1234567891234568 - 정밀도가 float보다 높음
		//실수형 상수의 기본값(?) : double - 정밀도가 높기 때문에 
		
		//문자형
		//1. char - 2바이트, 문자를 하나만 저장할 수 있음.
		char c1;
		c1 = 'a'; //반드시 ''를 앞뒤로 붙여주어야 함. 'a' : 문자형 리터럴 a
		System.out.println(c1);
		c1 = '1'; 
		System.out.println(c1); // 출력값은 1이지만 숫자 1과는 다름. '1' : 문자형 리터럴 1
		
		//논리형
		//1. boolean
		boolean flag;
		flag = true; // true : 논리형 리터럴 true
		//true, false : 논리 상수, boolean literal
		
		
		//자바 자료형
		//1. 기본형 : byte, short, int, long, float, double, boolean, char
		//2. 참조형 
		
		
		//***추가***
		//문자열, String
		// - 참조형
		// - 문자들의 열을 저장하는 자료형(한글자도 가능)
		String name; 
		name = "홍길동"; // 문자열 상수, String literal 홍길동. ""로 감싸 표현
		System.out.println(name);
		
		
		
		/*
		영문식 기호 표현
		
		~ 틸드(tilde)
		!
		@ 앳
		# 샵, 해시
		$
		%
		^ 엑소어(xor), caret, hat
		& 앰퍼샌드
		* all(wild card), asterisk
		- minus, dash, hyphen, horizontal bar
		| 파이프, 버티컬바
		` 백쿼터
		
		> 초과 greater than 
		< 미만 less than
		
		() 소괄호 
		{} 중괄호 brace
		[] 대괄호 bracket
		<> 화살표괄호
	
		*/
		
		
	}

}
