package com.BigDecimal;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.LinkedHashMap;

public class TestBigDecimal {

    /**
     RoundingMode.CEILING：取右边最近的整数

     RoundingMode.DOWN：去掉小数部分取整，也就是正数取左边，负数取右边，相当于向原点靠近的方向取整

     RoundingMode.FLOOR：取左边最近的正数

     RoundingMode.HALF_DOWN:五舍六入，负数先取绝对值再五舍六入再负数

     RoundingMode.HALF_UP:四舍五入，负数原理同上

     RoundingMode.HALF_EVEN:这个比较绕，整数位若是奇数则四舍五入，若是偶数则五舍六入
     **/

    public static void main(String[] args) {
        //bigDecimal 常常用于精确数字的计算
        BigDecimal b=new BigDecimal("100.416");
        BigDecimal c=new BigDecimal("20.132");
        //加
        BigDecimal add = b.add(c);
        System.out.println(add);//120.548
        //减
        BigDecimal sub = b.subtract(c);
        System.out.println(sub);//80.284
        //乘
        BigDecimal mul=b.multiply(c);
        System.out.println(mul);//2021.574912
        //除
//        BigDecimal div = b.divide(c);
//        System.out.println(div);
        //除 四舍五入,保留三位小数
        BigDecimal div1 =b.divide(c,3, RoundingMode.HALF_UP);
        System.out.println(div1);//4.988


        int scale = b.scale();
        BigDecimal bigDecimal = b.setScale(6);
        System.out.println(scale);//3
        System.out.println(bigDecimal);//100.419000

        BigDecimal bigDecimal1 = BigDecimal.ZERO.setScale(3);
        System.out.println(bigDecimal1);//0.000

        System.out.println(getBigDecimal(0.01));
        System.out.println(BigDecimal.ZERO.setScale(getBigDecimal(0.01).scale()));
        System.out.println(getBigDecimal(0.01).equals(BigDecimal.ZERO.setScale(getBigDecimal(0.01).scale())));

        BigDecimal bigDecimal2 = getBigDecimal(0.0);
        System.out.println(bigDecimal2.equals(BigDecimal.ZERO));

        BigDecimal bigDecimal3 = getBigDecimal("0.0");
        System.out.println(bigDecimal3.equals(BigDecimal.ZERO));

        System.out.println(bigDecimal2.compareTo(BigDecimal.ZERO));
        System.out.println(bigDecimal3.compareTo(BigDecimal.ZERO));


    }

    @Test
    public void test01(){
        //bigDecimal 常常用于精确数字的计算
        BigDecimal b=new BigDecimal("1000.4160");
        BigDecimal c=new BigDecimal("20.132");


        System.out.println(b.scale());//4
        BigDecimal bigDecimal = c.setScale(6);
        System.out.println(c);//20.132
        System.out.println(bigDecimal);//20.13200
    }


    @Test
    public void test02(){
        BigDecimal num = new BigDecimal("0.0");
        BigDecimal num1 = new BigDecimal("0.0000");

        System.out.println(num.compareTo(BigDecimal.ZERO));
        System.out.println(num1.compareTo(BigDecimal.ZERO));
    }


    public static BigDecimal getBigDecimal(Object obj) {
        if (obj == null)
            return BigDecimal.ZERO;
        if (obj instanceof Long) {
            return new BigDecimal(Long.toString((Long) obj));
        } else if (obj instanceof Integer) {
            return new BigDecimal(Integer.toString((Integer)obj));
        } else if (obj instanceof Double) {
            return new BigDecimal(Double.toString((Double)obj));
        } else if (obj instanceof String) {
            return new BigDecimal((String) obj);
        } else if (obj instanceof LinkedHashMap) {
            return BigDecimal.ZERO;
        } else if (obj instanceof BigDecimal) {
            return (BigDecimal)obj;
        }
        return new BigDecimal(((BigDecimal) obj).doubleValue(), MathContext.DECIMAL64);
    }
}
