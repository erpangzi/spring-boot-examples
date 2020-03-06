package com.test;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.*;

public class Test {

    @org.junit.Test
    public void test(){
        for (int i = 0; i < 6; i++) {
            if(i==3) continue;;
            System.out.println(i);
        }
    }

    @org.junit.Test
    public void test01(){
        if (!("1".equals("3")||2==2)){
            System.out.println("1111111");
        }else {
            System.out.println("2222222");
        }
    }

    @org.junit.Test
    public void test02(){
        char aa = '3';
        char[] chars = Integer.toBinaryString(6).toCharArray();
        System.out.println(chars[5]);
        System.out.println(chars[5] - 48);
    }

    @org.junit.Test
    public void test03(){
        Map<String,String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");

        String ss = map.get("1");
        ss="11";

        map.keySet().forEach(key->System.out.println("map.get(" + key + ") = " + map.get(key)));


    }

    @org.junit.Test
    public void test04(){
        System.out.println("WERT".toLowerCase());
        List<String> list = new ArrayList<>();
        list.add("1");list.add("2");list.add("3");
        int i = 0;
        test05(list,i);
        list.forEach(System.out::println);
        System.out.println(i);
    }

    public void test05(List<String > list , int i){
        //list = new ArrayList<String>(){{add("0");}};
        list.add("4");
        i+=1;
    }

    @org.junit.Test
    public void test06(){
        List<String> list = new ArrayList<String>(Arrays.asList("1","2","3"));
        for (String ss:list ) {
//            if(ss.equals("1")){
//                System.out.println(1);
//            }
//            else if(ss.equals("2")){
//                System.out.println(2);
//            }
//            else if(ss.equals("3")){
//                System.out.println(3);
//            }else System.out.println("结束！！"+ss);

            switch (ss){
                case "1" :{System.out.println(1);}
                case "2" :{System.out.println(2);}
                case "3" :{System.out.println(3);}
            }
        }
    }

    @org.junit.Test
    public void test07(){
        BigDecimal bigDecimal = new BigDecimal(2.222);

    }

    @org.junit.Test
    public void test08(){
        Double d = Double.valueOf(0);
        System.out.println(d==0);
        System.out.println(d==0.0);
        System.out.println(d==0.0000);
    }

    @org.junit.Test
    public void test09(){

        String ss = "12";
        System.out.println(ss.toString());

    }


    @org.junit.Test
    public void test10(){
        int a = 0;
//        try {
//             a ++;
//             return;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            a ++;
//            System.out.println(a);
//        }
        Integer integer = null;
        Assert.notNull(integer,"参数为空");

    }

}
