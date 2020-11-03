package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_use_01 {
	
	public static void main(String[] args) throws Exception {
		
//		m1();
//		m2();
//		m3();
//		m4();
		m5();
		
	}

	private static void m5() {

		//제어문(반복문) + break + continue
		//1. break
		// - 자신이 속한 제어문을 탈출한다.(***if문은 제외***)
		// - 루프를 해당 회차에 완전 종료시킴
		//2. continue
		// - 자신이 속한 제어문의 처음으로 돌아감.
		// - 루프를 해당 회차만 실행하지 않고 통과함.
		
//		for (int i=1; i<=10; i++) { // Dead code -> 1회만 하고 빠져나가기 때문에..
//			System.out.println(i);
//			break;
//		}
		
//		for (int i=1; i<=10; i++) { 
//			break;
//			System.out.println(i); // Unreachable code
//		}
		
		for (int i=1; i<=10; i++) { 
			
			if (i == 5) {
//				break; //if문은 break의 대상에서 제외되기 때문에 for문을 탈출해야 할 대상으로 인식함.
				continue; //5가 출력안됨. for문의 첫위치로 이동 -> 아래의 print 구문은 skip함
			}
			
			System.out.println(i); 
		}
		
		//선생님 + 학생 상담(30명)
		
		for (int i=1; i<=30; i++) {
			
			//반복 흐름 제어
//			if (i == 15) { //14번 까지만..
//				break;
//			}
			if (i == 15 || i == 17 || i == 25) { // 15, 17, 25번 학생이 결석..
				continue;
			}
			System.out.printf("선생님이 %d번 학생을 상담 중.. \n", i);
			
		}
		
	}

	private static void m4() throws Exception {
		
		//요구사항) 사용자에게 숫자 10개를 입력받아 그 수들의 합을 구하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		
		for (int i=1; i<=10; i++) {
				
		System.out.print("숫자 : ");
		int num = Integer.parseInt(reader.readLine());
		
		sum += num;
		
		}
		
		System.out.println(sum);
	}

	private static void m3() {

		//누적 Loop
		//1~10까지의 합을 구하시오.
		//1 + 2 + 3 + ... + 10 = 55
		
		//무언가의 누적값을 구해야 할 경우
		//1. 누적값을 저장할 변수 생성, 누적변수
		int sum = 0;
		
		//2. 누적시킬 수들의 열을 반복문을 통해 만든다. -> 수열 생성
		//1, 2, 3, 4, 5 ..., 10
		
//		for (int i=1; i<=10; i++) {			
//			sum += i;			
//		}
		
		for (int i=0; i<=100; i+=7) {
			sum += i;
		} //0~100사의의 7의 배수의 누적합 구하기
		System.out.println(sum);
	}

	private static void m2() {
		
		int a = 10; // a: 지역변수(m2)
		
		if (a > 0) {
			
			int b = 20; // b: 지역변수(if)
		}
		
		for (int i=1; i<=5; i++) { // i: 지역변수(for)********* -> for문이 5번 돌 동안 계속 살아있음. 1번 생성되어 1번 죽음. 생명주기가 더 길다.
			
			int c = 30; // c: 지역변수(for) -> for문이 5번 돌기 때문에 5번 생성되었다가 5번 죽음
			
		}
		
	}

	private static void m1() {
		
		//구구단 한단 한줄씩 출력
		
		int dan = 9;
		
		for (int i=1; i<=9; i++) {
			System.out.printf("%d x %d = %2d\n", dan, i, dan * i);
		}
	
	}

}
