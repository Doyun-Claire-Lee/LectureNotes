package com.test.io;

import java.io.File;

public class Ex43_Directory_question_07 {
	
	public static void main(String[] args) {
		
		//'MusicA와 MusicB 폴더를 서로 비교해서 양쪽 폴더에 모두 존재하는 파일만을 출력하시오.(중복 파일 알아내기)
		
//		추가조건
//		MusicA에만 존재하는 파일을 출력하시오.
//		MusicB에만 존재하는 파일을 출력하시오.
		
		fileCheck();
		
	}

	private static void fileCheck() {
		
		String pathA = "D:\\파일_디렉토리_문제\\동일 파일\\MusicA";
		String pathB = "D:\\파일_디렉토리_문제\\동일 파일\\MusicB";
		
		File dirA = new File(pathA);
		File dirB = new File(pathB);
		
		if (dirA.exists() && dirB.exists()) {
			
			File[] listA = dirA.listFiles();
			File[] listB = dirB.listFiles();
			
			duplicatedCheck(listA, listB);

		} else {
			System.out.println("폴더 없음");
		}
		
		
	}

	private static void duplicatedCheck(File[] listA, File[] listB) {
		
		for (File fileA : listA) {
			for (File fileB : listB ) {
				if (fileA.getName().equals(fileB.getName())) {
					System.out.println(fileA.getName());
				}
			}
		}
	}
	

}
