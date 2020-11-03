package com.test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Ex44_File_IO_quesiton_04 {
	
	public static void main(String[] args) throws Exception {
		
		//파일내의 성적을 확인 후 합격자/불합격자 명단을 출력하시오.
		//합격 조건 : 3과목 평균 60점 이상
		//과락 조건 : 1과목 40점 미만
		//이름,국어,영어,수학
		
		passFail();
		
	}

	private static void passFail() throws Exception {
	
		File file = new File("D:\\파일_입출력_문제\\성적.dat");
		
		if (file.exists()) {
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			
			ArrayList<String> passList = new ArrayList<String>();
			ArrayList<String> failList = new ArrayList<String>();
			
			while ((line = reader.readLine()) != null) {
				
				String[] result = line.split(",");
				int kor = Integer.parseInt(result[1]);
				int eng = Integer.parseInt(result[2]);
				int math = Integer.parseInt(result[3]);
				
				if ((kor >= 40 && eng >= 40 && math >= 40) && (kor + eng + math)/3 >= 60) {
					
					passList.add(result[0]);
										
				} else {
					failList.add(result[0]);
				}
			}//while
			
		reader.close();
		
		System.out.println("[합격자]");
		for (String name : passList) {
			System.out.println(name);
		}
		System.out.println("[불합격자]");
		for (String name : failList) {
			System.out.println(name);
		}
		
	
		} else {
			System.out.println("파일 없음");
		}
		
		
		
	
	
	}

}
