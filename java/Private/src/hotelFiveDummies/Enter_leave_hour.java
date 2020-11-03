package hotelFiveDummies;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Enter_leave_hour {
	
	public static void main(String[] args) {
		
		m2();
		
	}
	
	public static void m2() {
		
		HashMap<String, Calendar> map = new HashMap<String, Calendar>();
		
		try {

			File file = new File("D:\\Console Project\\데이터파일\\직원정보.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			Calendar c = Calendar.getInstance();
			
			String line = "";
			while ((line = reader.readLine()) != null) {
				String memberID = line.split("■")[0];
				String sDate = line.split("■")[4];
				int year = Integer.parseInt(sDate.split("\\.")[0]);
				int month = Integer.parseInt(sDate.split("\\.")[1])-1;
				int day = Integer.parseInt(sDate.split("\\.")[2]);
				c.set(year, month, day);
			
				map.put(memberID, c);
			}
			

			File file2 = new File("D:\\Console Project\\데이터파일\\출퇴근정보.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file2, true));
			List<String> days = getWeekdays();
			
			Set<String> set = map.keySet();
			
			for(String member : set) {

				for (String day : days) {
					
					Calendar cc = Calendar.getInstance();
					int year = Integer.parseInt(day.split("-")[0]);
					int month = Integer.parseInt(day.split("-")[1]) - 1;
					int date = Integer.parseInt(day.split("-")[2]);
		
					cc.set(year, month, date);
//					System.out.printf("%tF", cc);
					
					if (cc.after(map.get(member))) {
						
						String[] h1 = {"07", "08", "09", "10", "08", "08", "08", "08", "08",};
						String[] h2 = {"16", "17", "18", "19","18", "19","18", "19","18", "19", "15", "14"};
						String m = String.format("%02d", (int)(Math.random() * 60));
						
						String newline = member + "■"
										+ day + "■"
										+ h1[(int)(Math.random() * h1.length)] + ":"  + m + "■"
										+ h2[(int)(Math.random() * h2.length)] + ":"  + m + "\n";
						writer.write(newline);
						
					}
				}
			}
			writer.close();
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<String> getWeekdays() {
		
		Calendar from = Calendar.getInstance();
		from.set(2019, 0, 1);
		
		Calendar to = Calendar.getInstance();
		to.set(2020, 4, 16);

		ArrayList<String> days = new ArrayList<String>();
		
		while (from.before(to)) {
			
			if (from.get(Calendar.DAY_OF_WEEK) != 1 && from.get(Calendar.DAY_OF_WEEK) != 7) {

				String day = String.format("%tF", from);
				days.add(day);
			}
		
			from.add(Calendar.DAY_OF_MONTH, 1);
		}
		return days;
	}

}
