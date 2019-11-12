package com.student;

import java.util.Arrays;
import java.util.List;

import static com.student.Test1.test01;
import static java.lang.Integer.*;

public class TestList {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        test01(integers);
        integers.stream().forEach(System.out::println);
        System.out.println("========");
        integers.stream().forEach(e ->{
            e = e.intValue() + 1;
        });
        integers.stream().forEach(System.out::println);
    }



}
