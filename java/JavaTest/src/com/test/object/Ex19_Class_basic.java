package com.test.object;

import java.util.Arrays;

public class Ex19_Class_basic {
	
	public static void main(String[] args) {
		
		//클래스의 배열멤버
		//PencilCase Class
		
		//Case A-a.
		PencilCase c1 = new PencilCase();
		
		String[] items = new String[10];
		items[0] = "볼펜";
		items[1] = "연필";
		items[2] = "만년필";
	
		c1.setItems(items);
		System.out.println(Arrays.toString(c1.getItems()));
		
		
		//Case A-b.
		PencilCase c2 = new PencilCase();		
		
		c2.getItems()[0] = "볼펜";		//참조형이기 때문에 가능한 일
		c2.getItems()[1] = "연필";
		c2.getItems()[2] = "만년필";
		System.out.println(Arrays.toString(c2.getItems()));
		
		
		//Case b.
		PencilCase c3 = new PencilCase();
		
		c3.setPencil("볼펜");
		c3.setPencil("연필");
		c3.setPencil("만년필");
		
		System.out.println(c3.getPencil(1));
		
		
		
		
		
	}

}
