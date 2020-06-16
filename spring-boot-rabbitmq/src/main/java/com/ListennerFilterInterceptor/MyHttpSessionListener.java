package com.ListennerFilterInterceptor;

import javax.servlet.http.*;

public class MyHttpSessionListener implements HttpSessionListener , HttpSessionAttributeListener {

    public static int online = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("创建session");
        online ++;
    }
//    @Override
//    public void attributeAdded(HttpSessionBindingEvent se) {
//        System.out.println("添加attribute");
//        online ++;
//    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("销毁session");
        online --;
    }



}