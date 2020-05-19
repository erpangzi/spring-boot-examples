package com;

import org.junit.Test;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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


    @Test
    public void test01(){
        Date date = new Date();

        Map<String ,Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("1", date);
        Object o = stringObjectMap.get("1");
        Date date1 = (Date)o;
        System.out.println(date1);
        System.out.println(date1.toString());
    }

    private static Date str2Date(String strDate) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(strDate);
        return date;
    }

    @Test
    public  void test02(){
        Boolean b = null;

        System.out.println(b);

        boolean b2 = false;

        System.out.println(b2);
    }


}
