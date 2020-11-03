package com.test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Ex44_File_IO_quesiton_06 {
	
	public static void main(String[] args) throws Exception {
		
		//검색할 이름을 입력받아 해당 회원의 주문 정보를 출력하시오.
		//검색_회원.dat
		//1,정재재,서울시 강동구 라동
		//검색_주문.dat
		//1,마우스,19,53
		//==== 구매내역 ==== 
		//[번호]    [이름]    [상품명]    [개수]    [배송지]
		//     3    홍길동     마우스          3    서울시 강동구 천호동
		
		orderList();
	}

	private static void orderList() throws Exception {
		
		File member = new File("D:\\파일_입출력_문제\\검색_회원.dat");
		File order = new File("D:\\파일_입출력_문제\\검색_주문.dat");
		
		if(member.exists() && order.exists()) {
			
			Scanner scan = new Scanner(System.in);
			BufferedReader readMember = new BufferedReader(new FileReader(member));
			BufferedReader readOrder = new BufferedReader(new FileReader(order));
			
			System.out.print("이름 :");
			String name = scan.nextLine();
			
			System.out.println("[번호]\t[이름]\t[상품명]  [개수]  [주소]");
			String line = null;
			
			while ((line = readMember.readLine()) != null) {
				
				String[] memberInfo = line.split(",");
				
				if (name.equals(memberInfo[1])) {
					
					String subLine = null;
					while ((subLine = readOrder.readLine()) != null) {
						String[] orderInfo = subLine.split(",");
						
						if(memberInfo[0].equals(orderInfo[3])) {
							System.out.printf("%6d\t%s\t%4s %6d  %s\n"
													,Integer.parseInt(memberInfo[0])
													,memberInfo[1]
													,orderInfo[1]
													,Integer.parseInt(orderInfo[2])
													,memberInfo[2]);
						}
					}
				}	
			}
			
			readMember.close();
			readOrder.close();
			scan.close();
			
		} else { 
			System.out.println("파일 없음");
		}
		
		
	}

}
