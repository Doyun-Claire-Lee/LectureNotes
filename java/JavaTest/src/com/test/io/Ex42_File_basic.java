package com.test.io;

import java.io.File;
import java.util.Date;

public class Ex42_File_basic {
	
	public static void main(String[] args) {
		
		//파일 정보 확인 -> 파일 조작
		//디렛토리 정보 확인 -> 디렉토리 조작
		
//		m1();
//		m2();
//		m3();
		m4();
		
	}

	private static void m4() {
		
		// 파일 삭제하기 - 영구 삭제됨.(휴지통으로 이동X)
		
		String path = "D:\\class\\java\\io\\AAA\\data.txt";
		File file = new File(path);	//원본 객체
		
		if (file.exists()) {
			
			file.delete();	//리턴값으로 boolean 있음.
			System.out.println("파일 삭제 완료");
			
		} else {
			System.out.println("파일 없음");
		}
		
	}

	private static void m3() {
		
		//파일 이동하기
		//AAA -> BBB 폴더로 이동
		//이미 동일한 이름이 있는 경우 덮어쓰기X, 아무 행동도 하지 않음.
		
		String path = "D:\\class\\java\\io\\AAA\\data.txt";	//대소문자 구분여부를 확인할것, 운영체제와 실행환경에 따라 다름 
		File file = new File(path);	//원본 객체
		System.out.println(file.getAbsolutePath());
		
		if (file.exists()) {
			
			String path2 = "‪D:\\class\\java\\io\\BBB\\hong.txt";
			File file2 = new File(path2);
			
			file.renameTo(file2);
			System.out.println("파일 이동 완료");
			
		} else {
			System.out.println("파일 없음");
		}
	}

	private static void m2() {
		
		//파일 조작하기
		// - (생성, 복사,) 이동, 파일명 수정, 삭제 등
		// - 파일 객체 참조 후 조작
		
		//파일명 수정하기
		//hong.txt -> data.txt
		//이름이 바뀌고 난 후 모습의 객체를 하나 더 만들어서 수정해야 함.
		
		String path = "D:\\class\\java\\io\\AAA\\hong.txt"; //대소문자 구분여부를 확인할것, 운영체제와 실행환경에 따라 다름 
		File file = new File(path);	//원본 객체
		
		if (file.exists()) {

			String path2 = "D:\\class\\java\\io\\AAA\\data.txt";
			File file2 = new File(path2);
			System.out.println(file2.getAbsolutePath());
			
			file.renameTo(file2);	//리턴값으로 boolean 있음.
			System.out.println("파일명 수정 완료");
			
			
		} else {
			System.out.println("파일 없음");
		}
		
	}

	private static void m1() {
		
		//파일 접근 -> 정보 확인
		//파일 참조 객체(클래스)
		
		String path = "D:\\class\\java\\io\\test.txt";
		File file = new File(path); //java.io //File class
		
		System.out.println(file.exists());	//File 객체를 생성할때는 해당 경로의 파일이 없어도 일단 생성은 되기 때문에 exists()로 꼭 확인하기!
		
		//예외 검사
		if(file.exists()) {					//안전장치를 두어야 함. (외부환경에 의해 발생할 수 있는 에러이기 때문에,, ex.파일 삭제 등)
			
			//파일 정보 확인
			System.out.println(file.getName());			//파일명 반환
			System.out.println(file.isFile());			//파일인지 여부 
			System.out.println(file.isDirectory());		//폴더인지 여부
			System.out.println(file.length());			//파일의 크기(size)를 byte단위로 반환					
		
			System.out.println(file.getAbsolutePath());	//파일경로 반환(절대경로 - 드라이브(root) 부터 시작하는 경로)
			System.out.println(file.getPath());			//파일경로 반환(참조경로 - path에 입력한 경로)
			
	//--------------------------------------------------------------------------------------------------------------------------------	
			
			System.out.println(file.lastModified());	//1588896352384, 마지막으로 수정한 시각을 틱값으로 반환
			Date date = new Date(file.lastModified());	//틱값을 날짜형식으로 변환(?) 해주는 Date class
			System.out.printf("%tF %tT\n", date, date);
			
			System.out.println(file.canRead());			//파일을 읽을 수 있는지
			System.out.println(file.canWrite());		//파일을 수정할 수 있는지
			System.out.println(file.isHidden());		//파일이 숨겨져 있는지

		} else {
			System.out.println("파일이 없습니다.");
		}
		
		
		
	}

}
