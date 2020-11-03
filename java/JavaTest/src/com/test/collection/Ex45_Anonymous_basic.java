package com.test.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ex45_Anonymous_basic {
	
	public static void main(String[] args) {
		
		//익명 객체, Anonymous Object
		// - 익명 클래스, Anonymous Class
		// - 이름이 없는 클래스(객체)
		
		BBB b1 = new BBB();
		b1.test();
		b1.run();
		
		AAA b2 = new BBB(); //업캐스팅, 더욱 안정적인 방식
		b2.test();
		((BBB)b2).run(); //자식 객체의 멤버를 사용하고 싶은 경우 다운캐스팅 하면 됨.
		
		
		//원래 인터페이스는 객체를 만들지 못하는데, 아래와 같이 AAA() {}; 의 형식으로 선언부 없이 객체를 생성할 수 있음.
		//대신 구현해야 할 추상메소드가 있다면 구현해야 함.(자식클래스와 동일)
		
		//익명 클래스(익명 객체) 
		// - 클래스 선언 과정 없이 즉석으로 객체를 선언 + 생성하는 기술
		// - 이름이 없는 클래스(객체)
		// - 코드 절감 효과 X
		// - 가독성때문에 사용하는 기술
		
		AAA b3 = new AAA() {

			@Override
			public void test() {
				System.out.println("AAA.test() 구현");
			}
		};
		
		b3.test();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(50);
		list.add(30);
		list.add(20);
		list.add(40);
		
		//정렬하기, Quick Sort
//		list.sort();
		Collections.sort(list); 	// List<T>: ArrayList의 부모인터페이스
		Collections.reverse(list);	//그냥 뒤집기만 한 것. 내림차순으로 하고싶으면 sort후 reverse하면 됨.
		
		System.out.println(list);
		
		ArrayList<User> ulist = new ArrayList<User>();
		User u1 = new User(); u1.name = "가"; u1.age = 22; u1.gender = 1;
		User u2 = new User(); u2.name = "나"; u2.age = 50; u2.gender = 2;
		User u3 = new User(); u3.name = "다"; u3.age = 23; u3.gender = 2;
		User u4 = new User(); u4.name = "라"; u4.age = 64; u4.gender = 2;
		User u5 = new User(); u5.name = "마"; u5.age = 33; u5.gender = 1;
		
		ulist.add(u1);
		ulist.add(u2);
		ulist.add(u3);
		ulist.add(u4);
		ulist.add(u5);
		
//		Collections.sort(ulist, c);
		
		//Comparator<T> Comparator 인터페이스 객체를 매개변수로 넘겨야 함.
		ulist.sort(new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				//양수 혹은 음수를 반환
				//양수 : o1이 더 큼
				//음수 : o2가 더 큼
//				return o1.age - o2.age;				//나이로 비교
//				return o1.gender - o2.gender;		//성별로 비교
				return o1.name.compareTo(o2.name);	//문자열 비교 (문자코드값으로 루프돌림)
			}
		});
		System.out.println(ulist);
	}

}

interface AAA {
	void test();
}

class BBB implements AAA {
	@Override
	public void test() {
		System.out.println("인터페이스 AAA의 test() 메소드를 구현했습니다.");
	}
	public void run() {
		System.out.println("추가로 구현된 BBB만의 메소드입니다.");
	}
}

class User { //implements Comparator<User> { 
	
	public String name;
	public int age;
	public int gender;
	
	@Override
	public String toString() {
		return String.format("%s(%d,%s)"
								, this.name
								, this.age
								, this.gender == 1 ? "남자" : "여자");
	}

//	@Override
//	public int compare(User o1, User o2) {
//	
//		return o1.age - o2.age;
//	}
	
}