package com;

import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Component
public class test002 {

    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);

        Boolean aTrue = Boolean.valueOf("false");
        System.out.println(aTrue);

        String s = "true";
        String s1 = "12";


    }

    @Test
    public void listtest(){
        List<String> list01 = Arrays.asList("1","2","1","2","3");
        List arrList = new ArrayList(list01);

        Iterator<String> iterator = arrList.iterator();

        while(iterator.hasNext()){
            if(iterator.next().equals("1")){
                iterator.remove();
            }
        }

        arrList.forEach(System.out::println);
    }

}
