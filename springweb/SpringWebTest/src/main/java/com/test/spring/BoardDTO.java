package com.test.spring;

public class BoardDTO {

	//중요!! 
	//요청 메소드에 BoardDTO를 매개변수로 넘길 때 넘길 데이터의 name 속성값과 변수의 이름이 같아야 한다.
	//<input type="text" name="subject"> -> private String subject
	private String subject;
	private String content;
	private String name;
	
	
	@Override
	public String toString() {
		return "BoardDTO [subject=" + subject + ", content=" + content + ", name=" + name + "]";
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
