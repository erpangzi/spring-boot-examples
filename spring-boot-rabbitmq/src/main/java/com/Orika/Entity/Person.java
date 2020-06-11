package com.Orika.Entity;

public class Person {
    private String name;
    private String nickname;
    private int age;
    private String test;

    public Person(String name, String nickname, int age) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
    }

    public Person(String name, String nickname, int age, String test) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.test = test;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    // standard getters and setters


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", test='" + test + '\'' +
                '}';
    }
}
