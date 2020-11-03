package com.test.object;

public class Note {
	
//  크기, 표지 색상, 페이지수, 소유자이름, 가격
	
	private String size;
	private String color;
	private int page;
	private String owner;
	private int price = 500;
	
	
	//	가격 : Setter,Getter 구현 안함. 추후 info() 메소드에서 사용하기 위해 아래와 같은 규칙으로 계산
	//	(+) 기본 노트 : A5 + 흰색 + 10페이지 = 가격(500원)
	
	
	//	크기 : 쓰기 전용, A3, A4, A5, B3, B4, B5
	//	(+) 크기 변경 : A3(+400원), A4(+200원), B3(+500원), B4(+300원), B5(+100원)
	public void setSize(String size) {
		
		if (size != "A3" 
			&& size != "A4"
			&& size != "A5"
			&& size != "B3"
			&& size != "B4"
			&& size != "B5") {
			System.out.println("사이즈를 다시 입력하세요.");
		} else {
			
		this.size = size;
			switch (size) {
				case "A3" :
					price += 400;
					break;
				case "A4" :
					price += 200;
					break;
				case "B3" :
					price += 500;
					break;
				case "B4" :
					price += 300;
					break;
				case "B5" :
					price += 100;
					break;
			}
		}
	}
	
	//	표지 색상 : 쓰기 전용, 검정색, 흰색, 노란색, 파란색
	//	(+) 색상 변경 : 검정색(+100원), 노란색(+200원), 파란색(+200원)
	public void setColor(String color) {
		if (color != "검정색"
			&& color != "흰색"
			&& color != "노란색"
			&& color != "파란색") {
			System.out.println("색상을 다시 입력하세요.");
		} else {
			this.color = color;
			switch (color) {
			case "검정색" :
				price += 100;
				break;
			case "노란색" :
				price += 200;
				break;
			case "파란색" :
				price += 200;
				break;
			}
		}	
	}
	
	//	페이지수 : 쓰기 전용, 10 ~ 200페이지 이내
	//	(+) 페이지수 변경 : 페이지 당 x 10원 추가
	//	(+) 10~50(얇다), 51 ~ 100(보통), 101 ~ 200(두껍다)
	public void setPage(int page) {
		if (page < 10 || page > 200) {
			System.out.println("페이지 수를 다시 입력하세요.");
		} else {
			this.page = page;
		}
		
		if (page > 10) {
			for(int i=0; i<page-10; i++) {
				price += 10;
			}
		}
	}
	
	//	소유자이름 : 쓰기 전용, 한글 2~5자이내. 필수값
	public void setOwner(String owner) {
		boolean chk = true;
		
		if (owner.length() < 2 || owner.length() > 5) {
			chk = false;
		}
		for (int i=0; i<owner.length(); i++) {
			char c = owner.charAt(i);
			if (c < '가' || c > '힣') {
				chk = false;
				break;
			}
		}
		if (chk) {
			this.owner = owner;
		}
	}
	
	public String info() {
		
//		■■■■■■ 노트 정보 ■■■■■■
//		소유자 : 홍길동
//		특성 : 노란색 얇은 B4노트
//		가격 : 1,150원
//		■■■■■■■■■■■■■■■■■■■■■■
		
		String info = "";
		String thickness = "";
		
		if (this.page <= 50) {
			thickness = "얇은";
		} else if (this.page <= 100) {
			thickness = "보통";
		} else {
			thickness = "두꺼운";
		}
				
		
		if (this.owner == null) {
			
			info = "■■■■■■■ 노트 정보 ■■■■■■■\n" + 
					"주인 없는 노트\n" + 
					"■■■■■■■■■■■■■■■■■■■■■■■■■\n";
		} else {
			
			info = "■■■■■■■ 노트 정보 ■■■■■■■\n" 
					+ "소유자 : " + this.owner + "\n" 
					+ "특성 : " + this.color + " " + thickness + " " + this.size + "노트\n" 
					+ String.format("가격 : %,d원\n" , this.price)
					+ "■■■■■■■■■■■■■■■■■■■■■■■■■\n";		
		}	
		
		return info;
	}
	
	

}
