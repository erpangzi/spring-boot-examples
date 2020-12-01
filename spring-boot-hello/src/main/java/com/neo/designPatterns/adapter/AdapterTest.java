package com.neo.designPatterns.adapter;

/**
 * @Auther: wpy
 * @Date: 2020/11/27
 * @Description:
 */
public class AdapterTest {

    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }
}