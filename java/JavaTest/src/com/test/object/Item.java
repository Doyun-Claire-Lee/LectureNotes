package com.test.object;

import java.util.Calendar;

public class Item {
	
	private String name;
	private Calendar expiration;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Calendar getExpiration() {
		return expiration;
	}
	public void setExpiration(String s) {
		
		Calendar date = Calendar.getInstance();
		date.set(Integer.parseInt(s.substring(0,4))
				, Integer.parseInt(s.substring(5,7)) -1
				, Integer.parseInt(s.substring(8)));
		
		this.expiration = date;
	}
	

}
