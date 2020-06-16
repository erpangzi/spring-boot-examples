package com.Threads;

public class TestSynchronized implements Runnable {

    public  synchronized void get() {
        System.out.println("name:" + Thread.currentThread().getName() + " get();");
        set();
    }

    public synchronized  void set() {
        System.out.println("name:" + Thread.currentThread().getName() + " set();");
    }

    @Override

    public void run() {
        get();
    }

    public static void main(String[] args) {
        TestSynchronized ss = new TestSynchronized();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
    }

}
