package com.test.string;

public class Ex14_String_basic {
	
	public static void main(String[] args) {
		
		//문자열, String
		// - 현재까지 배운 자료형 : 숫자, 문자, 논리형 / 문자열, 날짜시간
		
		//문자열 조작 기능
		// - 메소드로 제공이 됨.
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		//m9();
		m10();
		
	}

	private static void m10() {
		
		//"10" -> 10 으로 변환
		
		String str = "10";
		
		System.out.println(Integer.parseInt(str));
		
		//10 -> "10" 으로 변환
		
		int num = 10;
		System.out.println(String.valueOf(10));
		System.out.println(num + "");
		
		
		
	}

	private static void m9() {
		
		//문자열 치환
		// - String replace(char old, char new)
		// - String replace(String old, String new)
		
		String txt = "안녕하세요. 홍길동입니다.";
		
		System.out.println(txt.replace("홍길동", "아무개")); //안녕하세요. 아무개입니다.
		System.out.println(txt); //안녕하세요. 홍길동입니다. //원본은 변경되지 않음.
		System.out.println(txt.replace("하하하", "아무개")); //없는 문자열을 찾을 때 -> 에러 안남. 그냥 그대로 리턴
		
		txt = "     하나     둘     셋     ";
		System.out.println(txt.replace(" ", "")); //전체 공백 삭제
		
	}

	private static void m8() {
		
		//문자열 검색
		// - IndexOf() => 위치를 알려줌
		// - lastIndexOf()
		// - boolean contains(String) => 있다 없다를 알려줌
		
		String txt = "안녕하세요. 홍길동입니다.";
		System.out.println(txt.contains("홍길동"));
		System.out.println(txt.indexOf("홍길동") > -1);
		
		System.out.println(txt.contains("아무개"));
		
		
	}

	private static void m7() {

		//문자열 추출
		// - char chatAt(int index) : 문자 추출
		// - String substring(int start, int end) : 문자열 추출
		//		- start : inclusive
		//		- end : exclusive
		
		String txt = "안녕하세요. 홍길동입니다.";
		System.out.println(txt.substring(3, 8)); //세요. 홍 -> 3~7까지만 
		System.out.println(txt.substring(3, 3)); //출력 불가
		System.out.println(txt.substring(3, 4)); //한글자만 추출
		
		System.out.println(txt.substring(3)); //3번부터 쭉 추출
		
	}

	private static void m6() {
		
		//(패턴)검색
		// - boolean startsWith(String word)
		// - boolean endsWith(String word)
		
		String name = "홍길동"; //타겟
		
		//홍씨 성을 가진 사람인지?
		System.out.println(name.charAt(0) == '홍');
		System.out.println(name.indexOf('홍') == 0);
		System.out.println(name.startsWith("홍"));
		
		//'동'으로 끝나느냐?
		System.out.println(name.charAt(name.length()-1) == '동');
		System.out.println(name.indexOf('동') == name.length()-1);
		System.out.println(name.endsWith("동"));
		
	}

	private static void m5() {
		
		//대소문자 변환
		// - String toUpperCase()
		// - String toLowerCase()
		
		String text = "Hello Hong";
		
		System.out.println(text.toUpperCase());
		System.out.println(text.toLowerCase());
		
	}

	private static void m4() {
		
		//문자열 검색
		// - 문자열 내에서 원하는 문자(문자열) 검색 -> 위치값을 반환해줌
		// - int indexOf(char c)
		// - int indexOf(String s) ** 많이 씀
		// - int indexOf(char c, int index)
		// - int indexOf(String s, int index)
		
		String txt = "안녕하세요. 홍길동입니다. 반갑습니다. 홍길동입니다.";
		
		int index = txt.indexOf('홍');
		System.out.println(index);
		
		index = txt.indexOf("홍");
		System.out.println(index);

		index = txt.indexOf("홍길동"); //문자열의 시작값을 위치값으로 반환
		System.out.println(index);

		index = txt.indexOf("아무개"); //없을때는? -1로 반환
		System.out.println(index);
		
		//문장 내에 "아무개"가 있느냐?
		if (txt.indexOf("아무개") > -1) {
			System.out.println("있음");
		} else {
			System.out.println("없음");
		}
		
		//"안녕하세요. 홍길동입니다. 반갑습니다. 홍길동입니다."
		index = txt.indexOf("홍길동");	//("홍길동", 0)에서 0이 생략된 형태
		System.out.println(index); 		//무조건 첫번째 찾은 검색어에서 끝내버림.

		index = txt.indexOf("홍길동", 10);
		System.out.println(index);
	
	
	
	
	}

	private static void m3() {
		
		//문자열 공백 제거
		// - String trim() -> 좌우 공백 제거
		// - 검색어 등을 처리할 때 자주 씀
		
		String txt = "     하나     둘     셋     ";
		System.out.printf("[%s]\n", txt);			//[     하나     둘     셋     ]
		System.out.printf("[%s]\n", txt.trim());	//[하나     둘     셋]
		
	}

	private static void m2() {
		
		//문자열 추출
		// - 특정 위치의 문자를 반환
		// - char charAt(int index)
		// - Zero-based Index : 인덱스(위치)는 0부터 시작함.
		
		String txt = "안녕하세요. 홍길동님.";
		System.out.println(txt.charAt(3)); // -> 4번째 문자를 반환함.
		System.out.println(txt.charAt(0)); 
		System.out.println(txt.charAt(11)); 
		System.out.println(txt.charAt(txt.length()-1)); //최대 index
		
		//java.lang.StringIndexOutOfBoundsException 오류
		System.out.println(txt.charAt(100));
		
	}

	private static void m1() {
		
		//문자열 길이
		// - 문자열을 구성하는 문자의 갯수
		// - int length()
		
		String txt = "Hello";
		System.out.println(txt.length());
		System.out.println("Bye".length());
		System.out.println("안녕하세요".length());
		
		
	
		
	}

}
