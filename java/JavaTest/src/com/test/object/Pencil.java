package com.test.object;

public class Pencil {
	
//	상태
//	hardness
//	흑연 등급(4B, 3B, 2B, B, HB, H, 2H, 3H, 4H)
//	행동
//	String info()
//	연필의 정보를 반환한다.
	
	private String hardness;

	public String getHardness() {
		return hardness;
	}

	public void setHardness(String hardness) {
		this.hardness = hardness;
	}
	
	public String info() {
		return String.format("%s 연필입니다.", this.hardness);
	}

}
