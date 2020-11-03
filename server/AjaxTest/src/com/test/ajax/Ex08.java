package com.test.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex08.do")
public class Ex08 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BoardDAO dao = new BoardDAO();
		
		//최근 글 1번부터 10번까지 
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("begin", "1");
		map.put("end", "10");
		
		
		ArrayList<BoardDTO> list = dao.list(map);
		dao.close();
		
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("list", list);
		//시작값과 끝값을 ajax가 알아야 하기 때문에 map도 넘김
		req.setAttribute("map", map);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ex08.jsp");
		dispatcher.forward(req, resp);
	
	}
		
}
