package com.test.spring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex05Controller {

	//글쓰기(add + addok)
	@RequestMapping(value="/board/add.action")
	public String add() {
		
		return "ex05";
	}
	
	//스프링 MVC에서 전송된 데이터를 수신하는 방법
	@RequestMapping(value="/board/addok.action")
	public void addok(
						HttpServletRequest req, 	//방법1
						HttpServletResponse resp,
//						String subject, 			//방법2, req.getParameter("subject")역할
//						String content,				//방법2
//						String name					//방법2
						BoardDTO dto,				//방법3, subject, content, name
						String seq
					) {
		
		//현재 상황
		//1. 데이터 가져오기
		//2. DTO 포장
		//3. DAO 호출 + DTO 전달 -> insert
		//4. 마무리
		
		/*
		//방법1. 기존에 사용하던 방식 : request 사용 (매개변수로 받아오기, 스프링이 알아서 전달해줌)
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		String name = req.getParameter("name");
		
		BoardDTO dto = new BoardDTO();
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setName(name);
		*/
		
		/*
		//방법2. 요청 메소드(현재 메소드)의 매개변수를 사용 (request 사용 안함)
		BoardDTO dto = new BoardDTO();
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setName(name);
		*/
		
		
		//방법3. 요청 메소드의 매개변수를 사용(request 사용 안함) -> BoardDTO를 매개변수로
		//만약 DTO에 넣을 수 없는 데이터도 함께 받아와야 할 경우? -> 매개변수를 별도로 받아오면 됨.
		
		
		//BoardDAO dao = new BoardDAO();
		//int result = dao.add(dto);
		
		//데이터 확인용 테스트 출력
		System.out.println(dto.toString());
		System.out.println(seq);
		
		//PrintWriter로 쓰기.. -> response객체 사용 (매개변수로 받아오기, 스프링이 알아서 전달해줌)
		try {
			PrintWriter writer;
			writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>alert('complete');</script>");
			writer.print("</body>");
			writer.print("</html>");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
