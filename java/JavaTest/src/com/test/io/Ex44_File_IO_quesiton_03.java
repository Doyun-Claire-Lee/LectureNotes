package com.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Scanner;

public class Ex44_File_IO_quesiton_03 {
	
	public static void main(String[] args) throws Exception {
		
		//메모장을 구현하시오.
		//쓰기
		//이름
		//작성시간
		//메모 내용(단일 라인)
		//메모 내용(다중 라인)
		//읽기
		//메모를 목록으로 출력
		
		memo();
		
	}

	private static void memo() throws Exception {
		
		File file = new File ("D:\\파일_입출력_문제\\memo.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		Scanner scan = new Scanner(System.in);

			
		System.out.print("이름: ");
		String name = scan.nextLine();
		writer.write(name+",");
		
		Calendar date = Calendar.getInstance();
		writer.write(String.format("%tF %tT,", date, date));
		
		System.out.print("내용: ");
		String content = scan.nextLine();
		writer.write(content+"\r\n");

		writer.close();
		
		
		
	}	
		

	
	

}
