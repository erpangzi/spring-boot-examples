package com.JDK8.Optional;

import com.JDK8.Java8Tester;
import com.JDK8.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;


public class Optional_Test {

    public static void main(String args[]){

        Java8Tester java8Tester = new Java8Tester();
        Integer value1 = null;
        Integer value2 = new Integer(10);

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);
        System.out.println(a.isPresent());
        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(b.isPresent());
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){

        // Optional.isPresent - 判断值是否存在

        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
    }

    @Test
    public void test01(){
        // Optional类已经成为Java 8类库的一部分，在Guava中早就有了，可能Oracle是直接拿来使用了
        // Optional用来解决空指针异常，使代码更加严谨，防止因为空指针NullPointerException对代码造成影响
        String msg = "hello";
        Optional<String> optional = Optional.of(msg);
        // 判断是否有值，不为空
        boolean present = optional.isPresent();
        // 如果有值，则返回值，如果等于空则抛异常
        String value = optional.get();
        // 如果为空，返回else指定的值
        String hi = optional.orElse("hi");
        // 如果值不为空，就执行Lambda表达式
        optional.ifPresent(opt -> System.out.println(opt));

        String msg01 = null;
        Optional<String> msg011 = Optional.of(msg01);
        boolean present1 = msg011.isPresent();


    }

    @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptional_thenNull() {
        Optional<User> emptyOpt = Optional.empty();
        emptyOpt.get();
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateOfEmptyOptional_thenNullPointerException() {
        User user = null;
        Optional<User> opt = Optional.ofNullable(user);

        System.out.println(opt.isPresent());
    }


    @Test
    public void whenCreateOfNullableOptional_thenOk() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);

        Assert.assertEquals("John", opt.get());
    }






}
