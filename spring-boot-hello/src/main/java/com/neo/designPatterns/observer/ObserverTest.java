package com.neo.designPatterns.observer;

/**
 * @auther: wpy
 * @date: 2020/12/1
 * @dscription:
 */
public class ObserverTest {

    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());

        sub.operation();
    }

}
