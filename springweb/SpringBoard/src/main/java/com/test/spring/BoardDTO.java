package com.test.spring;

import lombok.Data;

@Data
public class BoardDTO {
	
	private String seq;
	private String subject;
	private String content;
	private String filename;
	private String regdate;
	private String cseq;
	private String cname;	//카테고리명
	private String ctype;	//카테고리타입

}
