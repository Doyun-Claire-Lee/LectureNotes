package com.test.object;

public class Ex16_Class_question_01 {
	
	public static void main(String[] args) {
		
		//책 정보 입/출력 book class
		
		Book b1 = new Book();
		
		b1.setTitle("이것이 자바다");
		b1.setAuthor("신용권");
		b1.setPrice(30000);
		b1.setPage(1224);
		b1.setPublisher("한빛미디어");
		b1.setIsbn("9788968481475");
		
		System.out.println();
		
		System.out.println(b1.getTitle());
		System.out.println(b1.getAuthor());
		System.out.printf("%,d원\n", b1.getPrice());
		System.out.printf("%,d쪽\n", b1.getPage());
		System.out.println(b1.getPubYear());
		System.out.println(b1.getIsbn());
		
		System.out.println();
		
		System.out.println(b1.info());

	}

}
