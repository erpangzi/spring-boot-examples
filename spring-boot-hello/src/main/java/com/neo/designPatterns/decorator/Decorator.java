package com.neo.designPatterns.decorator;

/**
 * @auther: wpy
 * @date: 2020/11/30
 * @dscription:
 */
public class Decorator implements Sourceable {

    private Sourceable source;

    public Decorator(Sourceable source){
        super();
        this.source = source;
    }
    @Override
    public void method() {
        System.out.println("before decorator!");
        source.method();
        System.out.println("after decorator!");
    }
}
