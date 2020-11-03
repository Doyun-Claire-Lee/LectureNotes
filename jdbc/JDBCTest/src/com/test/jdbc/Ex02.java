package com.test.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class Ex02 {
	
	public static void main(String[] args) {
		
		DBUtil util = new DBUtil();
		Connection conn = null;
		
		
		try {
			
			//접속
//			conn = util.open();
			conn = util.open("211.63.89.64", "project", "java1234");
			
			//접속 확인
			System.out.println(conn.isClosed());
			
			//접속 종료
			util.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	

}
