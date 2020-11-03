package com.test.object;

public class Ex21_Class_basic {
	
	public static void main(String[] args) {
		
		//static 키워드
		// - 클래스 멤버에 붙이는 키워드(멤버 변수, 멤버 메소드에만 붙일 수 있음. 지역변수에는 X)
		
		//변수의 종류
		
		//1. 멤버 변수
		//	a. 객체 멤버 변수 : 이제까지 만들었던 변수들
		//	b. 정적 멤버 변수 : static 키워드를 작성한 변수
		
		//2. 지역 변수
		//	a. 메소드 내에서 선언한 것
		//	b. 제어문 내에서 선언한 것
		//	c. 매개변수
		
		
		//객체 메소드
		// - 개인 데이터(객체 변수) 읽기/쓰기
		// - 공용 데이터(정적 변수) 읽기/쓰기의 경우도 가끔 있음.
		
		//정적 메소드
		// - 공용 데이터(정적 변수) 읽기/쓰기
		// - 개인 데이터(객체 변수) 접근 불가 -> 정적 메소드가 생성될 때 객체 변수는 존재하지도 않았기 때문.. 
		//										 정적 메소드는 main()전에 태어나지만 객체 변수는 객체를 생성해야 태어나기 때문.
		
		
		//학생 객체 X 3명
		
		Student1.setSchool("역삼중학교");
		
		Student1 s1 = new Student1();
		s1.setName("홍길동");
		s1.setAge(14);
//		s1.setSchool("역삼중학교");
//		s1.setSchool("역삼중학교"); //The static method setSchool(String) from the type Student should be accessed in a static way 
		
		
		Student1 s2 = new Student1();
		s2.setName("아무개");
		s2.setAge(15);
//		s2.setSchool("역삼중학교");
	
		
		Student1 s3 = new Student1();
		s3.setName("하하하");
		s3.setAge(15);
//		s3.setSchool("역삼중학교");
		
		
		//객체 각자에게 질문 (개인들에게 어떤 학교에 다니는지 물어본 것과 같음)
		// public void hello2()
		s1.hello2();
		s2.hello2();
		s3.hello2();
		
		//클래스 자체에게 질문 (학생 단체에게 어떤 학교에 다니는지 물어본 것과 같음)
		// public static void hello2()
		Student1.hello3();
		
		
	}

}

//학생 클래스
// - 학생 정보를 저장하는 객체
// - 역삼 중학교 학생 (*****)
class Student1 {
	
	private String name;
	private int age;
//	private String school;	// 왜 모두 같은 학교인데 변수를 따로 만드는지?  -> 데이터화 하기 위해
	private static String school;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//	public String getSchool() {
//		return school;
//	}
//	public void setSchool(String school) {
//		this.school = school;
//	}
	public static String getSchool() {
		return school;
	}
	public static void setSchool(String school) {
		Student1.school = school;	//this -> Student로 변경됨
	}
	
	
	//자기 소개 메소드
	//static을 붙여야 하느냐 마느냐?
	//1. 객체마다 다른 행동을 해야 한다면 -> 객체 메소드로 (static X)
	//2. 객체마다 동일 행동을 해야 한다면 -> 정적 메소드로 (+ static)
	public void hello() {
		System.out.printf("안녕하세요, 저는 %s입니다.\n", this.name);
	}

	public void hello2() {
		System.out.printf("저는 %s에 다닙니다.\n", Student1.school);
	}
	public static void hello3() {
		System.out.printf("저는 %s에 다닙니다.\n", Student1.school);
	}
	

	
	
}