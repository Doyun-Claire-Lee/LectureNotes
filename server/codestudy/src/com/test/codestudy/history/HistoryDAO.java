package com.test.codestudy.history;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.codestudy.DBUtil;

public class HistoryDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	
	//생성자
	public HistoryDAO() {
		//DB연결
		
		DBUtil util = new DBUtil();
		conn = util.open();
		
	}
	
	public void close() {
		
		try {

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//index 서블릿에서 레코드 가져오는 작업 위임받음.
	public HistoryDTO get() {
		
		try {
			
			String sql = "select * from tblHistory where seq = 1";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				HistoryDTO dto = new HistoryDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setContent(rs.getString("content"));
				
				return dto; 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
		return null;
	}

	
	//history.do 에서 업데이트 작업을 위임받음.
	public void edit(String content) {
		
		try {
			String sql = "update tblHistory set content = ? where seq = 1";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, content);
			
			pstat.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
