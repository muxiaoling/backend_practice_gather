package com.javase;

import java.util.HashSet;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i >= -100; i--) {
            set.add(i);
        }
        for (int i : set) {
            System.out.print(i + "  ");
        }
    }
}
