package com.test.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex08_Transaction {
	
	public static void main(String[] args) {
		
		
		
		/*
		 
		 트랜잭션 처리
		 1. 오라클(DBMS)
		 	1-1. 스크립트 작업 중 사용자가 직접 Commit, rollback (수동)
		 	1-2. 프로시저 내에 (제어문, Excecption 처리하여) Commit, rollback을 넣어둠.(자동화)
		 2. 자바(JDBC > 응용)
		  	- connection 클래스를 사용
		  		  
		 */
		
		
		//update(댓글 카운트 증가) -> insert(댓글 쓰기)
		Connection conn = null;
		Statement stat = null;
		DBUtil util = new DBUtil();
		
		try {
			
			
			conn = util.open();
			
			//Statement 생성 전에 해야함!!!! 연결 직후!!
			conn.setAutoCommit(false); //Autocommit을 끔.
			
			stat = conn.createStatement();
			
			//업무 1
			String sql = "update tblBoard set commentCount =  commentCount + 1 where seq = 1";
			
			sql= "update tblBoard set commentCount =  commentCount + 1 where seq = 100";
			//where절은 오류가 나도 아무것도 하지 않기 때문에 아래 insert 구문만 실행됨.
			
			int result = stat.executeUpdate(sql); //적용된 행의 갯수를 받아온다
//			System.out.println(result);
			
			//업무 2
			sql = "insert into tblComment(seq, subject, pseq) values (11, '댓글', 1)";
			
			result += stat.executeUpdate(sql); //result 값을 누적함. 
//			System.out.println(result);
			
			System.out.println("완료");
			
			if(result == 2) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
			stat.close();
			conn.close();
			
			
			
		} catch (Exception e) {
		
			try {
				
				conn.rollback(); //별도의 try catch가 필요함.
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		}
		
		
		
	}

}
