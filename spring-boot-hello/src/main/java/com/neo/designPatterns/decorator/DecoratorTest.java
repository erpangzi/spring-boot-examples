package com.neo.designPatterns.decorator;

/**
 * @auther: wpy
 * @date: 2020/11/30
 * @dscription:
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Sourceable source = new Source();
        Sourceable obj = new Decorator(source);
        obj.method();
    }
}
