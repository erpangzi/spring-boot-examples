package com.neo.designPatterns.decorator;



/**
 * @auther: wpy
 * @date: 2020/11/30
 * @dscription:
 */
public class Source implements Sourceable {

    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
