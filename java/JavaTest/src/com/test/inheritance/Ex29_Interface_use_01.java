package com.test.inheritance;

public class Ex29_Interface_use_01 {
	
	public static void main(String[] args) {
		
		//상황) 홍길동(직원)의 업무 중 일자 드라이버 사용 업무 -> 십자로 드라이버 교환
		//main() : 직장상사
		
		Employee hong = new Employee();
		hong.name = "홍길동";
		hong.work();
		
		
		
		
	}//main
}//Ex29

class Employee {

	public String name;
	public void work() {
		
		//일자 드라이버 -> 나사조이기
//		Tool tool = new Tool();
//		tool.use();
		
		//십자드라이버
//		ScrewTool tool = new ScrewTool();
//		tool.work();
		
		
		//툴 특성에 맞는 구체적인 사용
//		Tool tool = new Tool();
//		tool.work();
//		ScrewTool tool = new ScrewTool();
//		tool.work();
		
		//툴의 추상적인 사용
		ITool tool = new Tool();	//업캐스팅
		tool.work();
		
		tool = new ScrewTool(); //업캐스팅
		tool.work();
		
		
		
	}
}

//행동(메소드 이름)통일 
// - 부모가 구현된 멤버를 상속해줘야 하는가?
//1. 상속 O : 추상 클래스를 통해
//2. 상속 X : 인터페이스를 통해

//부모 인터페이스
interface ITool {
	
	void work();
	
}


//일자 드라이버
class Tool implements ITool {
	
	public String name;
	public void work() {
		System.out.println("일자 드라이버를 돌려서 나사를 박습니다.");
	}
	public void check() {
		
	}
}

//십자 드라이버 
class ScrewTool implements ITool {
	
	public String name;
	public void work() {
		System.out.println("십자 드라이버로 나사를 박습니다.");
	}
	
	public void oiling() {
		
	}
}