package com.neo.designPatterns.templateMethod;

/**
 * @auther: wpy
 * @date: 2020/11/30
 * @dscription:
 */
public class Plus extends AbstractCalculator {

    @Override
    public int calculate(int num1,int num2) {
        return num1 + num2;
    }
}
