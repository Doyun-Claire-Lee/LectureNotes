package com.test.object;

public class Barista {
	
//	Espresso makeEspresso(int bean)
//	에스프레소 1잔을 만든다.
//	int bean : 원두량(g)
//	return Espreeso : 에스프레소 1잔
//	Espresso[] makeEspressoes(int bean, int count)
//	에스프레소 N잔을 만든다.
//	int bean : 원두량(g)
//	int count : 음료 개수(잔)
//	return Espresso[] : 에스프레소 N잔
	
	public Espresso makeEspresso(int bean) {
		
		Espresso espresso = new Espresso();
		espresso.setBean(bean);
		
		Coffee.setBean(Coffee.getBean() + bean);
		Coffee.setEspresso(Coffee.getEspresso() + 1);
		Coffee.setBeanTotalPrice(Coffee.getBeanTotalPrice() + Coffee.getBeanUnitPrice() * bean);
		
		return espresso;
		
	}
	
	public Espresso[] makeEspressoes(int bean, int count) {
		
		Espresso[] espressoes = new Espresso[count];
		
		for (int i=0; i<espressoes.length; i++) {
			
			espressoes[i] = new Espresso();
			espressoes[i].setBean(bean);
		}
		
		Coffee.setBean(Coffee.getBean() + bean * count);
		Coffee.setBeanTotalPrice(Coffee.getBeanTotalPrice() + Coffee.getBeanUnitPrice() * bean * count);
		Coffee.setEspresso(Coffee.getEspresso() + count);
		
		return espressoes;
	}
	
	
//	Latte makeLatte(int bean, int milk)
//	라테 1잔을 만든다.
//	int baen : 원두량(g)
//	int milk : 우유량(ml)
//	return Latte : 라테 1잔
//	Latte[] makeLattes(int bean, int milk, int count)
//	라테 N잔을 만든다.
//	int baen : 원두량(g)
//	int milk : 우유량(ml)
//	int count : 음료 개수(잔)
//	return Latte[] : 라테 N잔
	
	public Latte makeLatte(int bean, int milk) {
		
		Latte latte = new Latte();
		latte.setBean(bean);
		latte.setMilk(milk);
		
		Coffee.setBean(Coffee.getBean() + bean);
		Coffee.setMilk(Coffee.getMilk() + milk);
		Coffee.setBeanTotalPrice(Coffee.getBeanTotalPrice() + Coffee.getBeanUnitPrice() * bean);
		Coffee.setMilkTotalPrice(Coffee.getMilkTotalPrice() + Coffee.getMilkUnitPrice() * milk);
		Coffee.setLatte(Coffee.getLatte() + 1);
		
		return latte;
	}
	
	public Latte[] makeLattes(int bean, int milk, int count) {
		
		Latte[] lattes = new Latte[count];
		
		for (int i=0; i<lattes.length; i++) {
			
			lattes[i] = new Latte();
			lattes[i].setBean(bean);
			lattes[i].setMilk(milk);
		}
		
		Coffee.setBean(Coffee.getBean() + bean * count);
		Coffee.setMilk(Coffee.getMilk() + milk * count);
		Coffee.setBeanTotalPrice(Coffee.getBeanTotalPrice() + Coffee.getBeanUnitPrice() * bean * count);
		Coffee.setMilkTotalPrice(Coffee.getMilkTotalPrice() + Coffee.getMilkUnitPrice() * milk * count);
		Coffee.setLatte(Coffee.getLatte() + count);
		
		return lattes;
	}
	
//	Americano makeAmericano(int bean, int water, int ice)
//	아메리카노 1잔을 만든다.
//	int baen : 원두량(g)
//	int water : 물량(ml)
//	int ice : 얼음 개수(개)
//	return Americano : 아메리카노 1잔
//	Americano[] makeAmericanos(int bean, int water, int ice, int count)
//	아메리카노 N잔을 만든다.
//	int baen : 원두량(g)
//	int water : 물량(ml)
//	int ice : 얼음 개수(개)
//	int count : 음료 개수(잔)
//	return Americano[] : 아메리카노 N잔
	
	public Americano makeAmericano(int bean, int water, int ice) {
		
		Americano americano = new Americano();
		
		americano.setBean(bean);
		americano.setWater(water);
		americano.setIce(ice);
		
		Coffee.setBean(Coffee.getBean() + bean);
		Coffee.setWater(Coffee.getWater() + water);
		Coffee.setIce(Coffee.getIce() + ice);
		Coffee.setBeanTotalPrice(Coffee.getBeanTotalPrice() + Coffee.getBeanUnitPrice() * bean);
		Coffee.setWaterTotalPrice(Coffee.getWaterTotalPrice() + Coffee.getWaterUnitPrice() * water);
		Coffee.setIceTotalPrice(Coffee.getIceTotalPrice() + Coffee.getIceUnitPrice() * ice);
		Coffee.setAmericano(Coffee.getAmericano() + 1);
		
		return americano;
	}
	
	public Americano[] makeAmericanos(int bean, int water, int ice, int count) {
		
		Americano[] americanos = new Americano[count];
		
		for (int i=0; i<americanos.length; i++) {
			americanos[i] = new Americano();
			americanos[i].setBean(bean);
			americanos[i].setIce(ice);
			americanos[i].setWater(water);
		}
		Coffee.setBean(Coffee.getBean() + bean * count);
		Coffee.setWater(Coffee.getWater() + water * count);
		Coffee.setIce(Coffee.getIce() + ice * count);
		Coffee.setBeanTotalPrice(Coffee.getBeanTotalPrice() + Coffee.getBeanUnitPrice() * bean * count);
		Coffee.setWaterTotalPrice(Coffee.getWaterTotalPrice() + Coffee.getWaterUnitPrice() * water * count);
		Coffee.setIceTotalPrice(Coffee.getIceTotalPrice() + Coffee.getIceUnitPrice() * ice * count);
		Coffee.setAmericano(Coffee.getAmericano() + count);
		
		return americanos;
	}
	
//	void result()
//	판매 결과를 출력한다.
//	음료 판매량(에스프레소 판매 개수, 라테 판매 개수, 아메리카노 판매 개수)
//	원자재 소비량(원두 소비량, 물 소비량, 우유 소비량, 얼음 소비량)
//	매출액(원두 판매액, 물 판매액, 우유 판매액, 얼음 판매액)
	
	public void result() {
		
		System.out.println("=============================");
		System.out.println("          판매 결과          ");
		System.out.println("=============================");
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("음료 판매량");
		System.out.println("-----------------------------");
		System.out.printf("에스프레소 : %d잔\n", Coffee.getEspresso());
		System.out.printf("아메리카노 : %d잔\n", Coffee.getAmericano());
		System.out.printf("라테 : %d잔\n", Coffee.getLatte());
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("원자재 소비량");
		System.out.println("-----------------------------");
		System.out.printf("원두 : %,dg\n", Coffee.getBean());
		System.out.printf("물 : %,dml\n", Coffee.getWater());
		System.out.printf("얼음 : %,d개\n", Coffee.getIce());
		System.out.printf("우유 : %,dml\n", Coffee.getMilk());
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("매출액");
		System.out.println("-----------------------------");
		System.out.printf("원두 : %,d원\n", Coffee.getBeanTotalPrice());
		System.out.printf("물 : %,d원\n", Coffee.getWaterTotalPrice());
		System.out.printf("얼음 : %,d원\n", Coffee.getIceTotalPrice());
		System.out.printf("우유 : %,d원\n", Coffee.getMilkTotalPrice());
		
	}


}
