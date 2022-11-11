package com.tang.first;

/**
 * @author muxiaoling
 * @date 2022/11/3 20:46
 */
public class StudyVolatile {
    private static  int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                count++;
                //System.out.println(count);
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
