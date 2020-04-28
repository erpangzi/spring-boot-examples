package com;

import org.springframework.context.annotation.Bean;

import java.io.Serializable;


public class test01 implements Serializable {


    private static final long serialVersionUID = 3350428913692912739L;

    public static void main(String[] args)  {
        System.out.println(1);
        try {
            test();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }


    }



    static void test () throws  Exception{
        throw new RuntimeException("报错了");
    }





}
