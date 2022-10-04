package com.javase;

import java.io.File;
import java.io.IOException;

public class MyFile {
    public static void main(String[] args) {
        File file = new File("f:" + File.separator + "io_java" + File.separator + "tangjinghao.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class TestFile {
    static int num = 0;
    public static void main(String[] args) {
        File file = new File("f:" + File.separator);
        print(file);
        System.out.println(num);
    }
    public static void print(File file) {
        if (file.isDirectory()) {
            File result[] = file.listFiles();
            if (result != null) {
                for (File f : result) {
                    print(f);
                }
            }
        }
        num++;
        System.out.println(file);
    }
}
