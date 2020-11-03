package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Ex01 {
	
	public static void main(String[] args) {
		
		/*
		
		JDBC, Java Database Connectivity
		- 자바 응용 프로그램(콘솔, 웹, 모바일 등...)과 데이터베이스 시스템(오라클, MySql, MS-SQL 등..)간의 연결을 시켜주는 중간 계층
		- 사람(유저) <-> SQL Developer(툴)	<-> SQL(질의) <-> 오라클(서버)
		- 자바(유저) <-> JDBC(툴) 			<-> SQL(질의) <-> 오라클(서버)
		
		
		
		[사람 + SQL Developer로 작업시]
		
		1. developer 툴 실행
		
		2. DB접속
			2-1. 호스트명 : 서버ID or 도메인주소
			2-2. 포트번호 : 1521
			2-3. SID : ex
			2-4. 드라이버 : thin(oci)
			2-5. 사용자명 : hr
			2-6. 비밀번호 : java1234
			
		3. 질의(****)
			3-1. SQL사용
			3-2. 반환값이 없는 쿼리
				- select를 제외한 모든 쿼리
			3-3. 반환값이 있는 쿼리
				- 결과셋을 반환하는 쿼리
				- select
				- 결과셋 -> 업무에 사용
				
		4. 접속 종료
			4-1. commit or rollback
			4-2. 접속 종료
		
		[(사람 + JAVA)로 작업시]
		
		1. 응용 프로그램(JAVA)실행
		
		2. 접속(JDBC)
			- Connection 클래스 사용
			2-1. 호스트명 : 서버ID or 도메인주소
			2-2. 포트번호 : 1521
			2-3. SID : ex
			2-4. 드라이버 : thin(oci)
			2-5. 사용자명 : hr
			2-6. 비밀번호 : java1234
			
		3. 질의(****)
			- Statement 클래스 사용
			3-1. SQL사용
			3-2. 반환값이 없는 쿼리
				- select를 제외한 모든 쿼리
			3-3. 반환값이 있는 쿼리
				- ResultSet클래스 사용 -> select 결과셋 참조
				- 결과셋을 반환하는 쿼리
				- select
				- 결과셋 -> 업무에 사용
			
		4. 접속 종료
			- Connection 클래스 사용
			4-1. commit or rollback
			4-2. 접속 종료		


		Connection, Statement, ResultSet 클래스
			- JDBD관련 클래스를 사용하려면 *.jar 파일을 참조해야 함.
			- 데이터베이스 제조사에서 제공, DB종류 & 버전에 따라 다양하게 제공
		
		JDBC사용 환경 셋팅하기
			- ojdbcXX.jar
			- oracle 11g >>> ojdbc6.jar or ojdbc14.jar
			-C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
		
		*/
		
		//1. DB접속하기
		// - Connection 클래스
		// - java.sql
		
		Connection conn = null;
		
		//연결 문자열 생성(접속 정보)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pw = "java1234";
		
		//DB작업은 외부환경이기 때문에 예외처리를 필수로 해야함.
		try {
			
			//설치된 JDBC 드라이버 로딩(상투적인 구문)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//접속(Connection객체 생성후 반환 + DB연결)
			//conn : 연결 참조 객체
			conn = DriverManager.getConnection(url, id, pw);
			
			//접속 확인
			//false : 연결지속, true : 연결끊김
			System.out.println(conn.isClosed());
			
			//질의(업무)>>select, insert, update, delete...
			
			//2. DB접속 종료
			// - Connection 클래스
			conn.close();
			System.out.println(conn.isClosed());
			
			
			
		} catch (Exception e) {
			
		}
		
		
		
		
	
	}//main

}
