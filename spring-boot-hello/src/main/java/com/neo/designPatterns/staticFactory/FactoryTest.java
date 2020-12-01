package com.neo.designPatterns.staticFactory;

import com.neo.designPatterns.abstractFactory.Sender;

/**
 * @Auther: wpy
 * @Date: 2020/11/28
 * @Description:
 */
public class FactoryTest {

    public static void main(String[] args) {
        Sender sender = SendFactory.produceMail();
        sender.Send();
    }
}
