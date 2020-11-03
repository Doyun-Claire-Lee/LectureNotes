//이 라인은 주석(Comment, Remark) 영역입니다. - 컴파일러에게 "이 영역은 번역하지 마세요." 라고 지시하는 역할

//주석의 종류
//1. 단일 라인 주석, Single Line Comment - 다중 라인일때도 보통 단일 라인 주석을 사용한다. (단축키 : Ctrl + /)
//2. 다중 라인 주석, MultiLine Comment - (단축키 : Ctrl + Shift - / , Ctrl + Shift + \ )
/*
 다중
 라인
 주석
 */

//보라색 글자 - 일종의 예약어 

//단순히 물리적 형태만 봤을 때 - 패키지, 클래스, 메소드는 모두 코드의 집합(용도는 상이)

//package '패키지명' : 현재 파일(클래스)이 소속되어 있는 패키지 명시
//**패키지 생성 시 보통 영어 소문자만 이용함.**
//패키지(package) : 클래스를 담고 있는 폴더, 자바에서 존재할 수 있는 가장 큰 상자
package com.test.begin;

//class '클래스명'
//클래스 : 코드의 집합, 수많은 코드를 목적에 따라 분리하는 역할, 중형 상자
public class Ex02  //클래스 헤더(header) - 해당 요소를 정의하기 위한 선언부

{ //클래스 바디(body) - 선언부를 통해 해당 요소를 구현하기 위한 구현부
	
	//메소드(Method) : 코드의 집합, 소형 상자 
	public static void main(String[] args) //메소드 헤더
	
	{//메소드 바디
		
		//명령어(문장, Statement)
		//';' : 문장 종결자, 생략 시 에러발생
		System.out.println("안녕하세요.");
		System.out.println("반갑습니다.");
	
	}

}
