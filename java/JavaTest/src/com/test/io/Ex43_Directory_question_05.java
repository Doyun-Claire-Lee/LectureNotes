package com.test.io;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

public class Ex43_Directory_question_05 {
	
	public static void main(String[] args) {
		
		//이미지 파일이 확장자별로 있다. 확장자별로 파일이 몇개 있는지 세시오.
		count();
		
	}

	private static void count() {
		
		String path = "D:\\파일_디렉토리_문제\\확장자별 카운트";
		File dir = new File(path);
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		if (dir.exists()) {
			
			File list[] = dir.listFiles();

			for (int i=0; i<list.length; i++) {
				
				if (list[i].isFile()) {
					
					String[] name = list[i].getName().split("\\.");
					
					String extension = name[name.length-1];
					
					if (map.containsKey(extension)) {
						map.put(extension, map.get(extension)+1);
					} else {
						map.put(extension, 1);	
					}
				}
			}
			
			Set<String> set = map.keySet();
			for (String item : set) {
				System.out.printf("*.%s : %2d개\n", item, map.get(item));
			}
			
		} else {
			System.out.println("폴더 없음");
		}
	
	}

}
