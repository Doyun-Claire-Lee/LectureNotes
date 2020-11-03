package com.test.object;

public class Refrigerator {
	
//	Item을 냉장고에 넣는다. void add(Item item);
//	Item을 냉장고에서 꺼낸다. Item get(String name);
//	냉장고에 있는 Item의 개수를 확인한다. int count();
//	냉장고에 있는 Item을 확인한다. void listItem();
	
	private Item[] item;
	private int count;
		
	public void add(Item item) {
		
		System.out.printf("'%s'를 냉장고에 넣었습니다.\n", item.getName());
		
		for (int i=0; i<this.item.length; i++) {
			if (this.item[i] == null) {
				this.item[i] = item;
				break;
			}//if
		}//for
	}//add
	
	
	public Item get(String name) {
		for(int i=0; i<this.item.length; i++) {
			if (this.item[i].getName().equals(name)) {
				
				Item temp =  this.item[i];
				
				for (int j=i; j<this.item.length-1; j++) {
					item[j] = item[j+1];
				}
				item[item.length] = null;
				return temp;
			} 
		}
		return null;
	}
	
	
	public int count() {
		
		this.count = 0;
		
		for (int i=0; i<item.length; i++) {
			if (item[i] != null) {
				this.count++;
			} else {
				break;
			}
		}
		return this.count;
	}
	
	
	public void listItem() {
		System.out.println("[냉장고 아이템 목록]");
		for (int i=0; i<item.length; i++) {
			if (item[i] != null) {
				System.out.printf("%s(%tF)\n", item[i].getName(), item[i].getExpiration());
			} else {
				break;
			} 
		}
		
	}
	
	
	public Refrigerator() {
		item = new Item[100];
	}
	
}
