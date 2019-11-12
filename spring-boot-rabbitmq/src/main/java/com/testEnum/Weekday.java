package com.testEnum;

public enum Weekday {
    SUN,MON,TUS,WED,THU,FRI,SAT
}

class Test{
    public static void main(String[] args) {
        Weekday sun = Weekday.SUN;
        System.out.println(sun); // 输出 SUN
    }
}