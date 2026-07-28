//4.Write a Java program to create a
//Book class and implement a copy constructor 
//that copies the details of one book object into another.


package com.java.basics;

public class Book {
	
	String name;
	int price;
	int offerPrice;
	
	
	Book(String name , int price){
		this.name = name;
		this.price = price;
	}
	
	Book(Book obj){
		this.name = obj.name;
		this.price = obj.price;
	}
	
	void display() {
		System.out.println("Book Name: "+name);
		System.out.println("Book Price: "+price);
		System.out.println();
	}
	public static void main(String [] args) {
		Book book1 = new Book("Fantacy Story",155);
		Book book2 = new Book(book1);
		book1.display();
		book2.display();
	}

}
