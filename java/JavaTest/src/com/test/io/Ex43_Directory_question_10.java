package com.test.io;

import java.io.File;

public class Ex43_Directory_question_10 {
	
	public static void main(String[] args) {
		
		//각 파일들을 아래의 조건에 따라 폴더를 나누어 정렬(이동)하시오.
		//1차 : 직원 이름으로 폴더 생성
		//2차 : 년도별로 폴더 생성
		//3차 : 각 파일을 직원 > 년도 폴더에 이동
		
		fileMove();
		
	}

	private static void fileMove() {

		String path = "D:\\파일_디렉토리_문제\\직원";
		File dir = new File(path);
		
		if (dir.exists()) {
			
			File[] list = dir.listFiles();
			
			for (File file : list) {
				
				if(file.isFile()) {
					
					String[] temp = file.getName().split("_");
					String subPath = "D:\\파일_디렉토리_문제\\직원" + "\\" + temp[0] + "\\" +temp[1];
					File subDir = new File(subPath);
					subDir.mkdirs();
					
					String movedPath = "D:\\파일_디렉토리_문제\\직원" + "\\" + temp[0] + "\\" +temp[1] + "\\" + file.getName();

//					System.out.println(subFile.getAbsolutePath());
					
					file.renameTo(new File(movedPath));
				}				
			}
			
		} else {
			System.out.println("폴더 없음");
		}
		
		
		
	}

}
