package com.InterfaceTest;

import org.springframework.stereotype.Service;

@Service("interfaceTestImpl01")
public class InterfaceTestImpl01 implements InterfaceTest {
    @Override
    public void method01() {
        System.out.println("这是方法实现InterfaceTestImpl01");
    }
}
