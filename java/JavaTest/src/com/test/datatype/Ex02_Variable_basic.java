package com.test.datatype;

public class Ex02_Variable_basic {
	
	public static void main(String[] args) {
		
		//변수, Variable
		// - 자료형을 사용해서 얻어내는 메모리의 특정 공간
		// - 사용자가 임의로 데이터를 저장하거나 저장된 데이터를 꺼내올 수 있다.
		// - 값(데이터)를 저장하는 공간
		
		//1. 변수 선언하기
		// - 메모리의 일부 영역을 할당받기(얻어내기)
		// - 문법 : 자료형 변수명;
		
		byte kor; //kor - 변수(공간을 찾아가기 위한 메모리 주소값)
		
		//2. 변수 초기화하기
		// - 얻어낸 공간에 처음으로 값을 넣는 행동
		// - 문법 : 변수명 = 값; ('=' : 대입 연산자, 공간 = 값;)
		
		kor = 100;
		
		//3. 변수 호출하기
		// - 공간에 넣은 값을 가져오기
		
		System.out.println(kor); // 출력해보기
		
		
		//4. 변수 치환하기
		// - 공간 안의 값을 다른 값으로 바꾸기
		
		kor = 99;
		System.out.println(kor);
		
		//5. 변수 삭제하기
		// - 방법 없음. 생명주기(때가 되면 자연스럽게 소멸)
		
		
	}

}
