package com.test.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex14_String_use_01 {
	
	public static void main(String[] args) throws Exception {
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		m9();
		
	}

	private static void m9() {
		
		String jumin = "950420-2087456";
		
		//남자인지 여자인지?
		
		System.out.println(jumin.charAt(7) == '1' ? "남자" : "여자");
		System.out.println(jumin.indexOf("1") == 7 ? "남자" : "여자"); //별로
		System.out.println(jumin.substring(7, 8).equals("1") ? "남자" : "여자");
		
		//생일?
		
		System.out.println(jumin.substring(0, 2));
		System.out.println(jumin.substring(2, 4));
		System.out.println(jumin.substring(4, 6));
		
		
		//일부 내용 추출
		//D:\class\java\JavaTest\src\com\test\Hello.java
		String path = "D:\\class\\java\\JavaTest\\src\\com\\test\\Hello.java";
		
		//1. 파일명 추출 -> Hello.java
		int index = path.lastIndexOf("\\"); 
		System.out.println(index);
		String name = path.substring(index+1);
		System.out.println(name);
		
		//2. 확장자 추출 -> .java
		index = name.lastIndexOf(".");
		String ext = name.substring(index);
		System.out.println(ext);

		//3. 확장자 뺀 파일명 추출 -> Hello
		String filenameWithoutExt = name.substring(0, index);
		System.out.println(filenameWithoutExt);
		
	}

	private static void m8() {
		
		//얻어온 파일명 -> dog.jpg
		// - 이미지? 동영상? 문서인지 구분
		// - 이미지 (jpg, gif, png)
		// - 동영상 (mp4)
		// - 문서 (hwp, doc)
		
		String filename= "dog.jpg";
		
		if (filename.toLowerCase().indexOf(".jpg") == filename.length() - 4
			|| filename.toLowerCase().indexOf(".gif") == filename.length() - 4
			|| filename.toLowerCase().indexOf(".png") == filename.length() - 4) {
			System.out.println("이미지 파일");
			
		} else if (filename.toLowerCase().indexOf(".mp4") == filename.length() - 4) {
			System.out.println("동영상 파일");
			
		} else if (filename.toLowerCase().indexOf(".hwp") == filename.length() - 4
					|| filename.toLowerCase().indexOf(".doc") == filename.length() - 4) {
			System.out.println("문서 파일");
		}
		
		//훨씬 더 간단한 방법
		if (filename.toLowerCase().endsWith(".jpg")
			|| filename.toLowerCase().endsWith(".gif")
			|| filename.toLowerCase().endsWith(".png")) {
			System.out.println("이미지 파일");
		} else if (filename.toLowerCase().endsWith(".mp4")) {
			System.out.println("동영상 파일");
		} 
			
	}

	private static void m7() {
		
		//System.out.println("JAVA".equals("java")); //false
		
		String word1 = "Java";
		String word2 = "JAVA";
		String word3 = "java";
		
		//메소드 체인 -> 앞에서부터 해석 
		System.out.println(word1.toUpperCase().equals(word2.toUpperCase()));
		
		String txt = "안녕하세요. 저는 Java를 공부합니다.";
		String word = "java";
		
		//대소문자 구분을 안할 경우 : 검색률은 낮지만 정밀도는 높음
		if (txt.indexOf(word) > -1) { 
			System.out.println("O");
		} else {
			System.out.println("X");
		}
		
		//대소문자 구분을 할 경우 : 검색률은 높지만 정밀도는 떨어짐
		if (txt.toLowerCase().indexOf(word.toLowerCase()) > -1) {
			System.out.println("O");
		} else {
			System.out.println("X");
		}
	}

	private static void m6() {

		//검색어 모두 찾기 
		
		String txt = "안녕하세요. 홍길동입니다. 반갑습니다. 홍길동입니다. 다시 홍길동입니다.";
		String word = "홍길동";
		int index = -1;
		
//		index = txt.indexOf(word);
//		if (index > -1) {
//			System.out.printf("%d번 위치에서 발견\n", index);
//		}
		
//		index = txt.indexOf(word, index + word.length());
//		if (index > -1) {
//			System.out.printf("%d번 위치에서 발견\n", index);
//		}
		
		index = -word.length(); //아래 indexOf 메소드를 (word, 0)의 형식으로 시작하기 위해 초기값을 설정해줌. 
		
		while (true) {
			
			index = txt.indexOf(word, index + word.length());
			
			if (index > -1) {
				System.out.printf("%d번 위치에서 발견\n", index);
			} else {
				break;
			}
			
		}
		
		
	}

	private static void m5() throws Exception {
		
		//게시판 글쓰기
		// - 관리자 모드 : 금지어 설정 
		
		String content = "안녕하세요. 방금 가입했습니다. ~";
		
		//금지어 : 바보
		String word = "바보";
		
		if (content.indexOf(word) > -1) {
			System.out.println("금지어 사용 불가!");
		} else {
			System.out.println("글쓰기 진행..");
		}
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			System.out.print("내용 : ");
			content = reader.readLine();
			
			if (content.indexOf(word) == -1) {
				break;
			} else {
				System.out.println("금지어가 발견되었습니다.");
			}
		}
		
		System.out.println("글쓰기 진행...");
		
	}

	private static void m4() {
		
		//주민등록번호를 입력받아 유효성 검사 -> '-' 반드시 입력
		String jumin = "950420-2012345";
		
		if (jumin.charAt(6) == '-') {
			System.out.println("올바른 주민번호입니다.");
			
			if (jumin.charAt(7) == '1') {
				System.out.println("남자");
			} else {
				System.out.println("여자");
			}
			
		} else {
			System.out.println("올바르지 않은 주민번호입니다.");
		}
		
	}

	private static void m3() {
		
		String txt = "안녕하세요. 홍길동님.";
		
		//모든 문자 추출해보기(0~11)
		
		for (int i=0; i<txt.length(); i++) {
			char c = txt.charAt(i);
			System.out.println(c);
		}
		
		//아이디 입력(영어 소문자로만 구성되어야 함)
		// - 문자 코드값 의존 -> String으로는 불가하고 char로만 알아낼 수 있음.
		String id = "가나다123";
		boolean result = true; //기본값은 t/f 아무거나
		
		for(int i=0; i<id.length(); i++) {
			char c = id.charAt(i);
//			System.out.println(c);
//			System.out.println((int)c);
			
//			if (c >= 'a' && c <= 'z') {
//				System.out.println("소문자 O");
//			} else {
//				System.out.println("소문자 X");
//			}
			
		//유효성 검사를 할때는 되도록 잘못된 부분을 찾는 조건을 만듬.
			
//			if (c < 'a' || c > 'z') {
//			if ((c < 'a' || c > 'z') && (c <'A' || c > 'Z')) { //소문자 혹은 대문자외의 문자가 입력된 경우
//			if ((c < 'a' || c > 'z') && (c <'A' || c > 'Z') && (c < '0' || c > '9')) { //소문자, 대문자, 숫자까지 허용
			if (c < '가' || c > '힣') { //한글만 허용 (초성 안됨)
//				System.out.println("소문자 X");
				result = false;
				break; //한번 걸리면 또다시 검사할 필요가 없음. 대문자가 하나라도 존재하면 굳이 두번째까지 검사하지 않아도 되기 때문.
			}
		}
		
		if (result) {
			System.out.println("사용 가능합니다.");
					
		} else {
		System.out.println("사용 불가능합니다.");
		}
		
	}

	private static void m2() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//이름을 입력받아 유효성 검사하기
		// - 문자열 길이 검사
		
		System.out.print("이름(2~5자 이내) : ");
		String name = reader.readLine();
		
		if (name.length() >= 2 && name.length() <= 5) {
			System.out.println("회원 가입 완료!");
		} else {
			System.out.println("이름은 2~5자 이내로 입력하세요.");
		}
		
		
	}

	private static void m1() throws Exception {
		
		String txt = "안녕하세요. 홍길동입니다.";
		System.out.println(txt.length());
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문장 : ");
		txt = reader.readLine();
		System.out.println(txt.length());
		
	}

}
