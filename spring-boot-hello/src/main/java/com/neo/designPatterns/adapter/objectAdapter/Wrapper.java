package com.neo.designPatterns.adapter.objectAdapter;

import com.neo.designPatterns.adapter.Source;
import com.neo.designPatterns.adapter.Targetable;

/**
 * @Auther: wpy
 * @Date: 2020/11/27
 * @Description:
 */
public class Wrapper implements Targetable {

    private Source source;

    public Wrapper(Source source){
        super();
        this.source = source;
    }
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }

    @Override
    public void method1() {
        source.method1();
    }
}