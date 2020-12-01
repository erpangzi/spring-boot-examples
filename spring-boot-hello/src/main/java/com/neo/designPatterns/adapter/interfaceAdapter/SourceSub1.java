package com.neo.designPatterns.adapter.interfaceAdapter;

/**
 * @author 王鹏宇
 * @Auther: wpy
 * @Date: 2020/11/27
 * @Description:
 */
public class SourceSub1 extends Wrapper2 {
    @Override
    public void method1(){
        System.out.println("the sourceable interface's first Sub1!");
    }
}
