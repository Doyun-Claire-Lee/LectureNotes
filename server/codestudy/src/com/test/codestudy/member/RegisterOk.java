package com.test.codestudy.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/member/registerok.do")
public class RegisterOk extends HttpServlet {
	
	

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			//1. 데이터 가져오기
			//2. 파일 업로드 처리(프로필이미지) 
			//3. DB작업 - insert
			//4. 결과 반환 - JSP 호출하기(오늘은 X)
			
			//데이터에 한글이 있기 때문에 인코딩 해줌
			req.setCharacterEncoding("UTF-8");
			
			
			String id = "";
			String name = "";
			String email = "";
			String pw = "";
			String pic = "";
			int result = 0;
			
			try {
				
				MultipartRequest multi = new MultipartRequest(
											req,
											req.getRealPath("/pic"),
											1024 * 1024 * 10,
											"UTF-8",
											new DefaultFileRenamePolicy()
										);
				
				System.out.println(req.getRealPath("/pic"));
				
				//첨부파일 유무 확인?
//				System.out.println(multi.getFilesystemName("pic"));	//없으면 null
				
				id = multi.getParameter("id");
				name = multi.getParameter("name");
				email = multi.getParameter("email");
				pw = multi.getParameter("pw");
				
				
				pic = multi.getFilesystemName("pic") != null ? multi.getFilesystemName("pic") : "nopic.png";
				
				//DB작업은 다른 파일에 위임하기
				// - DB작업을 하는 객체들을 xxxDAO라는 이름으로 많이 생성함.
				// - Data Access Object
				MemberDAO dao = new MemberDAO();		//DB작업을 위임받을 클래스
				MemberDTO dto = new MemberDTO();		//회원가입할 멤버의 정보를 담을 상자
				
				dto.setId(id);
				dto.setName(name);
				dto.setEmail(email);
				dto.setPw(pw);
				dto.setPic(pic);
	
				//DB작업 후 결과 받아오기
				result = dao.add(dto);	
				
				//db닫기
				dao.close();
				
			} catch (Exception e) {
				e.printStackTrace();			
			}
	
			//registerok 대신 서블릿이 결과 안내 작업 대신하기
			
			if (result == 1) {
				//회원 가입 성공시 
				//시작 페이지로 이동시키기
				resp.sendRedirect("/codestudy/index.do");
					
				
			} else {
				//회원 가입 실패시
				
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
