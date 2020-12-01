package com.neo.designPatterns.templateMethod;

/**
 * @auther: wpy
 * @date: 2020/11/30
 * @dscription:
 */
public class StrategyTest {

    public static void main(String[] args) {
        String exp = "8+8";
        AbstractCalculator cal = new Plus();
        int result = cal.calculate(exp, "\\+");
        System.out.println(result);
    }
}
