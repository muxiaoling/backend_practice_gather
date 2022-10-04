package com.javase;

import java.util.List;

public class MyEnum {
    public static void main(String[] args) {
        Color c = Color.RED;
        System.out.println(c.ordinal());
        System.out.println(c.name());

    }
}

enum Color {
    RED, GREEN, BLUE;
}