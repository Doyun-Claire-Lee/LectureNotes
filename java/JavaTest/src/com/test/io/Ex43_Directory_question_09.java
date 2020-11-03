package com.test.io;

import java.io.File;
import java.util.ArrayList;

public class Ex43_Directory_question_09 {
	
	public static void main(String[] args) {
		
		//폴더의 위치와 상관없이 모든 폴더 내의 파일들을 찾아 한번에 크기를 비교하고, 크기가 큰 순으로 정렬하시오.
		
		arrange();
		
	}

	private static void arrange() {
		
		String path = "D:\\파일_디렉토리_문제\\크기 정렬";
		File dir = new File(path);
		ArrayList<File> list = new ArrayList<File>();
		
		if (dir.exists()) {
			
			addFile(dir, list);
			
			for (int i=0; i<list.size(); i++) {
				for (int j=0; j<list.size()-i-1; i++) {
					
					if (list.get(j).length() > list.get(j+1).length()) {
						File temp = list.get(j);
						list.set(j, list.get(j+1));
						list.set(j+1, temp);
					}
				}		
			}//for
			
			
			System.out.printf("%-24s\t%6s\t%-20s\n", "[파일명]", "[크기]", "[파일이 들어있는 폴더]");
			for (int i=0; i<list.size(); i++) {
				if (list.get(i).isFile()) {
					//String[] names = list.get(i).getPath().split("\\\\");
					System.out.printf("%-24s\t%6dKb\t%s\n"
							, list.get(i).getName()
							, list.get(i).length() / 1024
							//, names[names.length-2]);
							, list.get(i).getParentFile().getName());

				}
			}
		}
	}

	private static void addFile(File dir, ArrayList<File> list) {
		
		File[] files = dir.listFiles();
		
		for (File file : files) {
			
			if (file.isFile()) {
				list.add(file);					
			}
		}
		
		for (File file : files) {
			
			if (file.isDirectory()) {
				addFile(file, list);
			}
			
		}
	}

}
