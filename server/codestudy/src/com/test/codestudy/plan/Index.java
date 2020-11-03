package com.test.codestudy.plan;

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

@WebServlet("/plan/index.do")
public class Index extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//index.do
		//index.do?year=2020&month=8
		
		String txtYear = request.getParameter("year");
		String txtMonth = request.getParameter("month");
		Calendar c = Calendar.getInstance(); 
		

		int year = 0;
		int month = 0;


		if(txtYear == null || txtMonth == null) {	//년, 월이 넘어왔을 경우
		
			//이번 년, 이번 월
			year = c.get(Calendar.YEAR);
			month = c.get(Calendar.MONTH); 
			
		} else {	//년, 월이 넘어왔을 경우
			
			//지정 년, 지정 월
			year = Integer.parseInt(txtYear);
			month = Integer.parseInt(txtMonth);
		}
		
		//일정 가져오기
		PlanDAO dao = new PlanDAO();
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		map.put("year", year);
		map.put("month", month);
		
		ArrayList<PlanDTO> list = dao.list(map);
		//System.out.println(list.size());
		
		
		//달력 HTML제작하여 JSP에게 전달하기
		String txtCal = "";
		
		//달력만들때 필요한 요소
		//1. 해당 월의 최대일수
		//2. 해당 월 1일의 요일
		
		c.set(year, month, 1);
		
		int maxDate= c.getActualMaximum(Calendar.DATE);	//설정한 월의 최대 일자(8월 - 31일)
//		System.out.println(maxDate);
		
		txtCal += "<tr>";
		
		//1일 앞의 빈 <td> 출력하기
		for (int i=0; i<c.get(Calendar.DAY_OF_WEEK)-1; i++ ) {
		
			txtCal += "<td></td>";
		}
		
		//달력 생성하기
		for (int i=1; i<=maxDate; i++) {
			
			txtCal += "<td>";
			txtCal += String.format("<div class='date'>%d</div>", i);	//날짜 출력
			
			//출력되는 날짜와 일정의 날짜가 같은 경우
			for (PlanDTO dto : list) {
				if(dto.getRegdate().equals(String.format("%tF", c)) ) {
					txtCal += String.format("<div class='item' data-toggle='modal' data-target='#myModal' onclick='setData(\"%s\",\"%s\")'>- %s</div>"
																									, dto.getRegdate(), dto.getName(), dto.getContent());					
				}
			}
			
			txtCal += "</td>";
			
			//토요일마다 <tr>처리
			if(c.get(Calendar.DAY_OF_WEEK) == 7) {

				txtCal += "</tr>";
				txtCal += "<tr>";
			}
			
			c.add(Calendar.DATE, 1); //for문 돌때마다 하루씩 더해주기
			
		}

		//마지막일 뒤의 빈 <td> 출력하기
		for (int i=0; i<=7-c.get(Calendar.DAY_OF_WEEK); i++ ) {
		
			txtCal += "<td></td>";
		}
		
		txtCal += "</tr>";
			
		
		//현재날짜로 이전년월, 다음년월 얻기
		Calendar now = Calendar.getInstance();
		now.set(year, month, 1); //화면에서 보고 있는 날짜를 기준으로 일자 설정하기
		
		now.add(Calendar.MONTH, -1);
		int prevYear = now.get(Calendar.YEAR);
		int prevMonth = now.get(Calendar.MONTH);
		
		now.add(Calendar.MONTH, 2);
		int nextYear = now.get(Calendar.YEAR);
		int nextMonth = now.get(Calendar.MONTH);
		
		
		request.setAttribute("txtCal", txtCal);
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		
		request.setAttribute("prevYear", prevYear);
		request.setAttribute("prevMonth", prevMonth);
		request.setAttribute("nextYear", nextYear);
		request.setAttribute("nextMonth", nextMonth);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/plan/index.jsp");
		dispatcher.forward(request, response);
		
	}

}
