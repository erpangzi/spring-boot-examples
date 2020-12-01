package com.neo.designPatterns.observer;

/**
 * @auther: wpy
 * @date: 2020/12/1
 * @dscription:
 */
public class Observer1 implements Observer {

    @Override
    public void update() {
        System.out.println("observer1 has received!");
    }
}
