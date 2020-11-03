package com.test.collection;

import java.util.ArrayList;
import java.util.HashMap;

public class Ex40_HashMap_use {
	
	public static void main(String[] args) {
		
//		m1();	//객체 Value
		m2();
		
	}

	private static void m2() {
		
		//데이터 집합이 필요한 업무일 때
		//성적처리 -> 학생 1명의 성적을 관리할 집합이 필요
		//자료 구조 선택?
		//1. 배열
		//3. ArrayList
		//2. 클래스
		//4. HashMap
		
		//2. 클래스 방식 - 집합O, 가독성O
		Score s1 = new Score();
		s1.kor = 100;
		s1.eng = 90;
		s1.math = 80;
		
		//4. HashMap 방식 - 집합O, 가독성O
		HashMap<String, Integer> s2 = new HashMap<String, Integer>();
		s2.put("kor", 100);
		s2.put("eng", 90);
		s2.put("math", 80);
		
		//class vs HashMap : 재사용의 가능성을 보고 판단?
		// - 만약 학생 100명을 넣어야 한다면 무조건 class! (HashMap의 Key는 사용자가 직접 입력하기 때문에 오타의 가능성이 있음.
		// - HashMap은 class 선언을 하지 않아도 되기 때문에 적은 수의 자료를 관리할때 유리하며 비용이 적음.
		
		
		
	}

	private static void m1() {
		
		//Value - 주로 숫자, 문자열, 객체
		HashMap<String, Cup> map = new HashMap<String, Cup>();
		
		//case 1.
		map.put("내컵", new Cup());
		map.get("내컵").setName("머그컵");
		map.get("내컵").setSize(500);
		
		//case 2.
		map.put("니컵", new Cup("유리컵", 1000));
			
		//case 3. 
		Cup cup = new Cup();
		cup.setName("종이컵");
		cup.setSize(200);
		
		map.put("남의컵", cup);
		
		
		System.out.println(map);
		System.out.println();
		
		
//-------------------------------------------------------------------------------------------------
		
		//필통: 연필2, 지우개1, 볼펜1
		//필통 역할을 할 집합 선택 - 배열(개수 고정) vs [ArrayList vs HashMap](개수 가변)
		
		HashMap<String, PencilItem> pencilCase = new HashMap<String, PencilItem>();	
		pencilCase.put("색연필", new Pencil());
		pencilCase.put("연필", new Pencil());
		pencilCase.put("지우개", new Eraser());
		pencilCase.put("볼펜", new BallPen());
		
		HashMap<String, PencilItem> pencilCase2 = new HashMap<String, PencilItem>();
		pencilCase2.put("연필", new Pencil());
		pencilCase2.put("지우개", new Eraser());
		
		HashMap<String, PencilItem> pencilCase3 = new HashMap<String, PencilItem>();
		pencilCase3.put("볼펜", new BallPen());
		pencilCase3.put("볼펜", new BallPen());
	
		
		HashMap<String, HashMap<String, PencilItem>> myPencilCase = new HashMap<String, HashMap<String,PencilItem>>();
		myPencilCase.put("자주쓰는필통", pencilCase);
		myPencilCase.put("시험전용필통", pencilCase2);
		myPencilCase.put("잘안쓰는필통", pencilCase3);

		myPencilCase.get("시험전용필통").get("연필"); 	//두번째 필통의 연필을 꺼내고 싶을 때
		
		
		
		HashMap<String, ArrayList<Integer>> list = new HashMap<String, ArrayList<Integer>>();

		ArrayList<Integer> nums1 = new ArrayList<Integer>();
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		
		nums1.add(1);nums1.add(3);nums1.add(5);nums1.add(7);nums1.add(9);
		nums2.add(2);nums2.add(4);nums2.add(6);nums2.add(8);nums2.add(10);
		
		list.put("홀수", nums1);
		list.put("짝수", nums2);
		
		
		
		ArrayList<HashMap<String, Boolean>> list2;
		
	
	
	
	}

}
class PencilItem {
}
class Pencil extends PencilItem {
}
class Eraser extends PencilItem {
}
class BallPen extends PencilItem {
}

class Cup {
	private String name;
	private int size;
	
	public Cup() {
		this.name = "";
		this.size = 0;
	}
	public Cup(String name, int size) {
		this.name = name;
		this.size = size;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Cup [name=" + name + ", size=" + size + "]";
	}
	
}

class Score {
	public int kor;
	public int eng;
	public int math;
}