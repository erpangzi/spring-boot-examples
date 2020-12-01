package com.neo.designPatterns.singleton;

import com.neo.designPatterns.abstractFactory.MailSender;
import org.junit.jupiter.api.Test;

/**
 * @Auther: wpy
 * @Date: 2020/11/27
 * @Description:
 */
public class Singleton {

    private static Singleton singleton;

    public Singleton() {
    }
    /**
    双检锁，又叫双重校验锁，综合了懒汉式和饿汉式两者的优缺点整合而成。看上面代码实现中，
    特点是在synchronized关键字内外都加了一层 if 条件判断，这样既保证了线程安全，又比直接上锁提高了执行效率，还节省了内存空间。
     */
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    @Test
    public void test(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Singleton.getSingleton().hashCode());
            System.out.println(new MailSender().hashCode());
        }

    }


}
