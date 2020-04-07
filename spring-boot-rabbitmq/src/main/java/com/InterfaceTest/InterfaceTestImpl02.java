package com.InterfaceTest;


import org.springframework.stereotype.Service;

@Service("interfaceTestImpl02")
public class InterfaceTestImpl02 implements InterfaceTest {
    @Override
    public void method01() {
        System.out.println("这是方法实现InterfaceTest02");
    }
}
