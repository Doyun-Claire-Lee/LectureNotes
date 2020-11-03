package com.test.io;

import java.io.File;

public class Ex43_Directory_question_08 {
	
	public static int dirCount;
	public static int fileCount;
	
	public static void main(String[] args) {
		
		//'delete' 폴더를 삭제하시오.
		
		delete();
		
	}

	private static void delete() {
		
		String path = "D:\\파일_디렉토리_문제\\폴더 삭제\\delete";
		File dir = new File(path);
		
		if (dir.exists()) {
			
			subDelete(dir);
			System.out.printf("폴더를 삭제했습니다.\n삭제된 폴더는 %d개이고, 파일은 %d개입니다.", dirCount, fileCount);
			
		} else {
			System.out.println("폴더 없음");
		}
		
		
	}

	private static void subDelete(File dir) {
		
		File[] list = dir.listFiles();
		
		for (File file : list) {
			
			if (file.isFile()) {
				file.delete();
				fileCount++;
			} 
		}
		
		for (File file : list) {
			if (file.isDirectory()) {
				subDelete(file);
				file.delete();
				dirCount++;
			}
		}
	}

}
