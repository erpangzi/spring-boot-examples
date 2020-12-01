package com.neo.designPatterns.abstractFactory;

/**
 * @Auther: wpy
 * @Date: 2020/11/27
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Send();
    }
}