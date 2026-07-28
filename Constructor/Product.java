package com.java.basics;
public class Product{
    String name;
    int id;
    int price;
    Product() {
        System.out.println("No Argument Constructor");
    }
    Product(String name) {
        this.name = name;
    }
    Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    void display() {
        System.out.println("Product Name: " + name);
        System.out.println("Product ID: " + id);
        System.out.println("Product Price: " + price);
        System.out.println();
    }
    public static void main(String[] args) {
        Product obj = new Product();
        Product obj1 = new Product("Pencil");
        Product obj2 = new Product(1234, "Pen", 10);
        obj1.display();
        obj2.display();
    }
}