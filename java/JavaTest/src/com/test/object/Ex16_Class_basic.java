package com.test.object;

public class Ex16_Class_basic {
	
	public static void main(String[] args) {
		
		/*
		
		클래스, Class
		- 객체 지향 프로그래밍(Object Oriented Programming)
		- 프로그램을 객체의 행동과 상태 중심으로 풀어나가는 방식
		- 코드의 집합
		- 붕어빵 틀
		
		객체, Object
		- 클래스로부터 실체화된 결과물
		- 붕어빵
		
		인스턴스, Instance (객체보다 조금 더 좁은 의미로 쓰임)
		- 클래스로부터 실체화된 결과물
		- 붕어빵
		- 메모리에 실체화된 객체를 인스턴스라 부름
		
		속성, Property
		- 객체가 가지는 데이터
		- 멤버 변수
		
		메소드, Method, 행동, Behavior
		- 객체가 가지는 행동
		- 멤버 메소드
		
		
		자바에서 클래스 만들기
		
		class 클래스명 {
		
			//내용물: 클래스 멤버, Class Member
			 			1. 멤버 변수
			 			2 .멤버 메소드
	
		}
		
		*/
		
		//요구사항) 지도에 우리집의 좌표 표시 + 저장 + 불러오기 등등...
		
		//Case 1. 
		//아래 방법은 x,y가 한 쌍임을 증명할 방법이 없고, 추후 수정 및 확인이 어려움.
		//우리집 좌표값
		int x = 100;
		int y = 200;
		
		//마트 
		int x2 = 300;
		int y2 = 400;
		
		//Case 2.
		//조직적이고 나쁘진 않은 방법이나 배열의 데이터가 많아지면 헷갈리게 됨. 또한 같은 자료형만 저장 가능함.(의미를 알아보기 힘듬)
		int[] a1 = {100, 200};
		int[] a2 = {300, 400};
		
		//Case 3.
		// - 클래스 사용 == 클래스의 객체(인스턴스)를 생성한다.
		
		Point p1 = new Point(); //Point 클래스 내의 int x와 y, String name이 메모리공간에 만들어짐.
		p1.x = 100;
		p1.y = 200;
		p1.name = "우리집";
		
		Point p2 = new Point();
		p2.x = 300;
		p2.y = 400;
		p2.name = "마트";
		
		Size s1 = new Size();
		s1.width = 100;
		s1.height = 100;		

//-----------------------------------------------------------------------------------------------------------------------------------		
		
		//클래스 선언시 권장(필수)사항
		//1. 하나의 클래스는 하나의 파일로 저장한다. (하나의 파일 안엔 클래스를 하나만 선언한다)
		//2. 선언된 클래스의 이름이 파일의 이름과 같아야 한다.
		//3. 하나의 파일에 두개 이상의 클래스를 선언하게 될 경우
		//	a. 반드시 public 키워드 클래스 딱 1개 존대
		//	b. public 키워드 클래스의 이름이 파일명이 된다. -> 대표 클래스
		
		Student2 st1 = new Student2();
		
		st1.name = "홍길동";
		st1.kor = 100;
		st1.eng = 100;
		st1.math = 100;
		st1.total = st1.kor + st1.eng + st1.math;
		st1.avg = st1.total / 3.0;
		
		//학생 정보 출력
		
		//A.
		System.out.printf("이름 : %s\n", st1.name);
		System.out.printf("총점 : %d\n", st1.total);
		System.out.printf("이름 : %f\n", st1.avg);
		
		//B.
		print(st1);
		
		//C.
		st1.print();
		
//-----------------------------------------------------------------------------------------------------------------------------------		
		
		int a = 10;
		int b = 5;
		
		MyMath.add(a, b); //다른 클래스 내의 메소드는 클래스명을 생략할 수 없다.
		MyMath.substract(a, b);
		Ex16_Class_basic.test(); //FM
		test(); //같은 클래스 내의 메소드는 클래스명을 생략할 수 있다.
		
//-----------------------------------------------------------------------------------------------------------------------------------		

		Phone t1 = new Phone();
		
		t1.model = "아이폰";
		t1.number = "010-1234-5678";
		t1.owner = "홍길동";
		
		Phone t2 = new Phone();
		
		t2.model = "갤럭시";
		t2.number = "010-9876-5432";
		t2.owner = "아무개";
		
		
		t1.info();
		t2.info();
		
		t1.call();
		t2.call();
		
	}//main
	
	
	
	
	private static void print(Student2 st1) {
		
		System.out.printf("이름 : %s\n", st1.name);
		System.out.printf("총점 : %d\n", st1.total);
		System.out.printf("이름 : %f\n", st1.avg);
		
	}




	public static void test() {
		
	}

}//class


//클래스 선언 위치..(가장 바깥에서)

class Point { //클래스 이름 -> 대문자로 시작해야함.

	//데이터 집합으로 사용하기 위해 클래스를 선언함!!!! (배열과는 달리 다른 타입의 자료형이라도 같은 범주 내에 저장이 가능)
	
	//클래스 멤버 변수
	public int x;
	public int y;
	public String name;
	
}

class Size {
	
	public int width;
	public int height;
}

//클래스를 생성하는 목적
//1. 데이터 집합으로서의 클래스 = 멤버 변수만 있으면 됨.
//2. 행동 집합 = 멤버 메소드 (잘 안씀..)
//3. 데이터 + 행동 집합 = 멤버 변수 + 멤버 메소드 (가장 많고, 가장 흔하게 사용)

//행동 집합
class MyMath {
	
	public static void add(int a, int b) {
		
		System.out.println(a + b);
		
	}
	
	public static void substract(int a, int b) {
		
		System.out.println(a - b);
		
	}
}

//데이터 + 행동

class Phone {
	
	//멤버 변수
	public String model;
	public String number;
	public String owner;
	
	//멤버 메소드 : 항상 객체 메소드는 자신의 정보(데이터)를 바탕으로 행동해야 한다*****
	public void info() { // static 빼고 씀..
//		System.out.println("전화기 입니다.");
		System.out.printf("%s가 소유하고 있는 전화기 입니다. 번호는 %s입니다.\n", owner, number);
	}
	
	public void call() {
		System.out.printf("%s의 전화기로 전화를 겁니다.\n", owner);
	}
	
}