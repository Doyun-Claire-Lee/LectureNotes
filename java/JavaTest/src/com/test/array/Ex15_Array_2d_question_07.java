package com.test.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Array_2d_question_07 {
	
	public static void main(String[] args) throws Exception {
		
		//성적을 입력받아 그래프로 나타내기
		
		score();
		
	}

	private static void score() throws Exception {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("국어 점수 : ");
		int kor = Integer.parseInt(reader.readLine());
		System.out.print("영어 점수 : ");
		int eng = Integer.parseInt(reader.readLine());
		System.out.print("수학 점수 : ");
		int math = Integer.parseInt(reader.readLine());
		
		
		String[][] score = new String[10][3];
		
		//일단 빈 문자열로 모두 채우기
		for (int i=0; i<score.length; i++) {
			for (int j=0; j<score[0].length; j++) {
				score[i][j] = "";
			}
		}
		
		//점수만큼 채우기
		for (int i=0; i<score[0].length; i++) {
			switch (i) {
				case 0 : 
					for (int j=score.length-1; j>= score.length-kor/10; j--) {
						score[j][i] = "■";
					}
					break;
				case 1 :
					for (int j=score.length-1; j>= score.length-eng/10; j--) {
						score[j][i] = "■";
					}
					break;
				case 2 :
					for (int j=score.length-1; j>= score.length-math/10; j--) {
						score[j][i] = "■";
					}
					break;
			}//switch 
		}//for
		
		// 출력
		for (int i=0; i<score.length; i++) {
			for (int j=0; j<score[0].length; j++) {
				System.out.printf("%6s\t", score[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("-------------------------");
		System.out.println("  [국어]   [영어]  [수학]");
	}

}
