package com.test.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

public class Ex07_CallableStatement {
	
	public static void main(String[] args) {
		
		//1. Statement : 정적쿼리
		//2. PreparedStatement : 동적쿼리 (매개변수)
		//3. CallableStatement : 프로시저 전용
		
//		m1();
//		m2(); 	//단일 레코드
//		m3();	//단일 레코드
//		m4(); 	//다중 레코드
		m5();
		
	}//main

	private static void m5() {
		
		Connection conn = null;
		CallableStatement stat = null;
		DBUtil util = new DBUtil();
		ResultSet rs = null;
		
		try {
			
			String sql = "{ call procM5(?) }";
			conn = util.open();
			stat = conn.prepareCall(sql);
			
			stat.registerOutParameter(1, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(1);
			
			while (rs.next()) {
				System.out.printf("%s, %s, %s, %s\n", rs.getString("name")
													, rs.getString("age")
													, rs.getString("tel")
													, rs.getString("address"));
			}//while		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	private static void m4() {
	
		Connection conn = null;
		CallableStatement stat = null;
		DBUtil util = new DBUtil();
		ResultSet rs = null;
		
		try {
			
			
			String sql = "{ call procM4(?,?) }";
			conn = util.open();
			stat = conn.prepareCall(sql);
			
			stat.setString(1, "기획부");
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(2); //cursor를 일단 object타입으로 받아온 뒤 Resultset으로 형변환함.
			
			//여러 행을 가져왔기 때문에 while을 이용하여 출력해줌.
			while(rs.next()) {
				
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("jikwi"));
			}
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	private static void m3() {
		
		//단일 레코드 반환 
		
		Connection conn = null;
		CallableStatement stat = null;
		DBUtil util = new DBUtil();
		
		try {
			
			String name = "유재석";
			String sql = "{ call procM3(?,?,?) }";
			
			conn = util.open();
			stat = conn.prepareCall(sql);
			
			stat.setString(1, name);
			
			stat.registerOutParameter(2, OracleTypes.VARCHAR);
			stat.registerOutParameter(3, OracleTypes.NUMBER);
			
			stat.executeQuery(); //실행
			
			System.out.println(stat.getString(2));
			System.out.println(stat.getString(3));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

	private static void m2() {
		
		//단일값 반환받을때는 ResultSet이 필요없음!
		Connection conn = null;
		CallableStatement stat = null;
		DBUtil util = new DBUtil();
		
		
		try {
			
			conn = util.open();
			
			String sql = "{ call procM2(?,?,?,?) }"; //{}로 블럭 잡고(?) call + 프로시저이름
			stat = conn.prepareCall(sql);
			
			//**********
			
			//in parameter
			stat.setString(1,  "1001");
			
			//out parameter를 register메소드를 이용하여 저장
			stat.registerOutParameter(2, OracleTypes.VARCHAR);
			stat.registerOutParameter(3, OracleTypes.VARCHAR);
			stat.registerOutParameter(4, OracleTypes.VARCHAR);
			
			stat.executeQuery();
			
			//저장했던 값을 가져옴.
			System.out.println(stat.getString(2));
			System.out.println(stat.getString(3));
			System.out.println(stat.getString(4));
			
			
			stat.close();
			conn.close();

			System.out.println("완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	private static void m1() {
		
		//반환값이 없으므로 ResultSet은 만들지않음.
		Connection conn = null;
		CallableStatement stat = null;
		DBUtil util = new DBUtil();
		
		
		try {
			
			conn = util.open();
			
			String sql = "{ call procM1(?,?,?,?) }"; //{}로 블럭 잡고(?) call + 프로시저이름
			stat = conn.prepareCall(sql);
			
			stat.setString(1,  "호호호");
			stat.setInt(2,  20);
			stat.setString(3,  "010-1234-5454");
			stat.setString(4,  "서울시 강동구 천호동");
			
			stat.executeUpdate();
			
			stat.close();
			conn.close();

			System.out.println("완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
