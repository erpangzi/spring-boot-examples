package com.neo.designPatterns.bridge;

/**
 * @auther: wpy
 * @date: 2020/11/30
 * @dscription:
 */
public class SourceSub1 implements Sourceable {

    @Override
    public void method() {
        System.out.println("this is the first sub!");
    }
}
