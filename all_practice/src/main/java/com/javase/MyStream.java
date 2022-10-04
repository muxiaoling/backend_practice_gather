package com.javase;

import java.io.*;

public class MyStream {
    public static void main(String[] args) {
       // myFileOutputStream();
       // myFileInputStream();
        //myFileWriter();
        //myFileReader();
        myOutputStreamWriter();
    }

    //字节输出流
    public static void myFileOutputStream() {
        try {
            OutputStream outputStream = new FileOutputStream("D:\\IDEA_projects\\java-se\\java_practice\\stream.txt");
            String str = "今天学习";
            byte[] data = str.getBytes();
            System.out.println(data.length);
            for (byte a : data) {
                System.out.print(a);
            }
            outputStream.write(data);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //字节输入流
    public static void myFileInputStream() {
        try {
            InputStream inputStream = new FileInputStream("D:\\IDEA_projects\\java-se\\java_practice\\stream.txt");
            byte[] data = new byte[1024];
            int len = inputStream.read(data);
            System.out.println(new String(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //字符输出流
    public static void myFileWriter() {
        try {
            Writer out = new FileWriter("D:\\IDEA_projects\\java-se\\java_practice\\stream.txt");
            String str = "hello word！今天很适合学习。今天要好好努力学习！";
            out.write(str);
            //out.close();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //字符输入流
    public static void myFileReader() {
        try {
            Reader in = new FileReader("D:\\IDEA_projects\\java-se\\java_practice\\stream.txt");
            char[] data = new char[1024];
            in.read(data);
            System.out.println(new String(data));
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //转换流
    public static void myOutputStreamWriter() {
        try {
            OutputStream outputStream = new FileOutputStream("D:\\IDEA_projects\\java-se\\java_practice\\stream.txt");
            Writer out = new OutputStreamWriter(outputStream);
            out.write("你好，今天是周一");
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


