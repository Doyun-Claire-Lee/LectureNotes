package com.test.inheritance;

public class Ex30_Type_basic {
	
	public static void main(String[] args) {
		
		//일반클래스 vs 추상클래스 vs 인터페이스
		
		//1. 객체 생성 가능 유무 : 일반 클래스만 만들 수 있다.
		//2. 서로간의 상속 관계
		
		//1. 
		M706 m = new M706(); //일반 클래스
//		AMouse m2 = new AMouse(); // 추상클래스 - 인스턴스로 만들어지지 않음. Cannot instantiate the type AMouse
//		IMouse m3 = new IMouse(); // 인터페이스 - 인스턴스로 만들어지지 않음.
		//		=> 구현부가 없는 메소드가 있기 때문.. (객체의 사용이 불안정해짐.)
		
		//2. 	
		//a. 일반클래스(자식) -> 일반클래스(부모) 		//O
		//b. 일반클래스(자식) -> 추상클래스(부모)		//O, 자식클래스에서 추상메소드 구현, 구현멤버는 그대로 물려줌
		//c. 일반클래스(자식) -> 인터페이스(부모)		//O
		//d. 추상클래스(자식) -> 일반클래스(부모)		//O, but 쓰지말기.. 굉장히 헷갈리게 됨
		//e. 인터페이스(자식) -> 일반클래스(부모)		//X, 구현 멤버를 상속하기 때문
		//f. 추상클래스(자식) -> 추상클래스(부모)		//O
		//g. 인터페이스(자식) -> 인터페이스(부모)		//O, ***잘 쓰이는 형태 ***
		//h. 일반클래스 x n -> (추상클래스) -> 인터페이스
	}

}

//d.

class AAAA {
	public int a;
}
abstract class BBBB extends AAAA {
	
}


//e.

//interface CCCC extends AAAA { //The type AAAA cannot be a superinterface of CCCC; a superinterface must be an interface
//	//public int a 와 같은 상황이 되어버림. 불가능
//}


//f.

abstract class DDDD {
	public int a;
	public abstract void aaa(); 
}
abstract class EEEE extends DDDD {
	//부모의 추상메소드를 구현할지 말지 선택
	//구현x -> EEEE의 자식메소드가 구현하게 됨.
	//구현o -> 자식메소드에 구현메소드를 상속
}

//g. 

interface GGGG {
	void aaa();
	void bbb();
}

interface HHHH extends GGGG {	//**extends**
	//부모인터페이스의 추상메소드를 구현할 수 없음. 인터페이스는 구현부를 가질 수 없기 때문에...
	void ccc(); // 인터페이스를 늘리는 역할
}




//h.

//직원
//1. 정규직
//	a. 간부
//	b. 사원
//2. 계약직
//	a. 사원

//설계
interface 직원 {
	void 출근();
	void 퇴근();
}
interface 정규직 extends 직원 {
	void 보너스지급();
	void 연차지급();	
}
interface 계약직 extends 직원 {
	void 근무조정가능();
}
class 정규직간부 implements 정규직 {
	
	@Override
	public void 출근() {
	}
	
	@Override
	public void 퇴근() {
	}
	
	@Override
	public void 보너스지급() {
	}
	
	@Override
	public void 연차지급() {
	}
}
class 계약직사원 implements 계약직 {

	@Override
	public void 출근() {
	}

	@Override
	public void 퇴근() {
	}

	@Override
	public void 근무조정가능() {
	}
	
}



//다중 상속
// - 2개의 부모를 가지는 상속(자바는 불가능)
// - 인터페이스에 한해서 다중 상속이 가능하다.(인터페이스 부모 여러개)

interface AAAAA {
	void aaa();
}
interface BBBBB {
	void bbb();
}
class CCCCC implements AAAAA, BBBBB {

	@Override
	public void bbb() {
	}

	@Override
	public void aaa() {
	} // => 가능
	
}


interface 아빠 {
	void 책임진다();
	void 돈을번다();
}

interface 과장 {//직장에서의 아빠
	void 프로젝트를책임진다();
	void 보고서를작성한다();
}

interface 남자 {
	void 군대를간다();
}

class 홍길동 implements 아빠, 과장, 남자 {

	@Override
	public void 군대를간다() {
	}

	@Override
	public void 프로젝트를책임진다() {
	}

	@Override
	public void 보고서를작성한다() {
	}

	@Override
	public void 책임진다() {
	}

	@Override
	public void 돈을번다() {
	}
	
}

class 호호호 implements 과장 {

	@Override
	public void 프로젝트를책임진다() {
	}

	@Override
	public void 보고서를작성한다() {
	}
	
}

class 아무개 implements 과장, 남자 {

	@Override
	public void 군대를간다() {
	}

	@Override
	public void 프로젝트를책임진다() {
	}

	@Override
	public void 보고서를작성한다() {
	}
	
}