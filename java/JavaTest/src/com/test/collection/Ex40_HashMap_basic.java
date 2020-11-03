package com.test.collection;

import java.util.HashMap;
import java.util.Set;

public class Ex40_HashMap_basic {
	
	public static void main(String[] args) {
		
		//HashMap 컬렉션
		
		//ArrayList vs HashMap	★★★★★★★★면접질문★★★★★★★★
		
		//1. ArrayList(혹은 순수 배열)
		// - 스칼라 배열(Scalar Array)
		// - 방번호 존재 -> 요소의 순서가 존재
		// - 요소 접근 -> 첨자(Index)사용
		// - 일괄 접근 가능 -> 루프 탐색 가능
		// - 요소의 구분이 쉽지 않다.(방번호가 의미가 없다.)
		
		//2. HashMap
		// - 사전 구조(Dictionary), 맵(Map), 연관 배열
		// - 첨자(Index)가 존재하지 않음 -> 요소의 순서가 없음
		// - 요소 접근 -> 키(key) 사용
		// - 일괄 접근 불가 -> 루프 탐색 불가능
		// - 요소의 구분이 쉽다.(방에 이름이 있어서 직관적)
		// - key는 유일해야 한다.
		// - value는 중복 가능
		
		
//		m1();
		m2();
						
		
	}

	private static void m2() {

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		//1. 요소 추가하기
		// - V put(T value, V value)
		map.put("국어", 100);
		map.put("영어", 90);
		map.put("수학", 80);
		
		//2. 요소 개수 확인
		System.out.println(map.size());
		
		//3. 요소 접근
		System.out.println(map.get("국어"));
		System.out.println(map.get("영어"));
		System.out.println(map.get("수학"));
		System.out.println(map.get("과학")); //없는 key값을 요구하면 null값을 반환해줌
		
		//4. 요소 수정하기
		int result = map.put("국어", 98);	//덮어쓰기가 됨.
		System.out.println(map.get("국어"));
		System.out.println(result);			//.put() -> old value를 반환함.
		
		//5. 검색하기
		// - key 검색과 value검색이 따로 있음.
		System.out.println(map.containsKey("국어"));
		System.out.println(map.containsKey("체육"));
		System.out.println(map.containsValue(100));
		System.out.println(map.containsValue(98));
		
		//6. 요소 삭제하기
		map.remove("국어");
		System.out.println(map.size());
		System.out.println(map);
		
		//7. 요소 초기화
//		map.clear();
		System.out.println(map);
		System.out.println(map.isEmpty());
		System.out.println();
		
		//8. keySet()
		// - key + set(배열)
		// - key만 뽑아서 배열(set)을 만들어서 반환해줌.
		// - 루프를 돌릴 수 있음..그러나 잘 쓰지 않음.
		Set<String> set = map.keySet();
		for (String item : set) {
			System.out.println(item + ", " + map.get(item));
		}
		
		
	
	}

	private static void m1() {
		
//		HashMap map = new HashMap();	//오브젝트 타입
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		//요소 추가 -> .put()
		map.put("국어", 100);
		map.put("영어", 90);
		map.put("수학", 80);
		
		//요소 접근 -> .get()
		System.out.println(map.get("국어"));
		System.out.println(map.get("영어"));
		System.out.println(map.get("수학"));
		
		//요소 개수 -> .size()
		System.out.println(map.size());
		
		System.out.println();
		
		
		
		HashMap<String, String> classroom = new HashMap<String, String>();
		
		classroom.put("반장", "홍길동");
		classroom.put("부반장", "아무개");
		classroom.put("총무", "하하하");
		
		System.out.println(classroom); // toString 
		
		
		
		HashMap<Integer, String> map2 = new HashMap<Integer, String>(); //key를 int로 쓰는 경우는 많지 않음
		
		map2.put(10, "열");
		map2.put(20, "스물");
		map2.put(30, "서른");
		
		System.out.println(map2);

		
		
		HashMap<Boolean, String> map3 = new HashMap<Boolean, String>(); //데이터를 2개밖에 못넣어 의미가 없음.
		
		map3.put(true, "참");
		map3.put(false, "거짓");
		
		System.out.println(map3);
		
		
		//HashMap의 key는 보통 String만 씀, value는 다양한 타입이 쓰임.
		
		
		
		
	}

}
