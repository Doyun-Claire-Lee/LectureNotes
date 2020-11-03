package com.test.object;

public class Packer {
	
	private static int pencilCount;
	private static int eraserCount;
	private static int ballPointPenCount;
	private static int rulerCount;
	
	public void packing(Pencil pencil) {
		
//		흑연 등급(4B, 3B, 2B, B, HB, H, 2H, 3H, 4H)
		
		if (pencil.getHardness().equals("4B")
			|| pencil.getHardness().equals("3B")
			|| pencil.getHardness().equals("2B")
			|| pencil.getHardness().equals("B")
			|| pencil.getHardness().equals("HB")
			|| pencil.getHardness().equals("H")
			|| pencil.getHardness().equals("2H")
			|| pencil.getHardness().equals("3H")
			|| pencil.getHardness().equals("4H")) {
			
			System.out.println("포장 전 검수 : " + pencil.info());
			System.out.println("포장을 완료했습니다.");
			Packer.setPencilCount(Packer.getPencilCount()+1);
			
		} else {
			System.out.println("포장 전 검수 : 잘못된 연필입니다.\n 포장을 하지 않습니다.");
		}
	}
	
	public void packing(Eraser eraser) {

//		지우개 크기(Large, Medium, Small)
		if (eraser.getSize().equals("Large")
			||eraser.getSize().equals("Medium")
			||eraser.getSize().equals("Small")) {
			
			System.out.println("포장 전 검수 : " + eraser.info());
			System.out.println("포장을 완료했습니다.");
			Packer.setEraserCount(Packer.getEraserCount()+1);
			
		} else {
			System.out.println("포장 전 검수 : 잘못된 지우개입니다.\n 포장을 하지 않습니다.");
		}
	}
	
	public void packing (BallPointPen ballpointpen) {
//		볼펜 심 두께(0.3mm, 0.5mm, 0.7mm, 1mm, 1.5mm)
//		color
//		볼펜 색상(red, blue, green, black)
		
		if ((ballpointpen.getThickness() == 0.3
			|| ballpointpen.getThickness() == 0.5
			|| ballpointpen.getThickness() == 0.7
			|| ballpointpen.getThickness() == 1
			|| ballpointpen.getThickness() == 1.5)
			&& (ballpointpen.getColor().equals("red")
				|| ballpointpen.getColor().equals("blue")
				|| ballpointpen.getColor().equals("green")
				|| ballpointpen.getColor().equals("black"))) {
			
			System.out.println("포장 전 검수 : " + ballpointpen.info());
			System.out.println("포장을 완료했습니다.");
			Packer.setBallPointPenCount(Packer.getBallPointPenCount()+1);
			
		} else {
			System.out.println("포장 전 검수 : 잘못된 볼펜입니다.\n 포장을 하지 않습니다.");
		}
	}
	
	public void packing (Ruler ruler) {
//		length
//		자 길이(30cm, 50cm, 100cm)
//		shape
//		자 형태(줄자, 운형자, 삼각자)
		
		if ((ruler.getLength() == 30 
			|| ruler.getLength() == 50
			|| ruler.getLength() == 100)
			&& (ruler.getShape().equals("줄자"))
				|| ruler.getShape().equals("운형자")
				|| ruler.getShape().equals("삼각자")) {
			
			System.out.println("포장 전 검수 : " + ruler.info());
			System.out.println("포장을 완료했습니다.");
			Packer.setRulerCount(Packer.getRulerCount()+1);
			
		} else {
			System.out.println("포장 전 검수 : 잘못된 자입니다.\n 포장을 하지 않습니다.");
		}
	}
	
	public void countPacking(int type) {

//		int type : 출력할 내용물의 종류
//		0 : 모든 내용물
//		1 : 연필
//		2 : 지우개
//		3 : 볼펜
//		4 : 자

		System.out.println("=====================");
		System.out.println("      포장 결과      ");
		System.out.println("=====================");
		
		if (type == 0) {
			System.out.printf("연필 %d회\n", Packer.pencilCount);
			System.out.printf("지우개 %d회\n", Packer.eraserCount);
			System.out.printf("볼펜 %d회\n", Packer.ballPointPenCount);
			System.out.printf("자 %d회\n", Packer.rulerCount);		
		} else if (type == 1) {
			System.out.printf("연필 %d회\n", Packer.pencilCount);
		} else if (type == 2) {
			System.out.printf("지우개 %d회\n", Packer.eraserCount);
		} else if (type == 3) {
			System.out.printf("볼펜 %d회\n", Packer.ballPointPenCount);
		} else if (type == 4) {
			System.out.printf("자 %d회\n", Packer.rulerCount);
		} else {
			System.out.println("잘못된 번호입니다. 다시 입력하세요.\n");
		}
	}

	public static int getPencilCount() {
		return pencilCount;
	}

	public static void setPencilCount(int pencilCount) {
		Packer.pencilCount = pencilCount;
	}

	public static int getEraserCount() {
		return eraserCount;
	}

	public static void setEraserCount(int eraserCount) {
		Packer.eraserCount = eraserCount;
	}

	public static int getBallPointPenCount() {
		return ballPointPenCount;
	}

	public static void setBallPointPenCount(int ballPointPenCount) {
		Packer.ballPointPenCount = ballPointPenCount;
	}

	public static int getRulerCount() {
		return rulerCount;
	}

	public static void setRulerCount(int rulerCount) {
		Packer.rulerCount = rulerCount;
	}


}
