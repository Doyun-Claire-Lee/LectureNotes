package com.test.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Ex04_DML {
	
	public static void main(String[] args) {
		
		
	
//		m1();
		
		m2();
		
	}//main

	private static void m2() {


		Connection conn = null;
		Statement stat = null;
		Scanner scan = new Scanner(System.in);
		DBUtil util = new DBUtil();
		
		try {

			//1. 접속
			conn = util.open();
			
			//2. 질의 문자열
//			String sql = "update tblAddress set age = age + 1";
//			String sql = "delete from tblAddress where seq = 3";
			
			//DDL
//			String sql = "create table tblAAA (seq number primary key, data varchar2(100) not null)";
			String sql = "drop table tblAAA";
			
			
			System.out.println(sql); //디버깅 출력문
				
			//3. Statement 객체 생성
			stat = conn.createStatement(); 
			//4. SQL 실행
			int result = stat.executeUpdate(sql); //DB에 쿼리가 전달되고 실행됨. (자동커밋)
			//DML 실행시 반환되는 숫자값은 적용된 행의 갯수임. DDL은 숫자값을 반환해주지 않음.
			
			if (result > 0) {
				System.out.println("SQL 실행 완료");
			} else {
				System.out.println("SQL 실행 실패");
			}
			
			//5. 접속 종료
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m1() {

		
		//동적SQL로 만들기
		
		Connection conn = null; //new Connection(); 이 아님!
		Statement stat = null;
		Scanner scan = new Scanner(System.in);
		DBUtil util = new DBUtil();
		
		
		try {

			System.out.print("이름 : ");
			String name = scan.nextLine();
			System.out.print("나이 : ");
			String age = scan.nextLine();
			System.out.print("전화번호 : ");
			String tel = scan.nextLine();
			System.out.print("주소 : ");
			String address = scan.nextLine();

			//1. 접속
			conn = util.open();
			
			//2. 질의 문자열
			//	- 한번에 한 문장만 실행 가능 -> 문장 종결자(;)사용 안함.
			String sql = String.format("insert into tblAddress (seq, name, age, tel, address, regdate) values (seqAddress.nextVal, '%s', %s, '%s', '%s', default)"
												, name
												, age
												, tel
												, address);
			
			System.out.println(sql); //디버깅 출력문
				
			//3. Statement 객체 생성
			stat = conn.createStatement(); //new Statement(); 가 아님!
			
			//4. SQL 실행
			//4-1. 반환값이 없는 쿼리
			//	-stat.excuteUpdate()
			//4-2. 반환값이 있는 쿼리
			//	-stat.excuteQuery()
			
			int result = stat.executeUpdate(sql); //DB에 쿼리가 전달되고 실행됨. (자동커밋)
			
			if (result > 0) {
				System.out.println("SQL 실행 완료");
			} else {
				System.out.println("SQL 실행 실패");
			}
			
			//5. 접속 종료
			stat.close();
			conn.close();
			
			System.out.println("완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
