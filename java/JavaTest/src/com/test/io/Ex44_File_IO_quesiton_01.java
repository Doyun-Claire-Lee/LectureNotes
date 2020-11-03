package com.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Ex44_File_IO_quesiton_01 {
	
	public static void main(String[] args) throws Exception {
		
		//파일내에서 특정 이름을 찾아 다른 이름으로 변환 후 해당 파일을 다른 이름으로 저장하시오.
		//'유재석' → '메뚜기'
		//저장할 파일명 : 이름수정_변환.dat
		
		nameChange();
		
		
	}

	private static void nameChange() throws Exception {
		
		File file = new File("D:\\파일_입출력_문제\\이름수정.dat");
	
		
		if (file.exists()) {
			
			BufferedReader reader =  new BufferedReader(new FileReader(file));
			BufferedWriter writer =  new BufferedWriter(new FileWriter("D:\\파일_입출력_문제\\이름수정_변환.dat", true));
			String line = null;
			
			while((line = reader.readLine()) != null) {

				writer.write(line.replace("유재석", "메뚜기"));
				writer.newLine();
				
			}
			
			reader.close();
			writer.close();
			System.out.println("변환 완료");
			
		} else {
			System.out.println("파일 없음");
		}
		
		
	}

}
