package com.test.spring;

import org.springframework.beans.factory.annotation.Autowired;

//클래스 이름과 어노테이션이 충돌이 나서 풀네임으로 적어주었음.
@org.springframework.stereotype.Service
public class Service implements IService {
	
	@Autowired
	private DAO dao;

	@Override
	public int getCount() {
		
		return dao.getCount();
	}
	
	
	
}
