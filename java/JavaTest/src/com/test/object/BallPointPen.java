package com.test.object;

public class BallPointPen {
	
//	상태
//	thickness
//	볼펜 심 두께(0.3mm, 0.5mm, 0.7mm, 1mm, 1.5mm)
//	color
//	볼펜 색상(red, blue, green, black)
	
	private double thickness;
	private String color;
	
	public double getThickness() {
		return thickness;
	}
	public void setThickness(double thickness) {
		this.thickness = thickness;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String info() {
		return String.format("%s 색상 %.1fmm 볼펜입니다.", color, thickness);
		
	}
	
	

}
