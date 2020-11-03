package hotelFiveDummies;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Dummy {
	
	public static void main(String[] args) {
		
		m1();
		 
		
		
				
		
		
	}

	
	private static void m1() {
		
		File file = new File("D:\\Console Project\\데이터파일\\레스토랑 메뉴.txt");
		File file2 = new File("D:\\Console Project\\데이터파일\\레스토랑 주문내역.txt");
		
		List<String> roomNum = getRoomNumList();
		List<Integer> prices = new ArrayList<Integer>();
		List<String> menuNum = new ArrayList<String>();
		
		
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			
			while((line = reader.readLine()) != null) {
				int price = Integer.parseInt(line.split("■")[3]);
				String num = line.split("■")[1];
				
				prices.add(price);
				menuNum.add(num);
			}
			
			reader.close();
			
			System.out.println(prices);
			System.out.println(menuNum);
			
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file2, true));
			for (int i=0; i<5000; i++) {
				String date = getDate();
				String room = roomNum.get((int)(Math.random()*roomNum.size()));
				String num = menuNum.get((int)(Math.random()*menuNum.size()));
				
				
				line = date + "■"
						+ "room" + "■"
//						+ (int)(Math.random()*20 + 1) + "■"
						+ room + "■"
						+ num + "■"
						+ prices.get((int)(Math.random()*prices.size())) + "■"
						+ "false" + "\n";
				writer.write(line);
			}
			writer.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	

	private static void getCustomerEvaluation(File file) throws IOException {
		
		List<String> roomNum = getRoomNumList();
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
				
		for (int i=0; i<1000; i++) {
			
			String line = roomNum.get((int)(Math.random() * roomNum.size())) + "■"
							+ getDate() + "■"
							+ (int)(Math.random() * 10 + 1) + "■"
							+ (int)(Math.random() * 10 + 1) + "■"
							+ (int)(Math.random() * 10 + 1) + "■"
							+ (int)(Math.random() * 10 + 1) + "■"
							+ (int)(Math.random() * 10 + 1) + "■"
							+ (int)(Math.random() * 10 + 1) + "■"
							+ (int)(Math.random() * 10 + 1) + "■"
							+ (int)(Math.random() * 10 + 1) + "■"
							+ (int)(Math.random() * 10 + 1) + "■"
							+ (int)(Math.random() * 10 + 1) + "\n";
			writer.append(line);
		}
	}


	private static void getOrderHistory(File file) throws IOException {
		
		List<String> roomNum = getRoomNumList();
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
		
		for (int i=0; i<150; i++) {
			
			System.out.println(getDummyName());
			
			String dummyLine = roomNum.get((int)(Math.random() * roomNum.size())) + "■"
								+ getDummyName() + "■"
								+ (int)(Math.random() * 7 + 1) + "■"
								+ "true\n";
			writer.append(dummyLine);
		}
		writer.close();
	}

	
	
	public static List<String> getRoomNumList() {
		
		File file = new File("D:\\Console Project\\데이터파일\\전체 방 목록.txt");
		List<String> RoomNum = new ArrayList<String>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			
			String line = null;
			while((line = reader.readLine()) != null) {
				String room = line.split("■")[0];
				RoomNum.add(room);
			}
			
			reader.close();	
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return RoomNum;
		
	}
	
	public static String getDummyName() {
		
		String[] A = {"김","박","양","고","어","남","최","류","신","박","이","장","노",
				"방","손","권","정","조","곽","윤","안","임","여","송","전",};//성씨
		
		String[] B = {"민","현","동","준","지","현","승","우","건","예","현","도","동"
				,"시","은","지","하","채","윤","민","서","지","수","하","희","유","영","정","광",
				"중","종","정","성","진","병","재","병","준","현",
				"승","옥","경","명","숙","화","순","미","혜","아","보","유","수","연","세","소",
				"주","규","석","종","덕","용"};//이름1
		
		String[] C = {"자","순","희","옥","경","숙","미","정","영","주","진",
				"름","혜","빈","원","은","지","수","환","호","식","웅","길","일","수","철",
				"훈","민","현","석","혁","연","서","빈","진","원","현","윤","원","아","준",
				"혁","재","우","준","재","태"};//이름2
		
		return A[(int)(Math.random() * A.length)]
				+ B[(int)(Math.random() * B.length)]
						+ C[(int)(Math.random() * C.length)];
		
	}
	
	public static String getDate() {
		
		String date = "";
		int year = (int)(Math.random() * 3 + 2018);
//		int year = 2020;
//		int month = (int)(Math.random() * 12 + 1);
		int month = (int)(Math.random() * 12) +1;
		int day = (int)(Math.random() * 28 + 1);
		
		date = String.format("%d-%d-%d", year, month, day);
		
		return date;
	}
	
}
