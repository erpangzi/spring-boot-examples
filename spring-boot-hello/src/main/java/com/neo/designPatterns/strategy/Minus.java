package com.neo.designPatterns.strategy;

/**
 * @auther: wpy
 * @date: 2020/11/30
 * @dscription:
 */
public class Minus extends AbstractCalculator implements ICalculator {

    @Override
    public int calculate(String exp) {
        int arrayInt[] = split(exp,"-");
        return arrayInt[0]-arrayInt[1];
    }

}
