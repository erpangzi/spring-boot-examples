package com.JDK8;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class TestStreamUser {

    public List<User> list(){
        List<User> list = Arrays.asList(
                // name，age
                new User("张三", 11),
                new User("王五", 20),
                new User("王五", 91),
                new User("张三", 8),
                new User("李四", 44),
                new User("李四", 44),
                new User("李四", 44)
        ); return list;
    }

    /**
     * reduce 求和，归纳
     **/
    @Test
    public void testReduce(){
        Integer reduce = list().parallelStream().map(User::getAge).reduce(0, (a, b) -> a + b);
        System.out.println(reduce);

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,5,4,3,2,1);
        long count = list1.stream().reduce(0, (a,b)->a+b);
        System.out.println(count);

    }

    /**
     * sort 排序.
     */
    @Test
    public void testSort() {
        List<User> list = list();
        System.out.println("-----排序前-----");
        list.forEach(user -> System.out.println(user));
        System.out.println("-----排序后-----");
        // java 8 前
        System.out.println("java 8 前");
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (User user : list) {
            System.out.println(user);
        }
        // java 8 stream 方法引用
        System.out.println("java 8 stream 方法引用");
        list.stream().sorted(Comparator.comparing(User::getAge)).forEach(user -> System.out.println(user));
    }

    /**
     * filter 过滤.
     */
    @Test
    public void testFilter() {
        List<User> list = list();
        // 输出年龄大于50的人
        System.out.println("-----过滤前-----");
        list.forEach(user -> System.out.println(user));
        System.out.println("-----过滤后-----");
        // java 8 前
//        System.out.println("java 8 前");
//        for(User user: list){
//            if (user.getAge() > 50) {
//                System.out.println(user);
//            }
//        }
        // java 8 stream
        System.out.println("java 8 stream");
        //list.stream().filter((User user) -> user.getAge() > 50).forEach(user -> System.out.println(user));

        List<User> collect = list.stream().filter((User user) -> user.getAge() > 50).collect(toList());
        collect.forEach(item-> System.out.print(item + " "));
        System.out.println("======");
        list.parallelStream().forEach(item-> System.out.print(item + " "));

    }

    /**
     * limit 截断.
     */
    @Test
    public void testLimit() {
        List<User> list = list();
        // 从第三个开始截断，只输出前三个
        System.out.println("-----截断前-----");
        list.forEach(user -> System.out.println(user));
        System.out.println("-----截断后-----");
        // java 8 前
        System.out.println("java 8 前");
        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i));
        }
        // java 8 stream
        System.out.println("java 8 stream");
        list.stream().limit(3).forEach(user -> System.out.println(user));
    }

    /**
     * skip 跳过.
     */
    @Test
    public void testSkip() {
        List<User> list = list();
        // 跳过前三个元素，从第四个开始输出
        System.out.println("-----跳过前-----");
        list.forEach(user -> System.out.println(user));
        System.out.println("-----跳过后-----");
        // java 8 前
        System.out.println("java 8 前");
        for (int i = 3; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        // java 8 stream
        System.out.println("java 8 stream");
        list.stream().skip(3).forEach(user -> System.out.println(user));
    }

    /**
     * distinct 去重.
     */
    @Test
    public void testDistinct() {
        List<User> list = list();
        // 因为Arrays.asList() 返回的是Arrays的内部类ArrayList，操作remove，add会报错
        List<User> users = new ArrayList(list);
        // 为list去除重复数据
        System.out.println("-----去重前-----");
        list.forEach(user -> System.out.println(user));
        System.out.println("-----去重后-----");
        // java 8 前
        System.out.println("java 8 前");
        for (int i = 0; i < users.size() - 1; i++) {
            for (int j = users.size() - 1; j > i; j--) {
                if (users.get(j).getAge() == users.get(i).getAge() && users.get(j).getName()
                        .equals(users.get(i).getName())) {
                    users.remove(i);
                }
            }
        }
        for (User user : users) {
            System.out.println(user);
        }
        // java 8 stream
        System.out.println("java 8 stream");
        users.stream().distinct().forEach(user -> System.out.println(user));
    }

    /**
     * 去重+按照年龄大于40以后从小到大+只取前二
     */
    @Test
    public void demo() {
        List<User> list = list();
        list.stream().distinct().filter(user -> user.getAge() > 40).sorted(
                Comparator.comparing(User::getAge)).limit(2).forEach(user -> System.out
                .println(user));
    }

    /**
     * 测试计算.
     */
    @Test
    public void testNum() {
        List<User> list = list();
        IntSummaryStatistics num = list.stream().mapToInt(u -> u.getAge())
                .summaryStatistics();
        System.out.println("总共人数：" + num.getCount());
        System.out.println("平均年龄：" + num.getAverage());
        System.out.println("最大年龄：" + num.getMax());
        System.out.println("最小年龄：" + num.getMin());
        System.out.println("年龄之和：" + num.getSum());
    }

    /**
     * map 映射.
     */
    @Test
    public void testMap() {
        List<User> list = list();
        // 只输出所有人的年龄
        list.stream().forEach(user -> System.out.println(user));
        System.out.println("映射后----->");
        List<Integer> ages = list.stream().map(user -> user.getAge()).collect(toList());
        ages.forEach(age -> System.out.println(age));

        // 小写转大写
        List<String> words = Arrays.asList("aaa", "vvvv", "cccc");
        System.out.println("全部大写---->");
        List<String> collect = words.stream().map(s -> s.toUpperCase()).collect(toList());
        collect.forEach(s -> System.out.println(s));
    }




    @Test
    public void test01() {
        List<Aopi> aopiList = Lists.newArrayList();

        Aopi aopi = new Aopi("1", 1);
        Aopi aop2 = new Aopi("2", 2);
        Aopi aop3 = new Aopi("3", 3);
        Aopi aop4 = new Aopi("4", 4);

        aopiList.addAll(Arrays.asList(aopi, aop2, aop3, aop4));

        //第一种方式  Aopi{id=null, name='1_test', age=1}
        aopiList.forEach(item -> item.setName(item.getName() + "_test"));
        System.out.println(
                aopiList.stream().min((o1, o2) -> {
                    if (Objects.equals(o1.getAge(), o2.getAge()))
                        return 0;
                    return o1.getAge() > o2.getAge() ? 1 : -1;
                }).get().toString()
        );

        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");

        //第二种方式  Aopi{id=null, name='1_test', age=1}
//        System.out.println(
//                aopiList.stream().peek(item -> item.setName(item.getName() + "_test")).min((o1, o2) -> {
//                    if (Objects.equals(o1.getAge(), o2.getAge()))
//                        return 0;
//                    return o1.getAge() > o2.getAge() ? 1 : -1;
//                }).get().toString()
//        );

    }

    @Test
    public void test02(){
        Stream<String> stream = Stream.of("hello", "felord.cn");
        stream.peek((item -> item = "1")).forEach(System.out::println);

//        List<String> collect = stream.peek(item -> item = "1").collect(toList());
//        collect.parallelStream().forEach(System.out::println);



        System.out.println("======================");

//        List<String> strs= stream.peek(System.out::println).collect(Collectors.toList());
//        strs.forEach(System.out::println);
    }



}
