package com.test.codestudy.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/list.do")
public class List extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//새로고침 조회수 증가 방지를 위해 세션 안에 정보 넣기 (boolean 값을 on/off 스위치로 쓰기)
		HttpSession session = req.getSession();
		session.setAttribute("read", false);
		
		
		//목록 전체 출력인지 검색인지 구분하기
		// - 목록 : list.do
		// - 검색 : list.do?search=sss
		
		String search = req.getParameter("search");	//null or 검색어 
		
		
		//1. DB작업 > select
		//2. 결과값 전달 + JSP 호출하기
		
		//정렬 기준
		//- list.do --> 아래 list()메소드에 매개변수가 아무것도 넘어가지 않아(null) 정렬이 엉망이 됨. 
		//- list.do?sort=seq	--> 기본값으로 지정해 주기
		//- list.do?sort=heart
		//- list.do?sort=readcount
		String sort = req.getParameter("sort");
		
		if (sort == null) {
			sort = "thread";	//seq순 정렬을 기본으로 지정해줌
		}	
		
		
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("search", search);
		map.put("sort", sort);
		
		
		//페이징 처리 관련 변수 생성하기
		int nowPage = 0;		//현재 페이지 번호
		int totalCount = 0;		//총 게시물 수
		int pageSize = 10;		//한 페이지당 출력 갯수
		int totalPage = 0;		//총 페이지 수
		int begin = 0;			//선택한 페이지의 rnum 시작 번호
		int end = 0;			//선택한 페이지의 rnum 끝 번호
		int n = 0;				//페이지바 관련 변수
		int loop = 1;			//페이지바 관련 변수
		int blockSize = 10;		//페이지바 관련 변수

		
		
		//모든 list.do -> list.do?page=1 로 변경
		
		String page = req.getParameter("page");
		if (page == null || page == "") {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
	
		//만약 1페이지를 보려고 한다면? -> where rnum >= 1 and rnum <= 10
		//만약 2페이지를 보려고 한다면? -> where rnum >= 11 and rnum <= 20
		//만약 3페이지를 보려고 한다면? -> where rnum >= 21 and rnum <= 30
		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		//map에 담아서 넘기기
		map.put("begin", begin + "");
		map.put("end", end + "");

		
		
		//1.
		BoardDAO dao = new BoardDAO();
		
		
		//총 페이지수 알아내기
		//총 페이지 = (int)(총 게시글 / 한 페이지당 출력 게시물 수) + 1

		//총 글 수 받아오기
		totalCount = dao.getTotalCount(map);		//검색중이라면 검색어가 같이 넘어가야 하기 때문에 map 을 넘겨야함
		
		totalPage = (int)Math.ceil((double)totalCount / pageSize);
		System.out.println(totalPage);

		
		
		
		
		
		//DB에서 글목록 받아오기
		ArrayList<BoardDTO> list = dao.list(map);	//검색어 값을 매개변수로 넘김
		
		//list를 jsp에 전달하기 전에 가공하기
		//	1. SQL에서 진행
		//	2. 서블릿에서 진행
		//	3. JavaScript로 진행
		// -> 상황 보고 판단하기 (최소한의 규칙: 최대한 빨리한다)

		//오늘 쓴 글은 작성시각 표시, 아니면 날짜 표시
		//최신글 표시하기 -> 오라클에서 하기 
		
		//오늘 쓴 글인지 확인을 위해 오늘 날짜 가져오기
		
		Calendar now = Calendar.getInstance();
		
		
		
		for (BoardDTO dto : list) {
			
			//오늘 날짜인지?
			if(dto.getRegdate().startsWith(String.format("%tF", now))) {
				dto.setRegdate(dto.getRegdate().substring(11));
//				System.out.println("오늘 쓴 글");
			} else {
				//시분초 버리고 날짜만 저장
				dto.setRegdate(dto.getRegdate().substring(0, 10));
//				System.out.println("어제까지 쓴 글");
			}
			
			
			//req.getParameter("search")의 특징
			//1. list.do -> null반환
			//2. list.do?search=홍길동 -> 홍길동 반환
			//3. list.do?search= -> 빈문자열("") 반환
			
			
			
			if (search != null && search != "") {
				
				//검색어 부각시키기
				//a. 제목 
				String subject = dto.getSubject();
				subject = subject.replace(search, "<span style='font-weight:bold; color:tomato;'>"+ search +"</span>");
				dto.setSubject(subject);
				
				//b. 작성자
				String name = dto.getName();
				name = name.replace(search, "<span style='font-weight:bold; color:tomato;'>"+ search +"</span>");
				dto.setName(name);
				
				//c. 내용 -> view.java
			}
		}
		
		dao.close();
		
		
		//페이지바 만들기 
		String pagebar ="";
		n = ((nowPage - 1) / blockSize) * blockSize + 1;
		
		//페이지바 시작
		pagebar += "<nav class=\"pagebar\">";
		pagebar += "<ul class=\"pagination\">";
		
		//이전 10페이지
		if (n == 1) {
			pagebar += "<li class='disabled'>";
			pagebar += "<a href=\"#!\" aria-label=\"Previous\">";
			pagebar += "<span aria-hidden=\"true\">&laquo;</span>";
			pagebar += "</a>";
			pagebar += "<li>";
		} else {
			pagebar += "<li>";
			pagebar += String.format("<a href=\"/codestudy/board/list.do?page=%d\" aria-label=\"Previous\">", n-1);
			pagebar += "<span aria-hidden=\"true\">&laquo;</span>";
			pagebar += "</a>";
			pagebar += "<li>";
		}
	
		//페이지 번호
		//for (int i=1; i<=totalPage; i++) {
		while (!(loop > blockSize || n > totalPage)) {
				//loop : 10개씩 출력해주는 역할
				//n : 마지막 페이지를 지정해주는 역할
			
			if (n == nowPage) {	//선택한 페이지가 지금 보고있는 페이지인지?
				
				pagebar += "<li class=\"active\">";
				pagebar += String.format("<a href=\"#!\">%d</a>", n);	//현재페이지를 눌러도 이동되지 않도록 
				pagebar += "</li>";
				
			} else {
				pagebar += "<li>";
				pagebar += String.format("<a href=\"/codestudy/board/list.do?page=%d\">%d</a>", n, n);
				pagebar += "</li>";
			}
			
			loop++;
			n++;
		}
		
		//다음 10페이지
		if (n > totalPage) {
			pagebar += "<li class=\"disabled\">";
			pagebar += String.format("<a href=\"#!\" aria-label=\"Next\">", n);
			pagebar += "<span aria-hidden=\"true\">&raquo;</span>";
			pagebar += "</a>";
			pagebar += "<li>";
		} else {
			pagebar += "<li>";
			pagebar += String.format("<a href=\"/codestudy/board/list.do?page=%d\" aria-label=\"Next\">", n);
			pagebar += "<span aria-hidden=\"true\">&raquo;</span>";
			pagebar += "</a>";
			pagebar += "<li>";
		}
		
		
		//페이지바 끝
		pagebar += "</ul>";
		pagebar += "</nav>";
		
		
		
		
		
		
		
		
		
		
		//2.
		req.setAttribute("list", list);
		
		//전달받은 검색어를 검색어창에 출력해주기 위해 다시 전달함. 
		req.setAttribute("search", search);
		//정렬에 따라 정렬 버튼을 누른 상태로 표시해주기 위해 sort값을 다시 전달함
		req.setAttribute("sort", sort);
		//페이지 번호 건네주기
		req.setAttribute("page", nowPage);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		
		//페이지바 출력문 건네주기
		req.setAttribute("pagebar", pagebar);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/list.jsp");
		dispatcher.forward(req, resp);
		
	}

}

