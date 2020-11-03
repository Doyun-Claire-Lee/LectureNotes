package com.test.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex15_Array_2d_question_09 {
	
	public static void main(String[] args) throws Exception {
		
		//달팽이 모양 2차원 배열 만들기
		
		snail();
	
	}

	private static void snail() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행의 개수 : ");
		int row = Integer.parseInt(reader.readLine());
		System.out.print("열의 개수 : ");
		int column = Integer.parseInt(reader.readLine());
		
		int htimes = column;	// 내부 for문을 몇 번 돌릴지(수평으로몇 칸 이동할 지) 결정하는 요소
		int vtimes = row-1;	// 내부 for문을 몇 번 돌릴지(수직으로 몇 칸 이동할 지) 결정하는 요소
		int r = 0;		// 행(시작점 : 0)
		int c = 0;		// 열(시작점 : 0)
		
		int num = 1;	// 배열에 집어넣을 숫자(누적값)
		
		int[][] array = new int[row][column];
		
		for (int i=0
				; i< (row > column ? column : row)*2 -1		// 행, 열 중 작은 숫자에 x2를 한 값에서 - 1 만큼 진행됨.
				; i++) {
			
			switch (i % 4) {
				case 0 :		//오른쪽으로 진행
					for (int j=0; j<htimes; j++) {
						array[r][c] = num;
						num++;
						c++;	//for문이 돌때마다 한칸씩 오른쪽으로 가야 함.
					}
					c--; 		//마지막 for문이 돌 때 c값이 증가되어 배열 범위를 벗어나므로 다시 감소시켜줌.
					r++;		//밑으로 한 칸 가야 하므로 증가시켜줌.
					htimes--;	//다음 케이스(아래방향으로 진행)시에는 한번 덜 가야하므로 감소시켜줌.
					
					break;
				
				case 1 :		//아래쪽으로 진행
					for (int j=0; j<vtimes; j++) {
						array[r][c] = num;
						num++;
						r++; 	//for문이 돌때마다 한칸씩 밑으로 가야 함.
					}
					r--;
					c--; //다음 방향(왼쪽으로) 가야하므로 한칸 옮겨줌.
					vtimes--;
					
					break;
					
				case 2 : 		//왼쪽으로 진행
					for (int j=0; j<htimes; j++) {
						array[r][c] = num;
						num++;
						c--;
					}
					c++;
					r--;
					htimes--;
					
					break;
					
				case 3 : 		//위로 진행 
					for (int j=0; j<vtimes; j++) {
						array[r][c] = num;
						num++;
						r--;
					}
					r++;
					c++;
					vtimes--;
					
					break;						
			}//switch
		}//for
		
		for (int i=0; i<array.length; i++) {
			for (int j=0; j<array[0].length; j++) {
				System.out.printf("%3d", array[i][j]);
			}
			System.out.println();
		}
	}
	
	
}
