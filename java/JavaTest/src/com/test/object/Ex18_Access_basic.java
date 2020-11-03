package com.test.object;	

public class Ex18_Access_basic {
	
	public static void main(String[] args) {
		
		User hong = new User();
		hong.setName("홍길동");
		hong.setGender(1);
		hong.setId("hong");
		System.out.println(hong.getName());
		System.out.println(hong.getGender());
		System.out.println(hong.getId());
		
		System.out.println();
		
		User lee = new User();
		lee.setName("이순신");
		lee.setGender(2);
		lee.setId("leess");
		System.out.println(lee.getName());
		System.out.println(lee.getGender());
		System.out.println(lee.getId());
		
		System.out.println();
		
//------------------------------------------------------------------------------------------------------------------------------------
		
		Mouse m1 = new Mouse();
		
		m1.setModel("로지텍 M705"); 		//쓰기
		System.out.println(m1.getModel());	//읽기
		
		//읽기 전용 멤버 -> button
		//m1.setButton
		System.out.println(m1.getButton());	//읽기
		
		//쓰기 전용 멤버 - price
		m1.setPrice(50000);					//쓰기
		//m1.getPrice
		
		//계산된 프로퍼티(멤버), 가상멤버
		System.out.println(m1.getLevel());
		
	}
	

}
