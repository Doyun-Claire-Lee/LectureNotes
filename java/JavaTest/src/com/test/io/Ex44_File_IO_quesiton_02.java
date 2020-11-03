package com.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class Ex44_File_IO_quesiton_02 {
	
	public static void main(String[] args) throws Exception {
		
		//파일내에서 아라비안 숫자를 찾아서 한글로 바꿔 다른 이름으로 저장하시오.
		//0 → 영, 1 → 일 ... 9 → 구
		//저장할 파일명 : 숫자_변환.dat
		
		numberChange();
		
	}

	private static void numberChange() throws Exception {
		
		File file = new File("D:\\파일_입출력_문제\\숫자.dat");
		
		if (file.exists()) {
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\파일_입출력_문제\\숫자_변환.dat", true));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				System.out.println(line);
				
				writer.write(line.replace("0", "영").replace("1", "일").replace("2", "이").replace("3", "삼").replace("4", "사").replace("5", "오").replace("6", "육").replace("7", "칠").replace("8", "팔").replace("9", "구"));
				writer.newLine();
				
			}
			
			writer.close();
			reader.close();
						
			System.out.println("변환 완료");
			
		} else {
			System.out.println("파일 없음");
		}
		
		
		
	}

}
