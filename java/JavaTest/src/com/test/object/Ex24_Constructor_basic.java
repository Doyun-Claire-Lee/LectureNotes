package com.test.object;

public class Ex24_Constructor_basic {
	
	public static void main(String[] args) {
		
		//생성자, Constructor
		// - 특수한 목적을 가지는 메소드
		// - 객체(멤버 변수)를 초기화 하는 역할(****)
		// - 메소드명이 클래스명과 동일하다.
		// - 반환 타입을 명시하지 않는다. (void 조차도 없음..)
		
		
		//자료형(클래스명) (객체)변수명 = new Cup(); 과 같은 의미
		//								  new : 객체생성연산자 -> 클래스를 찾아가서 설계도대로 Heap영역에 null값인 변수들을 생성
		//									  Cup() : Constructor, 메소드 -> new가 만들어놓은 공간에 초기화를함. (값형 자료형을 0으로 초기화)
		Cup c1 = new Cup();
		
		//setter -> 객체 생성 후 나중에 값을 변경할 때 쓰임. (수정용)
//		c1.setName("종이컵");
//		c1.setSize(150);
		
		System.out.println(c1.getName());
		System.out.println(c1.getSize());
		
		Cup c2 = new Cup("스테인레스 컵", 850);
		
		System.out.println(c2.getName());
		System.out.println(c2.getSize());
		
		Cup c3 = new Cup("나무컵");
		
		System.out.println(c3.getName());
		System.out.println(c3.getSize());

		Cup c4 = new Cup(1000);
		
		System.out.println(c4.getName());
		System.out.println(c4.getSize());
		
		
	}

}

class Cup {
	
	//멤버 변수
	//선언만 하는 곳, 초기화 작업은 생성자메소드에서..
	private String name;
	private int size;
	private static int count;
	
	
	//객체 변수 -> 객체 생성자에서 초기화
	//정적 변수 -> 정적 생성자를 별도로 사용하여 초기화
	
	static { //정적 생성자
		Cup.count = 0;
	}
	
	//기본 생성자
//	public Cup() {
//		this.setName("종이컵");
//		this.setSize(150);
//	} // 컴파일 시 자동으로 만들어지는 코드, 안의 값을 바꾸면 객체의 초기상태값을 설정할 수 있다.
	

	public Cup() {
//		this.setName("종이컵");
//		this.setSize(150);
		this("종이컵", 150); // 중복 방지를 위해 다른 생성자를 호출한다.
	}
	
	
	//생성자 오버로딩(메소드 오버로딩)
	//원유효성 검사는 다 해야함.. 
	public Cup(String name, int size) {
		this.name = name;
		if(size >=0) {
		this.size = size;
		}
	} 
	
	public Cup(String name) {
//		this.name = name;
//		this.size = 0;
		this(name, 0); 
	}
	
	public Cup(int size) {
//		this.name = "이름없음";
//		this.size = size;
		this("이름없음", 0);
	}
	
	

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}