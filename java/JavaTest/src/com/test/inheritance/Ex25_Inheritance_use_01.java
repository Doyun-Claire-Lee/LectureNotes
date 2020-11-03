package com.test.inheritance;

import java.util.Random;

public class Ex25_Inheritance_use_01 {
	
	public static void main(String[] args) {
		
		//난수 생성기
		//상황) 난수 발생 잦음 > Random 클래스 의존도 높음
		//1. nextInt() : -21억 ~ 21억 자주 씀
		//2. 1 ~ 10사이 난수 자주 발생시켜야 함. 추가 업무 필요
		//3. 색상 난수 : 추가 난수 필요
		//4. nextBoolean() : true, false
		//5. nextDouble() : 나중에 추가로 필요
		//6. nextLong() : 나중에 추가로 필요
		

//		m1();
//		m2();
//		m3();
		m4();
		
		
		
	}

	private static void m4() {
		
		//상속으로 처리
		//MyRandom class
		
		MyRandom rnd = new MyRandom();
		
		//1. 
		System.out.println(rnd.nextInt());
		
		//2. 
		System.out.println(rnd.nextSmallInt());
		
		//3. 
		System.out.println(rnd.nextColor());
		
		//4. 
		System.out.println(rnd.nextBoolean());
		
		//5. 
		System.out.println(rnd.nextDouble());
		
		//6. 
		System.out.println(rnd.nextLong());
		
	}

	private static void m3() {
		
		//코드 재사용 도구 -> 제어문(반복문), 메소드, 클래스, 상속
		//MyUtil 클래스 생성
		
//		Random rnd = new Random();
		MyUtil m = new MyUtil();
		
		//1.
//		System.out.println(rnd.nextInt());
		System.out.println(m.nextInt());
		
		//2. 
		System.out.println(m.nextSmallInt());
		
		//3.
		System.out.println(m.nextColor());
		
		//4. 
//		System.out.println(rnd.nextBoolean());
		System.out.println(m.nextBoolean());
		
	}

	private static void m2() {
		
		//직접 구현하기(Random 클래스 이용)
		Random rnd = new Random();
		
		//1. 
		System.out.println(rnd.nextInt());
		
		//2. 1~10
		System.out.println(rnd.nextInt(10)+1);

		//3. 색상 난수
		String[] color = {"빨강", "노랑", "파랑", "흰색", "검정"};
		System.out.println(color[rnd.nextInt(color.length)]);
		
		//4. 
		System.out.println(rnd.nextBoolean());
		
		
		
		
		
		
		
	}

	private static void m1() {
		
		//난수 생성
		//1. Math.random() -> 다른 언어에서 주로 사용하는 방법
		//2. Random 클래스
		
		Random rnd = new Random();
		System.out.println(rnd.nextInt()); 		//int타입 난수 반환 -21억 ~ +21억
		System.out.println(rnd.nextInt(10)); 	//0부터 입력한 숫자 전까지 반환
		System.out.println(rnd.nextBoolean());
		System.out.println(rnd.nextDouble());
		System.out.println(rnd.nextLong());
		
		
		
	}

}
