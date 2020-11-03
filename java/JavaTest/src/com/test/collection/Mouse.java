package com.test.collection;

public class Mouse {
	
	public String name;
	public int button;
	
	public Mouse(String name, int button) {
		this.name = name;
		this.button = button;
	}

	@Override
	public String toString() {
		return String.format("%s(%d)", this.name, this.button);
	}
	
	@Override
	public int hashCode() {
		
		return (this.name + this.button).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		//Object가 매개변수로 넘어오기 때문에 Mouse로 다운캐스팅
//		Mouse m = (Mouse)obj;
		
//		return this.name.equals(m.name) && this.button == m.button;
		return this.hashCode() == obj.hashCode();
	}

}
