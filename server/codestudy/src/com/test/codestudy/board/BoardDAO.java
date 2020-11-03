package com.test.codestudy.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.codestudy.DBUtil;

//
public class BoardDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	
	//생성자
	public BoardDAO() {
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

	//WriteOk 서블릿의 엄무 위임
	public int write(BoardDTO dto) {
		
		try {
			
			String sql = "insert into tblBoard(seq, subject, content, regdate, readcount, mseq, thread, depth) values (seqBoard.nextVal, ?, ?, default, default, ?, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getMseq());
			pstat.setInt(4, dto.getThread());
			pstat.setInt(5, dto.getDepth());
			
			return pstat.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
		return 0;
	}
	
	//List 서블릿이 호출, 게시판 목록을 받아와 반환하기
	public ArrayList<BoardDTO> list(HashMap<String, String> map) {
		
		
		try {
			
			//전체 글 보기 or 검색 글 보기 
			
			String where ="";
			
			if (map.get("search") != null) {
				//작성자, 제목, 내용 검색 & 포괄 검색(like절)
				where = String.format("and (name like '%%%s%%' or subject like '%%%s%%' or content like '%%%s%%')", map.get("search"), map.get("search"), map.get("search")); 
			}
			
			String sql = String.format("select * from (select a.*, rownum as rnum from (select * from vwboard order by thread desc) a) where rnum >= %s and rnum <= %s %s order by %s desc"
										, map.get("begin")		//선택한 페이지의 rnum 시작 번호
										, map.get("end")		//선택한 페이지의 rnum 종료 번호
										, where					//조건절
										, map.get("sort"));		//정렬 선택
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate")); 
				dto.setReadcount(rs.getInt("readcount")); 
				dto.setHeart(rs.getInt("heart"));
				dto.setGap(rs.getInt("gab"));
				dto.setCommentcount(rs.getInt("commentcount"));
				
				dto.setDepth(rs.getInt("depth"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	//View 서블릿에서 글번호를 주고 게시물 1개를 반환받기 위해 위임
	public BoardDTO get(BoardDTO dto2) {
		
		try {
			
			
			String sql = "select a.* , (select name from tblMember where seq = a.mseq) as name, (select id from tblMember where seq = a.mseq) as id, (select count(*) from tblHeart where bseq = a.seq and mseq = ?) as heart from tblBoard a where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto2.getMseq());
			pstat.setString(2, dto2.getSeq());
			
			rs = pstat.executeQuery();
			
			//dto에 내용 담기
			if (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setHeart(rs.getInt("heart"));
				dto.setMseq(rs.getString("mseq"));
				
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				
				dto.setThread(rs.getInt("thread"));
				dto.setDepth(rs.getInt("depth"));
				
				return dto;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return null;
	}
	
	//view로부터 위임받음 -> 조회수 올리기
	public void updateReadcount(String seq) {

		try {
			
			String sql = "update tblBoard set readcount = readcount + 1 where seq = ?";
			
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			pstat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}	
	}
	
	//editok.do 서블릿에서 글 수정 db작업 위임받음 
	public int edit(BoardDTO dto) {
		
		try {
			
			String sql = "update tblBoard set subject = ?, content = ? where seq = ?";
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getSeq());
			
			return pstat.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
	
		return 0;
	}
	
	//deleteok.do 서블릿에서 글 삭제를 위임받음
	public int delete(String seq) {
		
		try {
			
			String sql = "delete from tblBoard where seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			return pstat.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();			
		}
		
		return 0;
	}

	public boolean isOwner(BoardDTO dto) {

		try {
		
			String sql = "select count(*) as cnt from tblBoard a where (select id from tblMember where seq = a.mseq) = ? and seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getSeq());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("cnt") == 1 ? true : false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
		
		return false;
	}
	
	
	//comment.do에서 댓글쓰기 기능을 위임받음.
	public int writeComment(CommentDTO dto) {
	
		try {
			String sql = "insert into tblComment (seq, commentContent, mseq, regdate, bseq) values (seqComment.nextval, ?, ?, default, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getCommentContent());
			pstat.setString(2, dto.getMseq());
			pstat.setString(3, dto.getBseq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//view.do에서 댓글 목록 가져오기 위임받음
	public ArrayList<CommentDTO> listComment(String seq) {
	
		try {
			
			String sql = "select a.*, (select name from tblMember where seq = a.mseq) as name, (select id from tblMember where seq = a.mseq) as id from tblcomment a where bseq = ? order by seq desc";
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			rs = pstat.executeQuery();
			
			ArrayList<CommentDTO> clist = new ArrayList<CommentDTO>();
			
			while(rs.next()) {
				
				CommentDTO dto =  new CommentDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setCommentContent(rs.getString("commentContent"));
				dto.setMseq(rs.getString("mseq"));
				dto.setBseq(rs.getString("bseq"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				
				clist.add(dto);
			}
		
			return clist;		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	//deletecomment.do 서블릿에서 댓글 삭제작업 위임받음.
	public int deleteComment(String seq) {
		
		try {
		
			String sql = "delete from tblComment where seq = ?";
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	//heart.do 서블릿에서 추천수 추가 위임하기
	public int addHeart(HeartDTO dto) {
		
		try {
	
			String sql = "insert into tblHeart (seq, mseq, bseq) values (seqHeart.nextVal, ?, ?)"; 
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getMseq());
			pstat.setString(2, dto.getBseq());
			
			return pstat.executeUpdate();
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	//heart.do 서블릿에서 로그인한 회원의 해당 글 추천수 확인 위임하기
	public boolean checkHeart(HeartDTO dto) {

		try {
			
			String sql = "select count(*) as cnt from tblHeart where bseq =? and mseq =?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getBseq());
			pstat.setString(2, dto.getMseq());
			
			rs = pstat.executeQuery();
						
			if (rs.next()) {
				return rs.getInt("cnt") != 1 ? true : false;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
				
		return false;
	}

	public int removeHeart(HeartDTO dto) {
		
		try {
			
			String sql = "delete from tblHeart where mseq = ?  and bseq = ?"; 
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getMseq());
			pstat.setString(2, dto.getBseq());
			
			return pstat.executeUpdate();
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	//writeok.do 서블릿에서 가장 큰 thread 값을 받아오는 작업 위임
	public int getThread() {

		try {
			
			String sql = "select nvl(max(thread), 0) + 1000 as thread from tblBoard";
			//nvl(값, 바꿀값) ->  결과값이 null이면 바꿀값으로 변경하여 반환해줌. 
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getInt("thread");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}


	//writeok.do 서블릿에서 답변 업무 일부 위임
	public void updateThread(HashMap<String, Integer> map) {

		try {
			String sql = "update tblboard set thread = thread - 1 where thread < ?  and thread > ?";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, map.get("parentThread"));
			pstat.setInt(2, map.get("previousThread"));
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	//list.do 서블릿에서 페이징 관련 업무 위임
	public int getTotalCount(HashMap<String, String> map) {
		
		DBUtil util = new DBUtil();
		try {
			
			
			conn = util.open();
			
			//전체 글 보기 or 검색 글 보기 
			
			String where ="";
			
			if (map.get("search") != null) {
				//작성자, 제목, 내용 검색 & 포괄 검색(like절)
				where = String.format("where name like '%%%s%%' or subject like '%%%s%%' or content like '%%%s%%'", map.get("search"), map.get("search"), map.get("search")); 
			}
			
			String sql = String.format("select count(*) as cnt from tblBoard %s", where);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
