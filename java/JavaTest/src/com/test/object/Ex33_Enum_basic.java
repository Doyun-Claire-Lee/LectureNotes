package com.test.object;

public class Ex33_Enum_basic {
	
	public static void main(String[] args) {
		
		//열거형, Enumeration
		// - 클래스
		// - enum 키워드
		
		//나열된 형테의 데이터가 필요한 경우에 사용
		// -> 옷 쇼핑몰에서 색상을 선택해야 하는 경우..
		
		//1. 오타율 高
		String color = "빨강";
		if (color.equals("빨강") || color.equals("노랑") || color.equals("파랑") ) {
			System.out.println("재고 있음");
		} else {
			System.out.println("재고 없음");
		}
		
		//2. 오타율은 낮으나 가독성이 떨어짐.
		//1(빨강), 2(노랑), 3(파랑)
		int color2 = 1;
		if (color2 == 1 || color2 == 2 || color2 == 3) {
			System.out.println("재고 있음");
		} else {
			System.out.println("재고 없음");
		}
		
		//3. 열거형 - 안정성을 증가시켜줌.
		Color color3 = Color.RED; 
//		System.out.println(color3);
		if (color3 == Color.RED || color3 == Color.YELLOW || color3 == Color.BLUE) {
			System.out.println("재고 있음");
		} else {
			System.out.println("재고 없음");
		}
		
		
		Employee hong = new Employee();
		hong.name = "홍길동";
		hong.position = 직급.과장;
		hong.position2 = 1;
		hong.position2 = 직급2.과장; //숫자 1
		
		
	}//main

}//Ex33

//열거형 -> 멤버 변수만 가질 수 있음. (메소드는 X)
enum Color {
	
	//멤버: 변수 이름만 적어놓기
	RED,	//public final static int 자료형(?)임. 
	YELLOW,
	BLUE
	
}

enum 직급 {
	부장,
	과장,
	대리,
	사원
}

class 직급2 { //위의 enum 직급과 같은 코드 
	public final static int 부장 = 1;
	public final static int 과장 = 2;
	public final static int 대리 = 3;
	public final static int 사원 = 4;
	
}

class Employee {
	public String name;
	public 직급 position;
	public int position2;
	
}