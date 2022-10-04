package com.javase;

public class MyStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("tang");
        String st = sb.toString();
        fun(sb);
        sb.delete(0, sb.length());
        sb.append(st);
        System.out.println(sb.toString());
    }

    public static void fun (StringBuilder sb) {
        sb.append("jh");
    }
}
