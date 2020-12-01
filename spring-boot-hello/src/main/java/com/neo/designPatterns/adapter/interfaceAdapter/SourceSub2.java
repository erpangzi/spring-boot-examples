package com.neo.designPatterns.adapter.interfaceAdapter;

/**
 * @Auther: wpy
 * @Date: 2020/11/27
 * @Description:
 */
public class SourceSub2 extends Wrapper2 {
    @Override
    public void method2(){
        System.out.println("the sourceable interface's second Sub2!");
    }
}
