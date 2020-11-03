package com.test.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class Ex05_Select {	
	
	public static void main(String[] args) {

		
//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
//		m6();
		m7();
		
		
	}//main

	private static void m7() {
		
		//기획부 직원 명단 출력 + 직원수 출력
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		
		
		try {
			
			conn = util.open();
			stat = conn.createStatement();
			
			String sql = "select count(*) as count from tblinsa where buseo = '개발부'";
			rs = stat.executeQuery(sql); 
			
			if (rs.next()) {

				System.out.println("직원 수: " + rs.getString("count"));
			}
			
			
			sql = "select * from tblInsa where buseo = '개발부'";
			rs = stat.executeQuery(sql); //레코드수 확인 불가.. Stream과 비슷, 한칸씩 내려가면서 확인해야 하기 때문
			
			
			System.out.println();
			System.out.println("[이름]\t[직위]\t[지역]\t[연락처]\t[급여]");
			
			while(rs.next()) { //레코드 갯수만큼 반복됨.
			
				System.out.printf("%s\t%s\t%s\t%-13s\t%s\t\n", rs.getString("name")
						, rs.getString("jikwi")
						, rs.getString("city")
						, rs.getString("tel")
						, rs.getString("basicpay"));
			
				
			}	
	
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	private static void m6() {
		
		//부서별로 직원 명단 출력
		//중첩된 select
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		
		try {
			
			String sql = "select distinct buseo from tblinsa order by buseo";
			conn = util.open();
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			while (rs.next()) {//각 부서
				
				System.out.printf("[%s]\n", rs.getString("buseo"));
				
				sql = String.format("select * from tblinsa where buseo = '%s' order by case\r\n" + 
																				"        when jikwi = '부장' then 1\r\n" + 
																				"        when jikwi = '과장' then 2\r\n" + 
																				"        when jikwi = '대리' then 3\r\n" + 
																				"        when jikwi = '사원' then 4\r\n" + 
																				"    end, name", rs.getString("buseo"));
				
				Statement stat2 = conn.createStatement();
				ResultSet rs2 = stat2.executeQuery(sql);
				
				while (rs2.next()) {
					
					//각 부서별 직원들
					System.out.printf("%s(%s)\n", rs2.getString("name"), rs2.getString("jikwi"));
					
				}
				
				rs2.close();
				System.out.println();
			}
			
			rs.close();
			stat.close();
			conn.close();
						
		} catch (Exception e) {
			e.printStackTrace();	
		}
		
	}

	private static void m5() {
		
		//tblAddressBook, 주소검색
		//검색어 : 주소 키워드를 입력받기
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		
		Scanner scan = new Scanner(System.in);
		
		try {
		
			//검색어 입력
			System.out.print("검색어를 입력하세요 : ");
			String word = scan.nextLine();
			
			System.out.println();
			String sql = String.format("select name, gender, age, address from tblAddressBook where replace(lower(address), ' ','') like '%%' || replace(lower('%s'), ' ','') || '%%'", word);
			
			conn = util.open();
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			System.out.println("[이름]\t[성별]\t[나이]\t[주소]");
			
			
			
			while (rs.next()) {
				
			System.out.printf("%s\t%s\t%s\t%s\n", rs.getString("name")
												, rs.getString("gender")
												, rs.getString("age")
												, rs.getString("address"));	
				
				
			}
		
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m4() {
		
		//tblInsa
		//1. 직원 1명 가져오기 : 개발부 부장
		//2. 직원 모두 가져오기 : 개발부 나머지
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		
		
		try {
			
			System.out.println("[이름]\t[직위]\t[지역]\t[연락처]\t[급여]");
			
			conn = util.open();
			stat = conn.createStatement();
			
			String sql = "select * from tblInsa where buseo = '개발부' and jikwi = '부장'";
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {

				System.out.printf("%s\t%s\t%s\t%s\t%s\t\n", rs.getString("name")
															, rs.getString("jikwi")
															, rs.getString("city")
															, rs.getString("tel")
															, rs.getString("basicpay"));
				
				
			} else {
				System.out.println("조건에 맞는 결과가 없습니다.");
			}
			
			rs.close(); //ResultSet도 반드시 닫아야함.
			
			System.out.println("------------------------------------------------");

			//또다른 sql 실행
			sql = "select * from tblInsa where buseo = '기획부' and jikwi <> '부장'";
			rs = stat.executeQuery(sql); //statement는 재사용이 가능함. 다시 만들필요 X, 닫아버리면 재사용이 안됨. 닫는 위치 중요!
			
			
			while(rs.next()) { //레코드 갯수만큼 반복됨.
			
				System.out.printf("%s\t%s\t%s\t%s\t%s\t\n", rs.getString("name")
						, rs.getString("jikwi")
						, rs.getString("city")
						, rs.getString("tel")
						, rs.getString("basicpay"));
				
			}	
			
			rs.close();
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void m3() {
		
		//m2() -> m3() 확장
		//직원 번호 입력 -> 직원 정보 출력
		
		Scanner scan = new Scanner(System.in);
		System.out.print("직원번호 입력 : ");
		String num = scan.nextLine();
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {

			conn = util.open();
			stat = conn.createStatement();

			String sql = String.format("select * from tblinsa where num = %s", num);

			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				
				System.out.println("이름: " + rs.getString("name"));
				System.out.println("부서: " + rs.getString("buseo"));
				System.out.println("직위: " + rs.getString("jikwi"));
				System.out.println("지역: " + rs.getString("city"));
				System.out.printf("급여: %,d원\n", rs.getInt("basicpay"));
				
				
				//레코드를 가져온 뒤 하는 행동들?
				//1. 컬럼값 얻어오기(*****************)
				System.out.println(rs.getString(1));
				System.out.println(rs.getString("name"));
				
				//2. 레코드(컬럼)정보 얻어오기
				ResultSetMetaData rsmd = rs.getMetaData();
				System.out.println(rsmd.getColumnCount()); //결과셋의 컬럼의 개수(원본과는 상관X)
				
				for (int i=0; i<rsmd.getColumnCount(); i++) {
					System.out.println(rs.getString(i+1));
				}
				
				System.out.println();
				System.out.println(rsmd.getColumnLabel(2)); //컬럼 인덱스 -> 라벨로 변경해줌
				System.out.println(rsmd.getColumnType(2)); //컬럼 자료형
				System.out.println(rsmd.getColumnDisplaySize(2)); //길이
				
				
			} else {
				
				System.out.println("존재하지 않는 직원번호입니다.");
			}

			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m2() {
		
		//날짜 데이터 가져오기
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {

			conn = util.open();
			stat = conn.createStatement();

			String sql = String.format("select max(ibsadate) as ibsadate from tblinsa");

			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				
				//1. Date 형으로 가져오기
//				Date ibsadate = rs.getDate("ibsadate"); //java.sql 패키지 안에 있는 Date객체..
//				System.out.printf("%tF %tT", ibsadate, ibsadate);

				//2. String으로 가져오기(*****) 더 많이씀!! 그냥 날짜를 가져와서 출력만 하기 때문에..
				String ibsadate = rs.getString("ibsadate");
				System.out.println(ibsadate);
				
				
			} else {
				System.out.println("결과값이 없습니다.");
			}

			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	private static void m1() {
		
		//1행 1열인 결과셋을 가져올 때
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		DBUtil util = new DBUtil();

		try {

			conn = util.open();
			stat = conn.createStatement();

			String sql = String.format("select count(*) as cnt from tblAddress");

			rs = stat.executeQuery(sql);
			
			//ResultSet 탐색 (********)
			// - Iterator, Stream과 사용법 비슷
			
			//rs.next(); //커서를 다음 레코드로 이동하기, 반환값 boolean

			if (rs.next()) { //if로 묶어 예외 발생했을시 처리하기

				String cnt = rs.getString(1); 	//첫번째 컬럼을 가져오기
				int cnt2 = rs.getInt(1);		//int로 가져오기
				double cnt3 = rs.getDouble(1);	//double로 가져오기
				
//				cnt = rs.getString("count(*)"); //보통 컬럼명을 적음
				cnt = rs.getString("cnt"); 		//allias로 설정하여 적기!!!!
				
				System.out.println(cnt);
				
			} else {
				System.out.println("select 결과 없음.");
			}

			stat.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
