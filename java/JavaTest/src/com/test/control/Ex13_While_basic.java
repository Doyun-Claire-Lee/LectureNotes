package com.test.control;

public class Ex13_While_basic {
	
	public static void main(String[] args) {
		
		//m1();
		m2();

	}

	private static void m2() {
		
		/*
		
		do while문 (요즘 잘 안쓰긴 함..콘솔에서는 많이 사용했음)
		
		while문 -> 선조건, 후실행
		do while문 -> 선실행, 후조건 (조건을 만족 못함에도 불구하고 최소 1회는 실행이 됨)
		
		do {
			실행코드;
		} while (조건);
		
		*/
		
		int n = 11;
		
		do {
			System.out.println(n);
			n++;
		} while (n<=10);
		
	}

	private static void m1() {
			
		/*
		
		While 문
		 - for문과 유사
		 - 조건에 따라 반복제어
		 - 조건식을 만족하는 동안 반복을 한다.
		
		while (조건식) {
			실행코드;
		}
		
		*/
				
		//숫자 1 ~ 10까지 출력하기
		
		for (int i=1; i<=10; i++) {
			System.out.printf("%d  ", i);
		}
		System.out.println();
		
		int num = 1;
		while (num <=10) {
			System.out.printf("%d  ", num);
			num++;
		}
		System.out.println();
		
		//while문 연습 -> for문 예제 + 문제를 while로 다시 풀기..
		
		
		//누적값 구하기, 누적값이 1000이 넘으면 Stop -> 몇번 돌지를 모르는 코드
		//for문으로 작성
		int sum = 0;
		int i = 1;
		
		for (i=1; ; i++) {
			
			sum += i;
			
			if (sum >= 1000) {
				break;
			}			
		}
		System.out.println(i);
		System.out.println(sum);
		
		//while문으로 작성
		
		sum = 0;
		num = 1;		
		
		while (true) {
			
			sum += num;
			num++;
			
			if (sum>=1000) {
				break;
			}
			
		}
		
		System.out.println(num);
		System.out.println(sum);
		
		//다시작성
		
		sum = 0;
		num = 1;
		
		while (sum < 1000) {
			sum += num;
			num++;
		}
		
		System.out.println(num);
		System.out.println(sum);
		
		sum = 0;
		i = 0;
		
		for (i=1; sum<1000; i++) {
			sum += i;
		}
	
		System.out.println(i);
		System.out.println(sum);
		
	} //m1

}
