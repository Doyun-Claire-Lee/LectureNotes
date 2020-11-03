package com.test.object;

public class Ex37_Object_basic {
	
	public static void main(String[] args) {
		
		//this vs super 연산자
		
		ObjectParent p = new ObjectParent();
		System.out.println(p.a);
//		System.out.println(p.b); -> private 멤버라 접근 불가
		
		ObjectChild c = new ObjectChild();
		System.out.println(c.a);
//		System.out.println(c.b);
		
		System.out.println();
		
		c.test();
		
	}

}


class ObjectParent {
	
	public int a = 10;
	private int b = 20;	//자식에게도 비공개
	
	public void check() {
		System.out.println("부모");
	}
	
}

class ObjectChild extends ObjectParent {
	
	public int a = 40;	//변수도 재정의가 됨. 그러나 사용하지 않음.
	private int c = 30;
	
	public void test() {
		System.out.println(this.a);	
		System.out.println(super.a);//부모 객체의 a, 거의 쓰지 않음.
//		System.out.println(this.b); //The field ObjectParent.b is not visible 
									//물려받은 부모의 private 객체는 자식 객체에서 this.로 사용할 수 없다. getter나 setter로 접근해야 함.
		System.out.println(this.c);
		
		check(); 		//this.check
		super.check();
	}
	
	public void check() {
		System.out.println("자식");
	}
	
	
}
