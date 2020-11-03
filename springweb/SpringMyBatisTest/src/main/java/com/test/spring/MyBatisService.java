package com.test.spring;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Autowired에 의해서 의존 주입 객체가 되려면 선언해야 하는 어노테이션
@Service
public class MyBatisService implements IMyBatisService {

	//DB작업은 DAO에게 넘기기 때문에 DAO를 의존함.
	@Autowired		
	private MyBatisDAO dao;

	@Override
	public void m1() {
		dao.m1();	//@Autowired를 깜빡할 경우 dao가 null이기 때문에 NullPointException이 발생함.
	}

	@Override
	public int m2(String seq) {
		return dao.m2(seq);
	}

	@Override
	public int m3(HashMap<String, String> map) {
		return dao.m3(map);
	}

	@Override
	public int m4(MyBatisDTO dto) {
		return dao.m4(dto);
	}

	@Override
	public String m5() {
		return dao.m5();
	}

	@Override
	public MyBatisDTO m6(String seq) {
		return dao.m6(seq);
	}

	@Override
	public List<String> m7() {
		return dao.m7();
	}

	@Override
	public List<MyBatisDTO> m8() {
		return dao.m8();
	}


	
}
