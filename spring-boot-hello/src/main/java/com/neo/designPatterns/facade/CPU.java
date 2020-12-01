package com.neo.designPatterns.facade;

/**
 * @auther: wpy
 * @date: 2020/11/30
 * @dscription:
 */
public class CPU {

    public void startup(){
        System.out.println("cpu startup!");
    }

    public void shutdown(){
        System.out.println("cpu shutdown!");
    }
}
