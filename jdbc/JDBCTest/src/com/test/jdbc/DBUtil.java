package com.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

//슬래시 + ** 치고 엔터(주로 Public 멤버에게 다는 주석, JAVA DOC 주석)
/**
 * 
 * @author Doyun Lee
 * 오라클 연결 클래스입니다.
 *
 */
public class DBUtil {
	
	private Connection conn = null;
	
	/**
	 * 서버에 연결합니다.
	 * @return 연결 객체를 반환합니다.
	 */
	public Connection open() {
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pw = "java1234";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);

			return conn;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}//open
	
	
	/**
	 * 서버에 연결합니다.
	 * @param host 서버 주소
	 * @param id 계정명
	 * @param pw 비밀번호
	 * @return 연결객체를 반환합니다.
	 */
	public Connection open(String host, String id, String pw) {
		
		
		String url = "jdbc:oracle:thin:@" + host + ":1521:xe";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);

			return conn;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}//open
	
	/**
	 * 연결을 종료합니다.
	 */
	public void close() {
		
		try {	
			
			conn.close();
		
		} catch (Exception e) {
		
		}
		
	}
	

}
