package com.neo.designPatterns.facade;

/**
 * @auther: wpy
 * @date: 2020/11/30
 * @dscription:
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}
