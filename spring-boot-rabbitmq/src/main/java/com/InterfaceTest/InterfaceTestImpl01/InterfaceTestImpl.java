package com.InterfaceTest.InterfaceTestImpl01;

import com.InterfaceTest.InterfaceTest;
import org.springframework.stereotype.Service;

@Service("interfaceTestImpl01")
public class InterfaceTestImpl implements InterfaceTest {
    @Override
    public void method01() {
        System.out.println("这是方法实现InterfaceTestImpl01");
    }
}
