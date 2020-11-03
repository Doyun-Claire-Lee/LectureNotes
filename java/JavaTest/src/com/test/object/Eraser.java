package com.test.object;

public class Eraser {
	
//	상태
//	size
//	지우개 크기(Large, Medium, Small)
//	행동
//	String info()
//	지우개의 정보를 반환한다.
	
	private String size;

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public String info() {
		return String.format("%s 사이즈 지우개입니다.", this.size);
	}
	

}
