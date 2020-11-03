package com.test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex49_Lambda_basic {
	
	public static void main(String[] args) {
		
		/*
		 
		람다식을 지원하는 빌트인 인터페이스
		 - 오직 람다식을 저장하기 위해 만들어진 인터페이스
		
		1. Consumer : 매개변수O, 반환값X
		2. Supplier : 매개변수X, 반환값O
		3. Function : 매개변수O, 반환값O, 매개변수를 반환값으로 변환 후 반환
		4. Operator : 매개변수O, 반환값O, 매개변수를 연산 후 반환(Function이 하는 일의 일부분만 구현)
		5. Predicate : 매개변수O, 반환값O, 매개변수를 논리 판단 후 반환(Function이 하는 일의 일부분만 구현)
		
		*/
		
//		m1();	//Consumer, BiConsumer
//		m2();	//Supplier
//		m3();	//Function
//		m4();	//중간정리
//		m5();	//BinaryOperator
//		m6();	//Predicate
		m7();
		
	
		
		
	}

	private static void m7() {
		
		//함수형 인터페이스 조합(결합?)
		// - 여러개의 람다식을 하나의 람다식으로 합치는 작업
		
		//andThen()
		// - A.andThen.(B) : A 실행 후 B 실행
		
		
		User hong = new User("홍길동", 20);
		
		Consumer<User> c1 = user -> System.out.println(user.name);
		c1.accept(hong);
		
		Consumer<User> c2 = user -> System.out.println(user.age);
		c2.accept(hong);
		
		
		//별도로 있었던 이름 출력 + 나이 출력을 한꺼번에
		//기존에 사용하던 람다식을 재사용 할 수 있음.
		Consumer<User> c3 = c1.andThen(c2);
		c3.accept(hong);
		
		Consumer<User> c4 = c2.andThen(c1);
		c4.accept(hong);
		
		System.out.println();
		Consumer<User> c5 = c1.andThen(c2).andThen(c1).andThen(c2);
		c5.accept(hong);
		System.out.println();
		
		Consumer<User> c6 = c3.andThen(c4);
		c6.accept(hong);
		System.out.println();
		
		
		//compose()
		Function<String, Integer> f1 = str -> str.length();
		System.out.println(f1.apply("홍길동입니다."));
		
		Function<Integer, String> f2 = num -> num > 5 ? "길다" : "짧다";
		System.out.println(f2.apply(10));
		System.out.println(f2.apply(3));
		System.out.println();
		
		
		System.out.println(f2.apply(f1.apply("홍길동입니다")));
		
		Function<String, String> f3 = f2.compose(f1);	//f1 먼저 실행되고 f2 실행됨.

		System.out.println(f3.apply("안녕"));
		System.out.println();
		
		
		//and(), or(), negate()
		// - Predicate 조합할 때만 쓰임.
		Predicate<Integer> p1 = n -> n % 2 == 0; 	//2의 배수인지?
		Predicate<Integer> p2 = n -> n % 5 == 0;	//5의 배수인지?
		
		int num = 10;
		System.out.println(p1.test(num));
		System.out.println(p2.test(num));
		System.out.println();
		
		System.out.println(p1.test(num) && p2.test(num));	//2와 5의 공배수인지?
		System.out.println();
		
		Predicate<Integer> p3 = p1.and(p2);		//A && B
		Predicate<Integer> p4 = p1.or(p2);		//A || B
		Predicate<Integer> p5 = p1.negate();	//!A
		
		System.out.println(p3.test(num));
		System.out.println(p4.test(num));
		System.out.println(p5.test(num));
		
	}

	private static void m6() {
		
		//Predicate
		// - 매개변수O, 반환값O
		// - 매개변수를 가지고 어떤 조건을 증명 후 결과를 반환하는 메소드를 구현할 때 사용
		
		Function<Integer, Boolean> f1 = age -> age >= 19;
		
		Predicate<Integer> p1 = age -> age >= 19;
		
		System.out.println(f1.apply(25));
		System.out.println(p1.test(25));
		System.out.println(f1.apply(15));
		System.out.println(p1.test(15));
		
	}

	private static void m5() {
		
		//Operator
		// - 매개변수O, 반환값O
		// - 구현 목적 : 연ㅇ산을 하는 메소드를 구현할 때 사용
		// - Function의 하위 호환 인터페이스(서브셋)
		// - 연산자는 보통 피연산자와 연산 결과의 자료형이 동일하다. 
		
		BiFunction<Integer, Integer, Integer> f1 = (a, b) -> a + b;			//연산자 역할 메소드
		BiFunction<Integer, Integer, String> f2 = (a, b) -> "업무 완료";	//프로세스 진행의 느낌,,
		
		BinaryOperator<Integer> o1 = (a, b) -> a + b;
		System.out.println(o1.apply(10, 20));
		
		BinaryOperator<String> o2 = (a, b) -> a + b;
		System.out.println(o2.apply("가", "나"));
	
	}

	private static void m4() {
		
		/*
		
		정리
		1. 익명 객체를 사용하는 경우 표현 단축을 위해 람다식(=익명 객체의 구현된 추상 메소드)를 사용
		2. 람다식 선언에는 반드시 인터페이스가 필요함. 함수형 인터페이스(추상메소드 반드시 1개)
		3. 자주 사용할만한 패턴의 추상 메소드를 가지는 여러 함수형 인터페이스가 제공됨.
		  - java.util.function : 함수형 인터페이스 제공
		  a. Consumer : 매개변수O, 반환값X
		  b. Supplier : 매개변수X, 반환값O
		  c. Function : 매개변수O, 반환값O, 매개변수를 반환값으로 변환 후 반환
		  
		 */
		
		Consumer<Integer> c1 = num -> System.out.println(num);
		BiConsumer<Integer, Integer> c2 = (a, b) -> System.out.println(a + b);
		
		Supplier<Integer> s1 = () -> 100;
		
		Function<Integer, String> f1 = num -> num > 0 ? "양수" : "음수";
		BiFunction<Integer, Integer, Integer> f2 = (a, b) -> a * b;
		
		c1.accept(10);
		c2.accept(10, 20);
		
		System.out.println(s1.get());
		
		System.out.println(f1.apply(10));
		System.out.println(f2.apply(10, 20));
		
		
	}

	private static void m3() {
		
		//Function
		// - 매개변수O, 반환값O
		// - applyXXX() 
		
		//매개변수 1개 -> 반환값
		Function<String,Integer> f1 = name -> name.length();
		System.out.println(f1.apply("홍길동"));
		
		Function<String,Integer> f2 = new Function<String, Integer>() {
			@Override
			public Integer apply(String t) {
				return t.length();
			}
		};
		
		Function<Integer,String> f3 = num -> num % 2 == 0 ? "짝수" : "홀수";
		System.out.println(f3.apply(2));
		System.out.println(f3.apply(7));
		
		
		BiFunction<Integer, Integer, String> f4 = (a, b) -> a > b ? "크다" : "작다";
		System.out.println(f4.apply(10, 2));
		
		
	}

	private static void m2() {
		
		//Supplier
		// - 반환값만 제공(공급)하는 역할
		// - getXXX() 메소드를 제공하는 함수형 인터페이스
		
		Supplier<String> s1 = () -> { return "문자열"; };
		Supplier<String> s2 = () -> "문자열";
		
		System.out.println(s1.get());
		System.out.println(s2.get());
		
		
		Supplier<Integer> s3 = () -> {
			Calendar c = Calendar.getInstance();
			return c.get(Calendar.HOUR_OF_DAY);
		};
		System.out.println(s3.get());
		
		
		Supplier<User> s4 = () -> new User("홍길동", 20);
		User hong = s4.get();
		System.out.println(hong);
		
		
		Supplier<User[]> s5 = () -> new User[] { new User("가가가", 20), new User("나나나", 22), new User("다다다", 25) };
		User[] list = s5.get();
		System.out.println(Arrays.toString(list));
		
		
		Supplier<List<User>> s6 = () -> {
			List<User> alist = new ArrayList<User>();
			alist.add(new User("라라라", 20));
			alist.add(new User("마마마", 20));
			return alist;
		};
		List<User> result = s6.get();
		System.out.println(result);
		
		
		Supplier<Double> s7 = () -> Math.random();	//범용
		DoubleSupplier s8 = () -> Math.random();	//전용(Double)
		
	}

	private static void m1() {
		
		//Consumer
		// - 매개변수를 받아서 소비하는 업무 구현
		// - acceptXXX() 메소드를 제공하는 함수형 인터페이스
		
		Consumer<String> c1 = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.printf("%s : 글자수 %d\n", t, t.length());
			}
		};
		
		Consumer<String> c2 = t -> System.out.printf("%s : 글자수 %d\n", t, t.length());
		
		c1.accept("문자열");
		c2.accept("문자열2");
		
		Consumer<Integer> c3 = num -> {
			for (int i=0; i<num; i++) {
				System.out.println(i);
			}
		};
		
		c3.accept(10);

		
		Consumer<User> c4 = user -> System.out.println(user.name);
		c4.accept(new User("홍길동", 20));
		
		Consumer<User> c5 = user -> {
			if(user.age > 18) {
				System.out.println(user.name + ": 성인");
			} else {
				System.out.println(user.name + ": 미성년자");
			}
		};
		c5.accept(new User("홍길동", 20));
		
		
		//매개변수 2개짜리
		BiConsumer<String,Integer> bc1 = (name, age) -> {
			User user = new User(name, age);
			System.out.println(user);
		};
		
		bc1.accept("아무개", 33);
		
		//Consumer<Integer> 
		//책 802p~ 
		IntConsumer ic1 = num -> System.out.println(num);
		ic1.accept(100);
		
	}

}

class User {
	
	public String name;
	public int age;
	
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
	
	
}