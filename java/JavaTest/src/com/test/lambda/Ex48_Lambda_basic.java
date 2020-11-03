package com.test.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Ex48_Lambda_basic {
	
	public static void main(String[] args) {
		
		//Lambda Expression, 람다식
		// - 함수형 프로그래밍 스타일을 지원하는 기술
		// - 이제까지 : 절자치향 + 객체지향 프로그래밍 스타일을 사용
		// - 자바에서는 컬렉션을 사용하는 기능에 람다식을 많이 지원하고 있음.
		
		//람다식 기본 표현(문법)
		// - (자료형 매개변수) -> { 실행코드 };
		// 1. (매개변수) : 메소드의 매개변수와 비슷한 역할
		// 2. -> : 화살표(Arrow), 코드블럭을 호출하는 역할
		// 3. {실행코드} : 메소드의 구현부와 동일한 역할
		
		//람다식에서 사용하는 인터페이스
		// 1. 추상 메소드는 반드시 하나만 가져야 한다.(************)
		// 2. 람다식을 저장하는 인터페이스를 '람다식의 타켓타입(Target Type)'이라고 한다.
		// 3. 혹은 '함수형 인터페이스(Functional Interface)'이라고 한다.	//여기서는 MyInterface
		// => 함수형 인터페이스란 ? 추상메소드를 하나만 가지는 인터페이스
		
		
		
		
		//실명 객체(MyClass(이름이 있는 클래스)를 통해 만든 객체)
		MyClass m1 = new MyClass();
		m1.test();
		
		MyInterface m2 = new MyClass();
		m2.test();
		
		//익명 객체
		MyInterface m3 = new MyInterface() {
			
			@Override
			public void test() {
				System.out.println("MyInterface를 구현한 익명 객체 메소드 호출");
			}

//			@Override
			public void call() {
	
			}
		};
		
		m3.test();
		
		//람다식
		// - 누가 구현하던지 동일하게 반복되는 코드를 생략
		MyInterface m4 = () -> {
			System.out.println("람다식으로 구현한 익명 객체 메소드 호출");
		};
		m4.test();
		
		MyInterface m5 = () -> {System.out.println("추가 구현");};
		m5.test();
		
		
		System.out.println();
		
		
		//람다식을 사용해서 메소드를 구현(매개변수X, 반환값X)
		NoParameterNoReturn pr1 = () -> { System.out.println("pr1"); };
		NoParameterNoReturn pr2 = () -> System.out.println("pr2");	//구현부 {} 생략 가능. 단, 구현부의 문장이 하나일 때
		
		pr1.call();
		pr2.call();
		
		//람다식을 사용해서 메소드를 구현(매개변수O, 반환값X)
		ParameterNoReturn pr3 = (int num) -> {System.out.println(num * 2);};
		ParameterNoReturn pr4 = num -> System.out.println(num * num);		//변수타입과 ()까지 생략 가능
		
		pr3.call(2);
		pr4.call(5);
		
		MultiParameterNoReturn pr5 = new MultiParameterNoReturn() {
			@Override
			public void call(int a, int b) {
				System.out.println(a + b);
			}
		};
		MultiParameterNoReturn pr6 = (a, b) -> System.out.println(a + b);
		
		pr5.call(2, 3);
		pr6.call(4, 5);
		
		//람다식을 사용해서 메소드를 구현(매개변수X, 반환값O)
		NoParameterReturn pr7 = () -> {return 10;};
		System.out.println(pr7.call());
		
		NoParameterReturn pr8 = () -> {
			Random rnd = new Random();
			return rnd.nextInt(100) + 1;
		};
		System.out.println(pr8.call());
		
		NoParameterReturn pr9 = () -> 10;	//실행블럭이 한줄일때 리턴값만 적도록 줄일 수 있음, 이때 return은 적으면 안됨
		System.out.println(pr9.call());
		
		//람다식을 사용해서 메소드를 구현(매개변수X, 반환값O)
		ParameterReturn pr10 = new ParameterReturn() {
			@Override
			public int call(int a, int b) {
				return a * b;
			}
		};

		ParameterReturn pr11 = (a, b) -> a * b;
		System.out.println(pr11.call(10, 5));
		
	
		//람다식 사용 예
		// - 익명 객체를 사용하는 곳에서 람다식을 사용할 수 있다.
		// ex) 컬렉션.sort(익명객체)
		
		List<String> names = new ArrayList<String>();
		names.add("딸기");
		names.add("귤");
		names.add("복숭아");
		names.add("포도");
		names.add("파인애플");
	
		//정렬 -> 글자수 정렬
		names.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		
		//람다식 사용
		names.sort((o1, o2) -> o2.length() - o1.length());
		
		System.out.println(names);
	
	
	}//main

}

interface MyInterface {
	void test();
//	void call();
}

class MyClass implements MyInterface {
	
	@Override
	public void test() {
		System.out.println("MyInterface를 구현한 MyClass 메소드 호출");
	}

//	@Override
	public void call() {
				
	}	
}

//람다식을 저장할 함수형 인터페이스 선언하기
// - 추상메소드 1개짜리 인터페이스

@FunctionalInterface
interface NoParameterNoReturn {
	void call();
//	void test();
}

@FunctionalInterface
interface ParameterNoReturn {
	void call(int num);
}
@FunctionalInterface
interface MultiParameterNoReturn {
	void call(int a, int b);
}

@FunctionalInterface
interface NoParameterReturn {
	int call();
}

@FunctionalInterface
interface ParameterReturn {
	int call(int a, int b);
}