package com.test.spring;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisDAO {
	
	/*
		JDBC에서는 Connection, Statement, ResultSet이 있어야 작업이 가능했었음.
		MyBatis에서는 SqlSessionTemplate이 필요(root-context.xml에서 정의)
	*/
	
	@Autowired
	private SqlSessionTemplate template;	//root-context.xml에서 정의된 <bean>에 따라 내부적으로 getBean()메소드가 호출되어 객체가 생성됨.
	
	/*
		stat.executeUpdate();
			- template.insert();
			- template.delete();
			- template.update();
		stat.executeQuery();
			- template.select();
	*/
	
	public void m1() {
	//반환값X, 인자값X
		
		//test.m1
		// -> 매퍼에 있는 쿼리들 중 네임스페이스가 test이고 id가 m1인 쿼리를 찾아 호출하라는 뜻
		template.insert("test.m1");
	}

	public int m2(String seq) {
	//반환값X, 단일 인자값
		
		return template.update("test.m2", seq);
	}

	public int m3(HashMap<String, String> map) {
	//반환값X, 다중 인자값(HashMap)

		return template.insert("test.m3", map);
	}

	public int m4(MyBatisDTO dto) {
	//반환값X, 다중 인자값(DTO)

		return template.insert("test.m4", dto);
	}

	public String m5() {
	//단일행, 단일컬럼 반환
	
		//결과 테이블의 "레코드" 개수에 따라 달라지는 메소드
		// - template.selectOne();	-> 레코드 1개
		// - template.selectList(); -> 레코드 여러개
		
		return template.selectOne("test.m5");
	}

	public MyBatisDTO m6(String seq) {
	//단일행, 다중컬럼 반환

		return template.selectOne("test.m6", seq);
	}

	public List<String> m7() {
	//다중행, 단일컬럼 반환
		
		return template.selectList("test.m7");
	}

	public List<MyBatisDTO> m8() {
	//다중행, 다중컬럼 반환
		
		return template.selectList("test.m8");
	}
	
	
}
