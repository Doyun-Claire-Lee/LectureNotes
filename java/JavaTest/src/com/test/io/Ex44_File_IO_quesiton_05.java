package com.test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Ex44_File_IO_quesiton_05 {
	
	public static void main(String[] args) throws Exception {
		
		//검색할 이름을 입력받아 해당 회원의 모든 정보를 출력하시오.
		//[홍길동] 
		//번호 : 33 
		//주소 : 서울시 강남구 역삼동 
		//전화 : 010-2345-6789 
		//32,유유유,강릉시 강서구 다동, 010-1096-4380
		
		info();
		
	}

	private static void info() throws Exception {
		
		File file = new File("D:\\파일_입출력_문제\\단일검색.dat");
		
		if (file.exists()) {
			Scanner scan = new Scanner(System.in);
			System.out.print("이름: ");
			String name = scan.nextLine();
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] info = line.split(",");
				
				if (name.equals(info[1])) {
					System.out.printf("[%s]\n번호 : %s\n주소 : %s\n전화 :%s"
											,info[1]
											,info[0]
											,info[2]
											,info[3]);
				} 
			}
			
			reader.close();
			scan.close();
			
		} else {
			System.out.println("파일 없음");
		}
		
		
		
		
		
		
		
		
	}

}
