package com.test.etc;

public class Ex36_Process {
	
	public static void main(String[] args) throws Exception { //**주의
		
		//외부 프로세스(프로그램) 호출
//		Process p1 = new ProcessBuilder("notepad.exe").start(); //앞에 변수는 필요없는 경우 안만들어도 됨.
		
//		new ProcessBuilder("mspaint.exe").start();
//		new ProcessBuilder("explorer.exe").start();
		
		//환경변수 path에 등록이 되어 있어야 이름만으로 불러올 수 있음.
		
//		new ProcessBuilder("‪C:\Program Files (x86)\Naver\Naver Whale\Application\2.7.98.24\whale.exe").start();
		
//		new ProcessBuilder("notepad.exe","D:\\class\\java\\JavaTest\\src\\com\\test\\io\\Ex35_Scanner_basic.java").start();
		
		new ProcessBuilder("C:\\Program Files (x86)\\Naver\\Naver Whale\\Application\\2.7.98.24\\whale.exe","http://naver.com").start();
		
		System.out.println("종료");
		
		
	}

}
