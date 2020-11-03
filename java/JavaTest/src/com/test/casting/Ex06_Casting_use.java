package com.test.casting;

public class Ex06_Casting_use {
	
	public static void main(String[] args) {
		
		//정수형 상수 : int
		
		byte b1 = (byte)10;	//byte(1) = int(4)		*예외) 원래는 명시적으로 형변환을 해주어야 하나 번거로운 관계로 암시적 형변환이 일어나게 되어있음.
		short s1 = (short)10;	//short(2) = int(4)	*예외) 원래는 명시적으로 형변환을 해주어야 하나 번거로운 관계로 암시적 형변환이 일어나게 되어있음.
		int n1 = 10;	//int(4) = int(4)
		long l1 = (long)10;	//long(8) = int(4)		*원래 암시적 형변환
		
		//정수 -> 실수
		
		int m1;
		double d1;
		
		m1 = 100;
		
		//큰형 = 작은형 -> 암시적 형변환
		//double = int
		d1 = (double)m1;
		System.out.print(d1);
		
		
		//실수 -> 정수
		// - 일부러 소수점 아래자리를 날려버리려 할 때(정수화) 자주 사용
		// - 내림처리
		
		int m2;
		double d2;
		
		d2 = 3.74;
		
		//작은형 = 큰형 -> 명시적 형변환
		//int = double
		m2 = (int)d2;
		System.out.println(m2);
		
		
		
		float f1;
		int m3;
		
		f1 = 31.4F;
		
		//int(4) = float(4)
		m3 = (int)f1;
		System.out.println(m3);
		
		//동일한 크기(4byte)의 자료형으로 형변환 하는데 왜 명시적 형변환을 해야 하는지?
		//int : +-21억
		//float : +-10^30
		// => float가 더 큰 범위를 가지기 때문에!

		
		long l2;
		
		//작은형 = 큰형
		//long(8) = float(4)
		l2 = (long)f1;
		System.out.println(l2);
		
		
		//수의 범위
		//byte(1) < short(2) < int(4) < long(8) < float(4) < double(8)
		
		
		//boolean 
		// - 형변환이 불가능
		
		//char
		// - 형변환이 가능

		int m5;
		char c1;
		
		m5 = 68;
		
		c1 = (char)m5;			//해당 숫자값을 문자 코드로 가지는 문자로 변환됨.
		System.out.println(c1);
		
		System.out.println((char)65);
		System.out.println((int)'A');
		
		
		//문자 코드
		System.out.println((int)'A');
		System.out.println((int)'Z');
		System.out.println((int)'a');
		System.out.println((int)'z');
		System.out.println((int)'0');
		System.out.println((int)'9');
		System.out.println((int)'가');
		System.out.println((int)'힣');
					
		System.out.println((int)'\r');
		System.out.println((int)'\n');
		System.out.println((int)'\t');
		System.out.println((int)'\b');
		System.out.println((int)' ');
		
		
//		## ? short를 char로 형변환 가능합니까? 이유는 뭡니까 >> *****쓰면 안됨***** 그냥 int로 쓰기
		//short(2byte) == char(2byte)
		//short : -32768 ~ 32767 : signed type
		//char : 0~65534 : unsigned type
		
		//char(2byte) <-> int(4byte)
		//char : 0~65534 
		//int : -21억 ~ 21억
		
		
		
	}

}
