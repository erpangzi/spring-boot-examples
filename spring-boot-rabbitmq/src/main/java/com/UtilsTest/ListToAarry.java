package com.UtilsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToAarry {

    public static void main(String[] args) {
        //如何将数组转换为list集合
        String[] arr = new String[5];
        arr[0]="a";
        arr[1]="b";
        arr[2]="c";
        arr[3]="d";
        arr[4]="e";
        List<String> list = new ArrayList<>();
        List<String> list1 = Arrays.asList(arr);
        System.out.println(list1);


        //将list集合转换为数组Array
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        ls.add(5);
        Object[] objects = ls.toArray();
        for(Object o : objects){
            System.out.println(o.toString());
        }
    }

}
