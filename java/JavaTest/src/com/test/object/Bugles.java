package com.test.object;

import java.util.Calendar;

public class Bugles {
	
    private int price;
    private int weight;
    private Calendar creationTime;
    private int expiration;
       
    
    //    가격 : 읽기 전용, 850원(300g), 1200원(500g), 1950원(850g)
	public int getPrice() {	
		return price;
	}

	//    용량 : 쓰기 전용, 300g, 500g, 850g
	public void setWeight(int weight) {
		if (weight == 300 
			|| weight == 500 
			|| weight == 850) {
		this.weight = weight;
		}
		
		switch (this.weight) {
		case 300 :
			this.price = 850;
			this.expiration = 7;
			break;
		case 500 :
			this.price = 1200;
			this.expiration =10;
			break;
		case 850 :
			this.price = 1950;
			this.expiration = 15;
			break;
		}		
	}

	//    생산일자 : 쓰기 전용(Calendar)
	public void setCreationTime(String creationTime) {
		
		Calendar date = Calendar.getInstance();
		int year = Integer.parseInt(creationTime.substring(0, 4));
		int month = Integer.parseInt(creationTime.substring(5, 7)) - 1;
		int day = Integer.parseInt(creationTime.substring(8));
		
		date.set(year, month, day);
		
		this.creationTime = date;
		
	}
	//    남은유통기한 : 읽기 전용, 생산된 제품의 유통기한 기준 : 7일(300g), 10일(500g), 15일(850g)
	public int getExpiration() {
		
		Calendar today = Calendar.getInstance();

		this.expiration -= (int)((today.getTimeInMillis() - this.creationTime.getTimeInMillis()) / 1000 / 60 / 60 / 24);
				
		return expiration;
	}
	
	public void eat() {
		if (this.expiration < 0 ) {
			System.out.println("유통기한이 지나 먹을 수 없습니다.");
		} else {
			System.out.println("과자를 맛있게 먹습니다.");
		}
	}

    
    

}
