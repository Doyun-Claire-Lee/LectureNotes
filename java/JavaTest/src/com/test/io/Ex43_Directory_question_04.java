package com.test.io;

import java.io.File;

public class Ex43_Directory_question_04 {
	
	public static void main(String[] args) {
		
		//음악 파일이 100개 있다. 파일명 앞에 일련 번호를 붙이시오.
		
		numbering();
		
	}

	private static void numbering() {
		
		String path = "D:\\파일_디렉토리_문제\\음악 파일";
		File dir = new File(path);
		int count = 0;
		
		if (dir.exists()) {
			
			File[] list = dir.listFiles();
			
			for (int i=0; i<list.length; i++) {
				
				if (list[i].isFile()) {
					count++;
					String path2 = String.format("D:\\파일_디렉토리_문제\\음악 파일\\[%03d]%s", count, list[i].getName());
					File file = new File(path2);
					
					list[i].renameTo(file);
				}
			}
			
			list = dir.listFiles(); //변경된 값이 바로 반영이 되지 않기 때문에 새롭게 값을 불러와야 함.
			
			for (int i=0; i<list.length; i++) {
				System.out.println(list[i].getName());
			}
			
		} else {
			System.out.println("폴더 없음");
		}
		
		
		
		
	}

}
