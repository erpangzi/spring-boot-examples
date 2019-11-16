package com.canshuchuandi;

import org.apache.commons.lang3.StringUtils;

public class TempTest {
    private void test1(A a){
        a.age = 20;
        System.out.println("test1方法中的age="+a.age);
    }
    public static void main(String[] args) {
        TempTest t = new TempTest();
        A a = new A();
        a.age = 10;
        t.test1(a);
        System.out.println("main方法中的age="+a.age);
        Integer integer = Integer.valueOf("1");
        Integer.parseInt("1");

    }
}
class A{
    public int age = 0;
}
