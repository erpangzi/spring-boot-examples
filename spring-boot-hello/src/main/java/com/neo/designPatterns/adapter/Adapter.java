package com.neo.designPatterns.adapter;

/**
 * @Auther: wpy
 * @Date: 2020/11/27
 * @Description:
 */
public class Adapter extends Source implements Targetable {

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}