package com.InterfaceTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/test01")
public class TestInterface {
    @Qualifier("interfaceTestImpl02")
    @Autowired
    private InterfaceTestImpl02 interfaceTestImpl02;

    @PostMapping(value = "/test01")
    public void test01(){
        interfaceTestImpl02.method01();
    }

}
