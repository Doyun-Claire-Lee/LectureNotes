package com.test.codestudy.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import com.test.codestudy.DBUtil;

public class Dummy {

	public static void main(String[] args) {
		
		//게시판 더미 데이터
		//seq, subject, content, regdate, readcount, mesq, thread, depth
		
		String[] subject = {"게시판 테스트입니다.", "동부간선·내부순환 통행 재개…올림픽·강변 통제 계속(종합)"
							,"남이섬이 잠겼다…폭우에 소양강댐 방류 탓 20년만에 처음", "환경 고민않고 과다소비…200만원 벌며 350만원 쓰는 꼴"
							,"질산암모늄이 도시 날릴 것 수차례 경고에도… 레바논 6년째 방치", "미, 전세계 여행금지 경보 해제…한국 전역은 여행재고로 내려(종합)"
							,"美 민소매, 英 노타이 허용… 캐나다선 후드티까지 등장", "英6세 치킨너겟 먹다 질식위기, 그속엔 마스크 들어있었다"
							, "韓제약사 일냈다…'사이토카인 폭풍' 치료 후보물질 美특허", "갤노트20, 휴대폰 아니라 예술작품 외신들 찬사"};
		String[] mseq = {"5", "6", "7"};
		
		Connection conn = null;
		PreparedStatement stat = null;
		DBUtil util = new DBUtil();
		Random rnd = new Random();
		
		try {
			
			conn = util.open();
			String sql = "insert into tblboard (seq, subject, content, regdate, readcount, mseq, thread, depth) values "
							+ "(seqBoard.nextVal, ?, '내용입니다', default, default, ?, ?, 0)";
			
			stat = conn.prepareStatement(sql);
			
			
			
			for (int i=0; i<175; i++) {
				stat.setString(1, subject[rnd.nextInt(subject.length)]);
				stat.setString(2, mseq[rnd.nextInt(mseq.length)]);
				stat.setInt(3, (i+1) * 1000);								//thread
				
				System.out.println(i + " : " + stat.executeUpdate());
			
			}
			
			stat.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
}
	
	
	
}
