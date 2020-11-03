package com.test.collection;

import java.util.Arrays;

public class MyHashMap {
	
//	MyHashMap
//	HashMap 사용자 정의 클래스

	//HashMap 생성 방법
	//1. 배열2개 + index
	private String[] keyList;
	private String[] valueList;
	private int index;
	
	//2. MapItem클래스 생성
//	private MapItem[] list;
	
	public MyHashMap(int capacity) {
		this.keyList = new String[capacity];
		this.valueList = new String[capacity];
		this.index = 0;
	}
	
	public MyHashMap() {
		this(10);
	}
	

	public void put(String key, String value) {
//	키와 값을 요소로 추가한다.
//	key : 추가할 요소의 키
//	value : 추가할 요소의 값		
//	해당키의 값을 요소로 수정한다.
//	key : 수정할 요소의 키
//	value : 수정할 요소의 값
		
		if (this.keyCheck(key) >= 0) {
			this.valueList[this.keyCheck(key)] = value;
		} else {
			checkLength();
			this.keyList[this.index] = key;
			this.valueList[this.index] = value;
			this.index++;			
		}
	}
	
	private int keyCheck(String key) {
		for (int i=0; i<this.index; i++) {
			if (this.keyList[i].equals(key)) {
				return i;
			}
		}
		return -1;
	}
	
	private void checkLength() {
		
		if (this.index >= this.keyList.length) {
			String[] temp1 = new String[this.keyList.length * 2];
			String[] temp2 = new String[this.valueList.length * 2];
			
			for(int i=0; i<this.keyList.length; i++) {
				temp1[i] = this.keyList[i];
				temp2[i] = this.valueList[i];
			}
			this.keyList = temp1;
			this.valueList = temp2;
		}
	}
//	public void put(String key, String value) {
//	}
	
	
	public String get(String key) {
//	키에 대응하는 요소의 값을 가져온다.
//	key : 가져올 요소의 키
//	return : 가져올 요소의 값
		
		for (int i=0; i<this.index; i++) {
			if (this.keyList[i].equals(key)) {
				return this.valueList[i];
			}
		}
		return null;
	}
	public int size() {
//	요소의 개수를 반환한다.
//	return : 요소의 개수
		return this.index;
	}
	
	public void remove(String key) {
//	원하는 키의 요소를 삭제한다.
//	key : 삭제할 요소의 키
		for (int i=0; i<this.index; i++) {
			if (this.keyList[i].equals(key)) {
				for (int j=i; j<this.index-1; j++) {
					this.keyList[j] = this.keyList[j+1];
					this.valueList[j] = this.valueList[j+1];
				}
				this.index--;
				break;
			}
		}
	}
	
	public boolean containKey(String key) {
//	해당 키가 존재하는지 확인한다.
//	key : 확인할 키
//	return : 키의 존재 유무
		for (int i=0; i<this.index; i++) {
			if (this.keyList[i].equals(key)) {
				return true;
			}
		}
		return false;
		
	}
	public boolean containsValue(String value) {
//	해당 값이 존재하는지 확인한다.
//	value : 확인할 값
//	return : 값의 존재 유무
		for (int i=0; i<this.index; i++) {
			if (this.valueList[i].equals(value)) {
				return true;
			}
		}
		return false;
	}
	public void clear() {
//	배열의 모든 요소를 삭제한다.
		this.index = 0;
	}


	@Override
	public String toString() {
		return "keyList=" + Arrays.toString(keyList) + "\nvalueList=" + Arrays.toString(valueList)
				+ "\nindex=" + index;
	}
	
}
//class MapItem {
//	private String key;
//	private String value;
//}
