package com.neo.designPatterns.abstractFactory;

/**
 * @Auther: wpy
 * @Date: 2020/11/27
 * @Description:
 */
public class MailSender implements Sender {

    @Override
    public void Send() {
        System.out.println("this is mailsender!");
    }

}
