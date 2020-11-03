package com.test.inheritance;

import java.util.Random;

public class MyRandom extends Random {
	
	//2. 
	public int nextSmallInt() {
		Random rnd = new Random();
		return rnd.nextInt(10) +1;
	}
	
	//3.
	public String nextColor() {
		Random rnd = new Random();
		String[] color = {"빨강", "노랑", "파랑", "흰색", "검정"};
		return color[rnd.nextInt(color.length)];
	}

}
