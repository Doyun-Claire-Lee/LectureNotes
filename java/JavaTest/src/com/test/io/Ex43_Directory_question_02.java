package com.test.io;

import java.io.File;
import java.util.Scanner;

public class Ex43_Directory_question_02 {
	
	public static void main(String[] args) {
		
		//특정 폴더의 특정 파일(확장자)만을 출력하시오.

		files();
		
	}

	private static void files() {

		Scanner scan = new Scanner(System.in);
		System.out.print("폴더 선택: ");
		String path = scan.nextLine();
		System.out.print("파일 확장자: ");
		String extension = scan.nextLine().toLowerCase();
		
		File dir = new File(path);
		
			if (dir.exists()) {
				
				File[] list = dir.listFiles();
				
				for (File file : list) {
					if (file.isFile()) {
						String[] name = file.getName().split("\\.");
						if (name[name.length-1].toLowerCase().equals(extension)) {
							System.out.println(file.getName());
						}
					}
				}
				
			} else {
				System.out.println("폴더 없음.");
			}
		
		
		
		
	}

}
