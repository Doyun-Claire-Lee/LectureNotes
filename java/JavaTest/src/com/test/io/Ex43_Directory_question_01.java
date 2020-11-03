package com.test.io;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Ex43_Directory_question_01 {
	
	public static void main(String[] args) {
		
		//특정 파일의 경로를 입력받아 정보를 출력하시오.
		
		fileInfo();
		
		
	}

	private static void fileInfo() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("파일 경로: ");
		String path = scan.nextLine();
		
		File file = new File(path);
		String[] extension = file.getName().split("\\."); 
		String size = "";
		
		if (file.exists()) {
			
			if (file.length() < 1024) {
				size = String.format("%dB", file.length());
			} else if (file.length() < 1024 * 1024) {
				size = String.format("%.1fKB", (double)file.length()/1024);
			} else if (file.length() < 1024 * 1024 * 1024) {
				size = String.format("%.1fMB", (double)file.length()/1024/1024);
			} else if (file.length() < 1024 * 1024 * 1024 * 1024) {
				size = String.format("%.1fGB", (double)file.length()/1024/1024/1024);
			} else {
				size = String.format("%.1fTB", (double)file.length()/1024/1024/1024/1024);
			}
			
			System.out.printf("파일명: %s\n종류: %s파일\n파일 크기: %s\n"
															, file.getName()
															, extension[extension.length-1]
															, size);
		} else {
			System.out.println("파일 없음");
		}
		
	}

}
