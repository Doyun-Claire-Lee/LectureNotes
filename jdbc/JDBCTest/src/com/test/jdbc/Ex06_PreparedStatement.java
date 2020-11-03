package com.test.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex06_PreparedStatement {
	
	public static void main(String[] args) {
		
		//insert 작업
//		m1();	//Statement >> 정적 쿼리
		m2();	//PreparedStatement >> 동적 쿼리 
		
		
		//Statement vs PreparedStatement
		//1. SQL매개변수 유무
		// - select * from tblInsa >> 정적쿼리, Statement 사용
		// - select * from tblInsa where num = 사용자입력 >> 동적쿼리, PreparedStatement 사용
		
		
		
	}//main

	private static void m2() {
		
		//사용자가 입력했다고 가정
		String name = "아무개";
		String age = "25";
		String tel = "010-1212-1212";
		String address = "서울시 강남구's 역삼동";
		
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {

			conn = util.open();

			String sql = "insert into tblAddress(seq, name, age, tel, address, regdate) "
										+ "values (seqAddress.nextVal, ?, ?, ?, ?, default)"; // ? >> 오라클에서 사용하는 parameter(변수표현)
			
			//stat = conn.createStatement()
 			stat = conn.prepareStatement(sql); //객체를 만들 때 부터 쿼리를 넣어줘야 함.
			
 			stat.setString(1, name); //첫번째 물음표에 String name값을 넣어달라 --> 자바 자료형에 따름.
 			stat.setString(2, age); //자바에서 age를 스트링으로 저장했기 때문에 age를 씀. 
 			stat.setString(3, tel);
 			stat.setString(4, address);	//자동으로 '를 이스케이프 해줌.
 			
			stat.executeUpdate();//메소드만 실행시키면 됨. 매개변수로 sql줄 필요 x
			
			System.out.println("실행 완료");

			stat.close();
			conn.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m1() {
		
		//사용자가 입력했다고 가정
		String name = "아무개";
		String age = "25";
		String tel = "010-1212-1212";
		String address = "서울시 강남구 역삼동";
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {

			conn = util.open();
			stat = conn.createStatement();

			String sql = String.format("insert into tblAddress(seq, name, age, tel, address, regdate) "
										+ "values (seqAddress.nextVal, '%s', %s, '%s', '%s', default)"
											, name, age, tel, address);

			stat.executeUpdate(sql);
			System.out.println("실행 완료");

			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
