package com.test.object;

public class Coffee {
	
	private static int bean;
	private static int water;
	private static int ice;
	private static int milk;
	
	private static int beanUnitprice = 1;
	private static double waterUnitPrice = 0.2;
	private static int iceUnitPrice = 3;
	private static int milkUnitPrice = 4;
	
	private static int beanTotalPrice;
	private static int waterTotalPrice;
	private static int iceTotalPrice;
	private static int milkTotalPrice;
	
	private static int americano;
	private static int latte;
	private static int espresso;
	
	
	public static int getBean() {
		return bean;
	}
	public static void setBean(int bean) {
		Coffee.bean = bean;
	}
	public static int getWater() {
		return water;
	}
	public static void setWater(int water) {
		Coffee.water = water;
	}
	public static int getIce() {
		return ice;
	}
	public static void setIce(int ice) {
		Coffee.ice = ice;
	}
	public static int getMilk() {
		return milk;
	}
	public static void setMilk(int milk) {
		Coffee.milk = milk;
	}
	
	
	public static int getBeanUnitPrice() {
		return beanUnitprice;
	}
	public static double getWaterUnitPrice() {
		return waterUnitPrice;
	}
	public static int getIceUnitPrice() {
		return iceUnitPrice;
	}
	public static int getMilkUnitPrice() {
		return milkUnitPrice;
	}

	
	public static int getBeanTotalPrice() {
		return beanTotalPrice;
	}
	public static void setBeanTotalPrice(int beanTotalPrice) {
		Coffee.beanTotalPrice = beanTotalPrice;
	}
	public static int getWaterTotalPrice() {
		return waterTotalPrice;
	}
	public static void setWaterTotalPrice(double d) {
		Coffee.waterTotalPrice = (int)d;
	}
	public static int getIceTotalPrice() {
		return iceTotalPrice;
	}
	public static void setIceTotalPrice(int iceTotalPrice) {
		Coffee.iceTotalPrice = iceTotalPrice;
	}
	public static int getMilkTotalPrice() {
		return milkTotalPrice;
	}
	public static void setMilkTotalPrice(int milkTotalPrice) {
		Coffee.milkTotalPrice = milkTotalPrice;
	}
	
	
	public static int getAmericano() {
		return americano;
	}
	public static void setAmericano(int americano) {
		Coffee.americano = americano;
	}
	public static int getLatte() {
		return latte;
	}
	public static void setLatte(int latte) {
		Coffee.latte = latte;
	}
	public static int getEspresso() {
		return espresso;
	}
	public static void setEspresso(int espresso) {
		Coffee.espresso = espresso;
	}
	


}
