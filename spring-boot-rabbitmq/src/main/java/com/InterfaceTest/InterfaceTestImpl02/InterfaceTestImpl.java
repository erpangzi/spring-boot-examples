package com.InterfaceTest.InterfaceTestImpl02;


import com.InterfaceTest.InterfaceTest;
import org.springframework.stereotype.Service;

@Service("interfaceTestImpl02")
class InterfaceTestImpl implements InterfaceTest {
    @Override
    public void method01() {
        System.out.println("这是方法实现InterfaceTest02");
    }
}
