package com.neo.designPatterns.bridge;

/**
 * @auther: wpy
 * @date: 2020/11/30
 * @dscription:
 */
public class MyBridge extends Bridge {
    public void method(){
        getSource().method();
    }
}
