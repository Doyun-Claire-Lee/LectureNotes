package com.test.io;

public class Ex04_Output_question_01 {
	
	public static void main(String[] args) {
		
		//1.
		
		String name = "홍길동";
		short age = 20;
		String gender = "남자";
		String address = "서울시 강남구 역삼동";
		
		System.out.printf("안녕하세요. 제 이름은 '%s'입니다.\n나이는 %d살이고 %s입니다.\n저는 '%s'에 살고 있습니다.\n", name, age, gender, address);
		
		System.out.println();
		System.out.println();

		//2. 
		
		String name1 = "홍길동";
		String name2 = "아무개";
		String name3 = "하하하";
		int kor1 = 80;
		int eng1 = 90;
		int math1 = 95;
		int kor2 = 76;
		int eng2 = 86;
		int math2 = 79;
		int kor3 = 89;
		int eng3 = 92;
		int math3 = 85;
		
		System.out.println("[학생]\t[국어]\t[영어]\t[수학]\t[평균]");
		System.out.println("--------------------------------------");
		System.out.printf("%s\t%5d\t%5d\t%5d\t%5d\n", name1, kor1, eng1, math1, (kor1 + eng1 + math1) / 3 );
		System.out.printf("%s\t%5d\t%5d\t%5d\t%5d\n", name2, kor2, eng2, math2, (kor2 + eng2 + math2) / 3 );
		System.out.printf("%s\t%5d\t%5d\t%5d\t%5d\n", name3, kor3, eng3, math3, (kor3 + eng3 + math3) / 3 );
		
		System.out.println();
		System.out.println();
		
		//3.
		
		String date1 = "2020-01-01";
		String date2 = "2020-01-01";
		String date3 = "2020-01-02";
		String date4 = "2020-01-03";
		String date5 = "2020-01-03";
		
		String content1 = "카페라테";
		String content2 = "돼지불백";
		String content3 = "마트 장본것들";
		String content4 = "교통 카드 충전";
		String content5 = "편의점";
		
		int price1 = 4800;
		int price2 = 8500;
		int price3 = 125840;
		int price4 = 45000;
		int price5 = 46200;
		
		System.out.printf("%-12s\t%-14s\t%6s\n", "[날짜]", "[내역]", "[금액]");
		System.out.println("-------------------------------------------------");
		System.out.printf("%-12s\t%-16s%,10d원\n", date1, content1, price1);
		System.out.printf("%-12s\t%-16s%,10d원\n", date2, content2, price2);
		System.out.printf("%-12s\t%-14s%,10d원\n", date3, content3, price3);
		System.out.printf("%-12s\t%-14s%,10d원\n", date4, content4, price4);
		System.out.printf("%-12s\t%-17s%,10d원\n", date5, content5, price5);
		
		
		
	}

}
