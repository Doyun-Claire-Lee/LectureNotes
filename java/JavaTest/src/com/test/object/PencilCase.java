package com.test.object;

public class PencilCase {

	private String size; //대중소
	private String color; 
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	private String[] items = new String[10];
	
	//Case A.
	//참조형인 배열을 바로 getter setter에 집어넣게 되면 안정성이 떨어진다..
	public String[] getItems() {
		return items;
	}
	public void setItems(String[] items) {
		this.items = items;
	}

	//Case B.
	public void setPencil(String item) {
		
		int i = 0;
		for (i=0; i<items.length; i++) {
			if (items[i] == null) {
				break;
			}
		}
		this.items[i] = item;
	}
	public String getPencil(int index) { //사용자가 몇번째 칸에 있는 물건을 빼낼 건지 물어봐야 함
		//한번 물건을 꺼낸 칸은 비워두고 싶을 때..
		String item = this.items[index];
		this.items[index] = null;		
		
		return item; //Return 뒤의 코드는 실행되지 않음.
	}
	
	
	
	
	
	
	
}
