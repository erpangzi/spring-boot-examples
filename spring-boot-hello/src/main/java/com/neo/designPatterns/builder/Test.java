package com.neo.designPatterns.builder;

/**
 * @Auther: wpy
 * @Date: 2020/11/27
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);

    }
}
