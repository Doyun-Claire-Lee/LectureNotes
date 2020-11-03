package com.test.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex12_For_assignment_11 {
	
	public static void main(String[] args) throws Exception {
		
		myBank();
		
	}

	private static void myBank() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("My Bank를 시작합니다.");
		 
		boolean loop = true;
		int balance = 100000;
		int password = 1234;
		
		
		for (;loop;) {
			
			System.out.println("======================");
			System.out.println("        My Bank       ");
			System.out.println("======================");
			System.out.println("1. 계좌 입급");
			System.out.println("2. 계좌 출금");
			System.out.println("3. 잔액 조회");
			System.out.println("4. 종료");
			System.out.println("======================");
			System.out.print("선택(번호) : ");
			int input = Integer.parseInt(reader.readLine());
			
			if (input == 1) {
				System.out.println();
				System.out.println("======================");
				System.out.println("       계좌 입금      ");
				System.out.println("======================");
				System.out.print("계좌 비밀번호 : ");
				int inputPW = Integer.parseInt(reader.readLine());
				
				if (password == inputPW) { 
					
					System.out.print("입금액: ");
					int deposit = Integer.parseInt(reader.readLine());
					balance += deposit;
					System.out.printf("%,d원이 입금되었습니다.\n", deposit);
					
					pause();			
					
				} else {
					
					System.out.println("비밀번호가 틀렸습니다.");
					pause();
				}
				
				
			} else if (input == 2) {
				
				System.out.println();
				System.out.println("======================");
				System.out.println("       계좌 출금      ");
				System.out.println("======================");
				System.out.print("계좌 비밀번호 : ");
				int inputPW = Integer.parseInt(reader.readLine());
				
				if (password == inputPW) { 
							
					System.out.print("출금액: ");
					int withdraw = Integer.parseInt(reader.readLine());
					
					if (balance >= withdraw) {
						
						balance -= withdraw;
						System.out.printf("%,d원이 출금되었습니다.\n", withdraw);
						
						pause();	
					} else {
						System.out.println("잔액이 부족합니다.");
						pause();
					}
					
				} else {
					System.out.println("비밀번호가 틀렸습니다.");
					pause();
				}
				
			} else if (input == 3) {
				
				System.out.println();
				System.out.println("======================");
				System.out.println("       잔액 조회      ");
				System.out.println("======================");
				System.out.printf("현재 잔액 : %,d원\n", balance);
				
				pause();
				
			} else { 
				System.out.println("My Bank를 종료합니다.");
				loop = false;
			}
			
		}
		
	}
	
	public static void pause() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("계속하시려면 엔터를 입력하세요.");
		String pause = reader.readLine();
		
		
	}

}
