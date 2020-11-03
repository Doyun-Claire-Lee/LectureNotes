package com.test.io;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class Ex43_Directory_basic {
	
	private static int count = 0;	//m7()용 누적변수
	
	public static void main(String[] args) {
		
//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
//		m6();
//		m7();
		m8();
	
	}

	private static void m8() {
		
		//정렬
		//D:\class\java\JavaTest\src\com\test\object
		//파일 목록 출력하기
		
		String path = "D:\\class\\java\\JavaTest\\src\\com\\test\\object";
		File dir = new File(path);
		File[] list = dir.listFiles();	//파일명을 기준으로 자동적으로 정렬함.
		
		//파일 크기를 기준으로 정렬하기
		//정렬 알고리즘, 5~6개 있음
		// - 버블 정렬(쉬움, 가장 효율(?)이 나쁘지만 일반적인 정렬 업무는 보통 효율을 따질 필요가 없음)
		// - 퀵정렬(가장 효율이 좋음, 어려움)
		
		//선택 정렬
//		for (int i=0; i<list.length-1; i++) {
//			for (int j=i; j<list.length; j++) {
//				
//				if(list[i].length() > list[j].length()) {
//					
//					File temp = list[i];
//					list[i] = list[j];
//					list[j] = temp;		
//				}
//			}
//		}
		
		//버블 정렬
		for (int i=0; i<list.length; i++) {
			for (int j=0; j<list.length-i-1; j++) {
				
				if(list[j].length() > list[j+1].length()) {
					File temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;		
				}
			}
		}
		
		//출력
		for (File file : list) {
			if (file.isFile()) {
				System.out.printf("[%,5dB] %s\n"
											, file.length()
											, file.getName());				
			}
		}
		
	}//m8

	private static void m7() {
		
		//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
		//m6()을 재귀 호출 구조로 변경하기
		
		String path = "C:\\eclipse";
		File dir = new File(path);
		
		if (dir.exists()) {
			
			countFile(dir);
			
		}
		
		System.out.println("파일 개수: " + count);
		
		
		
		
	}

	private static void countFile(File dir) {
		//1. 자식 목록 가져오기
		File[] list = dir.listFiles();
		
		//2. 파일만 갯수 세기
		for (File sub : list) {
			if(sub.isFile()) {	//폴더를 세고싶으면 .isDirectory()
				count++;
			}
		}
		
		//3. 자식 폴더를 대상으로 했던 행동 다시하기
		for (File sub : list) {
			if(sub.isDirectory()) {
				//똑같은 행동을 반복
				countFile(sub); //재귀 호출★★★★★★★★★★★★★★★★★★★★★★★★★★
				
			}
		}
	}

	private static void m6() {
		
		//특정 폴더의 모든 파일 갯수 세기
		//재귀메소드 사용..
		
		String path = "C:\\eclipse";
		File dir = new File(path);
		
		if (dir.exists()) {
	
			int count = 0;					//누적 변수
			File[] list = dir.listFiles(); 	//하위 파일 얻어오기
			
			for (File sub : list) {
				if (sub.isFile()) {
					count++;
				}
			}//파일 갯수 세기
			
			//하위 폴더로 이동
			for (File sub : list) {
				if (sub.isDirectory()) {
					
					File[] subList = sub.listFiles(); //하위 폴더의 하위파일 가지고오기
					
					for (File subsub : subList) {
						if(subsub.isFile()) {
							count++;
						}
					}
					
					//하위폴더의 하위폴더로 이동..
					for (File subsub : subList) {
						if (subsub.isDirectory()) {
							File[] subsublist = subsub.listFiles(); //증손자들..
						
						for (File subsubsub : subsublist) {
							if(subsubsub.isFile()) {
								count++;
							}
						}
							
						}
						
					}
				
				}
				
				
			}
			
			
			System.out.println("총 파일 개수: " + count);
			
			
		}
		
		
		
	}

	private static void m5() {
		
		//디렉토리 내용 보기(탐색) ★★★★★★
		// -하위 파일 + 하위 디렉토리
		
		String path = "C:\\eclipse";
		File dir = new File(path);
		
		if (dir.exists()) {
			
			//.list(): Returns an array of strings naming the files and directories in the directory denoted by this abstract pathname. 
//			String[] list = dir.list();
//			
//			for (String name : list) {
//				System.out.println(name);
//				File file = new File(path + "\\" + name);
//				System.out.println(file.length());
//			}
	
			File[] list = dir.listFiles();	//파일 객체의 배열을 반환해줌
			
//			for (File file : list) {
//				
//				System.out.println(file.getName());
////				System.out.println(file.isFile());
//				
//				if(file.isFile()) {
//					System.out.println(file.length());
//				}				
//			}
			
			for (File sub : list) {
				
				if (sub.isDirectory()) {
					System.out.printf("[%-15s]\t", sub.getName());
					System.out.print("\t");
					System.out.print("파일 폴더\t");
					Date date = new Date(sub.lastModified());
					System.out.printf("%tF %tT\n", date, date);
				}
			}
			
			for (File sub : list) {
				
				if (sub.isFile()) {
					System.out.print(sub.getName() + "\t\t");
					System.out.printf("%,dKB\t", sub.length() / 1024);
					System.out.print("파일\t\t");
					Date date = new Date(sub.lastModified());
					System.out.printf("%tF %tT\n", date, date);
				}
			}
			
		} else {
			System.out.println("폴더 없음");
		}
		
	}

	private static void m4() {
		
		//디렉토리 삭제
		// - 빈폴더만 삭제 가능하다.
		// - 내용물을 직접 지우면 폴더를 삭제할 수 있다. -> 해당 폴더 내의 모든 파일을 삭제 후 폴더를 빈폴더로 만들고 삭제
		
		String path = "D:\\class\\java\\io\\GGG";
		File dir = new File(path);
		
		if (dir.exists()) {
			System.out.println(dir.delete());
		} else {
			System.out.println("폴더 없음");
		}
	
	}

	private static void m3() {
		
		//디렉토리명 변경 & 이동
		
		String path = "D:\\class\\java\\io\\BBB";
		File dir = new File(path);
		
		if (dir.exists()) {
			
			String path2 = "D:\\class\\java\\io\\GGG\\BBB";
			File dir2 = new File(path2);
			
			dir.renameTo(dir2);
			System.out.println("디렉토리 수정");
		
		} else { 
			System.out.println("디렉토리 없음.");
		}
		
	}

	private static void m2() {
		
		//디렉토리 조작
		// - 생성, 이름바꾸기, 이동, 삭제(, 복사)
		
		//새 폴더 만들기
//		String path ="D:\\class\\java\\io\\CCC"; //희망 경로를 적기
		String path ="D:\\class\\java\\io\\DDD\\EEE\\FFF"; //
		File dir = new File(path);
		
//		boolean result = dir.mkdir(); 	//makeDirectory, boolean값 반환, 마지막 폴더만 생성해줌
		boolean result = dir.mkdirs();	//makeDirectories, boolean값 반환, 경로에 없는 모든 폴더를 생성해줌
		
		if(result) {
			System.out.println("폴더 생성 성공");
		} else {
			System.out.println("폴더 생성 실패");
		}
		
		
		//요구사항)
		//회원별 개인 폴더 작성하기
		String[] member = {"홍길동", "아무개", "하하하", "호호호", "후후후"};
		
		for (String name : member) {
			
			//폴더 생성
			path = String.format("D:\\class\\java\\io\\AAA\\[개인폴더]%s님", name);
			dir = new File(path);
			dir.mkdir();
			
			System.out.printf("%s님의 개인 폴더를 생성했습니다.\n", name);
		
		}
		
		
		//요구사항)
		//날짜별 폴더 생성하기
		//2020.01.01 ~ 2020.12.31
		// - Calendar 사용
		
		Calendar c = Calendar.getInstance();
		c.set(2020, 0, 1);
		
		System.out.println(c.getMaximum(Calendar.DAY_OF_YEAR)); //한 해가 며칠인지 알고싶을 때
		
		for (int i=0; i<c.getMaximum(Calendar.DAY_OF_YEAR); i++) {

			path = String.format("D:\\class\\java\\io\\BBB\\%tF", c);
			dir = new File(path);
			dir.mkdir();
			
//			System.out.printf("%tF\n", c);
			c.add(Calendar.DATE, 1);
			
		}
		
		
		
	}

	private static void m1() {
		
		//디렉토리 정보 확인
		// - 디렉토리 참조 객체 -> 정보 or 조작
		
		//디렉토리 참조 객체
		
		String path = "D:\\class\\java\\io\\AAA";
		File dir = new File(path);
		//폴더는 사실 폴더가 아니고 개별 파일이 참조하는 파일이라 폴더임에도 불구하고 File 객체로 생성
		//폴더는 사이즈 0짜리 파일임.
		
		if (dir.exists()) {
			
			//디렉토리 정보 확인
			System.out.println(dir.getName());			//폴더명 확인
			System.out.println(dir.isFile());			//파일인지?
			System.out.println(dir.isDirectory());		//폴더인지?
			System.out.println(dir.length());			//크기 -> 0byte, 폴더 자체의 크기는 항상 0byte임.
														//폴더 안의 파일 크기를 합산하여 알려주는 메소드는 없음. 구현해야 함.
			
			System.out.println(dir.getAbsolutePath());	//
			System.out.println(dir.getPath());			//
				
			System.out.println(dir.getParent());		//부모 폴더의 경로만 반환
			System.out.println(dir.getParentFile());	//부모 폴더를 참조하는 객체 반환
			
		} else {
			System.out.println("디렉토리 없음.");
		}
		
	}

}
