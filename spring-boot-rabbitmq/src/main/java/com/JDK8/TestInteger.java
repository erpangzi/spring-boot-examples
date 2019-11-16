package com.JDK8;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class TestInteger {

    public static void main(String[] args) {
        Integer a = 127;

        Integer b = 127;

        Integer c = 128;

        Integer d = 128;

        Integer e = new Integer(127);

        Integer f = new Integer(127);

        System.out.println(a == b);//true
        System.out.println(c == d);//false
        System.out.println(a == e);//false
        System.out.println(e == f);//false

        List<String> list = new ArrayList<>();
        list.add("1");list.add("2");list.add("3");
        System.out.println(list.toString());
        System.out.println(StringUtils.join(list,",",1,list.size()));

        System.out.println(Integer.parseInt("1"));

    }

}
