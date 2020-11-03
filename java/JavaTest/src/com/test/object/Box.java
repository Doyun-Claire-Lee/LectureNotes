package com.test.object;

public class Box {
	
	//	Macaron 객체의 정보
	//	생산 크기(5cm ~ 15cm) → 판매 유효 크기(8cm ~ 14cm)
	//	생산 색상(red, blue, yellow, white, pink, purple, green, black) → 판매 유효 색상(black을 제외한 모든 색상)
	//	생산 샌드 두께(1mm ~ 20mm) → 판매 유효 두께(3mm ~ 18mm)
	
    private Macaron[] list = new Macaron[10];

    public void cook() {
    	
    	String s[] = { "red", "blue", "yellow", "white", "pink", "purple", "green", "black" };
    	
    	int count= 0;
    	for(int i=0; i<list.length; i++) {
    		
    		list[i] = new Macaron();
    		list[i].setSize((int)(Math.random() * 11) + 5);  	
    		list[i].setColor(s[(int)(Math.random()*s.length)]);
    		list[i].setThickness((int)(Math.random() * 20) + 1);

    		count++;
    	}
    	System.out.printf("마카롱을 %d개 만들었습니다.\n", count);
    }
    public void check() {
    	
    	int count = 0;
    	
    	for(int i=0; i<list.length; i++) {
    		if (checkMacaron(i)) {
    			count++;
    		}
    	}
    	System.out.println("[박스 체크 결과]");
    	System.out.printf("QC 합격 개수 : %d개\n", count);
    	System.out.printf("QC 불합격 개수 : %d개\n", list.length - count);
    }
	private boolean checkMacaron(int i) {
		
		if ((list[i].getSize() < 8 || list[i].getSize() >14)
				|| list[i].getColor().equals("black")
				|| (list[i].getThickness() < 3 || list[i].getThickness() > 18)) {
				return false;
			} else {
				return true;
			}
	}
    
    public void list() {
    	System.out.println("[마카롱 목록]");
    	for (int i=0; i<list.length; i++) {
    		System.out.printf("%2d번 마카롱 : %2dcm (%-6s, %2dmm) : %s\n"
    							, i+1
    							, list[i].getSize()
    							, list[i].getColor()
    							, list[i].getThickness()
    							, checkMacaron(i) ? "합격" : "불합격");
    	}
    }
    
    

}
