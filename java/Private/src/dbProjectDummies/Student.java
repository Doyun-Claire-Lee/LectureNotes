package dbProjectDummies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Student {
	
	public static List<String> names;
	public static List<String> days;
	public static List<Integer> numbers;
	
	public static void main(String[] args) {
		
//		1	19/05/01	19/12/06	1
//		2	19/06/03	19/12/11	2
//		3	19/07/01	20/02/04	3
//		4	19/08/05	20/01/23	4
//		5	19/09/02	20/04/20	5
//		6	19/10/01	20/03/27	6
//		7	19/12/09	20/05/09	1
//		8	19/12/18	20/06/18	2 **
//		9	20/01/27	20/06/20	4
//		10	20/02/06	20/08/11	3 **
//		11	20/03/30	20/11/02	6
//		12	20/04/23	20/10/15	5
		
		m1();	
		m2("20190501", "20191206", 26, 1);
		m2("20190603", "20191211", 26, 2);
		m2("20190701", "20200204", 26, 3);
		m2("20190805", "20200123", 26, 4);
		m2("20190902", "20200420", 26, 5);
		m2("20191001", "20200327", 26, 6);
		m2("20191209", "20200509", 26, 7);
		m2("20191218", "20200618", 26, 8);
		m2("20200127", "20200620", 26, 9);
		m2("20200206", "20200811", 26, 10);
		m2("20200330", "20201102", 26, 11);
		m2("20200423", "20201015", 26, 12);
//		System.out.println(names.size());
//		System.out.println(names);
//		System.out.println(days);
		
	}
	
	//시작날짜(yyyymmdd), 종료날짜(yyyymmdd), 정원, 시행강의정원
	private static void m2(String start, String end, int seq, int courseNum) { //정원 30명짜리 
		
		
		Calendar regiDate = Calendar.getInstance();
		Calendar startDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		
		//과정 시작날짜 설정
		int year = Integer.parseInt(start.substring(0, 4));
		int month = Integer.parseInt(start.substring(4, 6)) - 1;
		int day = Integer.parseInt(start.substring(6));
		startDate.set(year, month, day);
		
		//과정 종료날짜 설정
		int year2 = Integer.parseInt(end.substring(0, 4));
		int month2 = Integer.parseInt(end.substring(4, 6)) - 1;
		int day2 = Integer.parseInt(end.substring(6));
		endDate.set(year2, month2, day2);
		
			//출력할 라인 선언&초기화
			String sql = "";
			
			//각 강의의 정원만큼 반복
			for (int i=0; i<seq; i++) {
				
				//학생 번호 저장 변수 선언&초기화
				int number = -1;
				
				for (int j=0; j<days.size(); j++) {
					
					//그 학생의 등록일로 날짜 설정
					year = Integer.parseInt(days.get(j).substring(0, 4));
					month = Integer.parseInt(days.get(j).substring(4, 6)) - 1;
					day = Integer.parseInt(days.get(j).substring(6));
					regiDate.set(year, month, day);
					
					if (regiDate.before(startDate)) {//등록일보다 강의 시작일이 먼저일 경우
						
						//그 학생의 seq를 number에 저장
						number = numbers.get(j);
						
						names.remove(j);
						days.remove(j);
						numbers.remove(j);
						j--;

//						System.out.println(names.get(j));
//						System.out.println(days.get(j));
//						System.out.println(names.size());
//						System.out.println(days.size());
						break;
					}
				}
				
				
				if (endDate.before(now)) { //종료일이 현재보다 먼저일 경우 
					sql = String.format("insert into tblCourseHistory values (courseHistorySeq.nextVal, %d, %d, '%s', '%s');"
							, number
							, courseNum
							, "수료"
							, String.format("%tF", endDate).replace("-", ""));
			
				} else { //아직 종료일이 안된 경우 
					sql = String.format("insert into tblCourseHistory values (courseHistorySeq.nextVal, %d, %d,'%s', null);"
							, number
							, courseNum
							, "수강중");
				}
			//sql문 찍기
			System.out.println(sql);
				
			}
		System.out.println();
	}//m2

	private static void m1() { //이름, 날짜 리스트에 넣기
		
		File nfile = new File("D:\\이름.txt");
		File dfile = new File("D:\\날짜.txt");
		
		names = new ArrayList<String>();
		days = new ArrayList<String>();
		numbers = new ArrayList<Integer>();
		
		names.clear();
		days.clear();
		
		try {
			
			BufferedReader nreader = new BufferedReader(new FileReader(nfile));
			
			if (nfile.exists()) { //이름 파일 존재하면
				
				String line = "";
				
				while((line = nreader.readLine()) != null) {
					names.add(line);
				}
				
			} else {
				System.out.println("이름 파일이 없습니다.");
			}
			
			BufferedReader dreader = new BufferedReader(new FileReader(dfile));
			
			if (dfile.exists()) { //날짜 파일 존재하면
				
				String line = "";
				
				while((line = dreader.readLine()) != null) {
					days.add(line);
				}
				
			} else {
				System.out.println("날짜 파일이 없습니다.");
			}
			
			for (int i=0; i<600; i++) {
				numbers.add(i+1);
			}
			
			//확인용 출력문
			
//			System.out.println(names);
//			System.out.println(names.size());
//			System.out.println(days);
//			System.out.println(days.size());
						
			
		} catch (Exception e) {

			e.printStackTrace();
		}
			
	}

}
