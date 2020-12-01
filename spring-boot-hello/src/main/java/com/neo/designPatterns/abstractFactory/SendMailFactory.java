package com.neo.designPatterns.abstractFactory;

/**
 * @Auther: wpy
 * @Date: 2020/11/27
 * @Description:
 */
public class SendMailFactory implements Provider {

    @Override
    public Sender produce(){
        return new MailSender();
    }
}
