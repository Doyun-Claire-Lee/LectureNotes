package com.test.collection;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ex39_ArrayList_test {
	
	private static Output output;
	private static Scanner scan;
	private static ArrayList<Student> list;
	static {
		output = new Output();
		scan = new Scanner(System.in);
		list = new ArrayList<Student>();
	}
	
	
	public static void main(String[] args) {
		
		//학생 정보 관리 프로그램
		
		//학생 정보
		// - 이름
		// - 나이
		// - 주소
		// - 연락처
		// - 번호(1~ 순차적 할당)
		
		//기능
		// - 학생 추가
		// - 학생 목록
		// - 학생 삭제
		// - 학생 검색
		// - 학생 수정(X)
		
		//고려사항
		//1. 학생 1명의 정보 관리,,, -> class 선언 -> Student
		//2. 여러 Student 관리,,, -> 집합 자료형 필요(배열, ArrayList) -> 가변이라 가정하고 ArrayList<Student> 사용
		
		//클래스 추가
		//1. Student : 학생 정보
		//2. Output : 출력 코드 담당 클래스(업무 분산)
		
		//프로그램 흐름
		// 시작 -> 메뉴 출력 -> 항목 선택 -> 기능 실행 -> 메뉴 출력 -> .... 
		
//		Output output = new Output();
//		Scanner scan = new Scanner(System.in);
		
		dummy();
		
		output.begin();
		
		boolean loop = true;
		while(loop) {
			output.menu();
			String sel = scan.nextLine();
			
			if (sel.equals("1")) {			//학생 추가
				add();
			} else if (sel.equals("2")) {	//학생 목록
				list();
			} else if (sel.equals("3")) {	//학생 삭제
				delete();
			} else if (sel.equals("4")) {	//학생 검색
				search();
			} else if (sel.equals("5")) {	//학생 검색
				search2();
			} else if (sel.equals("6")) {	//학생 검색
				search3();
			} else {						//프로그램 종료
				loop = false;
			}
		}
		
		
		
		output.end();
		
		
		
	}//main




	private static void dummy() {
		//테스트용 더미 데이터 X10명
		
		String[] temp1 = {"김", "이", "박", "최", "정"};
		String[] temp2 = {"유", "정", "은", "윤", "고", "영", "수", "희", "강", "민"};
		String[] temp3 = {"서울시", "인천시", "부산시", "대전시", "광주시"};
		String[] temp4 = {"강남구", "강서구", "강북구", "강동구"};
		
		Random rnd = new Random();
		
		for (int i=0; i<10; i++) {
			Student s = new Student();
			Student.temp++;
			s.setSeq(Student.temp);
			
			String name = temp1[rnd.nextInt(temp1.length)] 
						+ temp2[rnd.nextInt(temp2.length)]
						+ temp2[rnd.nextInt(temp2.length)];
			int age = rnd.nextInt(10) + 20;
			String address = temp3[rnd.nextInt(temp3.length)] + " " + temp4[rnd.nextInt(temp4.length)];
			String tel = "010-" + (rnd.nextInt(9000) + 1000) + "-" + (rnd.nextInt(9000) + 1000);
			
			s.setName(name);
			s.setAge(age);
			s.setTel(tel);
			s.setAddress(address);
			
			list.add(s);
			
		}
		
	}

	private static void add() {
		
		output.title(Title.ADD);
		
		System.out.print("이름: ");
		String name = scan.nextLine();
		
		System.out.print("나이: ");
		int age = scan.nextInt();
		scan.skip("\r\n");	//****************
		
		System.out.print("주소: ");
		String address = scan.nextLine();
		
		System.out.print("연락처: ");
		String tel = scan.nextLine();
		
		//입력받은 정보를 지역변수에 일단 저장해 둔 상태, Student 객체에 저장하기
		
		Student s = new Student();
		
		Student.temp++; //일련 번호의 역할
		
		s.setName(name);
		s.setAge(age);
		s.setAddress(address);
		s.setTel(tel);
		s.setSeq(Student.temp);
	
		list.add(s);	//***********학생 추가
		
		//메뉴로 돌아가기 전에 잠시 멈춤
		output.pause(scan); //아까 만들어둔 scanner를 넘겨줌..
	}

	private static void list() {
		
		output.title(Title.LIST);
		
		listName();
		
		output.pause(scan);
	}

	private static void listName() {
		
		System.out.println("[번호]\t[이름]\t[나이]\t[연락처]\t[주소]");
		for (Student s : list) {
			System.out.printf("%5d\t%s\t%5d\t%s\t%s\n"
								,s.getSeq()
								,s.getName()
								,s.getAge()
								,s.getTel()
								,s.getAddress());
		}
	}

	private static void delete() {
		
		output.title(Title.DELETE);
		
		listName(); //리스트를 먼저 출력
		
		System.out.println("삭제할 번호: ");
		int seq = scan.nextInt();
		scan.skip("\r\n");
		
		//번호가 몇번째 방에 있는지 찾아야 함 -> 배열 탐색
		
		for(int i=0; i<list.size(); i++) {
			if (list.get(i).getSeq() == seq) {
				list.remove(i);
				break;
			}
		}
		
		output.pause(scan);
		
		
	}

	private static void search() {
		
		output.title(Title.SEARCH);
		
		//검색을 어떻게 할지?
		// - list()작업과 유사
		// 1. list() : 모든 데이터 출력
		// 2. search() : 일부 데이터 출력, 조건부 list()
		
		System.out.print("검색(학생명): ");
		String word = scan.nextLine();
		
		System.out.println("[번호]\t[이름]\t[나이]\t[연락처]\t[주소]");
		
		for (Student s : list) {
			
			if (s.getName().contains(word)) { //검색할 단어가 포함된 경우 검색해주기
			// (s.getName().indexOf(word) < -1) 도 같은 뜻
				
				System.out.printf("%5d\t%s\t%5d\t%s\t%s\n"
						,s.getSeq()
						,s.getName()
						,s.getAge()
						,s.getTel()
						,s.getAddress());
			}
		}
		
		output.pause(scan);
		
	}
	private static void search2() {
		
		output.title(Title.SEARCH);
		
		System.out.print("검색(연락처): ");
		String word = scan.nextLine();
		
		System.out.println("[번호]\t[이름]\t[나이]\t[연락처]\t[주소]");
		
		for (Student s : list) {
			
			if (s.getTel().replace("-", "").contains(word)) { //"-"를 제외한 리스트에서 검색하기
			
				System.out.printf("%5d\t%s\t%5d\t%s\t%s\n"
						,s.getSeq()
						,s.getName()
						,s.getAge()
						,s.getTel()
						,s.getAddress());
			}
		}
		output.pause(scan);
	}
	
	private static void search3() {
		
		//토큰 검색, 스페이스 단위로 검색어를 쪼개 검색
		
		output.title(Title.SEARCH);
		
		
		System.out.print("검색(학생명): ");
		String word = scan.nextLine(); 	//김 이 박 이라고 했을 때,
		
		String[] wordList = word.split(" ");
		
		System.out.println("[번호]\t[이름]\t[나이]\t[연락처]\t[주소]");
		
		for (Student s : list) {
			
			
			if (isName(s.getName(), wordList)) { //검색할 단어가 포함된 경우 검색해주기
			// (s.getName().indexOf(word) < -1) 도 같은 뜻
				
				System.out.printf("%5d\t%s\t%5d\t%s\t%s\n"
						,s.getSeq()
						,s.getName()
						,s.getAge()
						,s.getTel()
						,s.getAddress());
			}
		}
		
		output.pause(scan);
		
		
	}

	private static boolean isName(String name, String[] wordList) {
		
		boolean flag = false;
		
		for (String word : wordList) {
						
			if (name.contains(word.replace("-", "")) && !word.startsWith("-")) { //마이너스 기호가 붙은 검색어는 출력하지 않기로 
				flag = true;
			} else if (name.contains(word.replace("-", "")) && word.startsWith("-")) {
				flag =  false;
			}
		}
		return flag;
	}



}
