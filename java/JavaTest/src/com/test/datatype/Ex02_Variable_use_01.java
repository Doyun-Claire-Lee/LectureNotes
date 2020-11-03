package com.test.datatype;

public class Ex02_Variable_use_01 {
	
	public static void main(String[] args) {
		
		//변수를 만드는 방법
		//1. 
		int a; //선언
		a = 10; //초기화
		System.out.println(a);
		
		//2. 
		int b = 20; //선언과 동시에 초기화
		System.out.println(b);
		
		//3.
//		int c;
//		int d;
//		int e;
		
		int c, d, e;
		
		c = 30;
		d = 40;
		e = 50;
		
		//ctrl + alt + 위아래 방향키 = 해당 라인 복사+붙여넣기
		//alt + 위아래 방향키 = 해당 라인 이동
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		
		//4.
		int f = 60, g = 70, h = 80;
		int i = 90, j, k, l = 100;
		
		//int a = 100; 
		//Duplicate local variable a 오류 : 로컬 변수 a가 중복됩니다.
		//같은 변수 이름은 이용 불가 
		
		int m;
		//The value of the local variable m is not used 오류 : 로컬 변수 m이 사용된 적이 없습니다 -> 선언 후 초기화 하지 않을 경우
//		System.out.println(m);
		//The local variable m may not have been initialized 오류 : 로컬 변수 m이 초기화되지 않았습니다.
		
		//변수를 선언하면 메모리 공간이 할당되는데, 해당 공간은 비어있거나 Garbage 데이터가 남아있는 상태이며, 해당 상태를 Null 상태라 지칭함.
		//Garbage 데이터가 남아있는 이유 ? 변수를 삭제하는 방법은 없기 때문에 사용하지 않아도 해당 메모리 공간에는 데이터가 존재하는데,
		//사용하지 않으면 데이터가 남아있어도 해당 메모리공간을 새로운 변수에게 할당하게 됨. 이 때 남아있는 데이터가 Garbage 데이터
		
		//주석을 다는 방법(TAP)
		
		int x1 = 100;	 //국어
		int x2 = 90; 	 //영어
		int x3 = 80; 	 //수학
		
		//국어
		int x4 = 100;
		//영어
		int x5 = 90;
		//수학
		int x6 = 80;
		
		int y1 = 100, y2 = 90, y3 = 80; //국어, 영어, 수학
		
		int y4 = 100, 	//국어
			y5 = 90,	//영어
			y6 = 80;	//수학
		
		int total = 10;
//		System.out.println(tota);
		//tota cannot be resolved to a variable 오류 : 선언되지 않은 변수를 사용했습니다.

		//식별자 수정 방법 - 영역 잡아서 ctrl + 1 후 첫번째 항목(현재 파일에서만 수정) 선택하여 변수 수정 후 엔터를 눌러 종료
		int abcd = 10;
		
		System.out.println(abcd);
		System.out.println(abcd);
		System.out.println(abcd);		
		
		//자바는 대소문자를 구분함. 
		//문법적으로는 아무 문제 없지만 아래처럼 이용하지 말기..
		int kor;
		int KOR;
		int Kor;
		
		
		//****변수명 만들기 규칙*****
		//1. 영문자 + 숫자 + '_' (한글, 공백, 나머지 특수문자 X)
		//2. 숫자로 시작하면 안됨.
		//3. 예약어 사용 불가 
		//4. 의미있게..****** 요즘은 약어가 아니라 풀네임으로 작성 
				
		int num10;
//		int 10num;
		int _10num; //숫자를 꼭 처음에 써야 할 경우 '_'를 씀.
		
//		int int; 
		
		byte score_english = 80; //영어 점수
		System.out.println(score_english);
		
		
		//명명법(굳이 안외워도 됨/문법상 권장사항이지만 실 업무시 필수적으로 이용)
		
		//1. 헝가리언 표기법 - 자료형을 식별자에 넣는 방식, 보통 자바에서는 인터페이스명에만 사용(interface IEmployees {})
		
		int num = 1;
		int int_num;
		int i_num;
		int inum;
		
		System.out.println(num); //마우스 커서를 대면 int라고 자료형이 뜸.
		
		//2. 파스칼 표기법 - 식별자가 한 단어 혹은 여러 단어로 표기되는 경우에 사용
		// - 모든 단어를 공백 없이 연결('_' 사용 X)
		// - 각 단어의 첫문자를 대문자로 표기, 나머지는 소문자 표기
		// - 자바에서는 주로 **클래스 이름**을 만들 때 이용 
		
		int score_kor;
		int ScoreKor; //파스칼 표기법
		
		//3. 캐멀 표기법 - 식별자가 한 단어 혹은 여러 단어로 표기되는 경우에 사용
		// - 모든 단어를 공백 없이 연결('_' 사용 X)
		// - 각 단어의 첫문자를 대문자로 표기, 나머지는 소문자 표기
		// - 식별자의 첫문자를 소문자 표기
		// - 자바에서는 주로 **변수명, 메소드명**을 만들 때 이용 
		
		int ScoreEnglish ; //파스칼
		int scoreEnglish ; //캐멀
		
		//4. 스네이크 표기법 - 식별자가 한 단어 혹은 여러 단어로 표기되는 경우에 사용
		// - 각 단어를'_'로 연결
		// - 자주 쓰는 표기법
		
		int score_math = 100;
		
		//5. 케밥 표기 - 식별자가 한 단어 혹은 여러 단어로 표기되는 경우에 사용
		// - 각 단어를'-'로 연결
		// - 자바는 지원 불가, '-'를 연산자(빼기)로 인식하기 때문
		
//		int score-math;
				
		
	}

}
