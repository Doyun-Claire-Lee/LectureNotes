package com.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex44_File_IO {
	
	public static void main(String[] args) throws Exception {
		
		/*
		
		파일 입출력
		 - 자바 프로그램 <-> (데이터) <-> 외부 공간(HDD, SSD)
		 - 콘솔 입출력 방식과 유사
		 
		 1. 텍스트 입출력(수업시)
		 - 문자(열) 읽기/쓰기
		 - 메모장 등
		 - ex) "ABC" <-> (변환) <-> 1010101110110001 : 인코딩(Encoding), 디코딩(Decoding)
		 
		 2. 바이너리 입출력(일반적인 프로그래머는 직접적으로 다룰 일이 거의 없음)
		 - 바이너리 데이터{(이진 데이터) 읽기/쓰기
		 - 비텍스트(기계어 등..) 데이터, 이미지, 동영상, 음악 파일, 압축 파일, 실행 파일 등..
		 - ex) 음악파일.mp3 <-> (변환) <-> 1010101110110001
		
		
		인코딩
		 - 문자 코드를 부호화(0,1)하는 작업
		 - 내보내기(쓰기)
		 
		 디코딩
		  - 부호 데이터를 문자 코드로 변환하는 작업(복호화)
		  가져오기(읽기)
		  
		  
		인코딩/디코딩 규칙(여러 규칙이 있으나 각 국가별로 자주 쓰는 세트가 다름)
		1. ISO-8859-1
		2. EUC-KR
		3. ANSI
		4. UTF-8
		5. UTF-16
		6. MS949
		
		ANSI(ISO-8859-1, EUC-KR, MS949) - 동일한 규칙은 아니나 한국에서는 똑같은 행동을 함.
		1. 영어: 1Byte
		2. 한글: 2Byte
		
		UTF-8(한글에는 좋지 않은 방식이지만 공식적인 개발 환경이 되어버림..)
		1. 영어: 1Byte
		2. 한글: 3Byte
		
		UTF-16
		1. 영어: 2 Byte
		2. 한글: 2Byte
		
		
		*/
		
//		m1();	//FileOutputStream: 예전 방법이라 잘 사용하지 않음.
//		m2();	//FileInputStream : 마찬가지로 잘 사용 안함
		
//		m3();	//FileWriter: 자주 씀
//		m4();	//FileWriter + Scanner
//		m5();	//FileReader: 한글자씩 읽어옴. 잘 안씀
		
//		m6();	//BufferedWriter(FileWriter()):
//		m7();	//BufferedReader
//		m8();
		
//		m9();
		m10();
		
	}

	private static void m10() throws Exception {
		
		//이전 내용을 다시 읽고 싶으면? 스트림을 다시 열어야 한다. -> 비용이 비쌈.. 
		//배열에 내용을 복사해놓고 배열을 읽기 -> 메모리 사용률이 증가함. 적당히 해야함.(데이터가 소량일 경우)
		//라인 단위로 복사, 총 라인수를 미리 알 수 없기 때문에 ArrayList 사용
		//메모리상에 있는 자료를 읽는 것 -> 속도도 훨씬 빠름
		
		File file = new File("D:\\class\\java\\io\\color.txt");
		
		if (file.exists() ) {
			
			ArrayList<String> list = new ArrayList<String>(); //임시 저장소
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				list.add(line);
			}
			
			reader.close();
			System.out.println(list.size() + "줄");
			
			for (String color : list) {
				System.out.println(color);
			}
			for (String color : list) {
				System.out.println(color);
			}
			
		} else {
			System.out.println("파일 없음");
		}
	}

	private static void m9() throws Exception {
		
		//스트림 특징: 읽기 작업시 한번 읽은 내용은 다시 읽을 수 없다.
		File file = new File("D:\\class\\java\\io\\color.txt");
		
		if (file.exists() ) {
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String color = reader.readLine();
			System.out.println(color);
			color = reader.readLine();
			System.out.println(color);
			color = reader.readLine();
			System.out.println(color);
			
			reader.close();
			
			//이전 내용을 다시 읽고 싶으면? 스트림을 다시 열어야 한다. -> 비용이 비쌈..  -> m10();
			reader = new BufferedReader(new FileReader(file));
			color = reader.readLine();
			System.out.println(color);
			
			
			//readLine() -> 자체적으로 포인터(커서)가 있음. 메소드를 실행시킬때마다 한줄씩 내려감.
			//			 -> 전진 커서이기 때문에 이미 읽은 라인으로는 다시 돌아갈 수 없음.
			//BoF, Begin of File: 포인터의 시작점
			//EoF, End of File: 포인터의 마지막
			
		} else {
			System.out.println("파일 없음");
		}
		
		
		
	}

	private static void m8() throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader("D:\\class\\java\\JavaTest\\src\\com\\test\\array\\Ex15_Array_use_01.java"));	//파일 읽기
		
		String line = null;
		int num = 1;
		
		while((line = reader.readLine()) != null) {
			System.out.printf("%3d: %s\r\n", num, line);
			num++;
		}
		
		reader.close();
		
	}

	private static void m7() throws Exception {
		
		//FileOutputStream, FileInputStream, FileWriter, FileReader : 파일 입출력
		//BufferedWriter, BufferedReader : 범용 입출력(파일, 키보드, 메모리, 네트워크 등...)
		
		//읽기
		
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 					//키보드 입력 읽기
		BufferedReader reader = new BufferedReader(new FileReader("D:\\class\\java\\io\\data3.txt"));	//파일 읽기
		
		String line = reader.readLine(); //엔터를 만나기 전까지 출력
		System.out.println(line);
		
		line = reader.readLine(); 
		System.out.println(line); //더이상 읽을 게 없으면 null을 반환

		reader.close();
		
	}

	private static void m6() throws Exception {
		
		//쓰기
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\class\\java\\io\\data3.txt"));
		writer.write("문자열입니다");
		writer.newLine();	//엔터
		
		writer.close();
		System.out.println("완료");
		
		
	}

	private static void m5() throws Exception {
		
		//쓰기
		// - FileWriter: 문자 단위 쓰기
		
		//읽기
		// - FileReader: 문자 단위 읽기
		
		FileReader reader = new FileReader("D:\\class\\java\\io\\할일.txt");
		
		int code = reader.read();
		System.out.println((char)code);
		
		code = -1;
		while((code = reader.read()) != -1) {
			System.out.print((char)code);
		}
		
		reader.close();
		
		
	}

	private static void m4() throws Exception {
		
		//콜솔 입력 -> 파일 출력
		Scanner scan = new Scanner(System.in); //입력도구
		
		System.out.print("파일명: ");
		String filename = scan.nextLine();
		FileWriter writer =  new FileWriter("D:\\class\\java\\io\\" + filename);

		while (true) {
			String line = scan.nextLine(); 	//입력
			if (line.equals("q")) {
				break;
			}
			writer.write(line + "\r\n");	//출력
		}
		
		writer.close();
		scan.close();
		
		System.out.println("파일 저장 완료");
		
	}

	private static void m3() throws Exception {
		
		//쓰기
		// - 문자 단위 쓰기(2byte)
		// - 모든 문자를 쓰기가 가능하다.(한글 포함)
		//FileWriter
		
		FileWriter writer = new FileWriter("D:\\class\\java\\io\\data2.txt");
		
		writer.write(65);
		writer.write('A');
		
		writer.write("ABCDEFGHIJKLMNOPQRSTUWVXYZ");
		writer.write("한글");
		
		writer.close();
		
		//Stream을 닫으면 입출력이 불가, 스트림을 다시 열어야 입력 가능(객체 생성)
		writer = new FileWriter("D:\\class\\java\\io\\data2.txt");
		writer.write("추가작업"); //java.io.IOException: Stream closed 에러
		writer.close(); // close를 하지 않으면 파일에 데이터가 저장이 안됨.
						// 버퍼라는 임시 메모리공간에 데이터를 저장했다가 close 이후 텍스트 파일에 한꺼번에 저장
						// 메모리 공간과 하드디스크간의 자료 교환에 걸리는 시간이 오래 걸리기 때문에..
		
		System.out.println("완료");
		
		
		
	}

	private static void m2() throws Exception {

		//읽기
		// - 바이트 단위 읽기
		// - System.in.read()와 유사
		
		//읽기 전용 스트림 객체 생성하기
		File file = new File("D:\\class\\java\\io\\data.txt");
		FileInputStream stream = new FileInputStream(file);
		
//		int code = stream.read();
//		System.out.println(code);
//		code = stream.read();
//		System.out.println(code);
//		code = stream.read();
//		System.out.println(code);
		
		//.read() -> 더이상 읽을 게 없으면 -1을 반환
		int code = -1;
		
		while ((code = stream.read()) != -1) {
			System.out.print((char)code);
		}
		
		stream.close();
	}

	private static void m1() throws Exception {
		
		//쓰기
		// - 바이트 단위 쓰기
		// - 1바이트씩 저장 -> (기본적으론)2바이트 문자 저장 불가능 -> ASCII문자 저장(영어, 숫자, 특문)
		
		//파일에 데이터 저장하기
		//1. 스트림 객체 생성하기(열기, 읽기전용/쓰기전용 나누어져있음.)
		//2. 스트림 객체 사용하기
		//3. 스트림 객체 닫기(필수)
		
		//FileOutputStream
		// - 쓰기 전용 스트림
		// - 스트림 열기 모드
		//  a. 생성 모드, Create Mode
		//		- 기본 방식
		//		- 파일이 없으면 새로 만든다.
		//		- 무조건 덮어쓰기를 한다.
		//  b. 추가 모드, Append Mode
		//		- 선택 방식
		//		- 파일이 없으면 새로 만든다.
		//		- 
		
		//1. 스트림 생성(열기)
		File file = new File("D:\\class\\java\\io\\data.txt");
		
//		FileOutputStream stream = new FileOutputStream(file);		//Create Mode
		FileOutputStream stream = new FileOutputStream(file, true);	//Append Mode
		
		//2. 사용
		stream.write(97);
		stream.write(98);
		stream.write(99);
		stream.write(100);
		
		stream.write('\r');
		stream.write('\n');
		
		stream.write('J');
		stream.write('a');
		stream.write('v');
		stream.write('a');
		
		stream.write('\r');
		stream.write('\n');

		String str = "Hello~ Hong~";
		for (int i=0; i<str.length(); i++) {
			stream.write(str.charAt(i));
		}
		
		
		//3. 닫기
		stream.close();
		System.out.println("완료");
		
		
		
		
		
		
		
	}

}
