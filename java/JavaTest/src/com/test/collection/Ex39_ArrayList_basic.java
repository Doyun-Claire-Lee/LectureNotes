package com.test.collection;

import java.util.ArrayList;

public class Ex39_ArrayList_basic {
	
	public static void main(String[] args) {
		
		/*
		
		컬렉션, collection
		- 배열을 wrapping시켜 기능을 추가하거나 용도를 지정한 것
		- 길이 가변(늘어나거나 줄어드는게 가능/ 기존 배열과는 다른 점)
		- 배열을 사용 목적에 따른 사용법이나 구조를 특화시켜 놓음 -> "자료구조"
		- 이 컬렉션은 예전 버전(Object 배열), 현재는 *제네릭 컬렉션* 이용
		
		
		ArrayList 클래스
		- 순수 배열과 가장 비슷함
		- 사용 빈도가 가장 높음
		- 첨자(index)를 사용해서 요소(element)에 접근 + 제어
		- ArrayList(C) -> List(I) -> Collection(I) // 상속관계 
				
		
		*/
		
//		m1();
//		m2();
		m3();
	
		
	}

	private static void m3() {
	
		//ArrayList 사용법
		
		ArrayList<String> list = new ArrayList<String>();
		
		//1. 요소 추가하기
		// - void add(T value)
		// - 배열의 맨 마지막에 추가(Append)
		
		list.add("빨강");
		list.add("노랑");	//list.remove(1), list.remove("노랑")
		list.add("파랑");
		list.add("주황");
		list.add("노랑");	//list.remove(4), list.remove("노랑")
		list.add("보라");
		
		
		//2. 요소 개수 확인
		// - int size()
		
		System.out.println(list.size());
		
		
		//3. 요소 접근하기
		// - T get(int index)
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		System.out.println(list.get(list.size() - 1));
		
		System.out.println();
		
		
		//4. 요소 수정하기
		// - list[0] = 10; -> 대입 + 수정
		// - void set(int index, T value)
		
		System.out.println(list.get(2));
		list.set(2, "초록");
		System.out.println(list.get(2));

		
		//5. 요소 삭제하기
		// - 순수 배열은 요소 삭제 불가능(방의 길이를 줄일 수 없음)
		// - 컬렉션은 요소 삭제가 가능(방의 길이를 줄일 수 있음)
		// - T remove(int index) -> 지워지는 값을 리해주고 삭제함. 				//더 많이 쓰는 방법
		// - boolean remove(T value) -> 지웠는지 못지웠는지 boolean 값을 리턴	//동일한 값이 중복될 경우 사용이 애매함.. 먼저 있는 값을 지워줌.
		
		System.out.println(list.size());
		String old = list.remove(2);
		System.out.println(old);
		list.remove("노랑");
		System.out.println(list.size());
		
		System.out.println();
		
		//6. 탐색
		// - 루프 탐색
		
		for (int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println();
		
		for (String color : list) {
			System.out.println(color);
		}
		System.out.println();
		
		//7. 요소 추가하기
		// - 배열의 원하는 위치에 추가하기
		// - Insert(삽입)
		// - void add(int index, T value)
		
		list.add(1, "검정");
		
		for (String color : list) {
			System.out.println(color);
		}
		
		System.out.println();
		
		//8. 요소 검색하기
		// - boolean contains(T value)
		// - int indexOf(T value)
		
		if (list.contains("빨강")) {
			System.out.println("빨강 있음");
		} else {
			System.out.println("빨강 없음");
		}
		
		System.out.println(list.indexOf("주황"));
		System.out.println(list.indexOf("남색")); //없는 요소 검색 시 -> -1 반환
		
		System.out.println();
		
		
		//9. 초기화
		// - 모든 방의 요소 삭제하기
		// - void clear()
		
		list.clear(); //주로 사용
//		list = new ArrayList<String>(); //새것으로 덮어쓰기 
		System.out.println(list.size());
		
		
		//10. 배열이 비어있는지 확인
		System.out.println(list.size() == 0);
		System.out.println(list.isEmpty());
	
	
	}

	private static void m2() {
		
		//오리지널 컬렉션 
		
		ArrayList list1 = new ArrayList(); //Object[]
		
		list1.add(100);
//		list1.add("홍"); //추가 요소의 자료형 주의!
		System.out.println((int)list1.get(0) + 100); //요소의 사용시 형변환 주의!
		
		
		
		//제네릭 버전
		
		ArrayList<Integer> list2 = new ArrayList<Integer>(); //int[]
		
		list2.add(100);
//		list2.add("홍");
		System.out.println(list2.get(0) + 100);
		
		
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("홍");
		System.out.println(list3.get(0) + "길동");
		
	}

	private static void m1() {
		
		//순수 배열과 ArrayList 비교
		
		//순수 배열
		// - 선언 : 타입 명시 + 길이 명시
		int[] nums1 = new int[3];
		
		//초기화 + 요소 제어 -> 첨자(index) 사용
		nums1[0] = 100;
		nums1[1] = 200;
		nums1[2] = 300;
		
		System.out.println(nums1[0]);
		//대괄호를 붙여 표시하는 방법 - 인덱서(Indexer), 자바에서는 배열에서만 인덱서를 사용 할 수 있음.
		
		//ArratList 컬렉션
		// - 선언 : 타입 명시(X) + 길이 명시(X)
		ArrayList nums2 = new ArrayList();	//ArrayList is a raw type. References to generic type ArrayList<E> should be parameterized
											//raw type 에러 : 예전(오래된)타입이니 사용하지 말라는 메세지.. 자바 업그레이드 되면서 사라질 수 있음.
		
		//초기화 + 요소 제어
		nums2.add(100);	//append - 배열의 (데이터가 들어있는 방 다음방에) 마지막 방에 추가
		nums2.add(200);	//오브젝트 배열 - 박싱 발생
		nums2.add(300);
		
		//***절대 금지! 
		//Object 저장 공간은 처음 데이터를 넣을 때는 자유이지만 이후부터는 절대적으로 처음과 같은 자료형만 넣을 것!
//		nums2.add("홍길동");
//		nums2.add("아무개");
//		nums2.add(true);
//		nums2.add(false);
		
		
		System.out.println(nums2.get(0)); //꺼낼 때 - get()사용, 방번호 이용
//		System.out.println(nums2.get(0) + 100); //타입이 오브젝트이기 때문에 연산이 안됨. -> 다운캐스팅 필요
		System.out.println((int)nums2.get(0) + 100); 

//		System.out.println(nums2.get(5)); //index에러남. 없는 방을 호출했기 때문에
		//java.lang.StringIndexOutOfBoundsException : 문자열 첨자
		//java.lang.ArrayIndexOutOfBoundsException : 배열 첨자
		//java.lang.IndexOutOfBoundsException : 컬렉션 첨자
		
		
		System.out.println(nums2.size()); //배열의 length와 비슷한 역할
		
		// - void add(Object value)
		// - Object get(int index)
		// - int size()
		
	}//m1

}
