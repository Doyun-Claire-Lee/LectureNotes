package com.test.codestudy.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.codestudy.DBUtil;

//DB작업 담당 객체
// - 서블릿 X, 일반 클래스
public class MemberDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	
	//생성자
	public MemberDAO() {
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
	
	//RegisterOk 서블릿이 MemberDTO를 매개변수로 넘겨주며 회원가입 DB작업을 위임한 상태
	public int add(MemberDTO dto) {
		
		try {
			
			String sql = "insert into tblMember (seq, id, name, email, pw, pic, regdate) values (seqMember.nextVal, ?, ?, ?, ?, ?, default)";
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getName());
			pstat.setString(3, dto.getEmail());
			pstat.setString(4, dto.getPw());
			pstat.setString(5, dto.getPic());
			
			
			//실행시키며 반환
			return pstat.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//성공하면 1, 실패하면 0을 반환하는 메소드
		return 0;
		
	} 
	
	//Login 서블릿이 아이디, 암호를 전달하며 회원인지 여부를 판단해달라 검사 위임
	public int login(MemberDTO dto) {
		
		try {
			
			String sql = "select count(*) as cnt from tblMember where id=? and pw=?";
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
		
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
		return 0;
	}

	//Login 서블릿이 아이디를 넘겨주며 회원정보를 반환해달라 위임
	public MemberDTO getMember(String id) {
		
		try {
			String sql = "select * from tblMember where id = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				
				//DTO = Data Transfer Object
				//VO = Value Object
				MemberDTO dto = new MemberDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPic(rs.getString("pic"));
				dto.setRegdate(rs.getString("regdate"));
				
				return dto;
			}
			
			pstat.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	//auth.do 에서 게시글, 댓글수 가져오기 위임받음 
	public HashMap<String, Integer> getCount(String seq) {

		try {
			
			String sql= "select (select count(*) from tblBoard where mseq = ?) as bcnt,  (select count(*) from tblComment where mseq = ?) as ccnt from dual";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			pstat.setString(2, seq);
			
			rs = pstat.executeQuery();
			
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			
			if(rs.next()) {
				map.put("bcnt", rs.getInt("bcnt"));
				map.put("ccnt", rs.getInt("ccnt"));
			}
			
			return map;
			
		} catch (Exception e) {
		
			e.printStackTrace();
		
		}
		
		
		
		return null;
	}

	public ArrayList<MemberDTO> listMember(String seq) {

		try {
			
			String sql = "select seq, id, name from tblMember where seq <> ? order by name asc";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			ArrayList<MemberDTO> mlist = new ArrayList<MemberDTO>();
			
			while(rs.next()) {
				
				MemberDTO dto = new MemberDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
			
				mlist.add(dto);
			}
			
			return mlist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int send(MessageDTO dto) {
		
		try {
			
			int result = 0;
			
			String sql = "insert into tblMessage (seq, smseq, rmseq, content, regdate, state) values (seqMessage.nextVal, ?, ?, ?, default, default)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSmseq());
			pstat.setString(3, dto.getContent());
			
			for (String rmseq : dto.getRmseq()) {
				pstat.setString(2, rmseq);
				result += pstat.executeUpdate();
			}
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<MessageDTO> listMessage(String seq) {

		try {
			String sql = "select m.*, (select name from tblMember where seq = m.smseq) as sname from tblMessage m where rmseq = ? order by seq desc";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs = pstat.executeQuery();
			
			ArrayList<MessageDTO> list = new ArrayList<MessageDTO>();
			
			while(rs.next()) {
				
				MessageDTO dto = new MessageDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setSmseq(rs.getString("smseq"));
				dto.setRmseq(new String[] {rs.getString("rmseq")});
				dto.setContent(rs.getString("content"));		
				dto.setRegdate(rs.getString("regdate"));
				dto.setState(rs.getString("state"));
				dto.setSname(rs.getString("sname"));
				
				list.add(dto);
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int countMessage(String mseq) {

		try {
			
			String sql = "select count(*) as cnt from tblMessage where rmseq = ? and state = 0";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, mseq);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public void updateState(String rmseq) {
		
		try {
			
			String sql = "update tblMessage set state = 1 where rmseq = ? and state = 0";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rmseq);
			pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public MessageDTO getMessage(String seq) {
		
		try {
			
			String sql = "select m.*, (select name from tblMember where seq = m.smseq) as sname from tblMessage m where m.seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				
				MessageDTO dto = new MessageDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setSname(rs.getString("sname"));
				dto.setState(rs.getString("state"));

				return dto;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void updateRead(String seq) {
		
		try {
			
			String sql = "update tblMessage set state = 2 where seq = ?";	//안읽음 -> 읽음으로 바꾸기 
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

	public int deleteMessage(String[] cbDelete) {

		try {
			
			//원래는 conn.autocommit 끄고 트랜젝션 처리 해야함..
			String sql = "delete from tblMessage where seq = ?";
			pstat = conn.prepareStatement(sql);
			
			int result = 0;
			
			for (String seq : cbDelete) {
				
				pstat.setString(1, seq);
				result += pstat.executeUpdate();
			}
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	
	
	
	
}
