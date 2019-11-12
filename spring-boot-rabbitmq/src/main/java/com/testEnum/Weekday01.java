package com.testEnum;

public enum Weekday01 {
    SUN(0),MON(1),TUS(2),WED(3),THU(4),FRI(5),SAT(6);

    private int value;

    private Weekday01(int value){
        this.value = value;
    }

    public static Weekday01 getNextDay(Weekday01 nowDay){
        int nextDayValue = nowDay.value;

        if (++nextDayValue == 7){
            nextDayValue =0;
        }

        return getWeekday01ByValue(nextDayValue);
    }

    public static Weekday01 getWeekday01ByValue(int value) {
        for (Weekday01 c : Weekday01.values()) {
            if (c.value == value) {
                return c;
            }
        }
        return null;
    }
}

class Test2{
    public static void main(String[] args) {
        System.out.println("nowday ====> " + Weekday01.SAT);
        System.out.println("nowday int ====> " + Weekday01.SAT.ordinal());
        System.out.println("nextday ====> " + Weekday01.getNextDay(Weekday01.SAT)); // 输出 SUN

        //输出：
        //nowday ====> SAT
        //nowday int ====> 6
        //nextday ====> SUN
    }
}