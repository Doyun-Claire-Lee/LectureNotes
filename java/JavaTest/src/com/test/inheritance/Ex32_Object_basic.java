package com.test.inheritance;

import java.util.Calendar;
import java.util.Random;

import org.omg.CORBA.OBJ_ADAPTER;

public class Ex32_Object_basic {
	
	public static void main(String[] args) {
		
		//Object 클래스
		// - java.lang.Object
		// - 중요 클래스
		// - 모든 클래스의 슈퍼(부모)클래스
		
		Temp t = new Temp();
		t.a = 10;
//		t.equals();
//		t.hashCode()
//		t.toString()
		System.out.println(t.hashCode()); //객체의 메모리 주소값.. 임시 ID 등으로 쓰임.
		System.out.println(t.toString());
		
		//Object 변수 -> 만능 주머니!
		//참조형
		Object o1 = new Object(); //쓸모가 없음,,
		Object o2 = new AA();
		Object o3 = new BB();
		Object o4 = new CC();
		Object o5 = new Random();
		Object o6 = Calendar.getInstance();
//		Object o6 = new Calendar(); 가 왜 아닌지..? -> 태국 빼고 다 그레고리력을 사용하고 있는데 태국만 다른 달력 사용.. 지역간 차이를 없애기 위해 메소드로 if문을 넣어두었기 때문.
//													-> Calendar는 추상 클래스임. 
		Object o7 = "홍길동";
		
		//값형인데 참조형 변수 안에 저장이 가능하다.
		Object o8 = 10;
		Object o9 = true;
		
		Object[] list = new Object[10]; //아무거나 담을 수 있는 배열 *** 많이 씀!
		
		
		
		Random rnd2 = new Random();	//가장 직관적인 방법
		
		Object rnd1 = new Random();	//random의 메소드는 보이지 않음.. 다운캐스팅을 해야함.
		list[0] = new Random();		//배열에 여러 자료형을 넣어야 할 때..
		
		//문제점 : 원래 어떤 타입의 변수인지 선언된 부분을 찾아야만 알 수 있음.. -> 다운캐스팅을 하려 해도 원래 자료형을 찾아야 함.
		
		System.out.println(((Random)rnd1).nextInt());	//괄호 주의** 우선순위 주기
		System.out.println(((Random)list[0]).nextInt());
		

		//****박싱과 언박싱****
		//오브젝트 변수에 값형 자료를 저장할 때! (참조형<->참조형은 아님, 단순 다운캐스팅)
		int num1 = 10;
		Object num2 = 20; 	//오브젝트 변수에 값형 자료를 저장하는 순간 new Integer(20);과 같은 구문이 자동으로 실행(박싱)되고,
						  	//Heap영역에 20이라는 값을 저장한 Integer클래스 변수(wrapper class)가 생성되어 그 주소값이 num2에 저장됨.
							//성능이 저하됨. 
		
		System.out.println(num1 + 10);
//		System.out.println(num2 + 10); //The operator + is undefined for the argument type(s) Object, int
		System.out.println((int)num2 + 10); //언박싱 -> 자료형만 바꾸는 것이 아닌, 객체로 되어있던 것 중에 데이터만 빼옴.		
		
		
		
		
		AA a = new AA();
		AA b = new BB();	//업캐스팅
		AA c = new CC();	//업캐스팅
		
	}//main

}//Ex32

class AA {
}
class BB extends AA {
}
class CC extends BB {	
}

//Class Object is the root of the class hierarchy.Every class has Object as a superclass. All objects,including arrays, implement the methods of this class.
class Temp extends Object { //extends Object : 평소에는 생략이 되며 부모 클래스를 따로 지정해 주지 않으면 모든 일반 클래스가 자동으로 상속받게 됨.
	public int a;
}