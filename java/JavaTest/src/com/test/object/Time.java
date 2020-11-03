package com.test.object;

public class Time {
	
	private int hour;
	private int minute;
	private int second;
	
	public Time() {
		this(0, 0, 0);
	}
	
	public Time(int hour, int minute, int second) {
		
		if (hour >= 0) {
			this.hour = hour;
		}
		if (minute >= 0) {
			this.minute = minute;
		}
		if (second >= 0) {
			this.second = second;
		}
	}
	
	public Time(int minute, int second) {
		this(0, minute, second);
	}
	
	public Time(int second) {
		this(0, 0, second);
	}
	
	public String info() {
		
		if (second / 60 >= 1) {
			minute += second / 60;
			second = second % 60;
		}
		
		if (minute / 60 >= 1) {
			hour += minute / 60;
			minute = minute % 60;
		}
		
		return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	
	

}
