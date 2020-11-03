package hotelFiveDummies;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class temp {
	
	public static void main(String[] args) {


		
//		m1();
		m2();
	}

	
	private static void m2() {
		
		Calendar c = Calendar.getInstance();
		System.out.printf("%tT", c);
		
		
	}


	private static void m1() {
		File file = new File("D:\\HotelFive\\data\\숙박\\숙박내역.txt");
		File file2 = new File("D:\\HotelFive\\data\\숙박\\숙박예약내역.txt");
		List<String[]> reserveList = new ArrayList<String[]>();
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			BufferedWriter writer = new BufferedWriter(new FileWriter(file2,true));
			String line = "";
			
			Calendar now = Calendar.getInstance();
			Calendar sDate = Calendar.getInstance();
			System.out.printf("%tF", now);
			
			while((line = reader.readLine()) != null) {
				
				String[] list = line.split("■");
				int year = Integer.parseInt(list[2].split("-")[0]);
				int month = Integer.parseInt(list[2].split("-")[1]) -1;
				int day = Integer.parseInt(list[2].split("-")[2]);
			
				sDate.set(year, month, day);
				
				if (sDate.after(now)) {
					String newLine = "미정" + line.substring(line.indexOf("■")) + "\r\n";
					writer.write(newLine);
				}
				
			}
			writer.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
