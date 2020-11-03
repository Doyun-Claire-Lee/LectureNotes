package com.test.array;

import java.util.Calendar;

public class Ex15_Array_use_01 {
	
	public static void main(String[] args) {
		
		//m1();
		//m2();
		//m3();
		m4();
		
	}

	private static void m4() {
		
		//배열 복사
		
		int a = 10;
		int b;
		b = a; //값 복사
		System.out.println(b);
		
		int[] list1 = new int[3];
		list1[0] = 100;
		list1[1] = 200;
		list1[2] = 300;
		
		int[] list2 = new int[3];
		
		//****list1에 들어있는 배열의 "주소값"을 list2에 복사함. -> 주소값 복사
		list2 = list1;
		System.out.println(list2[0]);
		
		list1[0] = 1000;
		System.out.println(list1[0]);
		System.out.println(list2[0]); //****원 배열에서 일어난 변화가 복사본에서도 나타남. 모든 참조형 변수에서 나타나는 현상(문자열 제외)
		
		//배열에 어떤 자료가 있는지 알아보고 싶을 때 
		
		view(list1);
		//***주의 : 다른 메소드에 리스트를 인자값으로 넘기면 주소값 복사가 일어남. 
		//			따라서 다른 메소드 내에서라도 리스트값에 변화를 주면 원데이터에도 변화(훼손)가 생김.
		
		
	}
	
	private static void view(int[] list1) {
		
		for(int i=0; i<list1.length; i++) {
			System.out.printf("i : %d\n", list1[i]);
		}
		
		
		
	}

	private static void m3() {
		
		//********메모리의 모든 공간은 한번 만들어지면 그 크기(용도, 형태)를 변화시킬 수 없다(불변).
		// -> 배열에도 적용 -> "배열의 길이는 불변이다."
		
		//배열의 길이를 동적 할당이 가능하다.
		//사용자에게 3을 입력받았다고 쳤을 때,
		
		int num = 3;
		int[] list = new int[num];
		System.out.println(list.length);
		
		//한번 만들어지면 길이는 불변임.
		
		
		
	}

	private static void m2() {
		
		//여러 자료형 + 배열
		
		//정수 배열(byte, short, int, long)
		
		//a의 자료형? short
		short a = 10;
		
		//list1의 자료형? short 1차원 배열
		short[] list1 = new short[3];
		
		//list[0]의 자료형? short
		list1[0] = 10;
		
		System.out.println(list1[0]);
		
		
		
		//실수 배열(float, double)
		double[] list2 = new double[3];
		list2[0] = 3.14;
		System.out.println(list2[0]);
		
		
		//문자형 배열
		char[] list3 = new char[3];
		list3[0] = 'a';
		System.out.println(list3[0]);
		
		
		//논리형 배열
		boolean[] list4 = new boolean[3];
		list4[0] = true;
		System.out.println(list4[0]);
		
//=====================================================================================================================================
		
		//문자열 배열
		String[] list5 = new String[3];
		list5[0] = "홍길동";
		System.out.println(list5[0]);
		
		//캘린더 배열
		Calendar[] list6 = new Calendar[3];
		list6[0] = Calendar.getInstance();
		System.out.println(list6[0]);
		
		
	}

	private static void m1() {
		
		//배열의 방번호는 for문의 루프변수(i)와 비슷
		
		int[] list = new int[10];
		
		//방 10개에 값 대입하기(난수)
		//값을 넣기 전에는 모두 NULL값을 가짐.
		//배열 탐색 루프
		for (int i=0; i<list.length; i++) {
			
			int n = (int)(Math.random() * 100); //0~99			
			list[i] = n;			
			
		}
		
		//출력
		
		for (int i=0; i<list.length; i++) {
			System.out.printf("list[%d] = %d\n", i, list[i]);
		}
		
		System.out.println(list[list.length-1]); //최대 방번호
//		System.out.println(list[list.length]); //없는 방번호를 출력할 경우?
		//java.lang.ArrayIndexOutOfBoundsException 에러
		
		
	}

}
