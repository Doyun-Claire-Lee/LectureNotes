package com.test.object;

public class Student {
	
//	name
//	이름
//	age
//	나이
//	grade
//	학년
//	classNumber
//	반
//	number
//	번호
//	static school
//	학교. 모두 '역삼 중학교' 재학
	
	private String name;
	private int age;
	private int grade;
	private int classNumber;
	private int number;
	private static String school;
	
	
	static {
		Student.school = "역삼중학교";
	}
	
	public Student() {
		this("미정", 0, 0, 0, 0);
	}
	
	public Student(String name, int age, int grade, int classNumber, int number) {
		
		if (name.length() >=2 && name.length() <=5) {
			this.name = name;
		}
		if (age >= 0 && age < 20) {
			this.age = age;
		}
		if (grade >= 0 && grade <= 3) {
			this.grade = grade;
		}
		if (classNumber >= 0 && classNumber < 20 ) {
			this.classNumber = classNumber;
		}
		if (number >= 0 && number < 50) {
			this.number = number;		
		}
	}
	
	public Student (String name, int age) {
		this(name, age, 0, 0, 0);
	}
	
	public Student (int grade, int classNumber, int number) {
			this("미정", 0, grade, classNumber, number);
	}
	
	
	public String info() {
		return String.format("%s(나이 : %s, 학년 : %s, 반 : %s, 번호 : %s)"
								, this.name
								, this.age == 0 ? "미정" : age+"세"
								, this.grade == 0 ? "미정" : grade+""
								, this.classNumber == 0 ? "미정" : classNumber+""
								, this.number == 0 ? "미정" : number+"");
	}
	
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public static String getSchool() {
		return school;
	}
	public static void setSchool(String school) {
		Student.school = school;
	}
	
}
