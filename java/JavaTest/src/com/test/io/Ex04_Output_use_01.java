package com.test.io;

public class Ex04_Output_use_01 {
	
	public static void main(String[] args) {
		
		
//		//Case A. -> XXX(쓰지말기)
//		System.out.println(100);
//		System.out.println(90);
//		System.out.println(80);
//		
//		//Case B.
//		int kor = 100;
//		int eng = 90;
//		int math = 80;
//		
//		System.out.println(kor);
//		System.out.println(eng);
//		System.out.println(math);
		
		
		//println() 과 printf()는 혼합하여 잘 쓰임.
		
		//학생 3명의 국영수 성적 출력
		
		String name1 = "홍길동";
		int kor1 = 100;
		int eng1 = 90;
		int math1 = 80;
		
		String name2 = "이도윤";
		int kor2 = 100;
		int eng2 = 100;
		int math2 = 100;
		
		String name3 = "이병학";
		int kor3 = 95;
		int eng3 = 85;
		int math3 = 75;
		
		//println()
		System.out.println("[이름]\t[국어]\t[영어]\t[수학]");
		System.out.println("------------------------------");
		System.out.println(name1 + "\t" + kor1 + "\t" + eng1 + "\t" + math1 );
		System.out.println(name2 + "\t" + kor2 + "\t" + eng2 + "\t" + math2 );
		System.out.println(name3 + "\t" + kor3 + "\t" + eng3 + "\t" + math3 );

		System.out.println();
		System.out.println();
		
		//print()
		System.out.println("[이름]\t[국어]\t[영어]\t[수학]");
		System.out.println("------------------------------");
		System.out.print(name1 + "\t");
		System.out.print(kor1 + "\t");
		System.out.print(eng1 + "\t");
		System.out.println(math1);
		System.out.print(name2 + "\t");
		System.out.print(kor2 + "\t");
		System.out.print(eng2 + "\t");
		System.out.println(math2);;
		System.out.print(name3 + "\t");
		System.out.print(kor3 + "\t");
		System.out.print(eng3 + "\t");
		System.out.println(math3);
		
		System.out.println();
		System.out.println();
		
		//printf(), print format 메소드
		
		//요구사항) "홍길동님 안녕하세요." 출력
		//추가사항) : 홍길동님 안녕하세요. 홍길동님 오랜만입니다." 출력
		String name = "홍길동";
		
		System.out.println(name + "님 안녕하세요.");
		System.out.printf("%s님 안녕하세요.\n", name);
		

		System.out.println(name + "님 안녕하세요. " + name + "님 오랜만입니다.");	//가독성이 떨어짐.
		System.out.printf("%s님 안녕하세요. %s님 오랜만입니다.\n", name, name);
		
		
		//SQL
		// - 데이터베이스에 레코드(행)을 추가하는 명령어
		// -"insert into tblScore (name, kor, eng, math) values ('홍길동', 100, 90, 80);"
		
		System.out.println("insert into tblScore (name, kor, eng, math) values ('" + name1 + "', " + kor1 + ", " + eng1 + ", " + math1 +");" );
		System.out.printf("insert into tblScore (name, kor, eng, math) values ('%s', %d, %d, %d);\n", name1, kor1, eng1, math1);
		//문자열(%s), 숫자(%d)
		
		System.out.println();
		System.out.println();
		
		//java.util.MissingFormatArgumentException 
		//java.util.IllegalFormatConversionException
		System.out.printf("제 이름은 %s 입니다. 나이는 %d살 입니다. 원주율은 %f입니다. \"나는 남자다\"라는 문장은 %b입니다. 제가 제일 좋아하는 문자는 %c입니다.\n"
				, "홍길동"
				, 20
				, 3.14
				, false
				, 'J' );
		
		System.out.println();
		System.out.println();
		
		int num = 10;
		System.out.printf("[%d]\n", num);
		System.out.printf("[%10d]\n", num);	//[        10] (10까지 총 열칸을 확보)
		System.out.printf("[%-10d]\n", num);//[10        ]
		System.out.println();
		
		System.out.println("==========");
		System.out.println("[가격(원)]");
		System.out.println("==========");
		System.out.printf("%,10d\n", 100000);
		System.out.printf("%,10d\n", 50000);
		System.out.printf("%,10d\n", 12100);
		System.out.printf("%,10d\n", 36658520);
		System.out.printf("%,10d\n", 2200);
		System.out.printf("%,10d\n", 800);
		System.out.printf("%,10d\n", 50);
		
		System.out.println();
		System.out.println();
		
		double a = 1000000;
		double b = 3;
		System.out.printf("%,20f\n", a / b);	//%f가 소수점 이하 6자리까지만 표기하도록 기본적으로 설정되어있음.
		System.out.printf("%,20.1f\n", a / b);
		System.out.printf("%,20.10f\n", a / b);
		//컴마, 자릿수, 소수이하 순서로 작성
		
		double c = 3.145678;
		System.out.printf("%.3f\n", c); //자동으로 반올림 됨.
		
		
	}
	

}
