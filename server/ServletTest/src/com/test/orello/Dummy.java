package com.test.orello;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;


public class Dummy {
	
	private Connection conn;
	private Statement stat;
	private Statement stat2;
	private PreparedStatement pstat;
	private PreparedStatement pstat2;
	private ResultSet rs;
	private ResultSet rs2;
	private int num = 1;
	
	public static void main(String[] args) {
		
		Dummy dummy = new Dummy();
		
		
//		dummy.tblchecklist();				//체크리스트 더미 
//		dummy.tblChecklistItem();			//체크리스트 항목 더미
//		dummy.tblCheckListItemComment();	//체크리스트 항목 댓글 더미
//		dummy.tblAlert();					//알림내역 더미
//		dummy.tblActivity();				//활동내역 더미
//		dummy.tblChatconfirm();				//채팅확인 더미 -> 안함
		
		
		dummy.tblChat();
//		dummy.tblChatattend();
		
	}

	private void tblChat() {
		
		try {
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} 
		
		
	}

	private void tblChatattend() {

	      DBUtil util = new DBUtil();

	      try {

	         conn = util.open();
	         stat = conn.createStatement();

	         String sql = "select * from tbl_chat";
	         
	         int num = 1;
	         
	         rs = stat.executeQuery(sql);

	         while (rs.next()) {

	            // 채팅방 번호 가져오기
	            String chat_seq = rs.getString("seq");
	            // 프로젝트 번호 가져오기
	            String project_seq = rs.getString("project_seq");

	            String sql2 = "select * from tbl_project_attend where project_seq = ?";

	            pstat = conn.prepareStatement(sql2);

	            pstat.setString(1, project_seq);

	            rs2 = pstat.executeQuery();

	            while (rs2.next()) {

	               String mseq = rs2.getString("member_seq");

	               String sql3 = "insert into tbl_chat_attend (seq, delflag, member_seq, chat_seq) values (seq_chat_attend.nextVal, default, ?, ?)";

	               pstat2 = conn.prepareStatement(sql3);

	               pstat2.setString(1, mseq);
	               pstat2.setString(2, chat_seq);

	               pstat2.executeUpdate();

	               System.out.println(num);
	               num++;
	               pstat2.close();
	            }
	            pstat.close();

	         }
	         stat.close();
	         conn.close();

	      } catch (Exception e) {
	         e.printStackTrace();

	      }

		   
		
	}

	private void tblChatconfirm() {

		DBUtil util = new DBUtil();
		
		try {
		
			String sql = "select * from tbl_chat_log";
			
			
			
			
			
		} catch (Exception e) {

		
		
		}
		
		
		
		
	}

	private void tblActivity() {
//		#활동내역 테이블 데이터 종류
//		##프로젝트 참여 내역
//		체크리스트 완료 내역 --> 현재 없음..
//		##게시글 작성 내역(공지사항)
//		##자료실 파일 업로드 내역
//		커밋 내역
		
		projectAttendList();
		boardWriteList();
		fileUploadList();
		commitList();		
	}

	private void commitList() {
		
		//커밋 내역
		DBUtil util = new DBUtil();
		
		try {
			
			conn = util.open();
			
			String sql = "select h.regdate as regdate, h.project_attend_seq as aseq, (select name from tbl_project where seq = c.project_seq) as title from tbl_commit_history h inner join tbl_commit c on c.seq = h.commit_seq";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			String aseq = "";
			String title = "";
			Calendar regdate = Calendar.getInstance();
			
			sql = "insert into tbl_activity (seq, content, regdate, project_attend_seq, delflag) values (seq_activity.nextVal, ?, ?, ?, default)";
			pstat = conn.prepareStatement(sql);
			
			while(rs.next()) {

				title = rs.getString("title");
				aseq = rs.getString("aseq");
				regdate.set(Integer.parseInt(rs.getString("regdate").substring(0,4))
						, Integer.parseInt(rs.getString("regdate").substring(5,7)) - 1
						, Integer.parseInt(rs.getString("regdate").substring(8,10)));
				String content = String.format("프로젝트 '%s'에 Commit하였습니다.", title);
				
				pstat.setString(1, content);
				pstat.setString(2, String.format("%tF", regdate));
				pstat.setString(3, aseq);
				
				System.out.println(content + " : " + pstat.executeUpdate());
			}
			
			pstat.close();
			rs.close();
			stat.close();
			conn.close();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void fileUploadList() {
		
		//자료실 파일 업로드 내역
		DBUtil util = new DBUtil();
		
		try {
			
			conn = util.open();
			String sql = "select n.project_attend_seq as aseq, n.regdate as regdate, (select name from tbl_project where seq = n.project_seq) as title from tbl_archive n";
			stat = conn.createStatement(); 
			rs = stat.executeQuery(sql);
			
			String aseq = "";
			String title = "";
			Calendar regdate = Calendar.getInstance();
			
			sql = "insert into tbl_activity (seq, content, regdate, project_attend_seq, delflag) values (seq_activity.nextVal, ?, ?, ?, default)";
			pstat = conn.prepareStatement(sql);
			
			while(rs.next()) {

				title = rs.getString("title");
				aseq = rs.getString("aseq");
				regdate.set(Integer.parseInt(rs.getString("regdate").substring(0,4))
						, Integer.parseInt(rs.getString("regdate").substring(5,7)) - 1
						, Integer.parseInt(rs.getString("regdate").substring(8,10)));
				String content = String.format("프로젝트 '%s'에 자료를 업로드 했습니다.", title);
				
				pstat.setString(1, content);
				pstat.setString(2, String.format("%tF", regdate));
				pstat.setString(3, aseq);
				
				System.out.println(content + " : " + pstat.executeUpdate());
				
			}
			
			pstat.close();
			rs.close();
			stat.close();
			conn.close();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	private void boardWriteList() {

		//공지 게시글 작성 내역 추가
		DBUtil util = new DBUtil();
		
		try {
			
			conn = util.open();
			String sql = "select n.project_attend_seq as aseq, n.regdate as regdate, (select name from tbl_project where seq = n.project_seq) as title from tbl_project_notice n";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			String aseq = "";
			String title = "";
			Calendar regdate = Calendar.getInstance();
			
			sql = "insert into tbl_activity (seq, content, regdate, project_attend_seq, delflag) values (seq_activity.nextVal, ?, ?, ?, default)";
			pstat = conn.prepareStatement(sql);
			
			while(rs.next()) {

				title = rs.getString("title");
				aseq = rs.getString("aseq");
				regdate.set(Integer.parseInt(rs.getString("regdate").substring(0,4))
						, Integer.parseInt(rs.getString("regdate").substring(5,7)) - 1
						, Integer.parseInt(rs.getString("regdate").substring(8,10)));
				String content = String.format("프로젝트 '%s'의 공지사항을 작성했습니다.", title);
				
				pstat.setString(1, content);
				pstat.setString(2, String.format("%tF", regdate));
				pstat.setString(3, aseq);
				
				System.out.println(content + " : " + pstat.executeUpdate());
				
			}
			
			pstat.close();
			rs.close();
			stat.close();
			conn.close();
					
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void projectAttendList() {

		//프로젝트 참여 활동 내역 추가
		DBUtil util = new DBUtil();
		
		try {
			
			conn = util.open();
			String sql = "select a.seq as aseq, (select name from tbl_project where seq = a.project_Seq) as title, (select regdate from tbl_project where seq = a.project_seq) as regdate from tbl_project_attend a";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			String aseq = "";
			String title = "";
			Calendar regdate = Calendar.getInstance();
			
			sql = "insert into tbl_activity (seq, content, regdate, project_attend_seq, delflag) values (seq_activity.nextVal, ?, ?, ?, default)";
			pstat = conn.prepareStatement(sql);
			
			while(rs.next()) {
				

				title = rs.getString("title");
				aseq = rs.getString("aseq");
				regdate.set(Integer.parseInt(rs.getString("regdate").substring(0,4))
						, Integer.parseInt(rs.getString("regdate").substring(5,7)) - 1
						, Integer.parseInt(rs.getString("regdate").substring(8,10)));
				String content = String.format("프로젝트 '%s'의 멤버가 되었습니다.", title);
				
				pstat.setString(1, content);
				pstat.setString(2, String.format("%tF", regdate));
				pstat.setString(3, aseq);
				
				System.out.println(content + " : " + pstat.executeUpdate());
			}
			
			pstat.close();
			rs.close();
			stat.close();
			conn.close();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	private void tblAlert() {
		
//		#알림내역 테이블 데이터 종류
//		##친구 추가되었음 알림
//		##프로젝트 초대받았음 알림 -> 수락/거절
//		##참여중인 프로젝트에 공지사항 등록되었음 알림
//		##체크리스트 기한 다가옴 알림
//		##전체 공지사항 등록되었음 알림
//		##체크리스트 항목 본인에게 할당되었음 알림
//		##본인이 쓴 글(공지사항, 자유게시판)에 새댓글 등록 알림
//		##QNA 답변 등록 알림	

		friendAddList();		//친구 추가 알림
		projectInvitedList();	//프로젝트 초대받음 알림
		projectNoticeAddList();	//프로젝트 공지사항 추가 알림
		checklistDueDateList();	//체크리스트 기한 다가옴 알림(1일 전)
		noticeAddList();		//전체 공지사항 등록되었음 알림
		checklistAssignedList();//체크리스트 본인에게 할당되었음 알림
		commentAlertList();		//본인이 쓴 글에 댓글 등록 알림
		qnaAlertList();			//QNA답변 등록 알림
				
	}
	private void qnaAlertList() {

		DBUtil util = new DBUtil();
		
		//qna 답변 등록 알림
		try {
			
			conn = util.open();
			String sql = "select  c.regdate as regdate, (select title from tbl_qna where c.qna_seq = seq) as title, (select member_seq from tbl_qna where c.qna_seq = seq) as mseq from tbl_qna_comment c";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			String mseq = "";
			String title = "";
			Calendar regdate = Calendar.getInstance();
			
			sql = "insert into tbl_alert (seq, content, regdate, member_seq, delflag) values (seq_alert.nextVal, ?, ?, ?, default)";
			pstat = conn.prepareStatement(sql);
			
			while(rs.next()) {

				title = rs.getString("title");
				mseq = rs.getString("mseq");
				regdate.set(Integer.parseInt(rs.getString("regdate").substring(0,4))
						, Integer.parseInt(rs.getString("regdate").substring(5,7)) - 1
						, Integer.parseInt(rs.getString("regdate").substring(8,10)));
				String content = String.format("작성하신 질문 '%s...'에 답변이 등록되었습니다.", title.length() > 10 ? title.substring(0, 10) : title);
				
				pstat.setString(1, content);
				pstat.setString(2, String.format("%tF", regdate));
				pstat.setString(3, mseq);
				pstat.executeUpdate();
				
				System.out.println(num++);
			}
			pstat.close();
			
			System.out.println("qna답변 등록 알림 끝");
			rs.close();
			stat.close();
			conn.close();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	private void commentAlertList() {
		
		DBUtil util = new DBUtil();
		
		//자유게시판 댓글 등록 알림
		
		try {
			
			conn = util.open();
			String sql = "select c.regdate as regdate, (select title from tbl_freeboard where seq = c.freeboard_seq) as title, (select member_seq from tbl_project_attend where (select project_attend_seq from tbl_freeboard where seq = c.freeboard_seq) = seq) as mseq from tbl_freeboard_comment c";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			String mseq = "";
			String title = "";
			Calendar regdate = Calendar.getInstance();
			
			sql = "insert into tbl_alert (seq, content, regdate, member_seq, delflag) values (seq_alert.nextVal, ?, ?, ?, default)";
			pstat = conn.prepareStatement(sql);
				
			while(rs.next()) {

				title = rs.getString("title");
				mseq = rs.getString("mseq");
				regdate.set(Integer.parseInt(rs.getString("regdate").substring(0,4))
						, Integer.parseInt(rs.getString("regdate").substring(5,7)) - 1
						, Integer.parseInt(rs.getString("regdate").substring(8,10)));
				
				String content = String.format("작성하신 글 '%s...'에 댓글이 등록되었습니다.", title.length() > 10 ? title.substring(0, 10) : title);
				
				pstat.setString(1, content);
				pstat.setString(2, String.format("%tF", regdate));
				pstat.setString(3, mseq);
				pstat.executeUpdate();
				
				System.out.println(num++);
			
			}
			pstat.close();
			System.out.println("자유게시판 댓글 등록 알림 끝");
			rs.close();
			stat.close();
			
			//공지사항 댓글 등록 알림
			
			String sql2 = "select c.regdate as regdate, (select title from tbl_project_notice where seq = c.project_notice_seq) as title, (select member_seq from tbl_project_attend where (select project_attend_seq from tbl_project_notice where seq = c.project_notice_seq) = seq) as mseq from tbl_project_notice_comment c";
			stat2 = conn.createStatement();
			rs2 = stat2.executeQuery(sql2);
			
			String mseq2 = "";
			String title2 = "";
			Calendar regdate2 = Calendar.getInstance();
			
			sql2 = "insert into tbl_alert (seq, content, regdate, member_seq, delflag) values (seq_alert.nextVal, ?, ?, ?, default)";
			pstat2 = conn.prepareStatement(sql2);
				
			while(rs2.next()) {

				title2 = rs2.getString("title");
				mseq2 = rs2.getString("mseq");
				regdate2.set(Integer.parseInt(rs2.getString("regdate").substring(0,4))
						, Integer.parseInt(rs2.getString("regdate").substring(5,7)) - 1
						, Integer.parseInt(rs2.getString("regdate").substring(8,10)));
				
				String content2 = String.format("작성하신 글 '%s...'에 댓글이 등록되었습니다.", title2.length() > 10 ? title2.substring(0, 10) : title2);
				
				pstat2.setString(1, content2);
				pstat2.setString(2, String.format("%tF", regdate2));
				pstat2.setString(3, mseq2);
				pstat2.executeUpdate();
				
				System.out.println(num++);
			}
			pstat2.close();
			
			System.out.println("공지사항 댓글 등록 알림 끝");
			rs2.close();
			stat2.close();
						
			conn.close();
					
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

	private void checklistAssignedList() {
		
		//체크리스트 본인에게 할당되었음 알림
		//-체크리스트 제목, 회원번호, 등록일
		
		DBUtil util = new DBUtil();
		
		try {
			
			conn = util.open();
			
			String sql = "select i.title as title, i.regdate as regdate, (select member_seq from tbl_project_attend where i.project_attend_seq = seq) as mseq from tbl_checklist_item i";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			String mseq = "";
			String title = "";
			Calendar regdate = Calendar.getInstance();
			
			sql = "insert into tbl_alert (seq, content, regdate, member_seq, delflag) values (seq_alert.nextVal, ?, ?, ?, default)";
			pstat = conn.prepareStatement(sql);
			
			while(rs.next()) {
				
				title = rs.getString("title");
				mseq = rs.getString("mseq");
				regdate.set(Integer.parseInt(rs.getString("regdate").substring(0,4))
						, Integer.parseInt(rs.getString("regdate").substring(5,7)) - 1
						, Integer.parseInt(rs.getString("regdate").substring(8,10)));
				String content = String.format("'%s'항목이 회원님에게 할당되었습니다.", title);
				
				pstat.setString(1, content);
				pstat.setString(2, String.format("%tF", regdate));
				pstat.setString(3, mseq);
				pstat.executeUpdate();
				
				System.out.println(num++);
			}
			pstat.close();
			
			System.out.println("체크리스트 할당 알림 끝");
			rs.close();
			stat.close();
			conn.close();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	private void noticeAddList() {
		
		//전체 공지사항 추가 알림 
		//공지사항 1건당 모든 회원에게 알림
		
		DBUtil util = new DBUtil();
		
		try {
			
			conn= util.open();
			String sql = "select * from tbl_member";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<String> members = new ArrayList<String>();
			String mseq = "";
			
			while(rs.next()) {
				mseq = rs.getString("seq");
				members.add(mseq);
			}
			
			stat.close();
			rs.close();
			
			sql = "select * from tbl_notice";
			stat2 = conn.createStatement();
			rs2 = stat2.executeQuery(sql);
			
			String content = "새로운 전체 공지사항이 등록되었습니다.";
			Calendar regdate = Calendar.getInstance();
			
			sql = "insert into tbl_alert (seq, content, regdate, member_seq, delflag) values (seq_alert.nextVal, ?, ?, ?, default)";
			pstat = conn.prepareStatement(sql);
				
			while(rs2.next()) {

				regdate.set(Integer.parseInt(rs2.getString("regdate").substring(0,4))
						, Integer.parseInt(rs2.getString("regdate").substring(5,7)) - 1
						, Integer.parseInt(rs2.getString("regdate").substring(8,10)));
				
				for (String member : members) {
					
					pstat.setString(1, content);
					pstat.setString(2, String.format("%tF", regdate));
					pstat.setString(3, member);
					pstat.executeUpdate();
					
					System.out.println(num++);
				}
			
			}
			System.out.println("전체 공지사항 등록 알림 끝");
			pstat.close();
			
			rs2.close();
			stat2.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void checklistDueDateList() {

		//4. 체크리스트 기한 다가옴 알림 
		//회원번호, 체크리스트 이름, 마감날짜
		
		DBUtil util = new DBUtil();
		
		try {
			
			conn= util.open();
			String sql = "select i.title as title, (i.enddate - 1) as regdate, (select member_seq from tbl_project_attend where i.project_attend_seq = seq) as mseq from tbl_checklist_item i where i.completeflag = 0";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			String mseq = "";
			String title = "";
			Calendar dueDate = Calendar.getInstance();
			
			sql = "insert into tbl_alert (seq, content, regdate, member_seq, delflag) values (seq_alert.nextVal, ?, ?, ?, default)";
			pstat = conn.prepareStatement(sql);
			
			while(rs.next()) {
				

				title = rs.getString("title");
				mseq = rs.getString("mseq");
				dueDate.set(Integer.parseInt(rs.getString("regdate").substring(0,4))
						, Integer.parseInt(rs.getString("regdate").substring(5,7)) - 1
						, Integer.parseInt(rs.getString("regdate").substring(8,10)));
				String content = String.format("'%s'의 마감기한 하루 전입니다.", title);
				
				pstat.setString(1, content);
				pstat.setString(2, String.format("%tF", dueDate));
				pstat.setString(3, mseq);
				pstat.executeUpdate();
				
				System.out.println(num++);
			}
			pstat.close();
			
			rs.close();
			stat.close();
			conn.close();
			System.out.println("체크리스트 기한 알림 끝");		
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void projectNoticeAddList() {
		
		DBUtil util = new DBUtil();
		
		try {

			conn = util.open();
			
			//3. 프로젝트 공지사항 추가 알림
			
			String sql = "select (select name from tbl_project where seq = a.project_seq) as pname, a.member_seq as mseq, n.regdate as regdate from tbl_project_attend a inner join tbl_project_notice n on a.project_seq = n.project_seq";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			String pname = "";
			String mseq = "";
			Calendar addDate = Calendar.getInstance();
			
			
			sql = "insert into tbl_alert (seq, content, regdate, member_seq, delflag) values (seq_alert.nextVal, ?, ?, ?, default)";
			pstat = conn.prepareStatement(sql);
				
			while(rs.next()) {

				pname = rs.getString("pname");
				mseq = rs.getString("mseq");
				addDate.set(Integer.parseInt(rs.getString("regdate").substring(0,4))
						, Integer.parseInt(rs.getString("regdate").substring(5,7)) - 1
						, Integer.parseInt(rs.getString("regdate").substring(8,10)));
				String content = String.format("'%s'프로젝트에 새로운 공지사항이 등록되었습니다.", pname);
				
				pstat.setString(1, content);
				pstat.setString(2, String.format("%tF", addDate));
				pstat.setString(3, mseq);
				
				pstat.executeUpdate();
				
				System.out.println(num++);
			}
			pstat.close();
			
			rs.close();
			stat.close();
			conn.close();
			System.out.println("프로젝트 공지사항 추가 알림 끝");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void projectInvitedList() {
		
		DBUtil util = new DBUtil();
		
		try {

			conn = util.open();
			
			//2. 프로젝트 초대받았음 알림(팀원만)
			
			String sql = "select p.name as pname, p.regdate as regdate, a.member_seq as mseq  from tbl_project p inner join tbl_project_attend a on p.seq = a.project_seq where a.position = '팀원'";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			String pname = "";
			String mseq = "";
			Calendar addDate = Calendar.getInstance();
			
			sql = "insert into tbl_alert (seq, content, regdate, member_seq, delflag) values (seq_alert.nextVal, ?, ?, ?, default)";
			pstat = conn.prepareStatement(sql);
			
			while(rs.next()) {
				

				pname = rs.getString("pname");
				mseq = rs.getString("mseq");
				addDate.set(Integer.parseInt(rs.getString("regdate").substring(0,4))
						, Integer.parseInt(rs.getString("regdate").substring(5,7)) - 1
						, Integer.parseInt(rs.getString("regdate").substring(8,10)));
				String content = String.format("'%s'프로젝트에 초대받으셨습니다.", pname);
				
				pstat.setString(1, content);
				pstat.setString(2, String.format("%tF", addDate));
				pstat.setString(3, mseq);

				pstat.executeUpdate();
				
				System.out.println(num++);
			}
			pstat.close();
			
			rs.close();
			stat.close();
			conn.close();
			System.out.println("프로젝트 초대알림 끝");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void friendAddList() {
		
		DBUtil util = new DBUtil();
		
		try {

			conn = util.open();
			
			//1. 친구 추가되었음 알림
			
			String sql = "select f.*, (select name from tbl_member m where f.friend_seq = m.seq) as fname from tbl_friend f";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			String fname = "";
			String mseq = "";
			Calendar addDate = Calendar.getInstance();
			
			
			sql = "insert into tbl_alert (seq, content, regdate, member_seq, delflag) values (seq_alert.nextVal, ?, ?, ?, default)";
			pstat = conn.prepareStatement(sql);

			while(rs.next()) {
				

				fname = rs.getString("fname");
				mseq = rs.getString("Member_seq");
				addDate.set(Integer.parseInt(rs.getString("regdate").substring(0,4))
						, Integer.parseInt(rs.getString("regdate").substring(5,7)) - 1
						, Integer.parseInt(rs.getString("regdate").substring(8,10)));
				String content = String.format("%s님이 회원님을 친구로 등록했습니다.", fname);
				
				pstat.setString(1, content);
				pstat.setString(2, String.format("%tF", addDate));
				pstat.setString(3, mseq);
				pstat.executeUpdate();
				
				System.out.println(num++);
			}
			
			pstat.close();
			rs.close();
			stat.close();
			conn.close();
			
			System.out.println("친구추가내역 등록 끝");
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tblCheckListItemComment() {
		
		DBUtil util = new DBUtil();
		
		
		try {
			conn = util.open();
			
			
			String sql = "select * from tbl_checklist_item";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			String[] comments = {"수고하셨습니다.", "고생하셨습니다.", "신속하게 부탁드립니다.", "수정 바랍니다.", "확인 바랍니다.", "보고 바랍니다.",
									"언제까지 완성해 주실 예정인가요?", "내일까지 완료 부탁드립니다.", "이번주 내로 진행상황 보고 바랍니다."};
			Calendar regdate = Calendar.getInstance();
			int num =1;
			
			while(rs.next()) {
				
				String iseq = rs.getString("seq");				//체크리스트 항목 번호
				String cseq = rs.getString("checklist_seq");	//체크리스트 번호
				
				//날짜 가져와서 잘라줌
				int year = Integer.parseInt(rs.getString("startdate").substring(0,4));
				int month = Integer.parseInt(rs.getString("startdate").substring(5, 7)) - 1;
				int day = Integer.parseInt(rs.getString("startdate").substring(8, 10));
				
				
				ArrayList<String> mlist = new ArrayList<String>();	//해당 프로젝트의 참여자만 저장할 리스트
				
				//해당 체크리스트 항목이 포함된 프로젝트의 참여자만 가져옴
				sql = "select seq from tbl_project_attend where project_seq = (select DISTINCT project_seq from tbl_checkList where seq = ?)";
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, cseq);
			
				rs2 = pstat.executeQuery();
				
				while(rs2.next()) {
					//멤버리스트에 참여자를 담아줌
					mlist.add(rs2.getString("seq"));
				}
				
				pstat.close();
				
				
				int count = (int)(Math.random() * 3); 	//댓글을 달 개수, 0~2개
				
				for (int i=0; i<count; i++) {				
					
					//날짜 랜덤 셋팅
					regdate.set(year, month, day + (int)(Math.random()*5));
					
					//체크리스트 항목 댓글
						// 번호
						// 삭제여부
						// 체크리스트 항목 번호
						// 작성일
						// 내용
						// 프로젝프 참여 번호
					
					String sql2 = "insert into tbl_checklist_item_comment (seq, delflag, checklist_item_seq, regdate, content, project_attend_seq) "
							+ "values (seq_checklist_item_comment.nextval, 0, ?, ?, ?, ?)";			
					
					pstat2 = conn.prepareStatement(sql2);
					pstat2.setString(1, iseq);
					pstat2.setString(2, String.format("%tF", regdate));
					pstat2.setString(3, comments[(int)(Math.random()*comments.length)]);
					pstat2.setString(4, mlist.get((int)(Math.random()*mlist.size())));
					
					pstat2.executeUpdate();
					pstat2.close();
					
					System.out.printf("%tF : %d\n", regdate, num);
					num++;
							
				}//for				
				
			}//while
			stat.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void tblchecklist() {

		DBUtil util = new DBUtil();
		
		try {
			
			conn = util.open();
			int num = 1;
			
			for(int i=1; i<=500; i++) {
				for (int j=1; j<4; j++) {
					
					String sql = String.format("INSERT INTO TBL_CHECKLIST (SEQ, TITLE, PROJECT_SEQ, DELFLAG) VALUES (SEQ_CHECKLIST.NEXTVAL, '체크리스트%d', %d, 0)", j, i);
					pstat = conn.prepareStatement(sql);
					pstat.executeUpdate();
					pstat.close();
					
					System.out.println(num);
					num++;
				}
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	public void tblChecklistItem() {
		
		DBUtil util = new DBUtil();
		
		try {
			
			//가져오기
			conn = util.open();
			String sql = "select * from vw_checklist_item";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			String[] title = {"화면설계", "요구명세서 작성", "더미데이터 삽입", "UI설계", "벤치마킹 분석", "UI 구현 지침서 작성", "테스트 케이스 시나리오 작성", 
								"테스트", "프로토타입 설계", "프로토타입 구현", "발표 대본 작성", "발표 PPT 제작", "ERD 작성", "ERD 수정", "기능 구현", "서버 구현",
								"HTML 작성", "CSS 작성", "외부 API 적용"};
			
			Calendar sdate = Calendar.getInstance();
			Calendar edate = Calendar.getInstance();
			Calendar rdate = Calendar.getInstance();
			
			int num = 1;
			
			while(rs.next()) {
				
				//체크리스트 항목
				//번호						:seq
				//삭제여부					:default
				//체크리스트번호(fk)		:
				//제목						:string[] title
				//내용						:null
				//시작일					
				//종료일
				//등록일
				//완료여부					:default
				//담당자(프로젝트참여번호)	:
				

				int period = (int)(Math.random() * 6) + 2;	//체크리스트 항목 기간이 얼마나 되는지, 2~7
				int gab = (int)(Math.random() * 5) + 1;		//프로젝트 등록일로부터 얼마나 오래되었는지, 1~5 
				
				
				int year = Integer.parseInt(rs.getString("sdate").substring(0,4));
				int month = Integer.parseInt(rs.getString("sdate").substring(5, 7)) -1;
				int day = Integer.parseInt(rs.getString("sdate").substring(8, 10));
				
				sdate.set(year, month, day + gab);
				edate.set(year, month, day + period);
				rdate.set(year, month, day + gab);
				
				String listTitle = title[(int)(Math.random()*title.length)];
							
				//데이터 삽입하기 
				sql = "insert into tbl_checklist_item "
						+ "(seq, delflag, completeflag, checkList_seq, project_attend_seq, title, startdate, enddate, regdate) values "
						+ "(seq_checklist_item.nextval, 0, 0, ?, ?, ?, ?, ?, ?)";
																		
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, rs.getString("cseq"));						//체크리스트 번호
				pstat.setString(2, rs.getString("paseq"));						//프로젝트 참여 번호
				pstat.setString(3, listTitle);									//제목
				pstat.setString(4, String.format("%tF", sdate));				//시작일
				pstat.setString(5, String.format("%tF", edate));				//종료일
				pstat.setString(6, String.format("%tF", rdate));				//등록일
				
				pstat.executeUpdate();
				pstat.close();
				
				System.out.println(listTitle +" : "+ num);
				num++;
			}
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
