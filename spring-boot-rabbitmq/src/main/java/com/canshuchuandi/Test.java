package com.canshuchuandi;

public class Test {

    public static void main(String[] args) {
        int a = 5;
        System.out.println("方法前：" + a);
        fun(a);
        System.out.println(a);// 输出结果为5
    }

    private static void fun(int a) {
        a += 1;
        System.out.println("方法中：" + a);
    }
}