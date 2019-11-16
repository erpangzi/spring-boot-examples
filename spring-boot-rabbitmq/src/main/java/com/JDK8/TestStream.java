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

    @Test//排序
    public void sort(){
        List<String> list = Arrays.asList("c", "e", "a", "d", "b");
        // Stream<T> sorted(Comparator<? super T> comparator);
        // int compare(T o1, T o2);
        list.stream().sorted((s1, s2) -> s1.compareTo(s2)).forEach(System.out::println);
    }

    @Test//去重
    public void distinct(){
        // 知之为知之,不知为不知
        Stream<String> stream = Stream.of("know", "is", "know", "noknow", "is", "noknow");
        stream.distinct().forEach(System.out::println); // know is noknow
        List<String> list = Arrays.asList("know", "is", "know", "noknow", "is", "noknow");
        list.stream().distinct().forEach(System.out::println);
    }

    @Test//统计个数
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

    @Test//统计个数
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

    @Test//循环
    public void foreach(){
        //获取一个Stream流
        Stream<String> stream = Stream.of("张三", "李四", "王五", "麻六");
        //使用Stream流中的方法forEach对Stream流中的数据进行遍历
        /*stream.forEach((name)->{
            System.out.println(name);
        });*/

        //优化Lambda表达式
        stream.forEach(name->System.out.println(name));
    }

    @Test//过滤
    public void filter(){
        //创建一个Stream流
        Stream<String> stream = Stream.of("张三", "李四", "张五", "麻六");
        //对Stream流中的元素进行过滤，只要姓张的人
        Stream<String> stream2 = stream.filter(name->name.startsWith("张"));
        //遍历stream2流
        stream2.forEach(name-> System.out.println(name));
    }

    @Test//映射值
    public void map01(){

        //获取一个Stream类型的Stream流
        Stream<String> stream = Stream.of("1","2","3","4","5","6");
        //使用map方法，把字符串类型的整数，转换(映射)为Integer类型的整数
        Stream<Integer> stream2 = stream.map(s->Integer.parseInt(s));
        //遍历stream2流
        stream2.forEach(i-> System.out.println(i));
    }

    @Test//累加
    public void count01(){

        //获取一个Stream流
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        Stream<Integer> stream = list.stream();
        long count = stream.count();
        System.out.println(count);
    }

    @Test//取前几个元素
    public void limit(){
        //获取一个Stream流
        String[] arr = {"张三", "李四", "张五", "麻六"};
        Stream<String> stream = Stream.of(arr);
        //使用limit对Stream流中的元素进行截取，只要前3个元素
        Stream<String> stream2 = stream.limit(3);
        //遍历stream2流
        stream2.forEach(name-> System.out.println(name));
    }

    @Test//组合结果集
    public void concat01(){
        //创建一个Stream流
        Stream<String> stream1 = Stream.of("张三", "李四", "张五", "麻六");
        //获取一个Stream流
        String[] arr = {"张三", "老八", "小九"};
        Stream<String> stream2 = Stream.of(arr);
        //把以上两个流组合为一个流
        Stream<String> concat = Stream.concat(stream1, stream2);
        //遍历concat流
        concat.forEach(name-> System.out.println(name));
    }


}
