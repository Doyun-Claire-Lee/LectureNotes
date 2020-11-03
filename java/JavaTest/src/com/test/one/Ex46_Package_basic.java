package com.test.one;
//import com.test.two.Item; //객체 선언시 다른 패키지라는 표현(com.test.two.객체)을 생략하기 위한 도구

import com.test.util.MyUtil;

public class Ex46_Package_basic {
	
	public static void main(String[] args) {
		
		//패키지, Package
		// - 클래스를 분류하고 관리하는 단위(폴더같은 개념)
		// - 자바 클래스의 배포 단위
		
		//패키지 명명법
		// a. 영문자로만 작성(소문자)
		// b. com.test.object
		//  - "." : 상하 레벨을 만들어 줌
		//  - 3단계 패키지(com > test > object)
		//  - 되도록 3단계 이상 권장
		//		1. 패키지명은 주로 도메인을 붙이기 때문에..(도메인은 중복되지 않기 때문에 주로 패키지명에 붙임)
		//		2. 중복 방지
		
		//패키지를 언제 만드는지?
		// - 다량의 코드 작성시 재량껏..
		//  1. 메소드를 추출할지 고려(반복 or 의미있는)
		//  2. 클래스 추출할지 고려 
		//  3. 패키지 추출 고려
		
		
		//같은 패키지 내의 Item객체
//		Item item = new Item();
		
		//다른 패키지 내의 Item
		// - 어느 패키지의 클래스인지 명시해야 사용할 수 있다.
//		com.test.two.Item item = new com.test.two.Item();
		Item item = new Item(); //패키지 import 후 com.test.two. 생략가능
		
		//import를 하고 해당 패키지 내에 동일한 이름의 클래스가 있는 경우에는 import를 못하고,
		//다른 패키지의 객체를 사용하고 싶은 경우 com.test.two.Item item 와 같이 사용해야 한다.
		
		//class Student
		Student s1 = new Student();
		s1.test();
		
		System.out.println("같은 패키지내의 다른 클래스에서 접근");
//		System.out.println("private a: " + s1.a);
		System.out.println("public b: " + s1.b);
		System.out.println("protected c: " + s1.c);	//같은 패키지 안에서는 public 처럼 씀.
		System.out.println("default d: " + s1.d);	//같은 패키지 안에서는 public 처럼 씀.
		System.out.println();
		
		
		MyUtil util = new MyUtil();
		System.out.println(util.nextInt());
		System.out.println(util.nextColor());
		
		
	}

}

class Item {
	
}
