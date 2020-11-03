package com.test.collection;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack {
	
	private String[] list;
	private int index;
	
	public void push(String value) {
//	값을 순차적으로 추가한다.
//	value : 추가할 요소의 값
		
		checkLength();
		this.list[this.index] = value;
		this.index++;		
		
	}
	
	private void checkLength() {
		if (this.index >= this.list.length) {
			String[] temp = new String[this.list.length * 2];
			for (int i=0; i<this.index; i++ ) {
				temp[i] = this.list[i];				
			}
			this.list = temp;
		}
	}
	public String pop() {
//	값을 순차적으로 가져온다.
//	return : 가져올 요소의 값
		this.index--;
		if (index < 0) {
			
			throw new EmptyStackException();
		}
		return this.list[this.index];
	}
	
	public int size() {
//	요소의 개수를 반환한다.
//	return : 요소의 개수
		return this.index;
	}
	
	public String peek() {
//	이번에 가져올 값을 확인한다.
//	value : 값 반환
		if (this.index > 0) {
 		return this.list[this.index-1];
		} else {
			throw new EmptyStackException();
		}
		
	}
	
	public void clear() {
//	배열의 모든 요소를 삭제한다.
		this.index =0;
	}
	
	public void trimToSize() {
//	배열안의 요소의 개수만큼 배열의 길이를 줄인다.

		String[] temp = new String[this.index];
		for (int i=0; i<this.index; i++) {
			temp[i] = this.list[i];
		}
		this.list = temp;
		
	}
	
	public MyStack(int capacity) {
		this.list = new String[capacity];
		index = 0;
	}
	public MyStack() {
		this(10);
	}

	@Override
	public String toString() {
		return "MyStack [list=" + Arrays.toString(list) + ", index=" + index + "]";
	}
	

}
