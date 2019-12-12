package com.canshuchuandi;

public class Test01 {

    public static void main(String[] args) {
        Integer a = 5;
        System.out.println("方法前：" + a);
        fun(a);
        System.out.println("方法后：" + a);// 输出结果为5
    }

    private static void fun(Integer a) {
        a += 1;
        System.out.println("方法中：" + a);
    }
}
