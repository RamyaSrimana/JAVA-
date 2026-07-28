//3.Write a Java program for a College class
//where all students share the same college name using a static variable.


package com.java.basics;

public class College {
	static String college = "Kongu College";
	String name;
	int roll_no ;
	
	College(String name,int roll){
		this.name = name;
		this.roll_no = roll;
	}
	
	void display() {
		System.out.println("Student Name: "+name);
		System.out.println("Student RollNo: "+roll_no);
		System.out.println("Student College: "+College.college);
		System.out.println();
		
	}

	public static void main(String[] args) {
		College student1 = new College("Ramya",45);
		College student2 = new College("Mehala",33);
		College student3 = new College("Keerthi",27);
		student1.display();
		student2.display();
		student3.display();
	}

}
