package com.javase;

public class Book_static {
    private static int count = 0;
    public Book_static() {
        count++;
        System.out.println("这是第" + count + "个对象");
    }

    public static void main(String[] args) {
        new Book_static();
        new Book_static();
        new Book_static();
        new Book_static();
        new Book_static();
    }
}
