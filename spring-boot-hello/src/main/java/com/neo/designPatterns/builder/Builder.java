package com.neo.designPatterns.builder;

import com.neo.designPatterns.abstractFactory.MailSender;
import com.neo.designPatterns.abstractFactory.Sender;
import com.neo.designPatterns.abstractFactory.SmsSender;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wpy
 * @Date: 2020/11/27
 * @Description:
 */
public class Builder {

    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count){
        for(int i=0; i<count; i++){
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count){
        for(int i=0; i<count; i++){
            list.add(new SmsSender());
        }
    }
}
