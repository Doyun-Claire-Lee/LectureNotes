package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_use_02 {
	
	public static void main(String[] args) throws Exception {
		
//		m1();
//		m2();
//		m3();
//		m4();
		m5();
		
	}


	private static void m5() {
		//난수 생성 방법
		// - 임의의 수(숫자)
		
		//Math 클래스 - 범용***
		//Random 클래스 - 완전 자바 기반, 자바에서만 흔히 봄
		
		//난수 생성기 메소드
		//- 0(포함) ~ 1(미포함) 사이 실수 반환	
//		System.out.println(Math.random());
		
		//ex)임의의 1~10 사이의 정수를 얻고싶을 때
		double num = Math.random();
		System.out.println((int)(num * 10) + 1); 
		
		//ex) 3~7사이의 난수
		num = Math.random();
//		System.out.println(num);
//		System.out.println(num * 10);
//		System.out.println((int)(num * 5)); // 0 ~ 4
		System.out.println((int)(num * 5) + 3); //*****************
		
		
		
	}


	private static void m1() {

		//무한 루프에 가까운 루프, 21억바퀴쯤 돈다. 언더플로우가 발생하면 끊김.
		for(int i=0; i<10; i--) {
			System.out.println(i);
		}
		
	}
	private static void m2() {
		
		//인위적인 무한 루프(필요하여 생성하는 경우가 있음)
		//컴퓨터가 망가지기 전까지 계속 돌아감. 
		for(;;) {
			
			System.out.println(System.currentTimeMillis());
			
		}
		
	}
	public static void m3() {
		
		//int 최대값에 도달하면 음수(최소값)으로 돌아간 후 다시 1씩 증가함.
		for (int i=2147000000; true; i++) { //true는 생략해도 되긴 함..
			System.out.println(i);
		}
	}
	
	
	
	//간단한 프로그램 만들기? ----------------------------------------------------------------------------------------
	
	public static void m4() throws Exception { 
		
		//프로그램 시작 -> (메뉴 출력 -> 메뉴 선택 -> 선택 기능 실행 -> 마침) X 반복 -> 프로그램 종료
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("프로그램 시작");
		
		boolean loop = true;
		
		for(;loop;) { //횟수를 알 수 없는 루프인데 조건을 걸어 루프를 빠져나가고 싶을때 이런 방식으로 만듬.
			
			System.out.println("=====================");
			System.out.println(("메뉴"));
			System.out.println("1. 쓰기");
			System.out.println("2. 읽기");
			System.out.println("3. 종료");
			System.out.println("=====================");
			System.out.print("선택 : ");
			String input = reader.readLine();
			
			if (input.equals("1")) {
				//쓰기
				write();
			} else if (input.equals("2")) {
				//읽기
				read();
			} else {
				loop = false;
			}
		}
		
		System.out.println("프로그램 종료");
		
	}


	private static void read() throws Exception {
		System.out.println("쓰기작업");	
		pause();
	}


	private static void write() throws Exception {
		System.out.println("읽기작업");	
		pause();
	}


	private static void pause() throws Exception {
		//잠시 멈추기 작업
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//사용자 입력을 받기 위해 기다리고 있음.. 잠시 쉬어가는 역할 
		System.out.println("계속하시려면 [엔터]를 입력하세요.");
		reader.readLine();

		
	}
	
	

}
