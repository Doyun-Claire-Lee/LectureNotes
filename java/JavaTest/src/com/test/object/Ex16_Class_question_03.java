package com.test.object;

public class Ex16_Class_question_03 {
	
	public static void main(String[] args) {
		
		//Bugles 과자 클래스
		
		Bugles snack = new Bugles();
		snack.setWeight(500);
		snack.setCreationTime("2020-04-22");
		System.out.println("가격 : " + snack.getPrice() + "원");
		System.out.println("유통 기한이 " + snack.getExpiration() + "일 남았습니다.");
		snack.eat();
		
		System.out.println();
		
		Bugles snack2 = new Bugles();
		snack2.setWeight(300);
		snack2.setCreationTime("2020-04-10");
		System.out.println("가격 : " + snack2.getPrice() + "원");
		System.out.println("유통 기한이 " + snack2.getExpiration() + "일 남았습니다.");
		snack2.eat();
		
	}

}
