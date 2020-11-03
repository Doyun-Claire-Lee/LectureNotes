package com.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
public class Service implements IService {

	@Autowired
	private DAO dao;

	//스프링 트랜잭션은 메소드 단위로 지원한다.
	@Override
	@Transactional
	public int add(DTO dto) {
		
		int result = 0;
		
		result += dao.point(dto);		//포인트 증가

		result += dao.add(dto);			//글쓰기
		
		return result;
	}
	
	

	
	
}
