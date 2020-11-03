package dbProjectDummies;

import java.util.ArrayList;
import java.util.List;

public class ClassRoomByEquipment {
	
	
	public static void main(String[] args) {
	
		m1();
		
	}

	private static String m3() {
		
		//랜덤 날짜 만들기
		String date = "";
		
		String[] year = {"2016", "2017", "2018", "2019"};
		int month = (int)(Math.random() * 12 + 1);
		int day = (int)(Math.random() * 28 + 1);
				
		date = String.format("%s-%02d-%02d", year[(int)(Math.random()*4)]
											, month
											, day);
	
		return date;
	}

	private static ArrayList<Integer> m2(int i) {
		
//		1	모니터			27~32
//		2	컴퓨터 본체		27~32
//		3	키보드			27~32
//		4	마우스			27~32
//		5	책상			27~31
//		6	의자			27~31
//		7	공기청정기		0~3
//		8	빔 프로젝터		1~2
//		9	보드마커		0~10
//		10	칠판지우개		0~5
//		11	랜선			27~32
//		12	에어컨			1~3
//		13	벽시계			0~2
//		14	멀티탭			30~40
//		15	마우스패드		27~35
//		16	화이트보드		1~2
//		17	롤 스크린		1~2
//		18	마이크			1~2
//		19	스피커			1~4
//		20	소화기			1~3
//		21	선풍기			0~5
//		22	블라인드		0~7	
		
		//수량을 하나씩 꺼내오기 위해 배열에 넣기!
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		if (i < 3) { //강의실번호가 1~3번이면(정원 30)
			
			list.add((int)(Math.random() * 3 + 30)); 	//모니터
			list.add((int)(Math.random() * 3 + 30)); 	//본체
			list.add((int)(Math.random() * 3 + 30)); 	//키보드
			list.add((int)(Math.random() * 3 + 30)); 	//마우스
			list.add((int)(Math.random() * 3 + 30)); 	//책상
			list.add((int)(Math.random() * 3 + 30)); 	//의자
			list.add((int)(Math.random() * 4)); 		//공기청정기
			list.add((int)(Math.random() * 2 + 1));		//빔 프로젝처
			list.add((int)(Math.random() * 11));	 	//보드마커
			list.add((int)(Math.random() * 6)); 		//칠판지우개
			list.add((int)(Math.random() * 3 + 30)); 	//랜선
			list.add((int)(Math.random() * 3 + 1)); 	//에어컨
			list.add((int)(Math.random() * 3));		 	//벽시계
			list.add((int)(Math.random() * 11 + 30)); 	//멀티탭
			list.add((int)(Math.random() * 3 + 30)); 	//마우스패드
			list.add((int)(Math.random() * 2 + 1)); 	//화이트보드
			list.add((int)(Math.random() * 2 + 1)); 	//롤스크린
			list.add((int)(Math.random() * 2 + 1)); 	//마이크
			list.add((int)(Math.random() * 4 + 1)); 	//스피커
			list.add((int)(Math.random() * 3 + 1)); 	//소화기
			list.add((int)(Math.random() * 6)); 	//선풍기
			list.add((int)(Math.random() * 8)); 	//블라인드
			
		} else { //정원 26
			
			list.add((int)(Math.random() * 3 + 26)); 	//모니터
			list.add((int)(Math.random() * 3 + 26)); 	//본체
			list.add((int)(Math.random() * 3 + 26)); 	//키보드
			list.add((int)(Math.random() * 3 + 26)); 	//마우스
			list.add((int)(Math.random() * 3 + 26)); 	//책상
			list.add((int)(Math.random() * 3 + 26)); 	//의자
			list.add((int)(Math.random() * 4)); 		//공기청정기
			list.add((int)(Math.random() * 2 + 1));		//빔 프로젝처
			list.add((int)(Math.random() * 11));	 	//보드마커
			list.add((int)(Math.random() * 6)); 		//칠판지우개
			list.add((int)(Math.random() * 3 + 26)); 	//랜선
			list.add((int)(Math.random() * 3 + 1)); 	//에어컨
			list.add((int)(Math.random() * 3));		 	//벽시계
			list.add((int)(Math.random() * 11 + 30)); 	//멀티탭
			list.add((int)(Math.random() * 3 + 26)); 	//마우스패드
			list.add((int)(Math.random() * 2 + 1)); 	//화이트보드
			list.add((int)(Math.random() * 2 + 1)); 	//롤스크린
			list.add((int)(Math.random() * 2 + 1)); 	//마이크
			list.add((int)(Math.random() * 4 + 1)); 	//스피커
			list.add((int)(Math.random() * 3 + 1)); 	//소화기
			list.add((int)(Math.random() * 6)); 	//선풍기
			list.add((int)(Math.random() * 8)); 	//블라인드
		}
		return list;
	}

	private static void m1() {
		
	
		
		String insert;
			
		for(int i=0; i<6; i++) {
			for (int j=0; j<22; j++) {
				
				List<Integer> list = new ArrayList<Integer>();
				list = m2(i);
				insert = String.format("procAddEquipmentByClassroom(equipmentByClassroomSeq.nextVal, %d, %d, %d, '%s');"
																							, i + 1
																							, j + 1
																							, list.get(j)
																							, m3());
				System.out.println(insert);
			}
		}
		
	}

}
