package com.neo.designPatterns.strategy;

/**
 * @auther: wpy
 * @date: 2020/11/30
 * @dscription:
 */
public class StrategyTest {

    public static void main(String[] args) {
        String exp = "2+8";
        ICalculator cal = new Plus();
        int result = cal.calculate(exp);
        System.out.println(result);

        String exp1 = "8-2";
        ICalculator cal1 = new Minus();
        int result1 = cal1.calculate(exp1);
        System.out.println(result1);

        String exp2 = "8*2";
        ICalculator cal2 = new Multiply();
        int result2 = cal2.calculate(exp2);
        System.out.println(result2);
    }
}
