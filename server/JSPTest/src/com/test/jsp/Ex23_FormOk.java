package com.test.jsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



@WebServlet("/ex23_formok.do")
public class Ex23_FormOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String path = req.getRealPath("/files/checklist");
		int size = 1024 * 1024 * 100;	//100MB
		
		String subject = "";
		String name = "";
		
		ArrayList<String> filename = new ArrayList<String>();
		ArrayList<String> orgfilename = new ArrayList<String>();
		
		try {
			
			req.setCharacterEncoding("UTF-8");
			
			MultipartRequest multi = new MultipartRequest(req		
					, path		//파일 저장 경로
					, size		//최대 파일 크기
					, "UTF-8"	//인코딩 방식
					, new DefaultFileRenamePolicy()	//똑같은 파일이 있는 경우 파일에 넘버링을 해줌.
					);
					
			subject = multi.getParameter("subject");
			name = multi.getParameter("name");
			
			
			//첨부파일 여러개의 파일명 알아내기 
			Enumeration e = multi.getFileNames();	
			
			while (e.hasMoreElements()) {
				String file = (String)e.nextElement();
				
				filename.add(multi.getFilesystemName(file));
				orgfilename.add(multi.getOriginalFileName(file));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("filename", filename);
		req.setAttribute("orgfilename", orgfilename);	
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/ex23_formok.jsp");
		dispatcher.forward(req, resp);
	
	

	}
	
	
	
}
