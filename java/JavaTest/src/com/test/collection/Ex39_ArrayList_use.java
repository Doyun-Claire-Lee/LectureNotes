package com.test.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex39_ArrayList_use {
	
	public static void main(String[] args) {
		
//		m1();
//		m2();
		m3();
		
	}

	private static void m3() {
		
		//배열: 길이 불변
		//컬렉션: 길이 가변, 배열 Wrapper class
		
		ArrayList<Integer> list = new ArrayList<Integer>(1000); //처음부터 1000칸으로 시작함.
		System.out.println(list.size());
		
		for (int i=0; i<1000; i++) {
			//10 -> 20 -> 40 -> 80 -> 160 -> 320 -> 640 -> 1280칸으로 배가 됨. 중간 과정에서 버려지는 자원들이 많다.. -> 낭비임.
			//데이터가 많은 배열은 미리 큰 배열을 만들어 두는 것이 좋음.
			list.add(i);
		}
		System.out.println(list.size());
		
		list.trimToSize();	//현재 데이터의 갯수와 동일한 배열로 교체. 데이터 없이 낭비되는 배열을 방지하기 위함..
							//더이상 데이터를 추가하지 않을 거란 강한 확신이 있을 때만 사용
 		
	}

	private static void m2() {
		
		//요소의 타입
		//1. 단일값 배열
		//2. 다중값 배열
		
		int[] list1 = new int[3]; 			//단일값 배열(방 = int)
		String[] list2 = new String[3]; 	//단일값 배열(방 = String)
		Item[] list3 = new Item[3];			//다중값 배열(방 1개 = int2, String1)
		
		ArrayList<Integer> list4 = new ArrayList<Integer>();	//단일값 배열
		ArrayList<String> list5 = new ArrayList<String>();		//단일값 배열
		ArrayList<Item> list6 = new ArrayList<Item>(); 			//다중값 배열
		
		list3[0] = new Item();
		list3[1] = new Item();
		list3[2] = new Item();
		
		list3[0].a = 100;
		list3[0].b = 200;
		list3[0].c = "홍";
		
		list6.add(new Item());
		list6.add(new Item());
		list6.add(new Item());
		
		list6.get(0).a = 100;
		list6.get(0).b = 200;
		list6.get(0).c = "홍";
		
		
		int[][] list7 = new int[2][3];
		list7[0][0] = 100;
		
		ArrayList<ArrayList<Integer>> list8 = new ArrayList<ArrayList<Integer>>();
		list8.add(new ArrayList<Integer>());
		list8.add(new ArrayList<Integer>());
		
		ArrayList<Integer> sub = new ArrayList<Integer>();
		sub.add(700);
		sub.add(800);
		sub.add(900);
		list8.add(sub); //변수에 1차원 컬렉션 생성 후 그 컬렉션을 다른 컬렉션에 대입하는 방법도 있음.
		
		list8.get(0).add(100);	//list.get(int index) 의 리턴 타입 -> ArrayList<Integer>
		list8.get(0).add(200);
		list8.get(0).add(300);
		
		list8.get(1).add(400);
		list8.get(1).add(500);
		list8.get(1).add(600);
		
		
	}

	private static void m1() {
		
		//배열 vs ArrayList
		// - 길이를 고정시켜야 하는지?
		
		//요구사항) 학생 명단 관리
		// 1. 인원수 5명 고정 >> 배열 사용
		
//		Scanner scan  = new Scanner(System.in);
//		
//		String[] names = new String[5];
//		
//		for (int i=0; i<names.length; i++) {
//			System.out.print("이름 : ");
//			names[i] = scan.nextLine();
//		}
//		
//		System.out.println();
//		System.out.println(Arrays.toString(names));
		
		
		//2. 인원수 불확실 >> ArrayList 사용
		
		Scanner scan  = new Scanner(System.in);
		
		ArrayList<String> names = new ArrayList<String>();
		
//		int count = 5;
//		
//		for (int i=0; i<count; i++) {	//names.size() 쓰면 안됨. 아무것도 add되지 않으면 초기 사이즈는 0이기 때문
										// for문이 도는 횟수를 고정해놓으면 arraylist의 실익이 없어 아래와 같이 이용(무한루프)
		
		for (;;) {
			System.out.print("이름 : ");
			String input = scan.nextLine();
			
			if (input.equals("exit")) {
				break;
			}
					
			names.add(input);
		}
		
		System.out.println();
		System.out.println(names);
		
	}

}

class Item {
	public int a;
	public int b;
	public String c;
}