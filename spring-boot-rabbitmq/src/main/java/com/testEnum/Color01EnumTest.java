package com.testEnum;

public class Color01EnumTest {
    public static void main(String[] args) {
        /**
         * 测试枚举的values()
         *
         */
        String s = Color01.getValue(0).getDesc();
        System.out.println("获取的值为:" + s);
        String name = Color01.BLUE.name();
        System.out.println(name);

        /**
         * 测试枚举的valueof,里面的值可以是自己定义的枚举常量的名称
         * 其中valueOf方法会把一个String类型的名称转变成枚举项，也就是在枚举项中查找字面值和该参数相等的枚举项。
         */

        Color01 color = Color01.valueOf("GREEN");
        System.out.println(color.getDesc());

        /**
         * 测试枚举的toString()方法
         */

        Color01 s2 = Color01.getValue(0);
        System.out.println("获取的值为:" + s2.toString());

        System.out.println(Color01.BLUE);
        Color01[] values = Color01.values();

        for (Color01 color01:values) {
            System.out.println(color01.name());
        }

    }
}