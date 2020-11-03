package com.test.spring;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO implements IBoardDAO {

	@Autowired
	private SqlSessionTemplate template;

	@Override
	public int add(BoardDTO dto) {

		return template.insert("board.add", dto);
	}

	@Override
	public List<BoardDTO> list() {
		
		return template.selectList("board.list");
	}

	@Override
	public BoardDTO get(String seq) {
		return template.selectOne("board.get", seq);
	}

	@Override
	public int edit(BoardDTO dto) {
		return template.update("board.edit", dto);
	}

	@Override
	public int delete(String seq) {
		
		return template.delete("board.delete", seq);
	}

	@Override
	public List<CategoryDTO> clist() {

		return template.selectList("board.clist");
	}
	
	
}
