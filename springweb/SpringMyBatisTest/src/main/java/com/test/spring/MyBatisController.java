package com.test.spring;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*

객체간의 관계
	
	Controller --(위임)--> IService --(DB관련 위임)--> DAO --(MyBatis(JDBC))--> Oracle 
			      DTO					  DTO					   DTO
			      
*/


@Controller
public class MyBatisController {

	//의존 객체를 Autowired를 이용해서 의존 주입한다. (객체를 만들어서 넣어준다.)
	@Autowired
	private IMyBatisService service;
	
	@RequestMapping(value = "/m1.action", method = { RequestMethod.GET })
	public String m1(HttpServletRequest request, HttpServletResponse response) {

		//반환값X, 인자값X -> 정적 쿼리
		service.m1();

		return "result";
	}
	
	@RequestMapping(value = "/m2.action", method = { RequestMethod.GET })
	public String m2(HttpServletRequest request, HttpServletResponse response) {
		
		//반환값X, 단일 인자값 
		String seq = "1";	//인자값, m2.action?seq=1
		
		//나이를 한살 업데이트 시키는 작업?
		int result = service.m2(seq);
		request.setAttribute("result", result);
		
		return "result";
	}
	
	@RequestMapping(value = "/m3.action", method = { RequestMethod.GET })
	public String m3(HttpServletRequest request, HttpServletResponse response, 
						String name, String age, String etc) {

		//반환값X, 다중 인자값 -> name, age, etc (레코드 하나와 관련된 다중인자값) 
		//다중 인자값일때 데이터를 넘겨주는 방법
		//1. HashMap
		//2. DTO(VO)
		//spring/m3.action?name=아무개&age=20&etc=테스트용
		
		//1.HashMap
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("age", age);
		map.put("etc", etc);
		
		int result = service.m3(map);
		
		request.setAttribute("result", result);
		return "result";
	}
	
	@RequestMapping(value = "/m4.action", method = { RequestMethod.GET })
	public String m4(HttpServletRequest request, HttpServletResponse response, MyBatisDTO dto) {

		//2.DTO
		//spring/m4.action?name=꾸르미&age=0&etc=테스트용
		
		int result = service.m4(dto);		

		request.setAttribute("result", result);
		return "result";
	}
	
	@RequestMapping(value = "/m5.action", method = { RequestMethod.GET })
	public String m5(HttpServletRequest request, HttpServletResponse response) {

		//반환값O
		//1. 단일값 반환 : 단일 레코드 + 단일 컬럼 -> int/double/String
		//2. 다중값 반환 : 단일 레코드 + 다중 컬럼 -> DTO
		//3.			   다중 레코드 + 단일 컬럼 -> List<String>
		//4.			   다중 레코드 + 다중 컬럼 -> List<DTO>
		
		//1.
		String name = service.m5();
		request.setAttribute("name", name);
		
		return "result";
	}
	
	@RequestMapping(value = "/m6.action", method = { RequestMethod.GET })
	public String m6(HttpServletRequest request, HttpServletResponse response, String seq) {

		//2.
		//m6?seq=1
		
		MyBatisDTO dto = service.m6(seq);
		request.setAttribute("dto", dto);
		
		return "result";
	}
	
	@RequestMapping(value = "/m7.action", method = { RequestMethod.GET })
	public String m7(HttpServletRequest request, HttpServletResponse response) {

		//3.

		List<String> names = service.m7();
		
		request.setAttribute("names", names);
		return "result";
	}
	
	@RequestMapping(value = "/m8.action", method = { RequestMethod.GET })
	public String m8(HttpServletRequest request, HttpServletResponse response) {

		//4. 다중레코드 + 다중컬럼

		List<MyBatisDTO> list = service.m8();
		
		request.setAttribute("list", list);
		return "result";
	}
	
	
	
	
	
	
	
}
