package com.neo.designPatterns.observer;

/**
 * @auther: wpy
 * @date: 2020/12/1
 * @dscription:
 */
public class MySubject extends AbstractSubject {

    @Override
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }

}
