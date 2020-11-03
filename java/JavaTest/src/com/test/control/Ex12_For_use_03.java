package com.test.control;

public class Ex12_For_use_03 {
	
	public static void main(String[] args) {
		
//		m1();
//		m2();
		m3();
		
		
	}

	private static void m3() {
		
		//별찍기..
		
		for (int i=0; i<5; i++) {
			
			for (int j=0; j<5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		
			
		for (int i=0; i<5; i++) { //행
			
			for (int j=0; j<=i; j++) { //열
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		
		
		for (int i=0; i<5; i++) {
			
			for (int j=i; j<5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		
	}

	private static void m2() { 
		
		
		for (int i=0; i<10; i++) {
			
			for (int j=0; j<10; j++) {
				
//				if ( i == 5 ) {
////					break; // 자신이 포함된 제어문을 탈출 -> j for문을 자신이 포함된 제어문이라 생각
//					continue;
//				}
				
				if ( j == 5) {
//					break;
					continue;
				}
				
				System.out.printf("i : %d, j : %d\n", i, j);
			}
			
			System.out.println();
		}
		
	}

	private static void m1() {
		
		//구구단
		
		for (int i=2; i<10; i++) {
			
			for (int j=1; j<10; j++) {
				
				System.out.printf("%d x %d = %2d\n", i, j, i * j);
			}
			
			System.out.println();
		}
		
		
	}

}
