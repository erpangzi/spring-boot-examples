package com.BigDecimal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.LinkedHashMap;

public class TestBigDecimal {

    public static void main(String[] args) {
        //bigDecimal 常常用于精确数字的计算
        BigDecimal b=new BigDecimal("100.416");
        BigDecimal c=new BigDecimal("20.132");
        //加
        BigDecimal add = b.add(c);
        System.out.println(add);
        //减
        BigDecimal sub = b.subtract(c);
        System.out.println(sub);
        //乘
        BigDecimal mul=b.multiply(c);
        System.out.println(mul);
        //除
//        BigDecimal div = b.divide(c);
//        System.out.println(div);
        //除 四舍五入,保留三位小数
        BigDecimal div1 =b.divide(c,3, RoundingMode.HALF_UP);
        System.out.println(div1);


        int scale = b.scale();
        BigDecimal bigDecimal = b.setScale(6);
        System.out.println(scale);//3
        System.out.println(bigDecimal);//100.419000

        BigDecimal bigDecimal1 = BigDecimal.ZERO.setScale(3);
        System.out.println(bigDecimal1);//0.000

        System.out.println(getBigDecimal(0.01));
        System.out.println(BigDecimal.ZERO.setScale(getBigDecimal(0.01).scale()));
        System.out.println(getBigDecimal(0.01).equals(BigDecimal.ZERO.setScale(getBigDecimal(0.01).scale())));

        BigDecimal bigDecimal2 = new BigDecimal(0.003);
        System.out.println(bigDecimal2.equals(BigDecimal.ZERO));

        BigDecimal bigDecimal3 = getBigDecimal("0");
        System.out.println(bigDecimal3.equals(BigDecimal.ZERO));

        System.out.println(bigDecimal2.compareTo(BigDecimal.ZERO));
        System.out.println(bigDecimal3.compareTo(BigDecimal.ZERO));

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
