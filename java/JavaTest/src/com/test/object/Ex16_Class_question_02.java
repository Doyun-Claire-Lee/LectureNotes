package com.test.object;

public class Ex16_Class_question_02 {
	
	public static void main(String[] args) {
		
		Note n1 = new Note();
		
		n1.setOwner("홍길동");
		n1.setColor("노란색");
		n1.setPage(25);
		n1.setSize("B4");
		
		System.out.println(n1.info());
		
		Note n2 = new Note();
		
		n2.setColor("검정색");
		n2.setPage(100);
		n2.setSize("A4");
		System.out.println(n2.info());
	}

}
