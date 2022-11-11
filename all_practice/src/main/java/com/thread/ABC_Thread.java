package com.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//三线程交替打印ABC
public class ABC_Thread {
    private static Lock lock = new ReentrantLock();
    private static int state = 0;
    static class MyThread extends Thread {
        private String word;
        private int num;
        public MyThread(String word, int num) {
            this.word = word;
            this.num = num;
        }
        @Override
        public void run() {
            try {
                lock.lock();
                for(int i = 0; i < 10; i++) {
                    while(state == num) {
                        System.out.print(word);
                        state = (state + 1) % 3;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
    public static void main(String[] args) {
        new MyThread("A", 0).start();
        new MyThread("B", 1).start();
        new MyThread("C", 2).start();
    }
}
