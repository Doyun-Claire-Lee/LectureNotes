package com.test.object;

import java.util.Calendar;

public class Ex34_Generic_use_01 {
	
	public static void main(String[] args) {
		
		//일반클래스, 추상클래스, 인터페이스, 열거형, 제네릭 클래스
		
		
		//제네릭 클래스, Generic class
		
		
//		m1();
//		m2();
		
		WrapperInt n1 = new WrapperInt(100);
		System.out.println(n1.getData() + 50);
		n1.setData(200);
		System.out.println(n1);
		
		WrapperObject n2 = new WrapperObject(300); //Boxing
		System.out.println((int)n2.getData() + 50);
		n2.setData(400);
		System.out.println(n2);
		
		Wrapper<Integer> n3 = new Wrapper<Integer>(500);
		System.out.println(n3.getData() + 50); //다운캐스팅을 안해도 됨.
		n3.setData(600);
		System.out.println(n3);
		

		System.out.println();
		
		
		WrapperString s1 = new WrapperString("홍길동");
		System.out.println(s1.getData().length());
		s1.setData("아무개");
		System.out.println(s1);
		
		WrapperObject s2 = new WrapperObject("유재석"); 
		System.out.println(((String)s2.getData()).length());
		s2.setData("강호동");
		System.out.println(s2);
		
		Wrapper<String> s3 = new Wrapper<String>("문자열123");
		System.out.println(s3.getData().length());
		s3.setData("문자열1234");
		System.out.println(s3);

		
		System.out.println();
		
		
		WrapperBoolean b1 = new WrapperBoolean(true);
		System.out.println(b1.getData() ? "참" : "거짓");
		b1.setData(false);
		System.out.println(b1);
		
		WrapperObject b2 = new WrapperObject(true); 
		System.out.println(((boolean)b2.getData() ? "참" : "거짓"));
		b2.setData(false);
		System.out.println(b2);
		
		Wrapper<Boolean> b3 = new Wrapper<Boolean>(true);
		System.out.println(b3.getData() ? "참" : "거짓");
		b3.setData(false);
		System.out.println(b3);
		
	}//main

	private static void m2() { //블럭잡고 마우스오른쪽버튼 - refactor - Extract method로 간편하게 생성 가능
		
		UserTime t1 = new UserTime(2, 30);
		System.out.println(t1); //com.test.object.UserTime@15db9742 -> 패키지명.클래스명@해시코드 값 나옴. 쓸모없음. 
		System.out.println(t1.toString()); //동일 결과 나옴. (toString 재정의 전)
		
		Calendar c1 = Calendar.getInstance();
		System.out.println(c1);	//위의 결과와 다른값이 나옴. 
		System.out.println(c1.toString()); //캘린더 클래스가 toString()을 오버라이드(재정의)
		
		//모든 자바 개발자는
		//객체.toString()은 객체가 가지는 데이터를 문자열로 반환한다고 기대함. 따라서 클래스를 만들 때 toString 오버라이드 하는것이 매너
	}
	
	public static void m1() {
		
		int a = 10;						//값형에서 정수를 담당
		Integer b = new Integer(10);	//참조형에서 정수를 담당 ,Wrapper Class, Util Class
		//위의 두가지를 동급 취급하여 연산까지 가능함. 내부적으로 언박싱이 이루어지기 때문
		System.out.println(a + b);
		long c = 10;
		Long d = new Long(10);
		//char 빼고 다른 값형 자료형들은 각각 클래스가 있음.
		
//		Integer.parseInt(); => static 메소드인 이유.. -> 동일한 결과(숫자로 변환)을 반환하기 때문에
//		Integer.MAX_VALUE;  => static 변수, final 변수(읽기 전용이라는 의미)
		
	}

}//Ex34

//요구사항
// - int값을 중심으로 이루어지는 여러가지 행동을 하는 클래스 생성하기
//1. int값 하나를 중심으로 그 값을 조작하는 클래스를 설계하시오.
//2. String값 하나를 중심으로 그 값을 조작하는 클래스를 설계하시오. -> String 변수는 Int변수로 변환이 불가능하기때문에 WrapperInt클래스의 코드는 재사용이 불가능함..
//3. boolean값 하나를 중심으로 그 값을 조작하는 클래스를 설계하시오.
//4. double
//5. byte
//6. char
//7. short
//8. long
//9. float
//10. Random
//11. Calendar
//12. UserTime 등등... 끝이 없는 클래스 생성작업을 반복하게 됨, 최소한으로 작업하는 방법 2가지 존재


class WrapperInt {
	
	private int data; //중심 데이터
	
//	public WrapperInt() {
//		this.data = 0;
//	} //기본 생성자 - 개발자가 다른 생성자를 하나라도 만들면 자동으로 생성되지 않음. 생성자를 따로 만들 경우 기본 생성자를 직접 만드는 경우가 대부분임.
	
	public WrapperInt(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return this.data + ""; //String.valueOf(this.data)
	}
	
}

class WrapperString {
	
	private String data; //중심 데이터
		
	public WrapperString(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return this.data; 
	}
}

class WrapperBoolean {
	
	private boolean data; //중심 데이터
	
	public WrapperBoolean(boolean data) {
		this.data = data;
	}
	
	public boolean getData() {
		return data;
	}
	
	public void setData(boolean data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return this.data + ""; 
	}
}

class WrapperObject {
	
	private Object data; //**********************모든 데이터를 담을 수 있는 변수
	
	public WrapperObject(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override //마우스 오른쪽 -> source -> generate toString() 
	public String toString() {
		return "WrapperObject [data=" + data + "]";
	}
		
}


//WrapperObject
class Wrapper<T> {
	
	private T data;
	
	public Wrapper(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Wrapper [data=" + data + "]";
	}
	
}


class UserTime {
	
	private int hour;
	private int min;
	
	public UserTime(int hour, int min) {
		this.hour = hour;
		this.min = min;
	}
	
	//toString 재정의
	@Override
	public String toString() {
		return String.format("%d:%d", this.hour, this.min);

	}
	
	
}
