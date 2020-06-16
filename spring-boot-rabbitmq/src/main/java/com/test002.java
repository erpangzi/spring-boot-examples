package com;

import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Component
public class test002 {

    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);

        Boolean aTrue = Boolean.valueOf("false");
        System.out.println(aTrue);

        String s = "true";
        String s1 = "12";

        Thread t1 = new Thread(new A());
        Thread t2 = new Thread(new A());
        t1.start();
        t2.start();


    }

    @Test
    public void listtest(){
        List<String> list01 = Arrays.asList("1","2","1","2","3");
        List arrList = new ArrayList(list01);

        Iterator<String> iterator = arrList.iterator();

        while(iterator.hasNext()){
            if(iterator.next().equals("1")){
                iterator.remove();
            }
        }

        arrList.forEach(System.out::println);
    }

    @Test
    public void  testInteger(){

        Integer integer1 = new Integer(10) ;
        Integer integer2 = new Integer(10) ;
        Integer integer3 = new Integer(200) ;
        Integer integer4 = new Integer(200) ;
        System.out.println(integer1.equals(integer2));
        System.out.println(integer3.equals(integer4));


        Integer t1 = 23;
        Integer t2 = 23;
        Integer t3 = 223;
        Integer t4 = 223;
        System.out.println(t1 == t2);// true
        System.out.println(t3 == t4);// false


        t1=t3;
        t3=300;
        System.out.println(t1);
        System.out.println(t3);

        Integer i = new Integer(1);
        Integer j = i;
        System.out.println(j);
        i = 2;
        System.out.println(j);
        System.out.println(i);
    }


    @Test
    public void Test() {

        Thread t1 = new Thread(new A());
        Thread t2 = new Thread(new A());
        t1.start();
        t2.start();

    }

    @Test
    public void Test01() {
        Long l = 0L ;
        if(l != 0L){
            System.out.println(111);
        }

    }

    static class A implements Runnable {
        static Integer a = 100;
        static int val = 0;

        @Override
        public void run() {
//            synchronized (a) {
                while (val < 100) {
                    val++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(val);
                }
//            }
        }
    }


    @Test
    public void Test02() {
        String s = "1";
        testString(s);
        System.out.println(s);
    }

    void testString(String s ){
        s = s +"被改变";
    }

}
