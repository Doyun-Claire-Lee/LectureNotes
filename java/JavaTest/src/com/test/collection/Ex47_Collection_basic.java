package com.test.collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class Ex47_Collection_basic {

	
	public static void main(String[] args) throws Exception {
		
		// 각 컬렉션의 특징, 공통점 및 차이, 장단점 등등 알고있어야 함.*****
		/*
		
		자바 컬렉션 인터페이스
		
		1. Collection
			- List와 Set의 부모 인터페이스
		
		2. List
			- ArrayList, Stack, LinkedList(Queue), Vector 등
			- 순서가 있는 집합(*********)
			- 방번호(index, 첨자)를 사용한다.
			- 데이터 중복을 허용한다.
		
		3. Set
			- HashSet, TreeSet 등
			- 순서가 없는 집합(*****************)
			- 방번호(index, 첨자)가 없다.
			- 데이터 중복을 허용하지 않음.(***************)
		
		4. Map
			- HashMap, TreeMap, HashTable, Properties 등
			- 순서가 없는 집합(***)
			- 키와 값을 사용한다.(********) -> 연관 배열, 딕셔너리, 사전 구조
			- 키(key): 식별자 역할, 유일해야 함. -> 중복 허용 안함 -> Set사용
			- 값(value): 데이터 -> 중복 허용 -> List 사용
		
		** Vector, HashTable, Properties: 호환성 때문에 남겨진 클래스 -> 사용X
		
		Vector -> ArrayList
		HashTable -> HashMap
		Properties -> XML, JSON 기술
		
		*/
		
//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
//		m6();
//		m7();	//TreeSet
//		m8();	//TreeMap
//		m9();	//Properties
//		m10();	//Properties
		
	}

	private static void m10() throws Exception {

		//프로그램을 종료하고 다시 실행할 때 저장했던 설정을 복구하는 상황
		
		Properties prop = new Properties();
		prop.load(new FileInputStream("setting.ini"));	//설정 불러오기
		
		System.out.println(prop);	
		
	}

	private static void m9() throws Exception {
		
		//Properties
		// - 문자열 전용 배열, 제네릭 버전이 없음.
		// - 문자열 내용을 파일에 입출력하는 기능도 있음.
		// - 프로그램의 설정을 관리하고 보관하는데 쓰이던 Collection, 요즘은 잘 안씀.
		
		Properties prop = new Properties();
		
		//설정(요소) 추가 - HashMap과 비슷
		prop.setProperty("path", "C:\\Program Files\\eclipse");
		prop.setProperty("font-family", "D2Coding");
		prop.setProperty("font-size", "16px");
		
		System.out.println(prop);
		System.out.println(prop.getProperty("font-size"));
		System.out.println();
		
		//프로그램 종료시 위에서 설정했던 부분을 파일로 저장
		// - BufferedWriter로도 할 수 있음
		
		prop.store(new FileOutputStream("setting.ini"), ""); 	//프로젝트 폴더 안에 setting.ini라는 파일이 생김.
		System.out.println("종료");
		
	}

	private static void m8() {

		//TreeMap
		// - 이진트리 구조의 Map
		// - 키 + 값 = 요소
		// - 키 자동 정렬
		// - 범위 추출에 효율적
	
		TreeMap<String,String> map = new TreeMap<String, String>();
	
		map.put("white", "하양");
		map.put("black", "검정");
		map.put("red", "빨강");
		map.put("yellow", "노랑");
		map.put("blue", "파랑");
		
		System.out.println(map.size());
		System.out.println(map);
		System.out.println(map.get("black"));
		System.out.println();
		
		//부분 검색(Tree)
		System.out.println(map.firstKey());
		System.out.println(map.firstEntry());	//Entry: Map의 요소클래스
		System.out.println(map.lastKey());
		System.out.println(map.lastEntry());
		System.out.println();
		System.out.println(map.headMap("m"));		//키의 첫글자가 m으로 시작하는 단어 전까지
		System.out.println(map.tailMap("m"));		//키의 첫글자가 m으로 시작하는 단어 부터
		System.out.println(map.subMap("m", "w"));	//키의 첫글자가 m으로 시작하는 단어부터 w로 시작하는 단어 전까지
			
		
	}

	private static void m7() {
		
		//TreeSet
		// - Tree 구조의 Set
		// - 중복값X, 순서X, 정렬X
		// - 저동으로 정렬이 됨.
		// - 이진 트리 구조로 구현되어 있다.
		// - 범위 검색에 효율적이다.(******)
		
		
		Set<Integer> set = new TreeSet<Integer>();
		set.add(5);
		set.add(3);
		set.add(2);
		set.add(7);
		set.add(9);
		set.add(6);
		set.add(1);
		
		System.out.println(set);
		
		//자동 정렬이 되는 이유 -> 이진 트리 구조이기 때문에.
		
		//부분 검색
		TreeSet<Integer> tset = (TreeSet<Integer>)set;
		
		System.out.println(tset.first());		//제일 작은것 추출
		System.out.println(tset.last());		//제일 큰것 추추루
		System.out.println(tset.headSet(5)); 	//5보다 작은 것들만 추출
		System.out.println(tset.tailSet(5)); 	//5부터 추출
		System.out.println(tset.subSet(3, 8));	//3부터 8전까지 추출
		
	}

	private static void m6() {
		
		//Set
		// - List 계열의 형제(?)
		// - 순서가 없는 배열
		// - 방번호(첨자) 사용 X
		// - 중복값을 가지지 못한다 (****)
		// - HashSet, TreeSet
		
		// - HashSet: Hash 알고리즘을 사용해서 Set인터페이스를 구현
		// - HashMap: Hash 알고리즘을 사용해서 Map인터페이스를 구현
		// - TreeSet: Tree 알고리즘을 사용해서 Set인터페이스를 구현
		// - TreeMap: Tree 알고리즘을 사용해서 Map인터페이스를 구현
		
		//HashSet
		//
		
//		ArrayList<String> list = new ArrayList<String>();
		List<String> list = new ArrayList<String>();
		
//		HashSet<String> set = new HashSet<String>();
		Set<String> set = new HashSet<String>();
		
		set.add("사과");
		set.add("바나나");
		set.add("포도");
		System.out.println(set.add("바나나"));	//false, 중복값이라 add하지 못함.
		System.out.println(set.add("복숭아"));	//true
		
		System.out.println(set.size());
		System.out.println(set);
		
		//방번호가 없기 때문에 데이터를 가져올 수 없음.
		//Iterator로 탐색해야함.
		//이러한 제약 때문에 사용하기도 함.
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		//로또 번호 6개 구하기(1~45)
		//1. ArrayList, Array
		// - 중복 값 발생 -> 중복 값 체크 + 제거
		//2. Set
		// - 자동 중복 제거
		Random rnd = new Random();
		
		Set<Integer> lotto = new HashSet<Integer>();
//		for(int i=0; i<6; i++) { //중복값이 있을 때는 add되지 않으므로 size가 6이 아닌 경우도 있음.
		while(lotto.size() < 6) {
			lotto.add(rnd.nextInt(45) + 1);			
		}
		System.out.println(lotto);
		System.out.println();
		
		
		Set<Mouse> cset = new HashSet<Mouse>();
		cset.add(new Mouse("M700", 3));
		cset.add(new Mouse("M700", 3)); //성질이 똑같은 객체는 중복값으로 보지 않음. (주소값이 다르기 때문에..)
										//그러면 어떻게 중복값이라 인식시키는지? -> 마우스 클래스에서 hashcode, equals 메소드 재정의
		cset.add(new Mouse("S500", 5));
		cset.add(new Mouse("A1000", 7));
		
		System.out.println(cset);
		System.out.println();
		
		
		//같은 마우스? 다른 마우스?
		//1. 주소값 기준: 다른 마우스
		//2. 상태값 기준: 같은 마우스
		Mouse m1 = new Mouse("M700",3);
		Mouse m2 = new Mouse("M700",3);
		Mouse m3 = new Mouse("A1000",7);
		
		
		System.out.println(m1.equals(m2));	//false: 모든 참조형 변수의 비교는 주소값 비교이기 때문에..
											//equals 메소드는 hashcode를 기준으로 비교한다.
		System.out.println(m1.hashCode());	//"M7003".hashcode() -> 72797289
		System.out.println(m2.hashCode());	//"M7003".hashcode() -> 72797289
		System.out.println(m3.hashCode());	//"A10007".hashcode() -> 1907624983
		
		System.out.println("홍길동".hashCode());
		System.out.println("홍길동".hashCode());
		System.out.println("홍길동".hashCode());
		
		
	}

	private static void m5() {
		
		//탐색 도구
		// - List, Set에서 사용
		// - 컬렉션 프레임워크에서 요소를 순차적으로 읽기 위한 표준화된 도구
		// - Enumeration, Iterator(****), ListIterator
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("사과");
		list.add("바나나");
		list.add("포도");
		list.add("딸기");
		list.add("복숭아");
		
		//탐색
		//1. for문: index 사용
		//2. 향상된 for문 : index 사용X
		//3. Iterator: index 사용X
		
		//****** 사용 빈도 높음(탐색 구조가 다른 곳에서도 많이 보이는 형태)
		Iterator<String> iter = list.iterator();
		
		//1. hasXXX()
		//2. nextXXX()
		
//		System.out.println(iter.hasNext());	//true	
//		System.out.println(iter.next());	//사과
//		
//		System.out.println(iter.hasNext());	//true	
//		System.out.println(iter.next());	//바나나
//		
//		System.out.println(iter.hasNext());	//true	
//		System.out.println(iter.next());	//포도
//		
//		System.out.println(iter.hasNext());	//true	
//		System.out.println(iter.next());	//딸기
//		
//		System.out.println(iter.hasNext());	//true	
//		System.out.println(iter.next());	//복숭아
//		
//		System.out.println(iter.hasNext());	//false	
//		System.out.println(iter.next());	//java.util.NoSuchElementException 예외
		
		//향상된 for문과 유사
		// - 전진커서, 후진X
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		//HashMap 탐색
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("사장", "홍길동");
		map.put("부장", "아무개");
		map.put("과장", "하하하");
		map.put("대리", "호호호");
		map.put("사원", "후후후");
		
		Set<String> keys = map.keySet();
		Iterator<String> kiter = keys.iterator();
		
		while (kiter.hasNext()) {
			String key = kiter.next();
			System.out.println(key + ", " + map.get(key));
		}
		
		Collection<String> vlist = map.values();
		Iterator<String> viter = vlist.iterator();
		
		while(viter.hasNext()) {
			System.out.println(viter.next());
		}
		
		System.out.println();
		System.out.println(list);
		System.out.println();
		
		//List계열
		// - 전, 후진 커서 사용
		// - 한번 읽은 데이터를 다시 읽을 수 있다.
		// - List 전용 이터레이터(set에서는 사용 불가)
		list.iterator();
		ListIterator<String> liter = list.listIterator();
		
		while(liter.hasNext()) {
			System.out.println(liter.next());
		}
		
		while(liter.hasPrevious()) {
			System.out.println(liter.previous());
		}
		
	}

	private static void m4() {
		
		//ArrayList vs LinkedList
		//작업별 속도 차이(극단적인 작업을 하지 않는 이상 큰 차이는 없음)

		ArrayList<Integer> nums1 = new ArrayList<Integer>();
		LinkedList<Integer> nums2 = new LinkedList<Integer>();
		
		long begin = 0, end = 0;
		
		System.out.println("순차적으로 데이터 추가하기(Append)");
		begin = System.nanoTime();
		for (int i=0; i<1000000; i++) {
			nums1.add(i);
		}
		end = System.nanoTime();
		System.out.printf("ArrayList 작업 시간: %,dns\n", end - begin);
			
		System.out.println("순차적으로 데이터 추가하기(Append)");
		begin = System.nanoTime();
		for (int i=0; i<1000000; i++) {
			nums2.add(i);
		}
		end = System.nanoTime();
		System.out.printf("LinkedList 작업 시간: %,dns\n", end - begin);
		
		
		System.out.println("중간에 데이터 추가하기(Insert + Shift)");
		begin = System.nanoTime();
		for (int i=0; i<100000; i++) {
			nums1.add(0,i);
		}
		end = System.nanoTime();
		System.out.printf("ArrayList 작업 시간: %,dns\n", end - begin);
			
		System.out.println("중간에 데이터 추가하기(Insert)");
		begin = System.nanoTime();
		for (int i=0; i<100000; i++) {
			nums2.add(0,i);
		}
		end = System.nanoTime();
		System.out.printf("LinkedList 작업 시간: %,dns\n", end - begin);
		
		
		System.out.println("중간에 데이터 삭제하기(Delete + Shift)");
		begin = System.nanoTime();
		for (int i=0; i<100000; i++) {
			nums1.remove(0);
		}
		end = System.nanoTime();
		System.out.printf("ArrayList 작업 시간: %,dns\n", end - begin);	
		
		System.out.println("중간에 데이터 삭제하기(Delete)");
		begin = System.nanoTime();
		for (int i=0; i<100000; i++) {
			nums2.remove(0);
		}
		end = System.nanoTime();
		System.out.printf("LinkedList 작업 시간: %,dns\n", end - begin);
		
		
		System.out.println("마지막부터 순차적으로 데이터 삭제하기(Delete)");
		begin = System.nanoTime();
		for (int i=nums1.size()-1; i>=0; i--) {
			nums1.remove(i);
		}
		end = System.nanoTime();
		System.out.printf("ArrayList 작업 시간: %,dns\n", end - begin);	
		
		System.out.println("마지막부터 순차적으로 데이터 삭제하기(Insert)");
		begin = System.nanoTime();
		for (int i=nums2.size()-1; i>=0; i--) {
			nums2.remove(i);
		}
		end = System.nanoTime();
		System.out.printf("LinkedList 작업 시간: %,dns\n", end - begin);
		
	}

	private static void m3() {
		
		//LinkedList 클래스
		// - Queue를 구현할 때 사용했던 클래스
		
		//ArrayList vs LinkedList
		// - 둘 다 List인터페이스를 구현한 클래스
		// - 겉모습은 거의 동일한데 내부 구조가 완전히 다름
		
		//ArrayList
		// - 연속적
		// - 요소의 접근 속도가 가장 빠름(0번째 방과 찾는 방의 인덱스까지의 크기를 따져 바로 찾아감)
		// - Append작업에는 효과적이지만 Insert / Delete 작업에는 비효율적임. (모든 데이터를 Shift해야하기 때문에)
		
		//LinkedList
		// - 비연속적
		// - 요소의 접근 속도가 느리다.(0번방을 찾아가서 또 다음방을 찾아가고 x N...) 
		// - Insert/Delete 작업에 효과적, Append에는 불리함(끝방까지 찾아가야 하기 때문에)
		
		//LinkedList의 종류
		//1. LinkedList
		//2. Double LinkedList
		//3. Double Circulat LinkedList : 자바의 LinkedList
		
		
		ArrayList<Integer> nums1 = new ArrayList<Integer>();
		LinkedList<Integer> nums2 = new LinkedList<Integer>();
		
		nums1.add(100);
		nums1.add(200);
		nums1.add(300);
		
		nums2.add(100);
		nums2.add(200);
		nums2.add(300);
		
		System.out.println(nums1.size());
		System.out.println(nums2.size());
		
		System.out.println(nums1.get(0));
		System.out.println(nums2.get(0));
		
	}

	private static void m2() {
	
		//정렬, sort
		// - 순서가 있는 집합에서 요소의 순서를 재배치
		// - List계열만 가능
		// - Set과 Map계열은 불가능(정렬이라는 개념이 없음)
		
		//객제.sort(): 단일값 정렬, 복합값 정렬 -> Comparator 반드시 구현
		//Collection.sort(): 단일값 정렬, 복합값 정렬 -> Comparator 선택 구현
		
		//단일값 정렬
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		list1.add(1);
		list1.add(6);
		list1.add(4);
		list1.add(9);
		
//		Collections.sort(list1);
		list1.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				//요소 2개의 비교 -> 누가 더 크고 작은지를 판단하는 규칙을 정하기
				//1. 양수를 돌려주거나
				//2. 음수를 돌려주거나
				//3. 0을 돌려주기
				return o1 - o2;
			}
		});
		System.out.println(list1);
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("사과");
		list2.add("귤");
		list2.add("오렌지");
		list2.add("파인애플");
		list2.add("포도");
		
		//문자 코드 정렬
//		Collections.sort(list2);
		
		//문자 길이 정렬
		list2.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o1.length() - o2.length();
			}
		});
		
		System.out.println(list2);
		
		
		
		//복합값 정렬
		ArrayList<Member> list3 = new ArrayList<Member>();
		Calendar c = Calendar.getInstance();
		c.set(1995, 2, 10);
		
		list3.add(new Member("홍길동", 25, c, "서울"));
		
		c = Calendar.getInstance();
		c.set(1995, 2, 10);
		c.set(Calendar.MONTH, 3);
		list3.add(new Member("아무개", 30, c, "부산"));
		
		c = Calendar.getInstance();
		c.set(1995, 2, 10);
		c.set(Calendar.MONTH, -1);
		list3.add(new Member("하하하", 22, c, "서울"));
		
		c = Calendar.getInstance();
		c.set(1995, 2, 10);
		c.set(Calendar.MONTH, 6);
		list3.add(new Member("유재석", 27, c, "서울"));
		
		c = Calendar.getInstance();
		c.set(1995, 2, 10);
		c.set(Calendar.MONTH, -3);
		list3.add(new Member("강호동", 26, c, "대구"));
		
		
		//정렬(************)
//		Collection.sort(list3); //단일값 정렬만 가능하기 때문에 이용 불가
		list3.sort(new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {

//				return o1.name.compareTo(o2.name);	//이름순 정렬
//				return o1.age - o2.age;				//나이순 정렬
//				return o1.birthday.compareTo(o2.birthday);	//태어난 순서대로
//				return o1.address.compareTo(o2.address);	//주소
				
				//주소가 같은 경우에는?
				if (o1.address.compareTo(o2.address) != 0) { //지역이 동일하지 않은 경우
					return o1.address.compareTo(o2.address); 
					
				} else { //지역이 동일한 경우
					return o1.name.compareTo(o2.name);
				}
			}
		});
		
		System.out.println(list3);
	}

	private static void m1() {
		
		//List계열
		//1. Vector : 동기화 지원
		//2. ArrayList : 동기화 지원안함(쓰레드 관련?)
		
		//사용법 거의 90% 동일 
		ArrayList<String> list1 = new ArrayList<String>();
		Vector<String> list2 = new Vector<String>();
		
		list1.add("홍길동");
		list1.add("아무개");
		
		list2.add("홍길동");
		list2.add("아무개");
		
		System.out.println(list1.size());
		System.out.println(list2.size());
	
		System.out.println(list1.get(0));
		System.out.println(list2.get(0));
	
	}
}
