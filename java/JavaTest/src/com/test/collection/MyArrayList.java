package com.test.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList {	
	
	private String[] list;
	private int index; //마지막 방번호 관리 변수
	

//	생성자 오버로딩
//	new MyArrayList()
//	내부 배열의 크기를 10으로 한다.
//	new MyArrayList(int capacity)
//	내부 배열의 크기를 capacity로 한다.	
	public MyArrayList() {
		this(10);
	}
	public MyArrayList(int capacity) {
		this.list = new String[capacity];
		this.index = 0;
	}
	
	public void add(String word) {
//	void add(String s)
//	Append 모드로 배열의 맨 끝에 요소를 추가한다.
//	s : 추가할 요소
		
		if (this.index >= this.list.length) { //배열이 꽉 차면 2배로 
			
			String[] temp = new String[this.list.length * 2];
			for (int i=0; i<this.list.length; i++) {
				temp[i] = this.list[i];
			}
			this.list = temp;
		}
		
		this.list[this.index] = word;
		this.index++;
	}
	
	public void add(int index, String value) {
//		void add(int index, String value)
//		Insert 모드로 원하는 위치에 요소를 삽입한다.
//		index : 수정할 요소의 위치
//		value : 수정할 요소의 값
		if (index >= 0 && index < this.index) {
	
			if (this.index >= this.list.length) { //배열이 꽉 차면 2배로 
				
				String[] temp = new String[this.list.length * 2];
				for (int i=0; i<this.list.length; i++) {
					temp[i] = this.list[i];
				}
				this.list = temp;
			}
			
			for(int i=this.index; i>index; i--) {
				this.list[i] = this.list[i-1];
			}
			
			this.list[index] = value;
			this.index++;		
			
		} else {
			throw new IndexOutOfBoundsException(); //강제로 에러메세지 발생하게 하는 구문
		}
	}
	
	public String get(int index) {
//	String get(int index)
//	원하는 위치에 있는 요소를 가져온다.
//	index : 가져올 요소의 위치
//	return : 가져올 요소의 값
		
		if (index >= 0 && index < this.index) {
		return this.list[index];
		} else {
			throw new IndexOutOfBoundsException(); //강제로 에러메세지 발생하게 하는 구문
		}
	}
	
	
	public int size() {
//	int size()
//	요소의 개수를 반환한다.
//	return : 요소의 개수
		return this.index;
	}
	
	public void set(int index, String value) {
//		void set(int index, String value)
//		원하는 위치의 요소를 다른 값으로 수정한다.
//		index : 수정할 요소의 위치
//		value : 수정할 요소의 값
		
		if (index >= 0 && index < this.index) {
			this.list[index] = value;			
			} else {
				throw new IndexOutOfBoundsException(); //강제로 에러메세지 발생하게 하는 구문
			}
	}
	

	public void remove(int index) {
//	void remove(int index)
//	원하는 위치의 요소를 삭제한다.
//	index : 삭제할 요소의 위치
		
		if (index >= 0 && index < this.index) {
			
			for (int i=index; i<this.index-1; i++) {
				this.list[i] = this.list[i+1];
			}
//			this.list[this.index] = null;  굳이 안지워도 됨, 나중에 덮어쓰이기 때문
			this.index--;	
			
			} else {
				throw new IndexOutOfBoundsException(); //강제로 에러메세지 발생하게 하는 구문
			}
	}
		
	
	public int indexOf(String value) {
//	int indexOf(String value)
//	원하는 요소가 몇번째 위치에 있는지 위치값을 반환한다.
//	value : 검색할 요소의 값
//	return : 검색된 요소의 위치
		int temp = -1;
		
		for (int i=0; i<this.index; i++) {
			if (this.list[i].equals(value)) {
				temp =  i;
				break;
			} else {
				temp =  -1;
			}
		}
		return temp;
	}
	
	
	public int lastIndexOf(String value) {
//	int lastIndexOf(String value)
//	원하는 요소가 몇번째 위치에 있는지 위치값을 반환한다.
//	value : 검색할 요소의 값
//	return : 검색된 요소의 위치
		
		int temp = -1;
		
		for (int i=this.index; i>=0; i--) {
			if (this.list[i].equals(value)) {
				temp =  i;
				break;
			} else {
				temp =  -1;
			}
		}
		return temp;
	}
	
	
	public void clear() {
//	void clear()
//	배열의 모든 요소를 삭제한다.
		
//		this.list = new String[10];  데이터를 지우지 않아도 나중에 덮어쓰이기 때문에 굳이 하지 않아도 됨.
		this.index = 0;
	}

	public boolean contains(String value) {
//	boolean contains(String value)
//	배열에 요소가 있는지 유무를 반환한다.
//	value : 검색할 요소의 값
//	return : 검색된 요소의 유무
		boolean flag = false;
		
		for (int i=0; i<this.index; i++) {
			if (this.list[i].equals(value)) {
				flag =  true;
				break;
			} else {
				flag = false;
			}
		}
		return flag;
	}
		
	
	public void trimToSize() {
//	void trimToSize()
//	내부 배열의 크기를 데이터의 개수와 일치하게 재조정한다.
		String[] temp = new String[this.index];
		for (int i=0; i<this.index; i++) {
			temp[i] = this.list[i];
		}
		this.list = temp;
	}
	
	public boolean isEmpty() {
//	boolean isEmpty()
//	배열이 비어있는지 boolean값을 반환한다.
//	return : 배열 비어있는 유무
		
		return this.index == 0 ? true : false;
	
	}
	
	public ArrayList<String> subList(int fromIndex, int toIndex) {
//	ArrayList<String> subList(int fromIndex, int toIndex)
//	배열의 일부분을 배열로 반환한다.
//	fromIndex : 추출할 부분의 시작 위치
//	toIndex : 추출할 부분의 끝 위치
//	return : 추출할 부분 배열
		
		ArrayList<String> arrayList = new ArrayList<String>();
		for (int i=fromIndex; i<toIndex; i++) {
			arrayList.add(this.list[i]);
		}
		return arrayList;
	}
	
	@Override
	public String toString() {
		return String.format("length: %d\nindex: %d\n%s\n", this.list.length, this.index, Arrays.toString(this.list));
	}
	
}
	

