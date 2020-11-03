package com.test.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Ex51_Stream_basic {
	
	public static void main(String[] args) {
		
		/*
		스트림 = 파이프의 조합
		1. 원본 파이프:  stream()
		
		[원본과 똑같은 자료형의 Stream을 반환]
		3. 정렬 파이프: sorted()
		4. 필터 파이프: filter()
		5. 중복 제거 파이프: distinct()
		
		[원본과 똑같은 자료형의 Stream을 반환하지 않음. 자료형을 가공해서 반환함.]
		6. 변환 파이프: map()
		
		2. 최종 소비 파이프: forEach()
		*/
		
		
		//입출력 기능(io) + 람다식 사용

//		Item item = new Item();
		
		//색 설정 -> public final static 변수 사용
//		item.color = Item.red;
		//색 설정 -> enum 사용
//		item.color = Item.Color.BLUE;
		
//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
		m6();
	
	}

	private static void m6() {
		
		//map()
		// - Mapping(연결 + 변환)
		// - 추출 작업
		// - 변환 작업
		// - 축소 작업
		
		List<String> names = Item.getListString();
		System.out.println(names);		
		
		names.stream()
				.map(name -> name)							//Stream<String> 반환
				.forEach(name -> System.out.println(name));
		System.out.println();
		
		names.stream()
				.map(name -> name.length())					//Stream<Integer> 반환
				.forEach(length -> System.out.println(length));
		
		List<Item> items = Item.getList();
		
		items.stream()
				.map(item -> {
								if (item.getSize() > 50 && (item.getColor() == Item.Color.BLACK || item.getColor() == Item.Color.WHITE)) {
									return "고가품";
								} else {
									return "저가품";
								}
			}).forEach(result -> System.out.println(result));
		System.out.println();
		
		items = Item.getList();
		
		items.stream().map(itme -> itme.getColor()).forEach(color -> System.out.println(color));
		System.out.println();
		
		
		//정리
		items = Item.getList();
		
		items.stream()
				.filter(item -> item.getName().length() >= 2)
				.map(item -> item.getName())
				.sorted((name1, name2) -> name1.length() - name2.length())
				.distinct()
				.forEach(name -> System.out.println(name));
		
		
		
	}

	private static void m5() {
		
		//distinct()
		// - 중복값 제거 -> 1개만 남기는 역할
		
		List<Integer> nums = Item.getListInt();
		System.out.println(nums);
		
		//중간 파이프 역할 함수들의 반환값 -> 항상 Stream
		nums.stream().distinct().forEach(num -> System.out.print(num + " "));
		System.out.println();
		
		//객체 배열 -> 중복값 제거
		List<Item> items = Item.getList();	//선풍기가 중복됨
		
		System.out.println(items);
		//hashCode()와 Equals()를 오버라이딩 시킨 후 중복값이 제거됨.
		items.stream().distinct().forEach(item -> System.out.println(item));
		
		//한꺼번에 써보기
		items.stream()																	//원본 파이프
				.filter(item -> item.getColor() == Item.Color.BLACK)					//필터 파이프
				.distinct()																//중복제거 파이프
				.sorted((item1, itme2) -> item1.getName().compareTo(itme2.getName()))	//정렬 파이프
				.forEach(item -> {														//소비 파이프
									System.out.println("이름: " + item.getName());
									System.out.println("크기: " + item.getSize());
									System.out.println("색상: " + item.getColor());
									System.out.println();
				});
		
	}

	private static void m4() {
		
		//필터
		// - 스트림의 요소 중 원하는 것만 추출
		// - 검색
		
		List<Integer> nums = Item.getListInt();
		
		nums.stream()
			.filter(num -> num > 50) //predicate 인터페이스 구현(매개변수를 넘겨받아 t/f값 반환)
			.forEach(num -> System.out.println(num));
		System.out.println();
		
		List<String> names = Item.getListString();
		
		names.stream()
			.filter(name -> name.length() >= 3)			//필터 하고
			.sorted()									//정렬 추가로 하고
			.forEach(name -> System.out.println(name));	//소비
		System.out.println();
		
		List<Item> items = Item.getList();
		//Item -> 이름, 크기, 색상
		
		items.stream()
			.filter(item -> item.getColor() == Item.Color.BLACK)
			.forEach(item -> System.out.println(item));
		System.out.println();
		
		items.stream()
			.filter(item -> item.getSize() >= 30 && item.getColor() == Item.Color.RED) //한 필터에 두 조건
			.forEach(item -> System.out.println(item));
		System.out.println();
		
		items.stream()
		.filter(item -> item.getSize() >= 30)				//한 필터에 한 조건씩 두 필터 -> 가독성 향상
		.filter(item -> item.getColor() == Item.Color.RED)
		.forEach(item -> System.out.println(item));
		System.out.println();
		
	}

	private static void m3() {
		
		//탐색을 하면서(Stream) 정렬..
		
		List<Integer> nums = Item.getListInt();
		System.out.println(nums);
		
		//List 정렬
		Collections.sort(nums);			
		System.out.println(nums);
		nums.sort((n1, n2) -> n2 - n1);
		System.out.println(nums);
		
		//Stream 정렬
		//데이터 정렬
		nums.stream().sorted().forEach(num -> System.out.print(num + " ")); //sorted는 오름차순 정렬 메소드
		System.out.println();
		
		nums.stream().sorted((n1, n2) -> n2 - n1).forEach(num -> System.out.print(num + " ")); //sorted안에 Comparator를 구현하여 내림차순 정렬
		System.out.println();
		
		List<String> names = Item.getListString();
	
		names.stream().sorted().forEach(name -> System.out.println(name));	//오름차순
		System.out.println();
		
		names.stream().sorted((s1, s2) -> s2.compareTo(s1)).forEach(name -> System.out.println(name));  //내림차순
		System.out.println();
		
		names.stream()
			.sorted((s1, s2) -> s1.length() - s2.length()) 	//글자수대로 정렬
			.forEach(name -> System.out.println(name)); 	//하나씩 출력
		System.out.println();
		
		//객체 정렬
		List<Item> items = Item.getList();	
		items.stream()
//			.sorted((item1, item2) -> item1.getName().compareTo(item2.getName()))	//객체의 이름을 비교하여 정렬
//			.sorted((item1, item2) -> item1.getSize() - item2.getSize())		 	//객체의 사이즈를 비교하여 정렬
			.sorted((item1, item2) -> item1.getColor().compareTo(item2.getColor())) //객체의 색상(enum의 선언 순서)를 비교하여 정렬
			.forEach(item -> System.out.println(item));
		System.out.println();
		
	}

	private static void m2() {
		
		//데이터 소스를 여러가지로 테스트
		
		//1. 데이터 소스: List
		List<String> names = Item.getListString();
		names.stream().forEach(name -> System.out.println(name));
		System.out.println();
		
		//2. 데이터 소스: 배열
		String[] list = new String[] { "빨강", "노랑", "파랑", "검정", "하양" };
		Arrays.stream(list).forEach(color -> System.out.println(color));
		System.out.println();
		
		//3. 데이터 소스: 파일
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("D:\\class\\java\\io\\할일.txt"));
			reader.lines().forEach(line -> System.out.println(line));
			System.out.println();
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//4. 데이터 소스: 디렉토리
		try {
			Files.list(Paths.get("D:\\class\\java")).forEach(path -> System.out.println(path.getFileName()));
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void m1() {

		//스트림, Stream
		// - JDK 1.8 ver added
		// - 주로 배열(컬렉션)을 탐색하기 위한 도구(디렉토리, 파일 등 입출력 용도)
		// - 람다식으로 구현(= 익명 객체 요구하는 부분 많음)
		// - Iterator(외부 반복자) 작업과 유사
		// - 내부 반복자
		
		List<Integer> nums = Item.getListInt();
		System.out.println(nums);
		
		//nums 탐색
		//1. for : index 미사용
		for (int i=0; i<nums.size(); i++) {
			System.out.print(nums.get(i) + " ");
		}
		System.out.println();
		
		//2. for : index 사용(향상된 for문은 내부적으로 Iterator사용)
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		//3. Iterator : index 미사용
		Iterator<Integer> iter = nums.iterator();
		
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
		
		
		//4. Stream : index 미사용
		Stream<Integer> stream = nums.stream();
		
		//매개변수로 인터페이스가 적혀있으면 할 수 있는 방법 3가지
		//A. 인터페이스 + 클래스선언 -> 객체생성 : 가장 hard한 방법, 사용하지 말기..
		stream.forEach(new Test());
		System.out.println();
		stream.close();			//forEach() 이후 자동으로(?) 닫히는데 관습적으로 close()를 씀. 자원(stream)을 사용했기 때문에..
		
		//B. 인터페이스 -> 익명 객체 생성
		stream = nums.stream(); //다시 stream 열기
		stream.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.print(t + " ");		
			}	
		});
		System.out.println();
		stream.close();
		
		//C. 인터페이스 -> 람다식 구현 : 가장 간편하고 가독성 높음 
		stream = nums.stream();
		stream.forEach(t -> System.out.print(t + " "));
		System.out.println();
		stream.close();
		
		
		List<String> names = Item.getListString();
		//함수형 스타일
		names.stream().forEach(name -> System.out.println(name));		
		Item.getList().stream().forEach(item -> System.out.println(item.getColor()));
		
	}

}
//이 클래스는 오로지 m1()의 forEach에 사용하기 위한 클래스임.
class Test implements Consumer<Integer> {
	@Override
	public void accept(Integer t) {
		System.out.print(t + " ");
	}
}


class Item {
	
	private String name;	//자유입력
	private int size;		//자유입력
//	private String color;	//이대로 놓으면 자유입력임. 선택입력 > public final static vs enum,  S
	
	//색 설정 방법 1.
//	public int color;
//	public final static int red = 1;
//	public final static int yellow = 2;
//	public final static int blue = 3;
	
	//색 설정 방법 2. *권장사항*
	private Color color;
	public enum Color {
		RED, YELLOW, BLUE, BLACK, WHITE, PURPLE, GREEN
	}
	
	
	
	public Item(String name, int size, Color color) {
		super();
		this.name = name;
		this.size = size;
		this.color = color;
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
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}



	@Override
	public String toString() {
		return String.format("(%s, %d, %s)", this.name, this.size, this.color);
	}
	
	//더미 객체 생성 메소드
	public static List<Item> getList() {
		
		List<Item> list = new ArrayList<Item>();
		
		list.add(new Item("키보드", 30, Color.BLACK));
		list.add(new Item("마우스", 10, Color.BLACK));
		list.add(new Item("선풍기", 25, Color.WHITE));
		list.add(new Item("선풍기", 25, Color.WHITE));
		list.add(new Item("컵", 35, Color.GREEN));
		list.add(new Item("책", 45, Color.YELLOW));
		list.add(new Item("소독제", 35, Color.BLUE));
		list.add(new Item("책상", 100, Color.RED));
		list.add(new Item("의자", 50, Color.RED));
		list.add(new Item("프로젝터", 55, Color.WHITE));
		list.add(new Item("우산", 40, Color.BLACK));
		
		return list;
		
	}
	
	public static List<Integer> getListInt() {
		
		List<Integer> list = new ArrayList<Integer>();
		List<Item> items = getList();
		
		for (Item item : items) {
			list.add(item.getSize());
		}
		
		return list;
	}
	
	public static List<String> getListString() {
		
		List<String> list = new ArrayList<String>();
		List<Item> items = getList();
		
		for (Item item : items) {
			list.add(item.getName());
		}
		
		return list;
	}



	
	
	//객체 비교 -> 기본적으로 주소값 비교임.
	//상태 비교를 하도록 작업 -> hashCode() & equals() 오버라이드
	
	@Override
	public int hashCode() {
		//"선풍기20BLACK".hashCode -> 이 String의 주소값 반환
		// - 상태값이 같은 객체들은 같은 값을 반환하게 됨.
		// - 아래의 return문에는 모든 멤버변수들을 다 넣을 필요는 없으나 모든 멤버를 넣는 것이 일반적임. 
		return (this.name + this.size + this.color).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {

		return this.hashCode() == obj.hashCode();
		//Item.equals(Item)
	}
	
	
	
}//Item
