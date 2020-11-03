package com.test.io;

import java.io.File;
import java.util.Scanner;

public class Ex43_Directory_question_03 {
	
	public static void main(String[] args) {
		
		//특정 파일을 이동하고, 중복되는 경우를 처리하시오.
		
		move();
	}

	private static void move() {
		
		Scanner scan = new Scanner(System.in);
		
		String originalPath = "D:\\class\\java\\file\\AAA\\test.txt";
		File originalFile = new File(originalPath);
		String movedPath = "D:\\class\\java\\file\\BBB\\test.txt";
		File movedFile = new File(movedPath);
		
		
		if (originalFile.exists()) {
			System.out.println("파일 이동을 실행합니다.");
			
			if(movedFile.exists()) {
				System.out.print("같은 이름을 가지는 파일이 이미 존재합니다. 덮어쓸까요?(y/n)");
				String input = scan.nextLine();
				
				switch (input) {
				
					case "y" :
						movedFile.delete();
						originalFile.renameTo(movedFile);
						System.out.println("파일을 덮어썼습니다.");
						break;
						
					case "n" :
						System.out.println("작업을 취소합니다.");
						break;
				}//switch
			} else {
				originalFile.renameTo(movedFile);
				System.out.println("파일 이동이 완료되었습니다.");
			}

		} else {
			System.out.println("파일 없음");
		}
		
	}

}
