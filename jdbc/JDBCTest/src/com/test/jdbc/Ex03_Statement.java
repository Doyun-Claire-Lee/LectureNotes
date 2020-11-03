package com.test.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class Ex03_Statement {

	
	public static void main(String[] args) {
		
		/*
		
		Statement 클래스
		- SQL문장을 실행하는 역할
		- 쿼리에 대한 작업만 담당, 연결 정보는 Connection개체에 의존
		- 모든 DML은 자동 커밋이 된다. (Auto Commit을 끌 수 있음.) *********
		
		
		Statement 종류
		1. Statement 클래스
			- 기본
		2. PreparedStatement 클래스
			- 인자값 관련 특화된 기능
			- 코드 안정성 높음, 가독성 높음
			- 코드량이 많음
		3. CallableStatement 클래스
			- 프로시저 전용
			- 
		
		
		*/
		
		//insert 작업
		Connection conn = null; //new Connection(); 이 아님!
		
		try {

			//1. 접속
			DBUtil util = new DBUtil();
			conn = util.open();
			
			//2. 질의 문자열
			//	- 한번에 한 문장만 실행 가능 -> 문장 종결자(;)사용 안함.
			String sql = "insert into tblAddress (seq, name, age, tel, address, regdate) values (seqAddress.nextVal, '아무개', 28, '010-1212-5678', '서울시 강남구 세곡동', default)";
			
			//3. Statement 객체 생성
			Statement stat = conn.createStatement(); //new Statement(); 가 아님!
			
			//4. SQL 실행
			//4-1. 반환값이 없는 쿼리
			//	-stat.excuteUpdate()
			//4-2. 반환값이 있는 쿼리
			//	-stat.excuteQuery()
			
			stat.executeUpdate(sql); //DB에 쿼리가 전달되고 실행됨. (자동커밋)
			
			//5. 접속 종료
			stat.close();
			conn.close();
			
			System.out.println("완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
