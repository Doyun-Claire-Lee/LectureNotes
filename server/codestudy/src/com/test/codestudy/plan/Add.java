package com.test.codestudy.plan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/plan/add.do")
public class Add extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1. 데이터 가져오기(regdate, content)
		//2. DB작업(insert)
		//3. 결과 반환 + 달력으로 이동
		
		
		//1. 
		req.setCharacterEncoding("UTF-8");
		String regdate = req.getParameter("regdate");
		String content = req.getParameter("content");
		
		HttpSession session = req.getSession();
		
		//2.
		PlanDAO dao = new PlanDAO();
		PlanDTO dto = new PlanDTO();
		
		dto.setMseq(session.getAttribute("seq").toString());
		dto.setRegdate(regdate);
		dto.setContent(content);
		
		int result = dao.add(dto);
		dao.close();
		
		
		//3.
		if (result == 1) {
			//글쓰기 성공
			resp.sendRedirect("/codestudy/plan/index.do");
		} else {
			//글쓰기 실패
			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('failed'); history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			writer.close();
		}

		
	}
}
