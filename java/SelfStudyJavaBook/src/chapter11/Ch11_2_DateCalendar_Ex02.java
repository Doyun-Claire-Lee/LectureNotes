package chapter11;

import java.util.Calendar;

public class Ch11_2_DateCalendar_Ex02 {
	
	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();
		
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DATE);
		int day2 = now.get(Calendar.DAY_OF_MONTH);
		
		//뭔차이지..?
		System.out.println(day);
		System.out.println(day2);
		
	}

}
