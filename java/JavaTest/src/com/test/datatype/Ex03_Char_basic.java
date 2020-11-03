package com.test.datatype;

public class Ex03_Char_basic {

	
	public static void main(String[] args) {
		
		//문자형
		//Escape Sequence
		// - 특정한 행동을 할 수 있도록 미리 약속되어 있는 문자
		
		//1. '\n' - new line, 개행문자, 줄바꿈(엔터)
		char c = '\n';
		System.out.println(c);
		System.out.println("하나" + c + "둘");
		System.out.println("하나\n둘");
		
		//2. '\r' - carriage return
		// - 캐럿의 위치를 현재 라인의 시작 위치로 이동해라(Home키)
		// - 콘솔은 삽입 기능이 없기 때문에 덮어쓰기가 됨.
		// - 현재 이클립스 버전에서는 안되는 듯?
		String str = "안녕하세요. \r홍길동님";
		System.out.println(str); 	//정상결과 : 홍길동님요.
		
		//엔터키(Return) = '\r' + \n' = "\r\n"
		System.out.println("반갑습니다. \n아무개님");
		System.out.println("반갑습니다. \r아무개님"); 	//아무개님다.
		System.out.println("반갑습니다. \r\n아무개님");	// "\r\n" - 엔터의 원형
			
		//3. '\t' - 탭(tap)
		// - 탭이란? 절대위치값(탭의 위치는 이미 고정되어 있고 탭키를 누르면 다음 순서의 위치로 이동함.)
		// - 화면을 보기좋게 만들어주는 역할
		//영역 잡고 ctrl + shift + f : 코드 정렬(format)
		System.out.println("하나\t둘\t셋");
		
		//4. '\b' - 백스페이스
		// - 현재 이클립스 버전에서는 안됨.
		System.out.println("일이\b삼사오"); //일삼사오
		
		//5. \', \", \\
		//안녕하세요, "홍길동"입니다.
		System.out.println("안녕하세요, \"홍길동\"입니다.");
		System.out.println("안녕하세요, '홍길동'입니다.");
		//수업 폴더의 경로?
		String path = "D:\\class\\java";	//로컬, 파일시스템 - 역슬래시 사용, 역슬래시를 출력값으로 얻고싶을 경우 두번 쓰기
		System.out.println(path);
		path = "D:/class/java"; 			//웹 경로(URL) - 슬래시 사용
		System.out.println(path);
		
		
	}
		
}
