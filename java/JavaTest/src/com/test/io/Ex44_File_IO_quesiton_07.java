package com.test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Ex44_File_IO_quesiton_07 {
	
	public static void main(String[] args) throws Exception {
		
		//직원들의 지각 횟수와 조퇴 횟수를 카운트해서 출력하시오.
		//출결.dat
		//2018-8-28,김재동,6:18,19:6
		//출근 : 오전 9시
		//퇴근 : 오후 6시
		//[이름]    [지각]    [조퇴] 
		//홍길동       4회       0회 
		//아무개       0회       0회 
		//하하하       2회       3회 
		
		attendance();
		
	}

	private static void attendance() throws Exception {

		File file = new File("D:\\파일_입출력_문제\\출결.dat");	
		
		
		if (file.exists()) {
			
			 BufferedReader reader = new BufferedReader(new FileReader(file));
			 ArrayList<MyMember> members = new ArrayList<MyMember>();
			 
			 String line = null;
			 		 		 
			 while ((line = reader.readLine()) != null) {
				 
				 String[] list = line.split(",");
				 
				 MyMember temp = null;
				 
				 boolean flag = false;
				 for (MyMember member : members) {
					 if (member.getName().equals(list[1])) {
						 temp = member;
						 flag = true;
					 }
				 }
				 if (!flag) {
					 temp = new MyMember(list[1],0,0);
					 members.add(temp);
				 }
				 
				 
				 String[] t1 = list[2].split(":");
				 String[] t2 = list[3].split(":");
				 
				 if (Integer.parseInt(t1[0]) >= 9) {
					 temp.setNum1(temp.getNum1()+1);
				 }
				 if (Integer.parseInt(t2[0]) < 18) {
					 temp.setNum2(temp.getNum2()+1);
				 }
				 
			 }
			 reader.close();
			 
			 System.out.println("[이름]\t[지각]\t[조퇴]");
			 for (MyMember member : members) {
				 System.out.printf("%s\t%2d회\t%2d회\n"
						 				, member.getName()
						 				, member.getNum1()
						 				, member.getNum2());
			 }

		} else {
			System.out.println("파일 없음");
		}
		
	}

}

class MyMember {
	
	private String name;
	private int num1; //지각
	private int num2; //조퇴
	
	public MyMember(String name, int num1, int num2) {
		this.name = name;
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public MyMember() {
		this("",0,0);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	
}