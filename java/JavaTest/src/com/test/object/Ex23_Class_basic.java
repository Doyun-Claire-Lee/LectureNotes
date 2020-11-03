package com.test.object;

public class Ex23_Class_basic {

	public static void main(String[] args) {
		
		//객체 멤버 vs 정적 멤버
		
		//생산된 키보드 개수 세기
		//키보드 각자가 아닌 전체의 갯수 - 공용 데이터의 성질을 갖고 있다. 
		
		//1.
		m1();
		
		//2. 
		m2();
		
		//3.
		m3();
		
	}

	private static void m3() {
		
		// static변수로 tcount 생성
		Keyboard k1 = new Keyboard();
		Keyboard.setTcount(Keyboard.getTcount()+1);
		Keyboard k2 = new Keyboard();
		Keyboard.setTcount(Keyboard.getTcount()+1);
		Keyboard k3 = new Keyboard();
		Keyboard.setTcount(Keyboard.getTcount()+1);

		System.out.println(Keyboard.getTcount());
	
	}

	private static void m2() {
		
		//클래스 내에 count 멤버 변수 생성..
		
		Keyboard k1 = new Keyboard();
		k1.setCount(k1.getCount()+1); //count = count + 1
		Keyboard k2 = new Keyboard();
		k2.setCount(k2.getCount()+1); 
		Keyboard k3 = new Keyboard();
		k3.setCount(k3.getCount()+1); 
		
		//각자 가지고 있는 변수(count =0)에 누적을 시켰기 때문에 모두 1이 나옴.
		System.out.println(k1.getCount());
		System.out.println(k2.getCount());
		System.out.println(k3.getCount());
	}

	private static void m1() {
		
		
		
		int count = 0; //누적 변수
		
		Keyboard k1 = new Keyboard();
		count++;
		Keyboard k2 = new Keyboard();
		count++;
		Keyboard k3 = new Keyboard();
		count++;
		
		System.out.println("키보드 개수 : " + count);
		
		//문제점..
		//1. 마우스 생산 행동과 카운트하는 행동의 결합이 느슨함..
		//2. 변수의 성질이 문법적인 수준에서 보장받지 못함. (count가 keyboard의 개수인지 보장X)
		
	}

}

class Keyboard {
	
	private String model;
	private int price;
	private int count; 			//객체 데이터
	private static int tcount;	//공용 데이터
	
	public static int getTcount() {
		return tcount;
	}
	public static void setTcount(int tcount) {
		Keyboard.tcount = tcount;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}