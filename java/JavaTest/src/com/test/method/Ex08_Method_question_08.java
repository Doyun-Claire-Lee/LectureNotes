package com.test.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Method_question_08 {
	
	public static void main(String[] args) throws Exception {
		//지하철 탑승 소요시간
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("역의 개수 : ");
		String station = reader.readLine();
		System.out.print("환승역의 횟수 : ");
		String transfer = reader.readLine();
		
		
		int istation = Integer.parseInt(station);
		int itransfer = Integer.parseInt(transfer);
		
		int time = getTime(istation, itransfer);
		
		System.out.printf("총 소요 시간은 %d분입니다.", time);
			
		
	}
	
	public static int getTime(int station, int transfer) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시간대(평상, 출근, 퇴근) : ");
		String time = reader.readLine();
		
		return time.equals("평상") ? (station * 2) + (transfer * 3) 
				: time.equals("출근") ? (station * 2) + (transfer * 4) 
				: time.equals("퇴근") ? (station * 2) + (transfer * 5) : 0;
			
	}

}
