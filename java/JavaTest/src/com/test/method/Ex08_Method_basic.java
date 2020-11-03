package com.test.method;

//Allman style -> 중괄호를 밑에 쓰는것
public class Ex08_Method_basic 
{
	//main method
	// - 특수한 메소드
	// - 이름이 예약어(main)
	// - 실행을 개발자가 직접하지 않고(main()와 같이), 자바의 JRE(JMM)가 자동으로 호출한다.
	// - 프로그램의 시작점(Entry Point) ~ 프로그램의 종착점(End Point)
	public static void main(String[] args) 
	{
		
		
		//메소드, Method
		// - 메소드, 함수(Function), 프로시저(Procedure), 서브루틴(Sub Routine)..
		// - 객체 내에 존재하는 함수를 메소드라 한다.
		// - "특정 행동을 하는 코드의 집합" -> Behavior
		
		//요구사항) "안녕하세요" X 5번 출력
		//수정사항) "반갑습니다."로 수정
		System.out.println("반갑습니다");
		System.out.println("반갑습니다");
		System.out.println("반갑습니다");
		System.out.println("반갑습니다");
		System.out.println("반갑습니다");
		System.out.println();
		
		/*
		
		메소드 사용법
		1. 메소드 정의하기(선언하기)
		
		public static void 메소드명() {
			실행코드;
		}
		
		접근지정자 정적키워드 반환타입 메소드명(인자리스트) {
			실행코드;
		}
		
		2. 메소드 호출하기(사용하기)
		
		메소드명();
		
		3. 메소드의 사용 목적(이유, 장점)
			a. 코드 재사용
			b. 유지/보수성 좋음
			c. 비용 절감(인건비 감소 등등)
			d. 가독성 향상(코드가 목적에 따라 분리되어 관리)
			
		*/
		//요구사항) "안녕하세요" X 5번 출력
		hello();
		hello();
		hello();
		hello();
		hello();
		
		
		
		//메소드 선언 유형
		// - 매개변수(인자, Parameter, Argument)의 유무
		// - 반환값(Return Value)의 유무
		//1. 매개변수x, 반환값x
		//2. 매개변수o, 반환값x
		//3. 매개변수x, 반환값o
		//4. 매개변수o, 반환값o
		
		paramNoReturn(10);
		paramNoReturn(20);
		
		int a = 100;
		paramNoReturn(a);
		
		noParamReturn(); // 이렇게 하면 반환값을 가져오기만 하고 끝나기 때문에 보통 값을 변수에 저장함.
		int result = noParamReturn();
		System.out.println(result);
		
		int b = 5;
		result = paramReturn(5);
		System.out.println(result);
		
		
		
		
		//에러(Error), 오류, 예외(Exception), 버그(Bug)
		
		//에러의 종류
		
		//1. 컴파일 오류
		// - 컴파일 과정에서 발견되는 오류
		// - 프로그래밍 언어 >> 기계어 번역 중에 발견되는 오류
		// - 문법이 틀린 오류(***)
		// - 컴파일러가 발견하는 오류(javac.exe)
		// - 난이도 하, 발견률 상
		// - 친절한 에러 메시지(원인, 발견 코드의 위치)
		// - 사용자 오타 등..
		
		//2. 런타임 오류(Runtime Error)
		// - 프로그램 실행 중 발생하는 오류(문법에는 오류가 없었던 것)
		// - 예외(Exception)이라 부름.
		// - 경우에 따라 발생이 안되는 경우가 있음.
		// - ex) 숫자를 입력받아 >> 실제 숫자로 변환하여 >> 더하기 연산을 하려 할 때
		//		 입력 : A >> 숫자가 아니기 때문에 오류 발생
		// - 난이도 중, 발견률 중
		
		//3. 논리 오류
		// - 문법도 맞고 실행도 잘 되는데 결과가 틀린 경우
		// - 난이도 상, 발견률 하
		//ex) a1 - b1		
//		int a1 = 10;
//		int b1 = 3;
//		System.out.println(a1+b1);
		
		System.out.println();
		System.out.println();
		
		int m = 20;
		
		m1();
		m1();
		m1();
		//m1을 여러번 생성해도 실행이 끝나면서 메모리에서 삭제되기 때문에 각각 다른 m1임.
		
//		System.out.println(num); >> 이미 m1 메소드의 실행이 끝났고, num은 다른 메소드내의 변수이기 때문에 이용 불가
		
				
		
		//메소드 오버로딩, Method Overloading
		// - 메소드가 매개변수의 구성을 다양한 형태로 가질 수 있게 하는 기술
		// - 같은 이름의 메소드를 여러개 만들 수 있는 것처럼 보이게 함.
		// - 개발자의 가독성 때문에 사용하는 기술
		// - 면접 기출 질문... (메소드 오버라이딩과 함께)
		
		//메소드 오버로딩 조건으로 사용 가능한 조건
		//1. 인자의 갯수
		//2. 인자의 타입
		
		//메소드 오버로딩 조건으로 사용 불가능한 조건
		//1. 인자의 이름
		//2. 반환값의 타입
		
		//메소드를 만드는 중..
		//1. public static void test() { }				//생성 성공
		//2. public static void test() { }				//생성 불가 - 1번과 동일하기 때문에
		//3. public static void test(int n) { }			//생성 가능 - 인자의 갯수가 다름.
		//4. public static void test(int m) { }			//생성 불가 - 호출시 문제가 생기기 때문에 생성 불가 (3번과 혼동되기 때문)
		//5. public static void test(String n) { }		//생성 가능
		//6. public static void test(int n, int m){ }	//생성 가능
		//7. public static void test(int n, String m){ }//생성 가능
		//8. public static int test(int n) { }			//생성 불가 - 3번때문에 불가
		
		//메소드 호출하는 중..
		//1. test(); 				// 1번메소드가 호출됨
		//2. test(10); 				// 3번메소드가 호출됨
		//3. test("문자열"); 		// 5번메소드가 호출됨
		//4. test(10, 20);			// 6번메소드가 호출됨
		//5. test(10, "문자열");	// 7번메소드가 호출됨
		//6. int result = test(10); // test(10);메소드 -> 3번 메소드가 호출되어 result 값에 저장됨.
		
		
		
		
		hello();
		hello("도윤");
	
		//이미 print 구문은 오버로딩이 되어있다. 
		System.out.println(100);		//public static void println(int n) { }
		System.out.println("문자열");	//public static void println(String s) { }
		System.out.println(true);		//public static void println(boolean b) { }
		
		
		
						
	}//main 괄호 닫음
	
	
	
	//1. 매개변수x, 반환값x
	public static void noParamNoReturn() { 
		
		//소괄호()안에 아무것도 없으면 매개변수가 없다는 의미
		//void - 반환값이 없다는 의미
		
		}
	
	//2. 매개변수o, 반환값x
	public static void paramNoReturn(int num) { 
		//(int num) : 매개변수
		// int num;과 같은 의미이지만 초기화를 하지 못함, 사용은 가능 -> 호출할 때 초기화를 함.
		
		System.out.println(num + 100);
		}
	
	
	//3. 매개변수x, 반환값o
	public static int noParamReturn() {
		
		//This method must return a result of type int 오류 -> return값을 설정해주어야 함.
		//return문, 반환문 이용
		
		return 10;
			
		}
	
	//4. 매개변수o, 반환값o >> 함수(Function)
	public static int paramReturn(int num) {
		
		int result = num * 2;
		return result;
		
	}
	
	//메소드 선언하기 (메소드가 또다른 메소드를 가질 수 없기 때문에)
	public static void hello() {
		
		System.out.println("반갑습니다");
				
	}
	
	public static void m1() { 
		
		//특정 메소드 안에서 선언된 변수 : Local Variable, 지역 변수
		// - 메소드 영역내에서 선언되고 사용되는 변수
		//변수의 생명주기, Life Cycle
		// - 변수가 언제 태어나고(선언문이 실행될 때), 언제 소멸되는지(메소드 실행이 완료되고 메인으로 돌아가는 순간)?
		
		
		int num = 10;
		System.out.println(num);
//		System.out.println(m); >> main 메소드에는 살아있는 변수이지만 다른 메소드 내에서는 쓰지 못함
	}
	
//	public static void hello() {  //Duplicate method hello() in type Ex08_Method_basic 오류 : 현재파일 안에 해당 메소드 중복되어있음.
//		
//	}
	
	public static void hello(String name) {
		
		System.out.printf("%s님 안녕하세요.\n", name);
		
	}
	

}//Ex08_Method_basic
		
		
		
		
		
	
