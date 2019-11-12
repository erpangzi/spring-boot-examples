package com.testEnum;

public enum Color implements Behaviour {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private Color(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index){
        for (Color c:Color.values()) {
            if(c.getIndex() == index){
                return c.name;
            }
        }
        return null;
    }

    // 接口方法
    @Override
    public String getInfo() {
        return this.name;
    }

    // 接口方法
    @Override
    public void print() {
        System.out.println(this.index + ":" + this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}



class Test02{
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