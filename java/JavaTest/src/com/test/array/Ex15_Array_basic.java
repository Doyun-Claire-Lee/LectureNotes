package com.test.array;

import java.util.Arrays;

public class Ex15_Array_basic {
	
	public static void main(String[] args) {
		
		//자바(객체 지향 프로그래밍 언어)에서 중요한 부분 : 제어문, 배열, 클래스
		// - 자료 구조 : 보통 배열로 만듬.
		// - 알고리즘 : 제어문 + 배열
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
//		project();
		//m7();
		//m8();
		//m9();
		m10();
		

	}

	private static void m10() {
		
		//2차원 배열의 쓰임
		//성적 데이터
		// - 학생 3명
		// - 과목 3과목
		// - 점수 0~100
		// - 총점, 평균
		
		int student = 3;
		
		String[] name = new String[student];
		int[][] score = new int[student][3];
		
		name[0] = "김땡땡";
		name[1] = "이땡땡";
		name[2] = "박땡땡";
		
		for (int i=0; i<score.length; i++) {
			for (int j=0; j<score[0].length; j++) {
				score[i][j] = (int)(Math.random()*41) + 60; //61~100
				
			}
		}
		
		//성적표처럼 출력
		System.out.println("===============================================");
		System.out.println("                    성적표                     ");
		System.out.println("===============================================");
		System.out.println("[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]");
		
		for (int i=0; i<score.length; i++) {
			System.out.printf("%s\t", name[i]);
			
//			System.out.printf("%d\t", score[i][0]);
//			System.out.printf("%d\t", score[i][1]);
//			System.out.printf("%d\t", score[i][2]);
			
			int sum = 0;
			for (int j=0; j<score[0].length; j++) {
				System.out.printf("%5d\t", score[i][j]);
				sum += score[i][j];	
			}
			System.out.printf("%5d\t", sum);
			System.out.printf("%5.1f\t", (double)sum / 3);
			
			System.out.println();
		}
		
		
	}

	private static void m9() {
		
		int[][] nums = new int[5][5];
		
		int n =1;
		
		for (int i=0; i<nums.length; i++) {
			for (int j=0; j<nums[0].length; j++) {
				nums[i][j] = n;
				n++;
			}
		}
		for (int i=0; i<nums.length; i++) {
			for (int j=0; j<nums[0].length; j++) {
				System.out.printf("%5d\t", nums[i][j]);
			
			}
		System.out.println();
		}
		
	}

	private static void m8() {
		
		//배열 초기화 리스트
		int[] num1 = {1, 2, 3, 4};
		
		int[][] num2 = new int[][] {{10, 20, 30}, {40, 50, 60}};
		int[][] num3 = {{10, 20, 30}, {40, 50, 60}};
		
		//new int[2][2][3];
		int[][][] num4 = new int[][][] {{{10, 20, 30}, {40, 50, 60}}, {{70, 80, 90}, {100, 110, 120}}};
		int[][][] num5 = {
							{
								{10, 20, 30}, 
								{40, 50, 60}
							}, 
							{
								{70, 80, 90}, 
								{100, 110, 120}
							}
						};
		
		
		
		
	}

	private static void m7() {
		
		//다차원 배열
		// - 배열은 차수를 가진다.
		// - 1차원 배열
		// - 2차원 배열
		// - 3차원 배열
		
		//1차원
		int[] num = new int[3];
		
		//2차원
		int[][] num2 = new int[2][3]; //2행 3열짜리 테이블이 됨
		
		num2[0][0] = 100;
		num2[0][1] = 200;
		num2[0][2] = 300;
		num2[1][0] = 400;
		num2[1][1] = 500;
		num2[1][2] = 600;
		
		//2차원 배열 탐색 -> 2중 for문
		for(int i=0; i<num2.length; i++) { //행(층)
			
			for (int j=0; j<num2[0].length; j++) { //열(호수)
				System.out.printf("num2[%d][%d] = %d\n", i, j, num2[i][j]);
			}
		}
			
		//자료형?
		//1. num2 -> int[][] :int 2차원 배열
		//1. num2[0][0] -> int 
		//3. num2[0] -> int[] : int 1차원 배열*****
		
		
		//3차원배열
		int[][][] num3 = new int[2][2][3];
		
		for (int i=0; i<2; i++) {
			for (int j=0; j<2; j++) {
				for (int k=0; k<3; k++) {
					num3[i][j][k] = i + j + k;
				}
			}
		}
		
		for (int i=0; i<2; i++) {
			for (int j=0; j<2; j++) {
				for (int k=0; k<3; k++) {
					System.out.println(num3[i][j][k]);
				}
			}
		}
		
		//Arrays.toString() -> 1차원 배열에만 쓰기
		
		
	}

	private static void project() {
		
		//프로젝트 - 학사관리 시스템
		// - 여러 회원 계급 중 학생회원 * 1000명의 데이터(테스트용, 더미 데이터)를 만들어야 할 때 배열 이용?
		// - 회원 정보 구성 
		//		a. 이름 : 문자열
		//		b. 나이 : 정수
		//		c. 성별 : 1:남자, 2:여자
		//		d. 주소 : 문자열
		
		int count = 1000; //인원수
		
		//회원 정보를 저장할 저장소(배열 or 컬렉션)
		String[] name= new String[count];
		int[] age = new int[count];
		int[] gender = new int[count];
		String[] address = new String[count];
		
		//난수화
		// - Math.random()
		
		//기초 데이터
		String[] n1 = { "김", "이", "박", "최", "정", "한", "지", "임", "홍", "유" };
		String[] n2 = { "대", "응", "찬", "준", "윤", "정", "희", "수", "진", "연" };
		
		String[] a1 = { "서울시", "인천시", "대전시", "부산시", "광주시" };
		String[] a2 = { "동대문구", "서구", "남구", "북구", "동구" };
		String[] a3 = { "자양동", "논현동", "대치동", "양재동", "도곡동" };
		
		
		int index = -1;
		String name2 = "";
		
//		index = (int)(Math.random() * n1.length);
//		name2 = n1[index];
//		
//		index = (int)(Math.random() * n2.length);
//		name2 += n2[index];
//		
//		index = (int)(Math.random() * n2.length); 
//		name2 += n2[index];
//		
//		System.out.println(name2);
		
		for (int i=0; i<count; i++) {
			
			name[i] = n1[(int)(Math.random() * n1.length)]
						+ n2[(int)(Math.random() * n2.length)]
						+ n2[(int)(Math.random() * n2.length)];
			age[i] = (int)(Math.random() * 41) +20;
			gender[i] = (int)(Math.random() * 2) + 1;
			address[i] = a1[(int)(Math.random() * a1.length)] + " "
						+ a2[(int)(Math.random() * a2.length)] + " "
						+ a3[(int)(Math.random() * a3.length)] + " "
						+ ((int)(Math.random() * 30) + 1) + "번지";
		}
		
		//확인(출력)
		for (int i=0; i<count; i++) {
			System.out.printf("%s\t %d세\t %s\t %s\n"
									, name[i]
									, age[i]
									, gender[i] == 1 ? "남자" : "여자"
									, address[i]);
		}
		
		
		
		
	}

	private static void m6() {
		
		//dump() 메소드
		
		String[] colors = { "빨강", "노랑", "파랑", "검정", "보라", "주황" };
		
		colors[4] = "black";
		
		//배열 탐색 + 출력 : Arrays.toString(배열이름)
		//System.out.println(Arrays.toString(colors)); //개발자가 배열을 확인하고 싶을 때 주로 씀
		
	}

	private static void m5() {

		//배열 초기화 리스트, 배열 초기자 -> {}
		int[] nums = new int[5];
		
		nums[0] = 100;
		nums[1] = 80;
		nums[2] = 99;
		nums[3] = 75;
		nums[4] = 91;
		
		int[] nums2 = new int[] { 100, 80, 99, 75, 91};

		for(int num : nums2) {
			System.out.println(num);
		}
		
		String[] names = new String[] { "가", "나", "다" };
		System.out.println(names[1]);
		
		int[] nums3 = {10, 20, 30, 40, 50}; //**********************주로 많이 씀.
		//위와 같이 쓸수 없는 경우
		
		int[] nums4;
		nums4 = new int[] {10, 20, 30}; //됨
		
		int nums5;
//		nums5 = {10, 20, 30}; // 안됨..
		
	}

	private static void m4() {
		
		//배열 초기화 ******
		// - 모든 참조형은 생성된 직후에 변수들이 특정값으로 자동 초기화가 된다.
		// - 이유 : 클래스 생성자 (?)
		// 1. 정수 -> 0
		// 2. 실수 -> 0.0
		// 3. 문자 -> \0 (널문자)
		// 4. 논리 -> false
		// 5. 참조 -> null (String 포함)
		int nums[] = new int[5];
		
		for (int num : nums) {
			System.out.println(num); //-> 0이 나옴.. 배열의 자동 초기화
		}
		
		double[] nums2 = new double[5];
		System.out.println(nums2[0]);
		
		boolean[] flags = new boolean[3];
		System.out.println(flags[0]);
		
		String[] names = new String[3];
		System.out.println(names[0]);
	}

	private static void m3() {
		
		//배열 탐색
		String[] names = new String[5];
		
		names[0] = "가";
		names[1] = "나";
		names[2] = "다";
		names[3] = "라";
		names[4] = "마";

		//순차 탐색 - for문
		for(int i=0; i<names.length; i++) {
			System.out.println(names[i]);
		}
		
		//순차 탐색 - 향상된 for문
		// - for (변수 : 배열) {}
		// - 무조건 0~끝방까지 탐색
		// - 읽기 전용 : 배열의 요소를 수정할 수 없다.
		//				 지역변수인 name에 names[]의 값을 복사해 와서 사용하기 때문에!
		for (String name : names) {
			System.out.println(name);
		}
		
		
		//배열 데이터 가공
		for(int i=0; i<names.length; i++) {
			names[i] += "님";
		}
		for (String name : names) {
			System.out.println(name);
		}
		
		for (String name : names) {
			name += "씨";
		}
		for (String name : names) {
			System.out.println(name);
		}
		
	}

	private static void m2() {
		
		//배열 선언하기
		// - 자료형[] 변수명 = new 자료형[길이];
		
		//메모리 영역에는 구획이 나누어져 있음. 
		//Stack : 구획 도시같은 곳, 촘촘히 나누어져 관리가 됨, 값형 변수를 생성하면 이곳에 생성되며 그 데이터도 함께 이곳에 저장됨, 
		//		  참조형의 경우 변수 자체는 Stack에 생기지만 Heap에 저장된 데이터의 주소값만을 저장함.		
		//Heap : 허허벌판 같은 곳, 참조형 변수를 생성하면 변수 자체는 Stack에 생기지만 그 데이터는 이곳(Heap)에 생성됨.
		
		
		
		// int[] kors = new int[3];  ==> "int 변수 3개를 *연속*으로 만들어라" 라는 뜻
		// Heap영역에 4바이트가 3개 연속된 12바이트짜리의 공간이 생기며, 
		// 해당 공간의 첫번째 주소값(연속되기 때문에 첫번째 주소값만을 넘겨줌)을 Stack에 생성된 kors 변수에 넘겨줌.
		
		
		int[] kors = new int[300]; //int 1차원 배열
		
		kors[0] = 100;
		kors[1] = 90;
		kors[2] = 80;
		
//		int total = kors[0] + kors[1] + kors[2];
		int total = 0;
		
		for (int i=0; i<kors.length; i++) {
			total += kors[i];
		}
		
		double avg = (double)total / kors.length;
		
		System.out.println(total);
		System.out.println(avg);

	
	
	}

	private static void m1() {
		
		//배열, Array
		// - 같은 자료형의 변수를 줄지어 모아놓은 집합
		// - 변수(단독주택), 배열(아파트)
		// - 집합 자료형
		// - 참조형 자료형(Reference Type)
		
		//요구사항) 학생 3명 > 국어 점수 >  총점, 평균 구하기
		//추가사항) 학생 300명
		
		int kor1;
		int kor2;
		int kor3;
		//+297개
		
		kor1 = 100;
		kor2 = 90;
		kor3 = 80;
		//+297개
		
		int total = kor1 + kor2 + kor3; //+297개
		double avg = total / 3.0; //300.0
		
		System.out.println(total);
		System.out.println(avg);
		
		
		
	}

}
