package com.test.object;

public class Book {
		
	private String title;
    private int price;
    private String author;
    private String publisher;
    private String pubYear = "2020";
    private String isbn;
    private int page;

    //getter, setter
    
    public void setTitle(String title) {
    	if (checkTitle(title)) {
    		this.title = title;
    	}    	
    }//setTitle
    
    public String getTitle() {
    	return title;
    }//getTitle;

	private boolean checkTitle(String title) {
		//	제목 : 읽기/쓰기, 최대 50자 이내(한글, 영어, 숫자)

		if (title.length() > 50) {
			System.out.println("제목은 50자 이내로 입력하십시오.");
			return false;
		}
		for (int i=0; i<title.length(); i++) {
			char c = title.charAt(i);
			
			if ((c < 'a' || c > 'z') 
				&& (c < 'A' || c > 'Z')
				&& (c < '가' || c > '힣')
				&& (c < '0' || c > '9')
				&& c!= ' ') {
				System.out.println("제목은 한글, 영어, 숫자로만 입력하십시오.");
				return false;
			}
		}
		return true;
	}//checkTitle

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		//	가격 : 읽기/쓰기, 0 ~ 1000000원
		
		if (price >= 0 && price <= 1000000) {
			this.price = price;
		} else {
			System.out.println("가격은 0원 ~ 1,000,000원 사이로 입력하십시오.");
		}
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		//	저자 : 읽기/쓰기, 제한 없음
		this.author = author;
	}

	public void setPublisher(String publisher) {
		//	출판사 : 쓰기 전용
		this.publisher = publisher;
	}

	public String getPubYear() {
		//	발행년도 : 읽기 전용(2020년)
		return pubYear;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		//	ISBN : 읽기/쓰기
		this.isbn = isbn;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		//	페이지수 : 읽기/쓰기, 1~무제한
		if (page >= 1) {
			this.page = page;
		} else {
			System.out.println("1페이지 이상 입력하십시오.");
		}
	}
	
	public String info() {
		
		String info = "제목 : " + this.title + "\n"
						+ "저자 : " + this.author + "\n"
						+ "가격 : " + this.price + "\n"
						+ "출판사 : " + this.publisher + "\n"
						+ "출판 년도 : " + this.pubYear + "\n"
						+ "페이지 수 : " + this.page + "\n"
						+ "ISBN : " + this.isbn + "\n";
		return info;
	}

}
