package com.design;

//双重检验锁单例
public class Singleton {
    private volatile static Singleton instance;
    private Singleton(){
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
