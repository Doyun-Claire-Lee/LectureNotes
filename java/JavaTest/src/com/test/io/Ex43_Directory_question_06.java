package com.test.io;

import java.io.File;

public class Ex43_Directory_question_06 {
	
	public static void main(String[] args) {
		
		//파일의 크기가 0byte인 파일만 삭제하시오.
		delete();
		
	}

	private static void delete() {
		
		String path = "D:\\파일_디렉토리_문제\\파일 제거";
		File dir = new File(path);
		int count = 0;
		
		
		if (dir.exists()) {
			
			File[] list = dir.listFiles();
			
			for (File file : list) {
				if (file.isFile() && file.length() == 0) {
					
					file.delete();
					count++;
				}
			}//for
			
			System.out.printf("총 %d개의 파일을 삭제했습니다.", count);
			
		} else {
			System.out.println("폴더 없음");
		}
		
	}

}
