package com.canshuchuandi;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Test01 {

    public static void main(String[] args) {
        Integer a = 5;
        System.out.println("方法前：" + a);
        fun(a);
        System.out.println("方法后：" + a);// 输出结果为5
    }

    private static void fun(Integer a) {
        a += 1;
        System.out.println("方法中：" + a);
    }

    @Test
    public void test01(){
        String ss = "123";
        System.out.println((String)ss);
    }

    @Test
    public void test02(){
        char aa = '3';
        char[] chars = Integer.toBinaryString(6).toCharArray();
        System.out.println(chars[6]);
        System.out.println(chars[6] - 48);
    }

    @Test
    public void test03(){
        Map<String,String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");

        String ss = map.get("1");
        ss="11";

        map.keySet().forEach(key->System.out.println("map.get(" + key + ") = " + map.get(key)));


    }


}
