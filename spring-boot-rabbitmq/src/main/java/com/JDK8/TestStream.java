package com.JDK8;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {

    public static final String zhangsan = "张三";

    public static void main(String[] args) {
        /**
         List<ConditionField> DetailCondition=conditions.parallelStream().filter(item -> (item.getName() == PRODUCT) || (item.getName() == SKUID)
         || (item.getName() == STOCKID) || (item.getName() == ORDERDATE)).collect(Collectors.toList());
         **/

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);list.add(2);list.add(3);list.add(4);

        List<Integer> DetailCondition=list.stream().filter((Integer item) -> item == 1
                || item == 2
                || item == 3).collect(Collectors.toList());
        System.out.println(list.toString());
    }

    @Test
    public void test(){
        List<Employee> list = Arrays.asList(
                new Employee("张三", "上海", 5000, 22),
                new Employee("李四", "北京", 4000, 23),
                new Employee("c五", "日本", 6000, 50),
                new Employee("b七", "香港", 7000, 50),
                new Employee("赵六", "纽约", 1000, 8)
        );


        Stream<Employee> stream = list.stream();//创建流
        list.stream().filter(employee -> employee.getName()=="").collect(Collectors.toList());
        List<Employee> collect = list.parallelStream().filter(employee -> (employee.getName() == zhangsan) || (employee.getName() == "李四")).collect(Collectors.toList());//过滤符合条件的流元素
//                .limit(5)//只取5个
//                .skip(4)//跳过4个
//                .distinct()//去重，需重写hashcode和equals方法
//                .forEach(System.out::println);//终止操作，获取流
        collect.forEach(employee -> System.out.println(employee.toString()));
    }

    @Test
    public void map(){
        List<String> list = Arrays.asList("how", "are", "you", "how", "old", "are", "you", "?");
        // <R> Stream<R> map(Function<? super T, ? extends R> mapper);
        for (String s : list.stream().map(item -> item.toUpperCase()).collect(Collectors.toList())) {
            System.out.println(s);
        }
        list.stream().forEach(System.out::println);
    }

    @Test
    public void sort(){
        List<String> list = Arrays.asList("c", "e", "a", "d", "b");
        // Stream<T> sorted(Comparator<? super T> comparator);
        // int compare(T o1, T o2);
        list.stream().sorted((s1, s2) -> s1.compareTo(s2)).forEach(System.out::println);
    }

    @Test
    public void distinct(){
        // 知之为知之,不知为不知
        Stream<String> stream = Stream.of("know", "is", "know", "noknow", "is", "noknow");
        stream.distinct().forEach(System.out::println); // know is noknow
        List<String> list = Arrays.asList("know", "is", "know", "noknow", "is", "noknow");
        list.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void count(){
        Stream<String> stream = Stream.of("know", "is", "know", "noknow", "is", "noknow");
        long count = stream.count();
        System.out.println(count);
    }

    @Test
    public void min(){
        List<String> list = Arrays.asList("1", "2", "3", "4", "5");
        // Optional<T> min(Comparator<? super T> comparator);
        Optional<String> optional = list.stream().min((a, b) -> a.compareTo(b));
        String value = optional.get();
        System.out.println(value);
    }

    @Test//合并
    public void concat(){
        List<String> list = Arrays.asList("a", "b");
        List<String> list2 = Arrays.asList("c", "d");
        Stream<String> concatStream = Stream.concat(list.stream(), list2.stream());
        concatStream.forEach(System.out::println);
    }

    @Test//归纳
    public void reduce(){
        Stream<String> stream = Stream.of("you", "give", "me", "stop");
        // Optional<T> reduce(BinaryOperator<T> accumulator);
        Optional<String> optional = stream.reduce((before, after) -> before + "," + after);
        optional.ifPresent(System.out::println);    // you,give,me,stop
    }




}
