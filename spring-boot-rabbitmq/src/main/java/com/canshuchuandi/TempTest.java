package com.canshuchuandi;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class TempTest {

    public static void main(String[] args) {
        TempTest t = new TempTest();
        A a = new A();
        a.age = 10;
        System.out.println("调用test1之前方法中的age="+a.age);
        t.test1(a);
        System.out.println("main方法中的age="+a.age);
        Integer integer = Integer.valueOf("1");
        int i = Integer.parseInt("1");

    }

    private void test1(A a){
        a.age = 20;
        System.out.println("test1方法中的age="+a.age);
    }

    @Test
    void test(){
        long l = 0;
    }

}
class A{
    public int age = 0;
}
