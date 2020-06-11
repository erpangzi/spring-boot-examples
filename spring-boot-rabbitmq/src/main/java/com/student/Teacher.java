package com.student;

import java.math.BigDecimal;
import java.util.Objects;

public class Teacher implements Cloneable{

    private String name;
    private Integer number;
    private Long testLong;
    private BigDecimal testBigDecimal;

    public Teacher() {
    }

    public Teacher(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public Teacher(String name, Integer number, Long testLong, BigDecimal testBigDecimal) {
        this.name = name;
        this.number = number;
        this.testLong = testLong;
        this.testBigDecimal = testBigDecimal;
    }

    public Long getTestLong() {
        return testLong;
    }

    public void setTestLong(Long testLong) {
        this.testLong = testLong;
    }

    public BigDecimal getTestBigDecimal() {
        return testBigDecimal;
    }

    public void setTestBigDecimal(BigDecimal testBigDecimal) {
        this.testBigDecimal = testBigDecimal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if(o.hashCode()!=this.hashCode())return false;
        Teacher student = (Teacher) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(number, student.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name+""+number);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
