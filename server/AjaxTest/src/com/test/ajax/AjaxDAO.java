package com.test.ajax;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class AjaxDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	//생성자
	public AjaxDAO() {
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
	
	
	//ex01.do 서블릿에서 설문조사 1건 반환 위임받음
	public ResearchDTO getResearch(String seq) {
		
		try {
			
			String sql = "select * from tblresearch where seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			ResearchDTO dto = new ResearchDTO();
			
			//레코드 1줄을 dto 1개에 옮겨담기
			if(rs.next()) {
				dto.setSeq(rs.getString("seq"));
				dto.setQuestion(rs.getString("question"));
				dto.setItem1(rs.getString("item1"));
				dto.setItem2(rs.getString("item2"));
				dto.setItem3(rs.getString("item3"));
				dto.setItem4(rs.getString("item4"));
				dto.setCnt1(rs.getInt("cnt1"));
				dto.setCnt2(rs.getInt("cnt2"));
				dto.setCnt3(rs.getInt("cnt3"));
				dto.setCnt4(rs.getInt("cnt4"));
			}

			return dto;		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<BoardDTO> list() {

		try {
			
			String sql = "select seq, subject, regdate from tblBoard where rownum <= 20";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<BoardDTO> list =  new ArrayList<BoardDTO>();
			
			while(rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
			}
			
			return list;
		
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return null;
	}

	public int check(String id) {

		try {
			
			String sql = "select count(*) as cnt from tblMember where id = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<ZipcodeDTO> ziplist(String search) {

		try {
			
			//dong like '%?%' 이렇게 걸면 안됨. -> 물음표가 변수이기 때문에 상수표기법('') 안에 집어넣으면 상수가 되어버림.
			String sql = "select * from zipcode where dong like '%' || ? || '%' order by seq";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, search);
			
			rs = pstat.executeQuery();
			
			ArrayList<ZipcodeDTO> list = new ArrayList<ZipcodeDTO>();
			
			while(rs.next()) {
				
				ZipcodeDTO dto = new ZipcodeDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setSido(rs.getString("sido"));
				dto.setGugun(rs.getString("gugun"));
				dto.setDong(rs.getString("dong"));
				dto.setBunji(rs.getString("bunji"));
				dto.setZipcode(rs.getString("zipcode"));
				
				list.add(dto);
			}
			
			return list;		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<CatDTO> catlist() {

		try {
			
			String sql = "select * from tblCat";
			
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
			ArrayList<CatDTO> list = new ArrayList<CatDTO>();
			
			while(rs.next()) {
				
				CatDTO dto = new CatDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setCatid(rs.getString("catid"));
				dto.setX(rs.getString("x"));
				dto.setY(rs.getString("y"));
				
				list.add(dto);
			}
			
			return list;		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int editCat(CatDTO dto) {
		
		try {
			
			String sql = "update tblCat set x = ?, y = ? where catid = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getX());
			pstat.setString(2, dto.getY());
			pstat.setString(3, dto.getCatid());
			
			return pstat.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<String> searchlist(String word) {
		
		try {
			
			String sql = "select word from tblSearch where word like ? || '%' order by word asc";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, word);
			
			rs = pstat.executeQuery();
			ArrayList<String> list = new ArrayList<String>();
			
			while(rs.next()) {
				
				list.add(rs.getString("word"));
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<String> buseolist() {
		
		try {
			
			String sql = "select distinct buseo from tblinsa order by buseo asc";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<String> list = new ArrayList<String>();
			
			while(rs.next()) {
				list.add(rs.getString("buseo"));
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<BuseoDTO> jikwilist(String buseo) {

		try {
			
			String sql = "select jikwi, count(*) as cnt from tblinsa where buseo = ? group by jikwi";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, buseo);
			rs = pstat.executeQuery();
			
			ArrayList<BuseoDTO> list = new ArrayList<BuseoDTO>();
			
			while(rs.next()) {
				
				BuseoDTO dto = new BuseoDTO();
				dto.setJikwi(rs.getString("jikwi"));
				dto.setCnt(rs.getString("cnt"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
