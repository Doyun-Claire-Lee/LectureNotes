package com.test.object;

public class Ruler {

//	상태
//	length
//	자 길이(30cm, 50cm, 100cm)
//	shape
//	자 형태(줄자, 운형자, 삼각자)
	
	
	private int length;
	private String shape;
	
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	
	public String info() {
		return String.format("%dcm %s입니다.", this.length, this.shape);
	}
	
	

}
