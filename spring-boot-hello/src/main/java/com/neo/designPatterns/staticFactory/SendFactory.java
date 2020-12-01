package com.neo.designPatterns.staticFactory;

import com.neo.designPatterns.abstractFactory.MailSender;
import com.neo.designPatterns.abstractFactory.Sender;
import com.neo.designPatterns.abstractFactory.SmsSender;

/**
 * @Auther: wpy
 * @Date: 2020/11/28
 * @Description:
 */
public class SendFactory {

    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }
}
