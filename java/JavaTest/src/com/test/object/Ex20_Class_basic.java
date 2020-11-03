package com.test.object;

public class Ex20_Class_basic {

	
	public static void main(String[] args) {
		
		Person p1 = new Person();
		p1.setName("홍길동");
		
		Person p2 = new Person();
		p2.setName("아무개");
				
		Person p3 = new Person();
		p3.setName("하하하");	
		
		//참조형 배열
		Person[] list = new Person[3];	//Person 객체가 3개 생성되었습니까 ? -> 아니오.. 0개 생성됨.
										//Person 객체를 3개 생성할 수 하여 저장할 수 있는 '참조변수' 를 연속으로 저장할 수 있는 방이 생성됨.
		
		//java.lang.NullPointerException 에러
//		list[0].setName("홍길동");
		
		list[0] = new Person(); //Person 객체가 생성되어 그 주소값이 list배열의 0번째 방에 저장되었다.
		list[1] = new Person();
		list[2] = new Person();
	
	}
	
}

class Person {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
