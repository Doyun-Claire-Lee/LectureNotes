package com.test.spring;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {

	@Autowired
	private SqlSessionTemplate template;
	
	//DAO에서 메소드1개는 1개의 쿼리만 실행한다.
	//1개의 메소드 안에서 2개 이상의 SQL을 실행하는 것은 권장하지 않는다. -> 나중에 재사용하기 어려워지기 때문에
	
	
	public int add(DTO dto) {
		//글쓰기
		return template.insert("tran.add", dto);
	}

	public int point(DTO dto) {
		//포인트 증가
		return template.update("tran.point", dto);
	}

}
