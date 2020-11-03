package com.test.erpos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dummy {
	
	private DBUtil util;
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	
	public Dummy() {
		util = new DBUtil();
		conn = util.open();
		
	}
	
	public static void main(String[] args) {
		
		
		Dummy d = new Dummy();
		
		d.test();
		
	}

	public void test() {
		
		try {
			
			String sql = "select * from tbl_test";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println(rs.getString("seq"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

}
