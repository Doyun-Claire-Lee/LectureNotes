package com.test.operator;

public class Ex07_Operator_use_01 {
	
	public static void main(String[] args) {
		
		//산술 연산자
		int a = 10;
		int b = 3;
		double c = 2.5;
		double d = 5;
		
		System.out.println(a + b);	//정수 + 정수 = 정수
		System.out.println(a + c);	//정수 + 실수 = 실수
		System.out.println(c + d);	//실수 + 실수 = 실수
		
		System.out.println(a - b);	//정수 - 정수 = 정수
		System.out.println(a - c);	//정수 - 실수 = 실수
		System.out.println(c - d);	//실수 - 실수 = 실수
		
		System.out.println(a / b);	//정수 / 정수 = 정수
		System.out.println(a / c);	//정수 / 실수 = 실수
		System.out.println(d / d);	//실수 / 실수 = 실수
		
		a = 10;
		b = 3;	//정수 3
		c = 3;	//실수 3
		
		System.out.println(a / b); 	//3
		System.out.println(a / c);	//3.3333333333333

		//******모든 산술 연산자는 연산자의 두 결과를 두 피연산자 중 더 큰 자료형으로 반환한다.******
		
		
		//*** 많이 실수하는 부분 -> 에러로 나타나지 않음.
		a = 2100000000;
		b = 2100000000;
		
		System.out.println(a + b); 			// 값 : -94967296 -> 오버플로우 발생
		System.out.println((long)a + b);	// 값 : 4200000000 -> 형변환하여 처리
		
		
		//나머지 연산자(%)
		// - 패턴 생성에 많이 사용(ex. 달력 등)
		// - 달력 생성 방법 
		//		a. 해당 년, 월의 마지막일을 파악
		//		b. 해당 달력의 1일의 요일을 파악
		
		
		System.out.println();
//============================================================================================================================================		
		
		
		//비교 연산자
		
		a = 10;		//int
		c = 10.0;	//double
		
		System.out.println(a > c);	//false
		System.out.println(a == b);	//true
		
		System.out.println();
		
		//유효성 검사
		// - 사용자가 데이터를 입력할 때 올바른 데이터를 입력했는지 확인하는 검사
		
		//ex) 아이디 -> 영어 소문자 한글자(a(97) ~ z(122))
		
		char id = 'j';
		System.out.println((int)id >= (int)'a');
		System.out.println((int)id >= (int)'z');
		System.out.println();
		
		a = 10;
		b = 10;
		System.out.println(a == b);
		System.out.println();
		
		//문자열의 비교는 ==, != 연산자를 사용할 수 없다.
		String s1 = "홍길동";
		String s2 = "홍길동";
		String s3 = "홍";
		s3 = s3 + "길동";
		System.out.println(s3);
		
		System.out.println(s1 == s2);		//true		
		System.out.println(s1 == s3);		//false
		System.out.println(s1.equals(s3));	//true
		System.out.println();
		//문자열의 비교는 equals()메소드를 사용해야 함. String이 클래스이기 때문
		
		
		
		//논리연산
		//나이 : 19세 이상 ~ 60세 미만
		//		 19 <= age < 60
		
		int age = 25;
//		System.out.println(19 <= age < 60); -> 안됨
//		System.out.println(true < 60)의 꼴이기 때문

		System.out.println(age >= 19 && age < 60); //true
		System.out.println();
		
		
		c = 'f';
		System.out.println(((int)c >= (int)'a') && ((int)c <= (int)'z'));
		System.out.println();
		
		//영어 소문자
		System.out.println(c >= 'a' && c <= 'z'); //암시적 형변환
		//영어 대문자
		System.out.println(c >= 'A' && c <= 'Z'); 
		//숫자
		System.out.println(c >= '0' && c <= '9'); 
		//한글
		System.out.println(c >= '가' && c <= '힣');
		
		System.out.println();
		
		
		
		int n = 10;
		int result = 0;
		
		//비권장(하나의 문장에 증감연산자와 다른 연산자를 동시에 사용하지 말것)
//		result = 20 + ++n; 값:31
//		result = 20 + n++; 값:30
		
		//권장
		++n;
		result = 20 + n;
		
		
		System.out.println(result);
		System.out.println(n);
		
		
		int o = 10;
		System.out.println(--o - o--);
		
		
		
		
		
	}

}
