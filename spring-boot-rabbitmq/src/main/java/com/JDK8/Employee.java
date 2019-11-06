package com.JDK8;

public class Employee {

    private String name;
    private String address;
    private Integer avg;
    private Integer age;

    public Employee() {
    }

    public Employee(String name, String address, Integer avg, Integer age) {
        this.name = name;
        this.address = address;
        this.avg = avg;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAvg() {
        return avg;
    }

    public void setAvg(Integer avg) {
        this.avg = avg;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", avg=" + avg +
                ", age=" + age +
                '}';
    }
}
