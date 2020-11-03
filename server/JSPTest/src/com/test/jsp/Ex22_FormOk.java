package com.test.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/ex22_formok.do")
public class Ex22_FormOk extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//파일 업로드 처리
		//1. 업로드된 파일을 어디에 저장할지 결정
		//	- 웹 경로 표기 (X) -> 로컬 파일 경로 표기(O)
		//	- WebContent > files
		//2. 업로드할 파일의 최대 크기 지정(트래픽 때문)
		// 	- 최대한 작게
		//	- 게시판(100MB)
		//	- 바이트
		//3. 변수 선언
		
		
		
		
		//1.
		//가상경로 & 상대경로를 쓰면 안됨(인식하지 못함), 절대경로로 적어야함
//		String path = "D:\\class\\server\\JSPTest\\WebContent\\files";		-> 이렇게 적기 불편..
		String path = req.getRealPath("/files");
		
//		System.out.println(path);
		//D:\class\server\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JSPTest\files
		//	-> 톰캣이 동작할 때 원본을 복사함. 
		
		//2.
		int size = 1024 * 1024 * 100;	//100MB
		
		//3.
		String subject = "";
		String name = "";
		String filename = "";
		String orgfilename = "";
		
		subject = req.getParameter("subject");
//		System.out.println(subject); //null값 출력됨. enctype="multipart/form-data"때문!!
		//<form enctype="multipart/form-data"> 인 경우 req.getParameter() 메소드만 동작하지 않음. 
		
		req.setCharacterEncoding("UTF-8");
		
		//따라서 req.getParameter()를 대신할 메소드를 씀! (try-catch절 안에 써야함.)
		// 	-> cos.jar
		
		try {
			
			//MultipartRequest 객체를 만들었을 때 파일 업로드가 끝남. 
			MultipartRequest multi = new MultipartRequest(req		//기존의 request 객체, MultipartRequest는 wrapper클래스임.
														, path		//파일 저장 경로
														, size		//최대 파일 크기
														, "UTF-8"	//인코딩 방식
														, new DefaultFileRenamePolicy()	//똑같은 파일이 있는 경우 파일에 넘버링을 해줌.
														);
			subject = multi.getParameter("subject");
			name = multi.getParameter("name");
			
			//업로드했던 첨부파일의 이름을 가져올 수 있음.
			//파일 업로드 컨트롤(input 태그)의 name값을 인자로 넣어주면 됨.
			filename = multi.getFilesystemName("attach");		//중복 파일의 넘버링된 이름
			System.out.println(filename);
			
			orgfilename = multi.getOriginalFileName("attach");	//원래 파일의 이름
			System.out.println(orgfilename);
		
			
			req.setAttribute("subject", subject);
			req.setAttribute("name", name);
			req.setAttribute("filename", filename);
			req.setAttribute("orgfilename", orgfilename);
			
		} catch (Exception e) {
			e.printStackTrace();			
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/ex22_formok.jsp");
		dispatcher.forward(req, resp);
	
	}
}
