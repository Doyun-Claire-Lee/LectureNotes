package com.test.spring;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class BoardController {
	
	//BoardController -> BoardDAO -> SqlSessionTemplate 의존
	@Autowired
	private IBoardDAO dao;
	
	//요청메소드
	@RequestMapping(value = "/template.action", method = { RequestMethod.GET })
	public String template(HttpServletRequest request, HttpServletResponse response) {

		
		//타일즈 레이아웃 설정 파일(WEB-INF/tiles.xml) -> <definition>의 이름
		return "template";
	}
	
	@RequestMapping(value = "/add.action", method = { RequestMethod.GET })
	public String add(HttpServletRequest request, HttpServletResponse response) {

		//글쓰기
		//1. DB작업 -> select
		//2. 카테고리 목록 -> JSP 전달
		
		List<CategoryDTO> clist = dao.clist();

		request.setAttribute("clist", clist);
		return "add";
	}
	
	@RequestMapping(value = "/addok.action", method = { RequestMethod.POST })
	public void addok(HttpServletRequest request, HttpServletResponse response, BoardDTO dto) {
		
		//1. 데이터 가져오기
		//2. 업로드 파일 처리
		//3. DB작업 -> insert
		//4. 결과 처리
		
		//<form enctype="X"> 			-> request객체 : HttpServletRequest	가 넘어옴.
		//<form enctype="multipart...">	-> request객체 : MultipartHttpServletRequesrt가 남아옴.
		
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)request;
		
		//첨부파일
		MultipartFile attach = multi.getFile("attach");	//첨부 파일 객체 참조, 매개변수는 첨부파일 태그의 name 속성값
	
		//System.out.println(attach.getName());
		//System.out.println(attach.getOriginalFilename());	//DB에 추가
		//System.out.println(attach.getSize());
		//System.out.println(attach.getContentType());
	
		//web-app > files 폴더 생성, 첨부파일을 저장할 경로
		//첨부된 파일을 임시 폴더에서 files 폴더로 이동해주기
		try {
			
			//똑같은 이름의 파일을 업로드하면 덮어쓰기 되어버림. 이름 변경해주기!
			String filename = attach.getOriginalFilename();
			
			//중복되지 않는 파일명을 만들어서 반환해주기(숫자 붙이기)
			filename = getFileName(request.getRealPath("files"), filename);	
			
			//D:\class\springweb\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringBoard\files\technology-785742_1920.jpg
			File file = new File(request.getRealPath("files") + "\\" + filename);		//중복되지 않는 파일명을 넣어줌!
			//System.out.println(file.getAbsolutePath());
			attach.transferTo(file);	//임시폴더에서 files 폴더로 파일을 이동한다. -> 파일 업로드 완료!
			
			dto.setFilename(filename);	//방금 업로드한 파일명을 DTO에도 추가하기
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//진짜 글쓰기!
		int result = dao.add(dto);
		complete(result, response, "list.action");
		
	}

	private void complete(int result, HttpServletResponse response, String url) {

		try {
			
			response.setCharacterEncoding("UTF-8");
			PrintWriter writer = response.getWriter();
			
			writer.print("<html>");
			writer.print("<head>");
			writer.print("<meta charset='UTF-8'>");
			writer.print("</head>");
			writer.print("<body>");
			writer.print("<script>");
			
			if(result == 1) {
				
				writer.print("location.href='/spring/" + url +"';");

			} else if (result == 0) {

				writer.print("alert('실패'); history.back();");
			}
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			
			writer.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private String getFileName(String realPath, String filename) {

		//중복된 파일명 -> 뒤에 숫자 붙이기 : test.java -> test1.java or test(1).java
		int n = 1;
		int index = filename.lastIndexOf(".");
		String name = filename.substring(0, index);	//test
		String ext = filename.substring(index);		//.java
		
		while (true) {
			
			//옮길 경로에 똑같은 파일이 있는지 파일 객체를 미리 만들어서 확인해보기 
			File file = new File(realPath + "\\" + filename);
			if (file.exists()) {
				//이미 같은 이름의 파일이 존재하는 경우 -> 파일 이름이 중복되지 않을때까지 n을 증가시키며 while문 돌아감.
				filename = name + "(" + n + ")" + ext;	
				n++;
				
			} else {
				return file.getName();
			}
		}
	}
	
	@RequestMapping(value = "/list.action", method = { RequestMethod.GET })
	public String list(HttpServletRequest request, HttpServletResponse response) {

		//목록보기
		//1. DB작업 -> select
		//2. 목록 반환 -> JSP 전달하기
		
		List<BoardDTO> list = dao.list();
		request.setAttribute("list", list);
		
		return "list";
	}

	@RequestMapping(value = "/view.action", method = { RequestMethod.GET })
	public String view(HttpServletRequest request, HttpServletResponse response, String seq) {

		//글 보기
		//1. 데이터 가져오기(seq)
		//2. DB작업 -> select
		//3. BoardDTO 반환 -> JSP 호출하기

		BoardDTO dto = dao.get(seq);
		String content = dto.getContent();
		content = content.replace("\r\n", "<br>");	//개행문자 처
		dto.setContent(content);
		
		//첨부파일 내용 읽기
		String temp = "";	
		Scanner scan;
		try {
		
			scan = new Scanner(new File(request.getRealPath("files") + "\\" + dto.getFilename()));
			
			while(scan.hasNextLine()) {
				temp += scan.nextLine() + "\r\n";
			}
			
			temp = temp.replace("<", "&lt;").replace(">", "&gt;");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("code", temp);
		request.setAttribute("dto", dto);
		
		return "view";
	}
	
	
	@RequestMapping(value = "/edit.action", method = { RequestMethod.GET })
	public String edit(HttpServletRequest request, HttpServletResponse response, String seq) {

		//수정하기
		//1. 데이터 가져오기(seq)
		//2. DB 작업(select)
		//3. DTO -> JSP에 전달
		
		BoardDTO dto = dao.get(seq);			
		List<CategoryDTO> clist = dao.clist();

		request.setAttribute("dto", dto);
		request.setAttribute("clist", clist);
		
		return "edit";
	}
	
	@RequestMapping(value = "/editok.action", method = { RequestMethod.POST })
	public void editok(HttpServletRequest request, HttpServletResponse response, BoardDTO dto) {

		//글 수정하기
		//1. 데이터 가져오기
		//2. 첨부 파일 처리하기
		//3. DB 작업 -> update
		//4. 결과
		
		
		//2. 첨부 파일 처리
		//a. 교체
		//b. 그대로
		
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)request;
		
		//첨부파일
		MultipartFile attach = multi.getFile("attach");	//첨부 파일 객체 참조, 매개변수는 첨부파일 태그의 name 속성값
		
		//첨부파일이 넘어왔는지(교체하려고 업로드하였는지) 확인하기
		if (!attach.isEmpty()) {
			//첨부파일 수정함
			try {
				//예전 파일은 삭제하기
				File oldfile = new File(request.getRealPath("files") + "\\" + dto.getFilename());		//중복되지 않는 파일명을 넣어줌!
				oldfile.delete();
				
				String filename = attach.getOriginalFilename();
				//중복되지 않는 파일명을 만들어서 반환해주기(숫자 붙이기)
				filename = getFileName(request.getRealPath("files"), filename);	
				File file = new File(request.getRealPath("files") + "\\" + filename);		//중복되지 않는 파일명을 넣어줌!
				attach.transferTo(file);	//임시폴더에서 files 폴더로 파일을 이동한다. -> 파일 업로드 완료!
				
				dto.setFilename(filename);	//방금 업로드한 파일명을 DTO에도 추가하기
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		int result = dao.edit(dto);
		complete(result, response, "view.action?seq=" + dto.getSeq());
		
	}
	
	@RequestMapping(value = "/delete.action", method = { RequestMethod.GET })
	public String delete(HttpServletRequest request, HttpServletResponse response, String seq) {

		//1.데이터 가져오기(seq)
		//2.DB작업 -> delete
		//3. 결과
		
		//첨부파일 삭제하기
		BoardDTO dto = dao.get(seq);
		File file = new File(request.getRealPath("files") + "\\" + dto.getFilename());
		file.delete();
		
		
		int result = dao.delete(seq);
		complete(result, response, "list.action");

		return "delete";
	}
	
}
