package com.Threads.Synchronized;

import org.junit.Test;

/**
 * 同步线程
 */
public class SyncThread implements Runnable {
    private static int count;

    public SyncThread() {
        count = 0;
    }

    public  void run() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(syncThread, "SyncThread1");
        Thread thread2 = new Thread(syncThread, "SyncThread2");
        thread1.start();
        thread2.start();
    }

//    @Test
//    public void test01(){
//        SyncThread syncThread = new SyncThread();
//        Thread thread1 = new Thread(syncThread, "SyncThread1");
//        Thread thread2 = new Thread(syncThread, "SyncThread2");
//        thread1.start();
//        thread2.start();
//    }
//
//    @Test
//    public void test02(){
//        Thread thread1 = new Thread(new SyncThread(), "SyncThread1");
//        Thread thread2 = new Thread(new SyncThread(), "SyncThread2");
//        thread1.start();
//        thread2.start();
//    }
//
//    @Test
//    public void test03(){
//        SyncThread syncThread1 = new SyncThread();
//        SyncThread syncThread2 = new SyncThread();
//        Thread thread1 = new Thread(syncThread1, "SyncThread1");
//        Thread thread2 = new Thread(syncThread2, "SyncThread2");
//        thread1.start();
//        thread2.start();
//    }


}
